package com.app.controller.member;

import java.io.IOException;
import java.util.Optional;

import org.apache.ibatis.javassist.compiler.ast.Member;

import com.all.Action;
import com.all.Result;
import com.app.domain.vo.MemberVO;
import com.app.exception.LoginFailException;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginOkController implements Action {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO member = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		MemberVO memberVO = new MemberVO();

		String memberEmail = req.getParameter("memberEmail");
		String memberPassword = req.getParameter("memberPassword");

		member.setMemberEmail(memberEmail);
		member.setMemberPassword(memberPassword);

		Optional<MemberVO> loginMember = memberDAO.selectByMemberEmailAndMemberPassword(member);
		
		try {
			memberVO = loginMember.orElseThrow(()->new LoginFailException());
			session.setAttribute("member", memberVO);
			result.setPath("/mypage.member");
		} catch (LoginFailException e) {
			System.out.println("로그인 실패");
			result.setPath("/login.member?login=false");
		}

		return result;
	}
}
