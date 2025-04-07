package com.app.repository.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.app.configuration.Configuration;
import com.app.domain.vo.MemberVO;

public class MemberDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
//	회원가입
	public void insert(MemberVO memberVO) {
		String query = "INSERT INTO TBL_MEMBER "
				+ "(ID, MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_AGE, MEMBER_GENDER) "
				+ "VALUES(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?)";
		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberVO.getMemberEmail());
			preparedStatement.setString(2, memberVO.getMemberPassword());
			preparedStatement.setString(3, memberVO.getMemberName());
			preparedStatement.setInt(4, memberVO.getMemberAge());
			preparedStatement.setString(5, memberVO.getMemberGender());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert(MemberVO) SQL문 오류");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}
	
//	로그인
	public Optional<MemberVO> selectByMemberEmailAndMemberPassword(MemberVO memberVO){
		MemberVO member = null;
		String query = "SELECT ID, MEMBER_EMAIL, MEMBER_NAME, MEMBER_AGE, MEMBER_GENDER "
				+ "FROM TBL_MEMBER "
				+ "WHERE MEMBER_EMAIL = ? AND MEMBER_PASSWORD = ?";
		
		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberVO.getMemberEmail());
			preparedStatement.setString(2, memberVO.getMemberPassword());
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				member = new MemberVO();
				member.setId(resultSet.getLong(1));
				member.setMemberEmail(resultSet.getString(2));
				member.setMemberName(resultSet.getString(3));
				member.setMemberAge(resultSet.getInt(4));
				member.setMemberGender(resultSet.getString(5));
			}
			
		} catch (SQLException e) {
			System.out.println("selectByMemberEmailAndMemberPassword(MemberVO) SQL문 오류");
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		
		return Optional.ofNullable(member);
	}
	
//	이메일 중복검사
	public Optional<MemberVO> selectByMemberEmail(String memberEmail){
		MemberVO memberVO = null;
		String query = "SELECT ID, MEMBER_EMAIL FROM TBL_MEMBER WHERE MEMBER_EMAIL = ?";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberEmail);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				memberVO = new MemberVO();
				memberVO.setId(resultSet.getLong(1));
				memberVO.setMemberEmail(resultSet.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		
		return Optional.ofNullable(memberVO);
	}
	
//	회원 수정
	public void update(MemberVO memberVO) {
		String query = "UPDATE TBL_MEMBER "
				+ "SET MEMBER_EMAIL = ?, MEMBER_NAME = ?, MEMBER_AGE = ?, "
				+ "MEMBER_GENDER = ?, UPDATED_DATE = SYSDATE "
				+ "WHERE ID = ?";
		
		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberVO.getMemberEmail());
			preparedStatement.setString(2, memberVO.getMemberName());
			preparedStatement.setInt(3, memberVO.getMemberAge());
			preparedStatement.setString(4, memberVO.getMemberGender());
			preparedStatement.setLong(5, memberVO.getId());
			
			preparedStatement.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}
	
//	회원 조회
	public Optional<MemberVO> selectById(Long id){
		MemberVO memberVO = null;
		String query = "SELECT "
				+ "ID, MEMBER_EMAIL, MEMBER_NAME, MEMBER_AGE, MEMBER_GENDER "
				+ "FROM TBL_MEMBER "
				+ "WHERE ID = ?";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				memberVO = new MemberVO();
				memberVO.setId(resultSet.getLong(1));
				memberVO.setMemberEmail(resultSet.getString(2));
				memberVO.setMemberName(resultSet.getString(3));
				memberVO.setMemberAge(resultSet.getInt(4));
				memberVO.setMemberGender(resultSet.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		
		return Optional.ofNullable(memberVO);
	}
	
//	회원 탈퇴
	public void delete(Long id) {
		String query = "DELETE FROM TBL_MEMBER WHERE ID = ?";
		
		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		
	}
}

































