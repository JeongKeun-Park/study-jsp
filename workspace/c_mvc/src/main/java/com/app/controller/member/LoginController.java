package com.app.controller.member;

import java.io.IOException;

import com.app.Action;
import com.app.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
//		LoginOkController에서 로그인 실패시 login의 값을 false로 보내준다.
//		이 login값을 다시 setAttribure 메소드를 사용하여 다시 담아서 화면으로 보내준다.
//		이때 login값을 이용하여 오류 메세지를 출력한다.
		if(req.getParameter("login") != null) {
			req.setAttribute("login", false);
		}
		result.setPath("/templates/member/login.jsp");
		result.setForward(true);
		return result;
	}
}





















