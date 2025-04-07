package com.app.controller.member;

import java.io.IOException;
import java.util.Optional;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;
import com.app.exception.LoginFailException;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginOkController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = req.getSession();
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		MemberVO member = null;
		String path = null;
		
		String memberEmail = req.getParameter("memberEmail");
		String memberPassword = req.getParameter("memberPassword");
		
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemberPassword(memberPassword);
		
		Optional<MemberVO> foundMember = memberDAO.selectByMemberEmailAndMemberPassword(memberVO);
		
		try {
			member = foundMember.orElseThrow(() -> {throw new LoginFailException();});
			session.setAttribute("member", member);
			path = "/mypage.member";
		} catch (LoginFailException e) {
			System.out.println("로그인 실패");
			path = "/login.member?login=false";
		}
		
		result.setPath(path);
		
		return result;
	}
}
