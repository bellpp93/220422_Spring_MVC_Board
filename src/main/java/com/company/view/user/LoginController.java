package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.spring_mvc_board.user.UserDAO;
import com.company.spring_mvc_board.user.UserDO;

public class LoginController implements Controller {

	@Override  // 다형성 => 메소드 오버라이딩
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 처리");
		
		// 1. 사용자 입력 정보 얻어오기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. Model을 이용하여 H2 DB연동 처리
		UserDO userDO = new UserDO();
		userDO.setId(id);
		userDO.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		
		// 3. 포워딩(=네비게이션)
		ModelAndView mav = new ModelAndView();
		
		if (user != null) {
//			System.out.println("로그인 인증 성공");
			mav.setViewName("redirect:getBoardList.do");
		} else {
//			System.out.println("로그인 인증 실패");
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}
}
