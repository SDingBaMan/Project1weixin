<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="${pageContext.request.contextPath }/style/work.css" rel="stylesheet" />
</head>
<body>

<div class="bigDiv">
	<div class="message">
		<div class="title">个人信息</div>
		<div class="content">
			<table>
				<tr>
					<td class="attrName">工号:</td>
					<td class="attrValue">${sessionScope.user.id }</td>
				</tr>
				<tr>
					<td class="attrName">姓名:</td>
					<td class="attrValue">${sessionScope.user.name }</td>
				</tr>
				<tr>
					<td class="attrName">性别:</td>
					<td class="attrValue">${sessionScope.user.sex }</td>
				</tr>
				<tr>
					<td class="attrName">生日:</td>
					<td class="attrValue">${sessionScope.user.birth }</td>
				</tr>
				<tr>
					<td class="attrName">部门:</td>
					<td class="attrValue">${sessionScope.user.department }</td>
				</tr>
				<tr>
					<td class="attrName">电话:</td>
					<td class="attrValue">${sessionScope.user.phone }</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="message">
		<div class="title">通知公告</div>
		<div class="content">
			<div class="tzgg">
				<div class="tzgg_title">${requestScope.message.title }</div>
				<div class="tzgg_content">
					${requestScope.message.content }
				</div>
				<div class="tzgg_date">${requestScope.message.date }</div>
			</div>
		</div>
	</div>
	<div class="message">
		<div class="title">备注备忘</div>
		<div class="content">
			<div class="bzbw">
				<%-- 这里是多个备忘块，需要循环数据库，输出所有备忘块 --%>
				<c:forEach items="${requestScope.memmoryMessage }" var="mm">
					<div class="bzbw_bar">
							${mm.date } : ${mm.content }
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

</body>
</html>