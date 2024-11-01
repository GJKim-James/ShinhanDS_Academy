package soccer.match.view;

import java.util.List;

import soccer.match.dto.MatchListDTO;

public class MatchListView {
	
	public static void display(List<MatchListDTO> matchList) {
		System.out.println("------------------------------ 경기 목록 ------------------------------");

		if (matchList.isEmpty()) {
			System.out.println("[알림] 경기 목록이 없습니다.");
		} else {
			for (MatchListDTO match : matchList) {
				System.out.println(match);
			}
		}
	}

	public static void display(MatchListDTO matchListDTO) {
		if (matchListDTO == null) {
			System.out.println("해당 경기 번호를 가진 목록 없음");
		} else {
			System.out.println("경기 번호 : " + matchListDTO.getMatch_no());
			System.out.println("경기 일시 : " + matchListDTO.getMatch_date());
			System.out.println("경기 장소 : " + matchListDTO.getMatch_place());
			System.out.println("경기 신청 마감 여부 : " + matchListDTO.getMatch_close());
			System.out.println("경기 신청 가격 : " + matchListDTO.getMatch_price());
			System.out.println("신청 가능 인원 수 : " + matchListDTO.getHead_count());
		}
	}

}
