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
		req.setAttribute("member", member);
		
		result.setPath("/templates/member/mypage.jsp");
		result.setForward(true);
		return result;
	}
}





















