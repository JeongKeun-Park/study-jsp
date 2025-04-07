package com.app.ex.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex03 extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action == null){
			req.getRequestDispatcher("/ex03.jsp").forward(req, resp);
		} else if(action.equals("fruit")) {
			String fruit = req.getParameter("fruit");
			String price = req.getParameter("price");
			String result = fruit + "는 " + price;
			
			req.setAttribute("result", result);
			req.getRequestDispatcher("/ex03-result.jsp").forward(req, resp);
		}
	}
	
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String fruit = req.getParameter("fruit");
//		String price = req.getParameter("price");
//		String result = fruit + "는 " + price;
//		
//		req.setAttribute("result", result);
//		req.getRequestDispatcher("/ex03-result.jsp").forward(req, resp);
//		
//		
//	}
}
