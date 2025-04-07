package com.app.controller.post;

import java.io.IOException;

import com.app.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PostFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String target = uri.substring(0, uri.lastIndexOf(".")).replace(req.getContextPath(), "");
		Result result = null;
		
		if(target.equals("/post")) {
			result = new PostController().execute(req, resp);
		}if(target.equals("/post-ok")) {
			result = new PostOkController().execute(req, resp);
		}
		
		if(result != null) {
			if(result.isForward()) {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}else {
				resp.sendRedirect(result.getPath());
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
