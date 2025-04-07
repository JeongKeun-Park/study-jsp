package com.app.repository.member;

import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.domain.vo.MemberVO;
import com.app.mybatis.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;
	
	public MemberDAO() {
//		auto commit
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	회원가입
	public void insert(MemberVO memberVO) {
		sqlSession.insert("member.insert", memberVO);
	}
	
//	로그인
	public Optional<MemberVO> selectByMemberEmailAndMemberPassword(MemberVO memberVO){
		return Optional
				.ofNullable((MemberVO)sqlSession
						.selectOne("member.selectByMemberEmailAndMemberPassword", memberVO));
	}

	//	이메일 중복검사
	public Optional<MemberVO> selectByMemberEmail(String memberEmail){
		return Optional
				.ofNullable((MemberVO)sqlSession
						.selectOne("member.selectByMemberEmail", memberEmail));
	}
	
//	회원 수정
	public void update(MemberVO memberVO) {
		System.out.println(memberVO);
		sqlSession.update("member.update", memberVO);
	}
	
//	회원 조회
	public Optional<MemberVO> selectById(Long id){
		return Optional
				.ofNullable((MemberVO)sqlSession
						.selectOne("member.selectById", id));
	}
	
//	회원 탈퇴
	public void delete(Long id) {
		sqlSession.delete("member.delete", id);
	}
}

































