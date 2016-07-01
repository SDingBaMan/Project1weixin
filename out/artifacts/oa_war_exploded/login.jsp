<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>OA-Login</title>
	<link rel="stylesheet" href="style/login.css" type="text/css">
</head>

<body>
	<div id="bigDiv">
		<div class="midDiv" id="title">
			欢迎使用OA,请登录!
		</div>
		<div class="midDiv" id="message">
			${requestScope.accountMessage }
		</div>
		<div class="midDiv">
			<form action="Login" method="post">
				<div class="msg">
					<div class="title2">工&nbsp;&nbsp;&nbsp;&nbsp;号:</div><input type="text" name="username"></input>
				</div>
				<div class="msg">
					<div class="title2">密&nbsp;&nbsp;&nbsp;&nbsp;码:</div><input type="password" name="password"></input>
				</div>
				<div>
					<a href="forgetPassword.jsp" class="button">
						<input type="button" value="忘记密码?" class="button" style="background-color:red;">
					</a>
					<input type="submit" value="登录!" class="button" style="background-color:green;">
				</div>
			</form>
		</div>
	</div>
</body>

</html>