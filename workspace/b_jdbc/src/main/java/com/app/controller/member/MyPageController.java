package com.app.controller.member;

import java.io.IOException;

import com.app.domain.vo.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MyPageController extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	   
	   //	   세션을 생성후 member객체를 받아온다
//	   session은 Object객체이기떄문에 다운캐스팅후 사용
      HttpSession session = req.getSession();
      MemberVO member = (MemberVO)session.getAttribute("member");
      System.out.println("메인" +member);
      req.setAttribute("member", member);
      req.getRequestDispatcher("/templates/member/mypage.jsp").forward(req, resp);
   }
}





















