package kr.hs.gms.board.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.hs.gms.board.service.BoardService;
import kr.hs.gms.board.service.impl.BoardDAO;
import kr.hs.gms.board.vo.BoardVO;
import kr.hs.gms.users.vo.UserVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(HttpServletRequest request, BoardVO vo, BoardDAO boardDAO, ModelAndView mv) throws Exception {
		System.out.println("글 상세 검색 처리 (어노테이션)");
		
		UserVO userSession = (UserVO) request.getSession().getAttribute("sessUser");
//		ModelAndView mv = new ModelAndView();
		
		if(userSession != null) {
			//1. 검색할 게시글 번호 추출
//			String seq = request.getParameter("seq");
			
			//2.DB 연동 처리
//			BoardVO vo = new BoardVO();
//			vo.setSeq(Integer.parseInt(seq));
			
//			BoardDAO boardDAO = new BoardDAO();
//			BoardVO board = boardDAO.selectBoard(vo);
			
			//3. 검색 결과와 화면정보를 ModelAndView에 저장하여 리턴한다
			mv.addObject("board", boardService.getBoard(vo));
			mv.setViewName("board/getBoard");
		} else {
			mv.setViewName("redirect:login.do");
		}
		
		return mv;
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("제목", "TITLE");
		
		return conditionMap;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", defaultValue="TITLE", required=true) String condition, HttpServletRequest request, BoardVO vo, BoardDAO boardDAO, Model model) throws Exception{
		System.out.println("글 목록 검색 처리 (어노테이션)");
		
		String keyword = request.getParameter("searchKeyword");
		
		String viewName = "";
		UserVO userSession = (UserVO) request.getSession().getAttribute("sessUser");
		
		System.out.println("condition=" + condition);
		System.out.println("keyword=" + keyword);
		
		if(userSession != null) {
			//1. 사용자 입력정보 추출
			//2. DB 연동 처리
//			BoardVO vo = new BoardVO();
//			vo.setSearchCondition(condition);
//			vo.setSearchKeyword(keyword);
			//3. 검색 결과와 화면 정보를 ModelAndView에 저자하여 리턴한다
			
			if(vo.getSearchCondition() == null) {
				vo.setSearchCondition("TITLE");
			}
			if(vo.getSearchKeyword() == null) {
				vo.setSearchKeyword("");
			}
			
			System.out.println(vo.toString());
			model.addAttribute("boardList", boardService.getBoardList(vo));
			viewName = "board/getBoardList";
		} else {
			viewName = "redirect:login.do";
		}
		return viewName;
	}
	
	@RequestMapping(value="/regBoard.do")
	public ModelAndView regBoard() throws Exception {
		System.out.println("글 등록 화면 (어노테이션)");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/regBoard");
		
		return mv;
	}
	
	@RequestMapping(value="/insertBoard.do")
	public ModelAndView insertBoard(HttpServletRequest request, BoardVO vo, BoardDAO boardDAO, ModelAndView mv) throws Exception {
		System.out.println("글 등록 처리 (어노테이션)");
		
		//1. 사용자 입력 정보 추출
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
		
		//2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
		
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/" + fileName));
		}
		
		boardService.createBoard(vo);
		
//		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:getBoardList.do");
		
		return mv;
	}
	
	@RequestMapping(value="/updateBoard.do")
	public ModelAndView updateBoard(HttpServletRequest request, @ModelAttribute("board") BoardVO vo, BoardDAO boardDAO, ModelAndView mv) throws Exception {
		System.out.println("글 수정 처리 (어노테이션)");
		
		//1. 사용자 입력 정보 추출
//		String seq = request.getParameter("seq");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
		
		//2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		vo.setTitle(title);
//		vo.setContent(content);
		
		System.out.println(vo.toString());
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.updateBoard(vo);
		
		boardService.modifyBoard(vo);
		
//		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:getBoardList.do");
		
		return mv;
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public ModelAndView deleteBoard(HttpServletRequest request, BoardVO vo, BoardDAO boardDAO, ModelAndView mv) throws Exception {
		System.out.println("글 삭제 처리 (어노테이션)");
		
		//1. 사용자 입력 정보 추출
//		String seq = request.getParameter("seq");
		
		//2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
		
		boardService.removeBoard(vo);
		
//		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:getBoardList.do");
		
		return mv;
	}
}
