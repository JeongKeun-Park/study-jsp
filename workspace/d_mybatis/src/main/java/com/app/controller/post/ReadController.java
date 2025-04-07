package com.app.controller.post;

import java.io.IOException;
import java.util.Optional;

import com.app.Action;
import com.app.Result;
import com.app.domain.dto.PostDTO;
import com.app.exception.PostNotFoundException;
import com.app.repository.member.PostDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReadController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = new Result();
		Long id = Long.parseLong(req.getParameter("id"));
		int page = Integer.parseInt(req.getParameter("page"));
		PostDAO postDAO = new PostDAO();
		Optional<PostDTO> foundPost = postDAO.selectById(id);
		PostDTO post = null;
		String path = null;
		
		try {
			post = foundPost.orElseThrow(() -> {throw new PostNotFoundException();});
			req.setAttribute("post", post);
			req.setAttribute("page", page);
			path = "/templates/post/read.jsp";
			postDAO.updateReadCount(id);
			
		} catch (RuntimeException e) {
			System.out.println("존재하지 않는 게시글");
			path = "/templates/post/list.jsp";
		}
		
		result.setPath(path);
		result.setForward(true);
		
		return result;
	}

}
