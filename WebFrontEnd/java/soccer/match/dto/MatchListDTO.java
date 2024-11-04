package soccer.match.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class MatchListDTO {
	
	int match_no; // 경기 번호
	String match_date; // 경기 일시
	String match_place; // 경기 장소
	int match_close; // 경기 신청 마감 여부
	int match_price; // 경기 신청 가격
	int head_count; // 인원수
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[경기 번호 : ").append(match_no).append(", 경기 일시 : ").append(match_date)
				.append(", 경기 장소 : ").append(match_place).append(", 신청 마감 여부 : ").append(match_close)
				.append(", 신청 가격 : ").append(match_price).append(", 신청 가능한 인원 수 : ").append(head_count).append("]");
		return builder.toString();
	}

}
