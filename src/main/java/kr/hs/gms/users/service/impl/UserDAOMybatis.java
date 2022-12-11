package kr.hs.gms.users.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.hs.gms.users.vo.UserVO;

@Repository("userDAO")
public class UserDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public UserVO selectUser(UserVO vo) {
		System.out.println("===> Mybatis(방법2)로 selectUser() 기능 처리");
		return (UserVO) mybatis.selectOne("Users.selectUser", vo);
	}
}
