package com.app.controller.member;

import java.io.IOException;

import com.app.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		uri에 요청한 URI를 담아준다
		String uri = req.getRequestURI();
//		uri에 lastIndexOf로 마지막에 있는 . 을 찾고 0부터 lastIndexOf로 가져온 index값을 마지막으로 설정하여 target에 담아준다
		String target = uri.substring(0, uri.lastIndexOf(".")).replace(req.getContextPath(), "");
		Result result = null;
		
//		아래의 if문에서 execute 메소드를 사용하여 알맞은 result값을 가져온다.
		if(target.equals("/login")) {
			result = new LoginController().execute(req, resp);
		}else if(target.equals("/login-ok")) {
			result = new LoginOkController().execute(req, resp);
		}else if(target.equals("/logout")) {
			result = new LogOutController().execute(req, resp);
		}else if(target.equals("/join")) {
			result = new JoinController().execute(req, resp);
		}else if(target.equals("/join-ok")) {
			result = new JoinOkController().execute(req, resp);
		}else if(target.equals("/mypage")) {
			result = new MyPageController().execute(req, resp);
		}else if(target.equals("/update-ok")) {
			result = new UpdateController().execute(req, resp);
		}else if(target.equals("/delete-ok")) {
			result = new DeleteController().execute(req, resp);
		}
		
//		위의 if문들 이후 아래에 if문은 일괄처리 되기 때문에 따로 빼서 관리한다.
		if(result != null) {
			if(result.isForward()) {
//			isForward가 true일때 forward
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}else {
//				isForward가 false일때 redirect
				resp.sendRedirect(result.getPath());
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
