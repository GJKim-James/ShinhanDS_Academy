package soccer.match.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import soccer.match.dto.MatchInfoDTO;
import soccer.match.dto.MatchListDTO;
import soccer.match.dto.UserDTO;
import soccer.match.util.DBUtil;

public class UserDAO {
	
	String sqlInsert = "INSERT INTO USER_INFO(USER_ID, USER_PW, USER_NAME, USER_GENDER) VALUES(?, ?, ?, ?)";
	String sqlIdDupCheck = "SELECT * FROM USER_INFO WHERE USER_ID = ?";
	String sqlLogin = "SELECT * FROM USER_INFO WHERE USER_ID = ? AND USER_PW = ?";
	String sqlSelectById = "SELECT * FROM USER_INFO WHERE USER_ID = ?";
	String sqlDuplicateChk = "SELECT * FROM MATCH_INFO WHERE MATCH_NO = ? AND USER_ID = ? AND USER_NAME = ?";
	String sqlSelectMatch = "SELECT * FROM MATCH_LIST WHERE MATCH_CLOSE = 0 ORDER BY MATCH_NO, MATCH_DATE";
	String sqlSelectByNo = "SELECT * FROM MATCH_LIST WHERE MATCH_NO = ?";
	String sqlApplyMatch = """
			INSERT INTO MATCH_INFO(MATCH_SEQ, USER_NAME, MATCH_DATE, MATCH_PLACE, USER_ID, MATCH_NO)
			VALUES(SEQ_MATCH_NO.NEXTVAL, ?, ?, ?, ?, ?)
			""";
	String sqlSelectMyMatch = "SELECT * FROM MATCH_INFO WHERE USER_ID = ? ORDER BY MATCH_SEQ, MATCH_DATE";

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;

	// 회원가입
	public int insert(UserDTO userDTO) {
		result = 0;

		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sqlInsert);

			st.setString(1, userDTO.getUser_id());
			st.setString(2, userDTO.getUser_pw());
			st.setString(3, userDTO.getUser_name());
			st.setString(4, userDTO.getUser_gender());

			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

		return result;
	}
	
	// 회원가입 시 아이디 중복 확인
	public int idDupCheck(String userId) {
		result = 0;

		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sqlIdDupCheck);

			st.setString(1, userId);

			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

		return result;
	}

	// 로그인
	public UserDTO login(UserDTO userDTO) {
		conn = DBUtil.getConnection();
		
		UserDTO resultDTO = new UserDTO();

		try {
			st = conn.prepareStatement(sqlLogin);

			st.setString(1, userDTO.getUser_id());
			st.setString(2, userDTO.getUser_pw());

			rs = st.executeQuery();
			
			while (rs.next()) {
				resultDTO.setUser_id(rs.getString("USER_ID"));
				resultDTO.setUser_pw(rs.getString("USER_PW"));
				resultDTO.setUser_name(rs.getString("USER_NAME"));
				resultDTO.setUser_gender(rs.getString("USER_GENDER"));
//				resultDTO.setUser_money(rs.getInt("USER_MONEY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}

		return resultDTO;
	}

	// 내 정보 보기
	public UserDTO selectById(String userId) {
		conn = DBUtil.getConnection();
		
		UserDTO resultDTO = new UserDTO();
		
		try {
			st = conn.prepareStatement(sqlSelectById);
			
			st.setString(1, userId);
			rs = st.executeQuery();
			
			while (rs.next()) {
				resultDTO.setUser_id(rs.getString("USER_ID"));
				resultDTO.setUser_pw(rs.getString("USER_PW"));
				resultDTO.setUser_name(rs.getString("USER_NAME"));
				resultDTO.setUser_gender(rs.getString("USER_GENDER"));
//				resultDTO.setUser_money(rs.getInt("USER_MONEY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}
		
		return resultDTO;
	}
	
	// 이미 신청한 경기인지 중복 확인
	public int selectDuplicateChk(int matchNo, UserDTO resultDTO) {
		int result = 0;
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlDuplicateChk);
			st.setInt(1, matchNo);
			st.setString(2, resultDTO.getUser_id());
			st.setString(3, resultDTO.getUser_name());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}
		
		return result;
	}

	// 신청 가능한 경기 목록 출력
	public List<MatchListDTO> selectAvailableMatch() {
		List<MatchListDTO> matchList = new ArrayList<>();
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlSelectMatch);
			rs = st.executeQuery();
			
			while (rs.next()) {
				MatchListDTO matchListDTO = new MatchListDTO();
				
				matchListDTO.setMatch_no(rs.getInt("MATCH_NO"));
				matchListDTO.setMatch_date(rs.getString("MATCH_DATE"));
				matchListDTO.setMatch_place(rs.getString("MATCH_PLACE"));
				matchListDTO.setMatch_close(rs.getInt("MATCH_CLOSE"));
				matchListDTO.setMatch_price(rs.getInt("MATCH_PRICE"));
				matchListDTO.setHead_count(rs.getInt("HEAD_COUNT"));
				
				matchList.add(matchListDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}
		
		return matchList;
	}

	// 경기 번호(MATCH_NO)로 해당 경기 목록 조회
	public MatchListDTO selectByNo(int matchNo) {
		MatchListDTO matchListDTO = new MatchListDTO();
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlSelectByNo);
			
			st.setInt(1, matchNo);
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				matchListDTO.setMatch_no(rs.getInt("MATCH_NO"));
				matchListDTO.setMatch_date(rs.getString("MATCH_DATE"));
				matchListDTO.setMatch_place(rs.getString("MATCH_PLACE"));
				matchListDTO.setMatch_close(rs.getInt("MATCH_CLOSE"));
				matchListDTO.setMatch_price(rs.getInt("MATCH_PRICE"));
				matchListDTO.setHead_count(rs.getInt("HEAD_COUNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}
		
		return matchListDTO;
	}

	// 경기 신청하기
	public int applyMatch(int matchNo, UserDTO resultDTO, MatchInfoDTO matchInfoDTO) {
		result = 0;
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlApplyMatch);
			
			st.setString(1, resultDTO.getUser_name());
			st.setString(2, matchInfoDTO.getMatch_date());
			st.setString(3, matchInfoDTO.getMatch_place());
			st.setString(4, resultDTO.getUser_id());
			st.setInt(5, matchNo);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}
		
		return result;
	}

	// 신청 내역 출력
	public List<MatchInfoDTO> selectMyMatch(UserDTO resultDTO) {
		List<MatchInfoDTO> myMatchInfoList = new ArrayList<>();
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlSelectMyMatch);
			st.setString(1, resultDTO.getUser_id());
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				MatchInfoDTO myMatchListDTO = new MatchInfoDTO();
				
				myMatchListDTO.setMatch_seq(rs.getInt("MATCH_SEQ"));
				myMatchListDTO.setUser_name(rs.getString("USER_NAME"));
				myMatchListDTO.setMatch_date(rs.getString("MATCH_DATE"));
				myMatchListDTO.setMatch_place(rs.getString("MATCH_PLACE"));
				myMatchListDTO.setUser_id(rs.getString("USER_ID"));
				myMatchListDTO.setMatch_no(rs.getInt("MATCH_NO"));
				
				myMatchInfoList.add(myMatchListDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}
		
		return myMatchInfoList;
	}

}
