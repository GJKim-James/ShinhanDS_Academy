package soccer.match.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	
	String user_id; // 사용자 아이디
	String user_pw; // 사용자 비밀번호
	String user_name; // 사용자 이름
	String user_gender; // 사용자 성별
//	int user_money; // 사용자 보유 금액

}
