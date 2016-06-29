<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style/calendar.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="bigDiv">
		<div class="calendar">
			<div class="title">日历</div>
			<div class="content">
				<div class="today">
					${requestScope.today }
				</div>
				<div class="month">
					<div class="day">
						<div class="oneday">日</div>
						<div class="oneday">一</div>
						<div class="oneday">二</div>
						<div class="oneday">三</div>
						<div class="oneday">四</div>
						<div class="oneday">五</div>
						<div class="oneday">六</div>
					</div>
					<div class="somedays">
						<c:forEach items="${requestScope.calendar }" var="cal" varStatus="status">
							
							<c:if test="${status.index%7==0 }">
								<div style="float:left;">
							</c:if>
							 
								<%-- 如果日期为今天的日期，日期变为红色 --%>
								<c:if test="${requestScope.date==cal  }">
									<span class="oneday" style="color:red; border:1px solid red;">${cal }</span>
								</c:if>
								<c:if test="${requestScope.date!=cal  }">
									<span class="oneday">${cal }</span>
								</c:if>
								
							<c:if test="${(status.index+1)%7==0 || cal==requestScope.daysOfMonth }">
								</div>
							</c:if>
							
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

		<div class="message">
			<div class="title">备忘</div>
			<div class="content">
				<c:forEach items="${requestScope.memmoryMessage }" var="mm">
					<div class="bzbw_bar">
						<p>${mm.date } : ${mm.content }</p>
						<span class="delete"><a href="DeleteMemmoryMessage?mmId=${mm.mmId }">删 除</a></span>
					</div>
				</c:forEach>
			</div>
			<a href="pages/addmm.jsp" class="create">
				创建一个新的备忘
			</a>
		</div>
	</div>
</body>
</html>