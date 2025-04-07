<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<a href="/list.post?page=${page}">돌아가기</a>
	<c:if test="${member.id eq post.memberId}">
	<a href="/update.post?id=${post.id}&page=${page}">수정하기</a>
	<a href="/delete.post?id=${post.id}&page=${page}">삭제하기</a>
	</c:if>
	<div>
		<h1>조회수: ${post.postReadCount}회</h1>
		<h2>${post.postTitle}</h2>
		<h3>${post.memberName}</h3>
		<p>${post.postContent}</p>
	</div>
</body>
</html>