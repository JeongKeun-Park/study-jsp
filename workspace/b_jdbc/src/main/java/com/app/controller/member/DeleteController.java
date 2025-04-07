package com.app.controller.member;

import java.io.IOException;

import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		MemberDAO memberDAO = new MemberDAO();
		
		Long memberId = memberVO.getId();
		
		memberDAO.delete(memberId);
		
		session.invalidate();
		
		resp.sendRedirect("/templates/member/login.jsp");
	}
}
