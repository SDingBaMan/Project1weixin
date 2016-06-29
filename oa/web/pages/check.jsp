<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style/check.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="bigDiv">
		<div class="box">
			<div class="title">请假</div>
			<div class="content">
				<%-- 如果是普通员工 --%>
				<c:if test="${not sessionScope.user.power }">
					<form action="Check" method="get">
						<div class="days">
							<span>请输入请假天数:</span>
							<span>
								<input type="text" name="days"/>&nbsp;天
							</span>
						</div>
						<div class="submit">
							<input type="submit" value="申请">
						</div>
					</form>
				</c:if>
				
				<%-- 如果是管理员 --%>
				<c:if test="${sessionScope.user.power }">
					<table class="applys">
						<thead>
							<tr>
								<td>日期</td>
								<td>申请人</td>
								<td>申请内容</td>
								<td>审核</td>
							</tr>
						</thead>
						<c:forEach items="${requestScope.applys }" var="a">
							<tr>
								<td>${a.date }</td>
								<td>${a.sendId }</td>
								<td>请假${a.content }天</td>
								<td>
									<span class="button" <c:if test="${a.state==1 }">style="border:1px solid red;"</c:if> >
										<a href="Approval?check=1&aid=${a.aId }">同意</a>
									</span>
									&nbsp;
									<span class="button" <c:if test="${a.state==0 }">style="border:1px solid red;"</c:if> >
										<a href="Approval?check=0&aid=${a.aId }" class="button">不同意</a>
									</span>
								</td>
							</tr>
						</c:forEach>
					</table>
				
				</c:if>
				
			</div>
			<c:if test="${not sessionScope.user.power }">
				<hr/>
				<table class="applys">
					<thead>
						<tr>
							<td>日期</td>
							<td>申请人</td>
							<td>申请内容</td>
							<td>审核状态</td>
						</tr>
					</thead>
					<c:forEach items="${requestScope.myapplys }" var="a">
						<tr>
							<td>${a.date }</td>
							<td>${a.sendId }</td>
							<td>请假${a.content }天</td>
							<td>
								<c:if test="${a.state==1 }">批准</c:if>
								<c:if test="${a.state==0 }">未批准</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>