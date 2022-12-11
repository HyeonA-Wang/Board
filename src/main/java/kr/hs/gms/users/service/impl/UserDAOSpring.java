package kr.hs.gms.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.hs.gms.users.vo.UserRowMapper;
import kr.hs.gms.users.vo.UserVO;

//@Repository("userDAO")
public class UserDAOSpring {
	
	private final String USER_SELECT = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserVO selectUser(UserVO vo) {
		System.out.println("===>JDBC Template을 이용한 selectUser() 기능 처리");
		
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_SELECT, args, new UserRowMapper());
	}
}
