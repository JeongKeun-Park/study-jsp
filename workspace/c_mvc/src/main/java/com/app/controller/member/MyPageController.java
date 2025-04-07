package com.app.controller.member;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MyPageController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
//		화면이나 다른 프론트쪽에서 사용하기 위해서는 다시 setAttribute로 member의 정보를 담아줘야한다.
		req.setAttribute("member", member);
		
		result.setPath("/templates/member/mypage.jsp");
		result.setForward(true);
		return result;
	}
}





















