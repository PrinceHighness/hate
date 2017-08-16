<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>千军万马来相见</h1>
<input type="button" value="退出登陆" 
onclick="location.href='<%=request.getContextPath() %>/user/logout.jhtml'">

<form action="<%=request.getContextPath() %>/user/insertUser.jhtml" method="post">
	<input name="userAccount">
	<input name="userPwd">
	<input type="submit">
</form>
</body>
</html>