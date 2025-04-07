package com.app.controller.member;

import java.io.IOException;

import com.all.Action;
import com.all.Result;
import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO member = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		
		String memberEmail = req.getParameter("memberEmail");
		String memberPassword = req.getParameter("memberPassword");
		String memberName = req.getParameter("memberName");
		int memberAge = Integer.parseInt(req.getParameter("memberAge"));
		String memberGender = req.getParameter("memberGender");
		String path = null;
		if(memberDAO.duplicateEmail(memberEmail).orElse(null) !=null) {
			System.out.println(memberDAO.duplicateEmail(memberEmail));
			path = "/join.member?email=false";
		}else {
			member.setMemberEmail(memberEmail);
			member.setMemberPassword(memberPassword);
			member.setMemberName(memberName);
			member.setMemberAge(memberAge);
			member.setMemberGender(memberGender);
			
			memberDAO.insert(member);
			
			path = "/login.member";
		}
		
		
		result.setPath(path);
		
		return result;
	}

}
