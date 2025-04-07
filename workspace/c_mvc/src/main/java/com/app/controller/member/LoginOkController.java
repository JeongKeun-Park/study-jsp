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
//		로그인한 회원의 정보를 담고다닐 session을 하나 생성해준다.
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
//			로그인 성공시 생성한 session에 setAttribute메소드를 이용하여 member 라는이름에 member의 정보를 담아준다
			session.setAttribute("member", member);
			path = "/mypage.member";
		} catch (LoginFailException e) {
//			로그인 실패시 원래의 로그인 화면으로 돌아가며 login의 값을 false로 설정하여 돌려준다.
			System.out.println("로그인 실패");
			path = "/login.member?login=false";
		}
		
		result.setPath(path);
		
		return result;
	}
}
