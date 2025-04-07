package com.app.controller.member;

import java.io.IOException;
import java.util.Optional;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;
import com.app.exception.MemberNotFoundException;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateController implements Action {
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		HttpSession session = req.getSession();

		MemberVO member = (MemberVO) session.getAttribute("member");
		String sessionMemberEmail = member.getMemberEmail();
		String memberEmail = req.getParameter("memberEmail");
		String memberName = req.getParameter("memberName");
		int memberAge = Integer.parseInt(req.getParameter("memberAge"));
		String memberGender = req.getParameter("memberGender");
		String path = "/mypage.member";
		boolean emailFlag = false;
		
		memberVO.setId(member.getId());
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemberName(memberName);
		memberVO.setMemberAge(memberAge);
		memberVO.setMemberGender(memberGender);

		if (!sessionMemberEmail.equals(memberEmail)) {
			Optional<MemberVO> foundMember = memberDAO.selectByMemberEmail(memberEmail);
			if(foundMember.isPresent()) {
				path += "?email=false";
				emailFlag = true;
			}
		}
		
		if(!emailFlag) {
			memberDAO.update(memberVO);
			session.removeAttribute("member");
			Optional<MemberVO> foundMember = memberDAO.selectById(member.getId());
			memberVO = foundMember.orElseThrow(() -> {throw new MemberNotFoundException();});
			session.setAttribute("member", memberVO);
		}
		result.setPath(path);
		
		return result;
	}
}









