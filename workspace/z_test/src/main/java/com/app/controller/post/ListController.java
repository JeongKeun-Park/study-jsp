package com.app.controller.post;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.Criteria;
import com.app.repository.member.PostDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		PostDAO postDAO = new PostDAO();
		String temp = req.getParameter("page");
		int page = temp != null ? Integer.parseInt(temp) : 0;
		Criteria criteria = new Criteria(page, postDAO.selectCountAll());
		
		req.setAttribute("criteria", criteria);
		req.setAttribute("posts", postDAO.selectAll(criteria));
		
		result.setPath("/templates/post/list.jsp");
		result.setForward(true);
		
		return result;
	}

}
