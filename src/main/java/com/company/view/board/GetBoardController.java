package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.spring_mvc_board.board.BoardDAO;
import com.company.spring_mvc_board.board.BoardDO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("게시글 상세보기 처리");
		
		// getBoardList.jsp 페이지에서 get 방식으로 넘어온 게시글번호 얻어옴
		String seq = request.getParameter("seq");
		
		BoardDO boardDO = new BoardDO();
		boardDO.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardDO board = boardDAO.getBoard(boardDO);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);  // Model 결과 정보 저장
		mav.setViewName("getBoard");  // View 정보(=포워딩) 저장
		
		return mav;
	}
}
