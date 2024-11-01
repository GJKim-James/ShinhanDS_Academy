package soccer.match.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import soccer.match.dto.MatchListDTO;
import soccer.match.util.DBUtil;

public class MatchListDAO {
	
	String sqlInsert = """
			INSERT INTO MATCH_LIST(MATCH_NO, MATCH_DATE, MATCH_PLACE)
			VALUES(SEQ_MATCH_NO.NEXTVAL, ?, ?)
			""";
	String sqlSelectAll = "SELECT * FROM MATCH_LIST";
	String sqlUpdate = """
			UPDATE MATCH_LIST
			SET MATCH_DATE = ?,
			    MATCH_PLACE = ?,
			    MATCH_CLOSE = ?,
			    MATCH_PRICE = ?,
			    HEAD_COUNT = ?
			WHERE MATCH_NO = ?
			""";
	String sqlDelete = "DELETE FROM MATCH_LIST WHERE MATCH_NO = ?";

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	// 경기 추가
	public int insert(MatchListDTO matchListDTO) {
		result = 0;
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlInsert);
			
			st.setString(1, matchListDTO.getMatch_date());
			st.setString(2, matchListDTO.getMatch_place());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}
		
		return result;
	}

	// 경기 목록 조회
	public List<MatchListDTO> selectAll() {
		List<MatchListDTO> matchList = new ArrayList<>();
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlSelectAll);
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

	// 경기 목록 수정
	public int updateMatchList(MatchListDTO matchListDTO) {
		result = 0;
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlUpdate);
			
			st.setString(1, matchListDTO.getMatch_date());
			st.setString(2, matchListDTO.getMatch_place());
			st.setInt(3, matchListDTO.getMatch_close());
			st.setInt(4, matchListDTO.getMatch_price());
			st.setInt(5, matchListDTO.getHead_count());
			st.setInt(6, matchListDTO.getMatch_no());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}
		
		return result;
	}

	// 경기 삭제
	public int deleteMatch(int matchNo) {
		result = 0;
		
		conn = DBUtil.getConnection();
		
		try {
			st = conn.prepareStatement(sqlDelete);
			
			st.setInt(1, matchNo);
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnet(conn, st, rs);
		}
		
		return result;
	}

}
