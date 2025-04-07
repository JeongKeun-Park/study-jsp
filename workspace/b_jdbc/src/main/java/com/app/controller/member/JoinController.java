package com.app.controller.member;

import java.io.IOException;

import com.app.domain.vo.MemberVO;
import com.app.repository.member.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinController extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("/templates/member/join.jsp").forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      MemberVO memberVO = new MemberVO();
      MemberDAO memberDAO = new MemberDAO();
      
      String memberEmail = req.getParameter("memberEmail");
      String memberPassword = req.getParameter("memberPassword");
      String memberName = req.getParameter("memberName");
      int memberAge = Integer.parseInt(req.getParameter("memberAge"));
      String memberGender = req.getParameter("memberGender");
      
      memberVO.setMemberEmail(memberEmail);
      memberVO.setMemberPassword(memberPassword);
      memberVO.setMemberName(memberName);
      memberVO.setMemberAge(memberAge);
      memberVO.setMemberGender(memberGender);
      
      memberDAO.insert(memberVO);
      
      
      resp.sendRedirect("/member/login?memberName=" + memberVO.getMemberName());
   }
}



















