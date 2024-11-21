package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("test01/uploadForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encoding = "utf-8";
		
		String uploadPath = getServletContext().getRealPath("./uploadLocation"); // webapp/uploadLocation
		File currentDirPath = new File(uploadPath);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) { // 텍스트
					System.out.println("일반 텍스트 " + fileItem.getFieldName() + " : " + fileItem.getString(encoding));
				} else { // 이미지는 서버에 업로드
					System.out.println("getFieldName : " + fileItem.getFieldName());
					System.out.println("getName : " + fileItem.getName());
					System.out.println("getSize : " + fileItem.getSize() + "bytes");
					System.out.println("------------------------------");

					if (fileItem.getSize() > 0) {
						// 마지막 구분자 '\\'를 찾아서 파일 이름만 추출
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) { // '\\'를 못찾으면
							// 마지막 구분자 '/'를 찾아서 파일 이름만 추출
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1);
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
