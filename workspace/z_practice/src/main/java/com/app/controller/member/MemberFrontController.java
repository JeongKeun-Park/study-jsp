package com.app.controller.member;

import java.io.IOException;

import com.all.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String target = uri.substring(0, uri.lastIndexOf(".")).replace(req.getContextPath(), "");
		Result result = null;
		
		if(target.equals("/join")) {
			result = new JoinController().execute(req, resp);
		}else if (target.equals("/join-ok")) {
			result = new JoinOkController().execute(req, resp);
		}else if(target.equals("/login")) {
			result = new LoginController().execute(req, resp);
		}else if(target.equals("/login-of")) {
			result = new LoginOkController().execute(req, resp);
		}
	
		
		if(result.isForward()) {
			req.getRequestDispatcher(result.getPath()).forward(req, resp);
		}else {
			resp.sendRedirect(result.getPath());
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
