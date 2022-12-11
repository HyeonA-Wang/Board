package kr.hs.gms.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.hs.gms.users.service.impl.UserDAO;
import kr.hs.gms.users.vo.UserVO;

public class LoginProcessController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 처리");
		
		//1. 사용자 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.selectUser(vo);
		
		//3. 화면 네비게이션
		ModelAndView mv = new ModelAndView();
		if(user != null) {
			mv.setViewName("redirect:getBoardList.do");
			request.getSession().setAttribute("sessUser", user);
		} else {
			mv.setViewName("redirect:login.do");
		}
		return mv;
	}
}
