<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
	<form action="/update-ok.post" method="post">
		<input type="hidden" name="page" value="${page}">
		<input type="hidden" name="id" value="${post.id}">
		<input type="text" name="postTitle" value="${post.postTitle}">
		<textarea rows="4" cols="20" name="postContent">${post.postContent}</textarea>
		<button>수정 완료</button>
	</form>
</body>
</html>