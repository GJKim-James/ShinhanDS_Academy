package soccer.match.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import soccer.match.dto.MatchListDTO;
import soccer.match.service.AdminService;
import soccer.match.util.DateUtil;
import soccer.match.view.MatchListView;

public class AdminController {

	static Scanner sc = new Scanner(System.in);
	
	static AdminService adminService = new AdminService();

	// 관리자 메뉴
	static void adminMenu() {
		boolean isStop = false;
		
		while (!isStop) {
			System.out.println("======================================================================");
			System.out.println("1. 경기 추가 | 2. 경기 목록 조회 | 3. 경기 목록 수정 | 4. 경기 삭제 | 5. 로그아웃");
			System.out.println("======================================================================");
			System.out.print("번호 입력>> ");
			
			int numSelect = Integer.parseInt(sc.nextLine());

			switch (numSelect) {
				case 1 -> {
					insertMatch(); // 경기 추가
				}
				case 2 -> {
					selectMatchList(); // 경기 목록 조회
				}
				case 3 -> {
					updateMatchList(); // 경기 목록 수정
				}
				case 4 -> {
					deleteMatch(); // 경기 삭제
				}
				case 5 -> {
					isStop = true; // 로그아웃
					System.out.println("-------------------- 로그아웃 되었습니다. --------------------");
				}
			}
		}

		sc.close();
	}

	// 경기 삭제
	private static void deleteMatch() {
		System.out.print("삭제할 경기 번호 입력>> ");
		int matchNo = Integer.parseInt(sc.nextLine());
		
		int result = adminService.deleteMatch(matchNo);
		
		if (result == 1) {
			System.out.println("---------- 경기 삭제 성공 ----------");
		} else {
			System.out.println("[알림] 해당 번호를 가진 경기가 없습니다.");
		}
	}

	// 경기 목록 수정
	private static void updateMatchList() {
		System.out.println("----- 수정할 경기 목록 정보를 입력해주세요. -----");
		MatchListDTO matchListDTO = new MatchListDTO();
		
		System.out.print("경기 일시 입력(YYYY-MM-DD HH:MM:SS)>> ");
		String matchDate = sc.nextLine();
		
		System.out.print("경기 장소 입력>> ");
		String matchPlace = sc.nextLine();
		
		System.out.print("경기 신청 마감 여부 입력(0, 1)>> ");
		int matchClose = Integer.parseInt(sc.nextLine());
		
		System.out.print("경기 신청 가격 입력>> ");
		int matchPrice = Integer.parseInt(sc.nextLine());
		
		System.out.print("신청 가능 인원 수 입력>> ");
		int headCount = Integer.parseInt(sc.nextLine());
		
		System.out.print("수정할 경기 번호 입력>> ");
		int matchNo = Integer.parseInt(sc.nextLine());
		
		matchListDTO.setMatch_date(matchDate);
		matchListDTO.setMatch_place(matchPlace);
		matchListDTO.setMatch_close(matchClose);
		matchListDTO.setMatch_price(matchPrice);
		matchListDTO.setHead_count(headCount);
		matchListDTO.setMatch_no(matchNo);
		
		int result = adminService.updateMatchList(matchListDTO);
		
		if (result == 1) {
			System.out.println("---------- 경기 수정 성공 ----------");
		} else {
			System.out.println("---------- 경기 수정 실패 ----------");
		}
	}

	// 경기 목록 조회
	public static void selectMatchList() {
		List<MatchListDTO> matchList = adminService.selectAll();
		
		MatchListView.display(matchList);
	}

	// 경기 추가
	private static void insertMatch() {
		System.out.println("---------- 추가할 경기 정보를 입력해주세요. ----------");
		
		System.out.print("경기 일시(YYYY-MM-DD HH:MM:SS) : ");
		String matchDate = sc.nextLine();
		
		System.out.print("경기 장소 : ");
		String matchPlace = sc.nextLine();
		
		MatchListDTO matchListDTO = new MatchListDTO();
		matchListDTO.setMatch_date(matchDate);
		matchListDTO.setMatch_place(matchPlace);
		
		int result = adminService.insertMatch(matchListDTO);
		
		if (result == 1) {
			System.out.println("---------- 경기 추가 성공 ----------");
		} else {
			System.out.println("---------- 경기 추가 실패 ----------");
		}
	}

}
