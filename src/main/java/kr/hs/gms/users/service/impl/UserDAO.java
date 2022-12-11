package kr.hs.gms.users.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import kr.hs.gms.users.vo.UserVO;
import kr.hs.gms.util.JDBCUtil;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String USER_SELECT = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	public UserVO selectUser(UserVO vo) {
		UserVO user = null;
		
		try {
			System.out.println("===> JDBC로 selectUser() 기능 처리");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_SELECT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			
			System.out.println("아이디 : " + vo.getId() + "비밀번호 : " + vo.getPassword());
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				System.out.println("로그인 성공!");
			} else {
				System.out.println("해당 아이디와 비밀번호로 매핑되는 데이터가 없습니다");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}
