package com.app.ex.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex04 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("ex04.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String area = req.getParameter("area");
		
//		if(area.equals("경기도")) {
//			String namyangju = "남양주";
//			String result = area + " " + namyangju;
//			req.setAttribute("result", result);
//			
//			req.getRequestDispatcher("ex03-result.jsp").forward(req, resp);
//		} else if(area.equals("서울")){
//			String gangnam = "강남구";
//			String result = area + " " + gangnam;
//			req.setAttribute("result", result);
//			
//			req.getRequestDispatcher("ex03-result.jsp").forward(req, resp);			
//		}
		if(area.equals("경기도")) {
			String namyangju = "남양주";
			String reulstComent = area + " " + namyangju;
			req.setAttribute("reulstComent", reulstComent);
			
			resp.sendRedirect("ex04-namyang?reulstComent=" + URLEncoder.encode(reulstComent+ "입니다", "UTF-8"));
		} else if( area.equals("서울")) {
			String gangnam = "강남구";
			String reulstComent = area + " " + gangnam;
			req.setAttribute("reulstComent", reulstComent);
			
			resp.sendRedirect("ex04-gangnam?reulstComent=" + URLEncoder.encode(reulstComent+ "입니다", "UTF-8"));			
		}
	}
}
