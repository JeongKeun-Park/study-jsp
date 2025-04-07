package com.app.controller.member;

import java.io.IOException;

import com.app.Action;
import com.app.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinController implements Action {
//	이 메소드는 단순 경로이동만 실행한다.
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		
		result.setPath("/templates/member/join.jsp");
		result.setForward(true);
		return result;
	}
}



















