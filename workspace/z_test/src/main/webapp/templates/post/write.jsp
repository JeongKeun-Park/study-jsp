<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<form action="/write-ok.post" method="post">
		<h3>게시글 제목</h3>
		<div>
			<input type="text" name="postTitle">
		</div>
		<h3>게시글 내용</h3>
		<div>
			<textarea name="postContent" rows="5" cols="20"></textarea>
		</div>
		<button>작성하기</button>
	</form>
</body>
</html>


