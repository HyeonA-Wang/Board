package kr.hs.gms.users.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.hs.gms.users.service.UserService;
import kr.hs.gms.users.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDAO")
	private UserDAOMybatis userDAO;
	
	public UserVO getUser(UserVO vo) {
		return userDAO.selectUser(vo);
	}
}
