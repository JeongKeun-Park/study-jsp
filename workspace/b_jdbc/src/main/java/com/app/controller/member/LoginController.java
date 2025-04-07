package com.app.controller.member;

import java.io.IOException;
import java.util.Optional;

import com.app.domain.vo.MemberVO;
import com.app.exception.LoginFailException;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      if(req.getParameter("login") != null) {
         req.setAttribute("login", false);
      }
      req.getRequestDispatcher("/templates/member/login.jsp").forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	   정보를 들고다니기 위한 세션 생성
      HttpSession session = req.getSession();
      MemberDAO memberDAO = new MemberDAO();
      MemberVO memberVO = new MemberVO();
      MemberVO member = null;
      
      String memberEmail = req.getParameter("memberEmail");
      String memberPassword = req.getParameter("memberPassword");
      
      memberVO.setMemberEmail(memberEmail);
      memberVO.setMemberPassword(memberPassword);
      
      Optional<MemberVO> foundMember = memberDAO.selectByMemberEmailAndMemberPassword(memberVO);
      
      try {
         member = foundMember.orElseThrow(() -> {throw new LoginFailException();});
//         세션안에 member객체를 담는다
         session.setAttribute("member", member);
         resp.sendRedirect("/member/mypage");
      } catch (LoginFailException e) {
         System.out.println("로그인 실패");
         resp.sendRedirect("/member/login?login=false");
      }
   }
}





















