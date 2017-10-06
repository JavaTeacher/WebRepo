/**
 * 
 */
package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.dao
 *  |_ UserDao
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 6.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class UserDao extends AbstractDao {

	private static UserDao dao = new UserDao();
	
	private UserDao() {
		
	}
	
	public static UserDao getInstance() {
		return dao;
	}
	
	public UserVO searchUser(UserVO vo) throws Exception {
		
		String sql = "SELECT ID, NAME, NICKNAME FROM USER WHERE ID=? AND PWD=?";
		
		try (Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			ResultSet rs = pstmt.executeQuery();
			
			UserVO result = null;
			if(rs.next()) {
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setNickname(rs.getString(3));
			}
			
			return result;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}
	
	public UserVO searchUserById(UserVO vo) throws Exception {
		
		String sql = "SELECT ID, NAME, NICKNAME FROM USER WHERE ID=?";
		
		try (Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			
			UserVO result = null;
			if(rs.next()) {
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setNickname(rs.getString(3));
			}
			
			return result;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}
	
	public void insertUser(UserVO vo) throws Exception {
		
		String sql = "INSERT INTO USER VALUES(?, ?, ?, ?)";
		
		try (Connection connection = getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNickname());
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 0) throw new Exception("사용자 등록 실패");
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 등록 시 오류가 발생하였습니다.");
		}
	}
}
