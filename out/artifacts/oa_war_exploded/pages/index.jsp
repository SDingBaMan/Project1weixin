<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用OA</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/index.css"/>
</head>

<frameset rows="20%, 80%">
	<frame src="${pageContext.request.contextPath }/pages/top.jsp">
	<frameset cols="15%,85%">
		<frame src="${pageContext.request.contextPath }/pages/left.jsp">
		<frame src="${pageContext.request.contextPath }/pages/right.jsp" name="rightFrame">	
	</frameset>
</frameset>

</html>