package soccer.match.controller;

import java.util.Scanner;

import soccer.match.dto.UserDTO;
import soccer.match.service.UserService;
import soccer.match.util.CmmUtil;

public class MainController {

	static Scanner sc = new Scanner(System.in);
	
	static UserService userService = new UserService();
	
	public static void main(String[] args) {
		boolean isStop = false;

		while (!isStop) {
			mainMenu(); // 메인 메뉴

			int numSelect = Integer.parseInt(sc.nextLine());

			switch (numSelect) {
				case 1 -> {
					insertUser(); // 회원가입
				}
				case 2 -> {
					UserDTO resultDTO = login(); // 로그인
					
					if (resultDTO.getUser_id() == null) {
						System.out.println("---------- 로그인 실패 ----------");
					} else if (resultDTO.getUser_id().equals("admin")) {
						isStop = true;
						System.out.println("---------- 관리자로 로그인 성공 ----------");
						AdminController.adminMenu();
					} else {
						isStop = true;
						System.out.println("---------- " + resultDTO.getUser_id() + " (으)로 로그인 성공 ----------");
						UserController.userMenu(resultDTO);
					}
				}
				case 3 -> {
					isStop = true; // 프로그램 종료
				}
			}
		}

		sc.close();
//		System.out.println("========== 프로그램 종료 ==========");
	}

	// 로그인
	private static UserDTO login() {
		System.out.print("아이디 : ");
		String userId = CmmUtil.nvl(sc.nextLine());
		
		System.out.print("비밀번호 : ");
		String userPW = CmmUtil.nvl(sc.nextLine());
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_id(userId);
		userDTO.setUser_pw(userPW);
		
		UserDTO resultDTO = userService.login(userDTO);
		
		return resultDTO;
	}

	// 회원가입
	private static void insertUser() {
		System.out.println("----- 회원 정보를 입력해주세요. -----");
		
		int result = userService.insertUser(makeUser());
		
		if (result == 1) {
			System.out.println("----- 회원가입 성공 -----");
		} else {
			System.out.println("----- 회원가입 실패 -----");
		}
	}

	// 회원가입 시 입력하는 사용자 정보
	private static UserDTO makeUser() {
		System.out.print("아이디 : ");
		String userId = CmmUtil.nvl(sc.nextLine());
		
		System.out.print("비밀번호 : ");
		String userPW = CmmUtil.nvl(sc.nextLine());
		
		System.out.print("이름 : ");
		String userName = CmmUtil.nvl(sc.nextLine());
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_id(userId);
		userDTO.setUser_pw(userPW);
		userDTO.setUser_name(userName);
		
		return userDTO;
	}

	// 메인 메뉴
	private static void mainMenu() {
		System.out.println("===================================");
		System.out.println("1. 회원가입 | 2. 로그인 | 3. 프로그램 종료");
		System.out.println("===================================");
		System.out.print("번호 입력>> ");
	}

}
