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
public class MatchInfoDTO {
	
	int match_seq; // 경기 정보(MATCH_INFO) 번호
	String user_name; // 사용자 이름
	String match_date; // 경기 일시
	String match_place; // 경기 장소
	int match_count; // 경기 참여 인원 수
	String user_id; // 사용자 아이디
	int match_no; // 경기 번호
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[신청 경기 번호 : ").append(match_seq).append(", 사용자 이름 : ").append(user_name)
				.append(", 경기 일시 : ").append(match_date).append(", 경기 장소 : ").append(match_place)
				.append(", 경기 참여 인원 : ").append(match_count).append(", 사용자 아이디 : ").append(user_id)
				.append(", 경기 번호 : ").append(match_no).append("]");
		return builder.toString();
	}

}
