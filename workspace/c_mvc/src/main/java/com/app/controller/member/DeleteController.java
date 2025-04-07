package com.app.controller.member;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteController implements Action {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = req.getSession();
		MemberDAO memberDAO = new MemberDAO();
		
		Long id = ((MemberVO)session.getAttribute("member")).getId();
		memberDAO.delete(id);
		
		result.setPath("/login.member");
		return result;
	}
}



















