package soccer.match.service;

import java.util.List;

import soccer.match.dao.MatchListDAO;
import soccer.match.dto.MatchListDTO;

public class AdminService {
	
	MatchListDAO matchListDAO = new MatchListDAO();

	// 경기 추가
	public int insertMatch(MatchListDTO matchListDTO) {
		return matchListDAO.insert(matchListDTO);
	}

	// 경기 목록 조회
	public List<MatchListDTO> selectAll() {
		return matchListDAO.selectAll();
	}

	// 경기 목록 수정
	public int updateMatchList(MatchListDTO matchListDTO) {
		return matchListDAO.updateMatchList(matchListDTO);
	}

	// 경기 삭제
	public int deleteMatch(int matchNo) {
		return matchListDAO.deleteMatch(matchNo);
	}

}
