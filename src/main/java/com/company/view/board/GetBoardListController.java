package com.company.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.spring_mvc_board.board.BoardDAO;
import com.company.spring_mvc_board.board.BoardDO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("전체 게시글 목록 보기 처리");
		
		String searchField = "";
		String searchText = "";
		
		if(request.getParameter("searchCondition") != "" 
				&& request.getParameter("searchKeyword") != "") {
			searchField = request.getParameter("searchCondition");
			searchText = request.getParameter("searchKeyword");
		}
		
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);
		
		/*
		 * 아래 소스가 MVC 프레임워크 개발 방식과의 차이점
		 */
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardList", boardList);  // Model 정보 저장
		mav.setViewName("getBoardList");		// View 정보 저장
		
		return mav;
	}

}
