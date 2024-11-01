package soccer.match.view;

import java.util.List;

import soccer.match.dto.MatchInfoDTO;
import soccer.match.dto.UserDTO;

public class UserView {

	public static void display(UserDTO userDTO) {
		System.out.println("-------------------- 내 정보 --------------------");
		System.out.println("아이디 : " + userDTO.getUser_id());
		System.out.println("비밀번호 : " + userDTO.getUser_pw());
		System.out.println("이름 : " + userDTO.getUser_name());
//		System.out.println("보유 금액 : " + userDTO.getUser_money() + "원");
	}

	public static void display(List<MatchInfoDTO> myMatchInfoList) {
		if (myMatchInfoList.isEmpty()) {
			System.out.println("[알림] 경기 목록이 없습니다.");
		} else {
			for (MatchInfoDTO match : myMatchInfoList) {
				System.out.println(match);
			}
		}
	}

}
