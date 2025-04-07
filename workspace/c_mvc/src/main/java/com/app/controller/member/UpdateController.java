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
//		로그인한 회원의 정보를 다시 가져오기 위해 session 받을 준비를 한다.
		HttpSession session = req.getSession();
//		session에 member의 정보를 가지고 있는 member를 getAttribute 메소드를 사용하여 가져온다
//		이때 Object 객체로 오기 때문에 MemberVO 로 다운캐스팅 해준다
//		이걸 member객체에 저장한다. (이게 로그인한 회원의 정보가 된다.)
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

//		이때는 회원정보가 수정되지 않는다.
//		파라미터값으로 받아온 이메일정보가 있다면
//		path를 재설정하고 emailflag를 true로 설정한다.
		if (!sessionMemberEmail.equals(memberEmail)) {
			Optional<MemberVO> foundMember = memberDAO.selectByMemberEmail(memberEmail);
			if(foundMember.isPresent()) {
				path += "?email=false";
				emailFlag = true;
			}
		}
		
//		emailFlag가 false라는 말은 위의 이메일 중복검사를 통과했다는 말이 된다.
//		따라서 이때 정보가 수정되고 세션에 기존에 있던 member를 제거한 후에
//		수정되었던 member의 정보를 다시 객체에 담아준다.
//		이후 setAttribute메소드를 통해 다시한번 세션에 담아서 재사용한다.
		if(!emailFlag) {
			memberDAO.update(memberVO);
//			removeAttribute는 세션에 특정 속성을 삭제하는 메소드이다
			session.removeAttribute("member");
//			Optional에 있는 member는 기존 세션에 있던 유저의 id를 뜻한다.
			Optional<MemberVO> foundMember = memberDAO.selectById(member.getId());
//			memberVO는 수정된 정보를 담기위한 객체이다.
			memberVO = foundMember.orElseThrow(() -> {throw new MemberNotFoundException();});
			session.setAttribute("member", memberVO);
		}
		result.setPath(path);
		
		return result;
	}
}









