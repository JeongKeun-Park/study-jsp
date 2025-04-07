<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="/login-ok.member" method="post" name = "login-form">
		<div>
			<input type="text" name="memberEmail" placeholder="이메일 입력">
		</div>
		<div>
			<input type="password" name="memberPassword" placeholder="비밀번호 입력">		
		</div>
		<button>로그인</button>
	</form>
</body>
</html>