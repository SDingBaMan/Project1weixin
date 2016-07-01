<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建备忘</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/addmm.css" />
</head>
<body>
	<div class="bigDiv">
		<div class="box">
			<div class="title">请创建备忘信息</div>
			<div class="message">${requestScope.message }</div>
			<div class="content">
				<form action="${pageContext.request.contextPath }/AddMemmoryMessge" method="post">
					<div class="item">
						<div class="name">日期:</div>
						<div class="value">
							<input type="date" name="date"/>
						</div>
					</div>
					<div class="item">
						<div class="name">内容:</div>
						<div class="value">
							<textarea rows="5" cols="10" name="context"></textarea>
						</div>
					</div>
					<div class="item">
						<div class="submit">
							<input type="submit" value="创建备忘" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>