package com.app.controller.post;

import java.io.IOException;

import com.app.Action;
import com.app.Result;
import com.app.domain.vo.MemberVO;
import com.app.domain.vo.PostVO;
import com.app.repository.member.PostDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PostOkController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		PostDAO postDAO = new PostDAO();
		PostVO post = new PostVO();
		
		String postTitle = req.getParameter("title");
		String postContent = req.getParameter("content");
		Long memberId = memberVO.getId();
		
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);
		post.setMemberId(memberId);
		
		postDAO.insert(post);
		
		return null;
	}
}
