<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<form action="/post-ok.post">
		<div>
			<span>제목</span>
			<input type = "text" name = "title" placeholder="제목입력">
		</div>
		<div>
			<span>내용</span>
			<input type = "text" name = "content" placeholder="내용입력">
		</div>
		<button>게시글 작성</button>
	</form>
</body>
</html>