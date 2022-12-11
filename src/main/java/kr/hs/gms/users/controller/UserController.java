package kr.hs.gms.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.hs.gms.users.service.UserService;
import kr.hs.gms.users.service.impl.UserDAO;
import kr.hs.gms.users.vo.UserVO;

//implements 없어도 사용하는 방법!
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//HandlerMapping과 Controller 등록을 간단하게!
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(HttpServletRequest request, UserVO vo) throws Exception {
		System.out.println("로그인 화면 (어노테이션)");
		
		System.out.println(vo.toString());
		vo = (UserVO) request.getSession().getAttribute("sessUser");
		
		return "users/login";
	}
	
	@RequestMapping(value="/loginProcess.do", method=RequestMethod.POST)
	public ModelAndView loginProcess(HttpSession session, UserVO vo) {
		System.out.println("로그인 처리");
		
		System.out.println("userVO [" + vo.toString() + "]");
		
		//1. 사용자 정보 추출
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		String role = request.getParameter("role");
		
		//2. DB 연동 처리
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		vo.setName(name);
//		vo.setRole(role);
		
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다");
		}
		
//		UserDAO userDAO = new UserDAO();
		UserVO user = userService.getUser(vo);
		
		//3. 화면 네비게이션
		ModelAndView mv = new ModelAndView();
		if(user != null) {
			mv.setViewName("redirect:getBoardList.do");
			session.setAttribute("sessUser", user);
		} else {
			mv.setViewName("redirect:login.do");
		}
		return mv;
	}
	
	@RequestMapping(value="/logout.do")
	public ModelAndView logout(HttpServletRequest request) throws Exception{
		System.out.println("로그아웃 처리");
		
		//1. 브라우저와 연결된 세션 객체를 강제 종료한다
		request.getSession().invalidate();
		
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("redirect:getBoardList.do");

		return mv;
	}
}
