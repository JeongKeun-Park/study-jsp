package com.app.controller.member;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		MemberVO memberVO = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		
//		form태그안에 있는 name들을 req.getParameter로 가져와서 변수에 담아준다.
		String memberEmail = req.getParameter("memberEmail");
		String memberPassword = req.getParameter("memberPassword");
		String memberName = req.getParameter("memberName");
		int memberAge = Integer.parseInt(req.getParameter("memberAge"));
		String memberGender = req.getParameter("memberGender");
		
//		변수에 담긴 값들을 memberVO의 필드요소들에 set으로 설정해준다
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemberPassword(memberPassword);
		memberVO.setMemberName(memberName);
		memberVO.setMemberAge(memberAge);
		memberVO.setMemberGender(memberGender);
		
//		memberDAO에 insert메소드를 사용하여 세팅한 값들을 db에 올려준다
		memberDAO.insert(memberVO);
		
//		위에 코드들을 실행하고 이동할 경로를 설정한다.
		result.setPath("/login.member");
		
		return result;
	}
}







