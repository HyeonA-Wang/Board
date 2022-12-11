package kr.hs.gms.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.hs.gms.board.service.impl.BoardDAO;
import kr.hs.gms.board.vo.BoardVO;
import kr.hs.gms.users.vo.UserVO;

public class LogoutController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");
		
		//1. 브라우저와 연결된 세션 객체를 강제 종료한다
		request.getSession().invalidate();
		
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("redirect:getBoardList.do");

		return mv;
	}
}

