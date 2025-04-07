package com.app.repository.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.app.domain.dto.PostDTO;
import com.app.domain.vo.Criteria;
import com.app.domain.vo.PostVO;
import com.app.mybatis.config.MyBatisConfig;

public class PostDAO {
	public SqlSession sqlSession;

	public PostDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

//	추가하기
	public void insert(PostVO postVO) {
		sqlSession.insert("post.insert", postVO);
	}
	
//	전체 목록
	public List<PostDTO> selectAll(Criteria criteria){
		System.out.println("Criteria: " + criteria);
		return sqlSession.selectList("post.selectAll", criteria);
	}
	
//	전체 게시글 개수
	public int selectCountAll() {
		return sqlSession.selectOne("post.selectCountAll");
	}
}



















