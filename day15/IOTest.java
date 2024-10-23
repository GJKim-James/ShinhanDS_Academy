package com.shinhan.day15;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString(of = { "name", "age", "name2", "age2" })
@Getter
@AllArgsConstructor
class Student implements Serializable {
	private String name;
	private int age;
	private static String name2 = "신한";
	private transient int age2;
}

public class IOTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
		f10();
	}
	
	// File과 Files 클래스
	private static void f10() {
		File f = new File("cc.data");
		System.out.println(f.exists());
		System.out.println(f.isDirectory());
		System.out.println(f.getAbsolutePath());
	}

	/*
	 * name2 필드가 출력 결과에 포함된 이유는 직렬화 과정에서 name2가 저장되었기 때문이 아니라, name2가 static 필드이기 때문에 클래스 로딩 시점에 메모리에 한 번만 로드되어 모든 인스턴스에서 공유되기 때문입니다.
	 * 즉, Student 객체를 직렬화할 때 name2는 저장되지 않지만, 역직렬화 후에도 해당 클래스의 static 필드는 그대로 존재하므로 출력 시 name2의 값이 표시됩니다.
	 * 좀 더 자세히 설명하면:
	 * 	1.	직렬화 과정에서:
	 * 	•	name과 age는 인스턴스 필드이므로 직렬화됩니다.
	 * 	•	age2는 transient 키워드로 표시되어 있어 직렬화되지 않습니다.
	 * 	•	name2는 static 필드이므로 직렬화되지 않습니다.
	 * 	2.	역직렬화 과정에서:
	 * 	•	직렬화된 데이터로부터 name과 age 값이 복원됩니다.
	 * 	•	age2는 직렬화되지 않았으므로 기본값인 0으로 초기화됩니다.
	 * 	•	name2는 static 필드로, 클래스 로딩 시 이미 메모리에 존재하므로 해당 값 5jo를 그대로 갖습니다.
	 * 	3.	출력 과정에서:
	 * 	•	@ToString(of = {"name", "age", "name2", "age2"}) 어노테이션에 의해 toString() 메서드는 지정된 필드들의 값을 문자열로 반환합니다.
	 * 	•	이때 name2는 static 필드지만 클래스에 속해 있으므로 해당 값이 출력됩니다.
	 * 따라서 name2가 출력에 포함되는 것은 직렬화되어서가 아니라, 클래스의 static 필드로 존재하기 때문입니다.
	 * 정리하면: name2는 직렬화되지 않았지만, 역직렬화 후에도 클래스의 static 필드로 남아있기 때문에 출력 결과에 나타납니다.
	 */

	// f8() 먼저 실행하고 f9() 실행
	private static void f9() {
		try (FileInputStream fos = new FileInputStream("cc.data");
				ObjectInputStream oos = new ObjectInputStream(fos)) {
//			Member4 m1 = (Member4) oos.readObject();
//			Member4 m2 = (Member4) oos.readObject();
//			Member4 m3 = (Member4) oos.readObject();
//			System.out.println(m1);
//			System.out.println(m2);
//			System.out.println(m3);
			
			Student s1 = (Student) oos.readObject();
			Student s2 = (Student) oos.readObject();
			Student s3 = (Student) oos.readObject();
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 객체 스트림(직렬화; Serializable)
	private static void f8() {
		try (FileOutputStream fos = new FileOutputStream("cc.data");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(new Member4("홍길동1", 20));
			oos.writeObject(new Member4("홍길동2", 30));
			oos.writeObject(new Member4("홍길동3", 40));
			
			// ##### Student 추가 필요 #####
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 기본 타입 스트림(DataOutputStream)
	private static void f7() {
		// 자바의 기본 타입 저장, 읽기
		try (FileOutputStream fos = new FileOutputStream("bb.txt"); DataOutputStream dos = new DataOutputStream(fos)) {
			dos.writeInt(100);
			dos.writeDouble(3.141592);
			dos.writeBoolean(true);
			dos.writeUTF("문자");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fis = new FileInputStream("bb.txt"); DataInputStream dis = new DataInputStream(fis)) {
			int i = dis.readInt() + 200;
			double d = dis.readDouble() + 100;
			boolean result = dis.readBoolean();
			String s = dis.readUTF();
			System.out.println(i);
			System.out.println(d);
			System.out.println(result);
			System.out.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 성능 향상 스트림(BufferedReader)
	private static void f6() {
		try (FileReader fr = new FileReader("data.txt"); BufferedReader br = new BufferedReader(fr)) { // BufferedReader
																										// : 한 줄씩 읽기 가능
			String line;

			line = br.readLine(); // 첫째 줄 읽기
			System.out.println(line.replaceAll("/", "\t") + "\t총점\t평균");

			while ((line = br.readLine()) != null) { // 마지막까지 읽기
				String[] arr = line.split("/");
//				System.out.println(Arrays.toString(arr));

				int sum = 0;
				for (int i = 1; i < arr.length; i++) {
					sum += Integer.parseInt(arr[i]);
				}
				System.out.print(line.replaceAll("/", "\t"));
				System.out.println("\t" + sum + "\t" + (sum / 3));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void f5() {
		// 파일 출력 : FileWriter
		try (FileWriter fw = new FileWriter("aa.txt")) { // () 안에 작성함으로써 자원 반납
			fw.write("오늘은 금요일입니다.1\n");
			fw.write("오늘은 금요일입니다.2\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void f4() {
		// PrintStream : 모니터 출력
		PrintStream ps = System.out;

		try {
			ps.write("자바".getBytes()); // write() : byte 배열로 바꾼 후 출력해야함
			ps.print("자바");
			ps.println();
			ps.println();

			byte[] arr = "자바".getBytes();
			byte[] arr2 = new byte[arr.length + 2];
			arr2 = Arrays.copyOf(arr, arr.length + 2);
			arr2[arr2.length - 2] = 13; // enter
			arr2[arr2.length - 1] = 10; // newline
			ps.write(arr2);
			ps.print("자바");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void f3() {
		// FileReader : 2byte
		try (FileReader fr = new FileReader("src/com/shinhan/day15/IOTest.java")) {
			int i;

			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void f2() {
		// FileInputStream : 1byte씩 입력
		// InputStreamReader : 1byte -> 2byte 바꿔줌(한글 출력하기 위해)
		// newLine(10), enter(13)
		try (FileInputStream fi = new FileInputStream("src/com/shinhan/day15/IOTest.java");
				InputStreamReader ir = new InputStreamReader(fi)) {
			int i;

			while ((i = ir.read()) != -1) { // End Of File(EOF) : -1
				System.out.print((char) i);
			}
		} catch (FileNotFoundException e) { // 하위
			e.printStackTrace();
		} catch (IOException e) { // 상위
			e.printStackTrace();
		}
	}

	private static void f1() {
		// InputStream : 1byte씩 입력
		// 1. 키보드
		int i;

		try (InputStream is = System.in;) { // 사용 후 자동으로 닫히게 하기 위해 try () 안에 작성
			i = is.read();
			System.out.println((char) i); // InputStream은 1byte씩 읽기 때문에 한 문자만 출력
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] arr = new byte[3];

		int i2;

		try (InputStream is = System.in;) {
			i2 = is.read(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
