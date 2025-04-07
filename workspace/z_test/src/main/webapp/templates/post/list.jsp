<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
	table {
		width: 500px;
		margin: 0 auto;
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	tr, td, th {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성 날짜</th>
		</tr>
		<c:forEach var="post" items="${posts}">
			<tr>
				<td>${post.id}</td>
				<td>${post.postTitle}</td>
				<td>${post.memberName}</td>
				<td>${post.createdDate}</td>
			</tr>
		</c:forEach>
	</table>
	<div style="width: 500px; margin: 0 auto; text-align: center;">
	<c:if test="${criteria.prev}">
		<a href="/list.post?page=${criteria.startPage - 1}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${criteria.startPage}" end="${criteria.endPage}">
		<a href="/list.post?page=${i}">${i}</a>
	</c:forEach>
	<c:if test="${criteria.next}">
		<a href="/list.post?page=${criteria.endPage + 1}">[다음]</a>
	</c:if>
	</div>
</body>
</html>














