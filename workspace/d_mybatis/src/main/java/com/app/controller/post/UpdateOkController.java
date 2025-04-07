package com.app.controller.post;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.PostVO;
import com.app.repository.member.PostDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		PostDAO postDAO = new PostDAO();
		Long id = Long.parseLong(req.getParameter("id"));
		int page = Integer.parseInt(req.getParameter("page"));
		String postTitle = req.getParameter("postTitle");
		String postContent = req.getParameter("postContent");
		
		PostVO postVO = new PostVO();
		postVO.setId(id);
		postVO.setPostTitle(postTitle);
		postVO.setPostContent(postContent);
		
		postDAO.update(postVO);
		result.setPath("/read.post?id=" + id + "&page=" + page);
		return result;
	}
}












