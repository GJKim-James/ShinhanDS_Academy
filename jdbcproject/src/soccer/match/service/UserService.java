package soccer.match.service;

import java.util.List;

import soccer.match.dao.UserDAO;
import soccer.match.dto.MatchInfoDTO;
import soccer.match.dto.MatchListDTO;
import soccer.match.dto.UserDTO;

public class UserService {
	
	UserDAO userDAO = new UserDAO();

	// 회원가입
	public int insertUser(UserDTO userDTO) {
		return userDAO.insert(userDTO);
	}

	// 로그인
	public UserDTO login(UserDTO userDTO) {
		return userDAO.login(userDTO);
	}

	// 내 정보 보기
	public UserDTO selectById(String userName) {
		return userDAO.selectById(userName);
	}

	// 신청 가능한 경기 목록 출력
	public List<MatchListDTO> selectAvailableMatch() {
		return userDAO.selectAvailableMatch();
	}
	
	// 이미 신청한 경기인지 중복 확인
	public int selectDuplicateChk(int matchNo, UserDTO resultDTO) {
		return userDAO.selectDuplicateChk(matchNo, resultDTO);
	}

	// 경기 번호(MATCH_NO)로 해당 경기 목록 조회
	public MatchListDTO selectByNo(int matchNo) {
		return userDAO.selectByNo(matchNo);
	}
	
	// 경기 신청하기
	public int applyMatch(int matchNo, UserDTO resultDTO, MatchListDTO matchListDTO) {
		return userDAO.applyMatch(matchNo, resultDTO, matchListDTO);
	}

	// 신청 내역 출력
	public List<MatchInfoDTO> selectMyMatch(UserDTO resultDTO) {
		return userDAO.selectMyMatch(resultDTO);
	}

}
