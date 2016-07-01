<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/style/message.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="bigDiv">
		<div class="message">
			<div class="title">通知公告</div>
			<%-- 
				content部分需要循环读出
			 --%>
			<c:forEach items="${requestScope.message }" var="m">
				<div class="content">
					<div class="tzgg">
						<div class="tzgg_date">${m.date }:</div>
						<div class="tzgg_content">
							<a href="ShowMessage?mid=${m.mId }" target="_blank">${m.title }</a>
						</div>
						<c:if test="${sessionScope.user.power }">
							<div class="delete">
								<a href="DeleteMessage?mid=${m.mId }">删除</a>
							</div>
						</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
		<c:if test="${sessionScope.user.power }">
			<div class="message">
				<div class="title">新建通知公告</div>
				<form action="CreateMessage" method="post">
				
					<div class="box">
						<div class="c_title">标题:</div>
						<div class="c_content">
							<textarea rows="1" cols="61" name="title"></textarea>
						</div>
					</div>
					
					<div class="box">
						<div class="c_title">内容：</div>
						<div class="c_content">
							<textarea rows="10" cols="61" name="content"></textarea>
						</div>
					</div>
					<div class="submit">
						<input type="submit" value="发布" />
					</div>
					
				</form>
			</div>	
		</c:if>
	</div>
</body>
</html>