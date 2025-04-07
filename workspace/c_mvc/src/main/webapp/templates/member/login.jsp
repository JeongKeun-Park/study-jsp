<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	#check {
		color: red;
	}
</style>
</head>
<body>
	<form action="/login-ok.member" method="post" name="login-form">
		<div>
			<input type="text" name="memberEmail" placeholder="이메일 입력">
		</div>
		<div>
			<input type="password" name="memberPassword" placeholder="비밀번호 입력">
		</div>
		<!-- login값을 getParameter메소드를 이용하여 가져온다
		만약 이 값이 null이 아니라면 login때 Exception이 발생했다는 의미이기 때문에
		경고 메세지를 p태그에 담아 출력해준다 -->
		<%if(request.getParameter("login") != null){%>
			<div>
				<p id="check">아이디 또는 비밀번호를 다시 확인해주세요</p>
			</div>
		<%} %>
		<div>
			<button>로그인</button>
		</div>
	</form>
</body>
</html>







