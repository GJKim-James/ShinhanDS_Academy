package soccer.match.controller;

import java.util.List;
import java.util.Scanner;

import soccer.match.dto.MatchInfoDTO;
import soccer.match.dto.MatchListDTO;
import soccer.match.dto.UserDTO;
import soccer.match.service.UserService;
import soccer.match.view.MatchListView;
import soccer.match.view.UserView;

public class UserController {

	static Scanner sc = new Scanner(System.in);
	
	static UserService userService = new UserService();
	
	// 사용자 메뉴
	static void userMenu(UserDTO resultDTO) {
		boolean isStop = false;

		while (!isStop) {
			System.out.println("==================================================");
			System.out.println("1. 경기 신청하기 | 2. 신청 내역 | 3. 내 정보 | 4. 로그아웃");
			System.out.println("==================================================");
			System.out.print("번호 입력>> ");

			int numSelect = Integer.parseInt(sc.nextLine());

			switch (numSelect) {
				case 1 -> {
					selectAvailableMatch(); // 신청 가능한 경기 목록 출력
					System.out.println("------------------------------------------------------------");
					applyMatch(resultDTO); // 경기 신청하기
				}
				case 2 -> {
					selectMyMatch(resultDTO); // 신청 내역 출력
				}
				case 3 -> {
					selectMyInfo(resultDTO); // 내 정보 보기
				}
				case 4 -> {
					isStop = true; // 로그아웃
					System.out.println("-------------------- 로그아웃 되었습니다. --------------------");
				}
			}
		}

		sc.close();
	}

	// 경기 신청하기
	private static void applyMatch(UserDTO resultDTO) {
		System.out.print("위 경기 목록에서 신청하실 경기 번호(MATCH_NO)를 입력해주세요.>> ");
		int matchNo = Integer.parseInt(sc.nextLine());
				
		// 이미 신청한 경기인지 중복 확인
		int result = userService.selectDuplicateChk(matchNo, resultDTO);
		
		if (result == 1) { // 이미 신청한 경기라면
			System.out.println("[알림] 이미 신청한 경기입니다.");
		} else { // 신청하지 않은 경기라면
			MatchListDTO matchListDTO = userService.selectByNo(matchNo);
			
			int result2 = userService.applyMatch(matchNo, resultDTO, matchListDTO);
			
			if (result2 == 1) {
				System.out.println("---------- 경기 신청 성공 ----------");
			} else {
				System.out.println("---------- 경기 신청 실패 ----------");
			}
		}
	}
	
	// 신청 가능한 경기 목록 출력(경기 신청하기에서 사용)
	private static void selectAvailableMatch() {
		List<MatchListDTO> availableMatchList = userService.selectAvailableMatch();
		
		MatchListView.display(availableMatchList);
	}
	
	// 신청 내역 출력
	private static void selectMyMatch(UserDTO resultDTO) {
		List<MatchInfoDTO> myMatchInfoList = userService.selectMyMatch(resultDTO);
		
		UserView.display(myMatchInfoList);
	}

	// 내 정보 보기
	private static void selectMyInfo(UserDTO resultDTO) {
		String userName = resultDTO.getUser_id();
		
		UserDTO userDTO = userService.selectById(userName);
		UserView.display(userDTO);
	}

}
