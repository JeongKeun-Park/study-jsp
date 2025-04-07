package com.app.repository.member;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.domain.vo.MemberVO;
import com.app.mybatis.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;

	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	회원가입
	public void insert(MemberVO memberVO) {
		sqlSession.insert("member.insert", memberVO);
	}

//	이메일 중복검사
	public Optional<MemberVO> duplicateEmail(String memberEmail) {
		return Optional.ofNullable((MemberVO) sqlSession
				.selectOne("member.duplicateEmail", memberEmail));
	}

//	로그인
	public Optional<MemberVO> selectByMemberEmailAndMemberPassword(MemberVO memberVO) {
		return Optional.ofNullable((MemberVO)sqlSession
				.selectOne("member.selectByMemberEmailAndMemberPassword", memberVO));
	}
	

}
