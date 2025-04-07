package com.app.controller.member;

import java.io.IOException;

import com.all.Action;
import com.all.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		
		result.setPath("/templates/member/login.jsp");
		result.setForward(true);
		
		return result;
		
	}

}
