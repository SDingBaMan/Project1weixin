<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

body{
	background-color:#08273b;
}

span{
	color:white;
}

ul {
	list-style: none;
	margin-top: 20px;
}

ul li {
	margin-bottom: 10px;
}

ul li a {
	text-decoration: none;
	color: white;
	font-size: 18px;
	font-weight: Bold;
}

ul li a:visited {
	text-decoration: none;
	color: white;
	font-size: 18px;
	font-weight: Bold;
}
</style>

</head>

<body>
	<center>
		<span>【${sessionScope.user.name }】 您好！</span>
	</center>
	<hr/>
	<ul>
		<li><a href="${pageContext.request.contextPath }/ChooseRightPage?choose=1" target="rightFrame">工作台</a></li>
		<li><a href="${pageContext.request.contextPath }/ChooseRightPage?choose=2" target="rightFrame">通知公告</a></li>
		<li><a href="${pageContext.request.contextPath }/ChooseRightPage?choose=3" target="rightFrame">日历</a></li>
		<li><a href="${pageContext.request.contextPath }/ChooseRightPage?choose=4" target="rightFrame">审批</a></li>
	</ul>
</body>
</html>