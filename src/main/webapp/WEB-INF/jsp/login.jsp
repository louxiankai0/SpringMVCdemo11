<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
	String basePath = request.getContextPath();
	if (!"/".equals(basePath)) {
		basePath += "/";
	}
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=basePath%>/login" method="post">
		<label for="userName">用户名:<input type="text" id="userName" name="userName" /></label>
        <label for="password">密码:<input type="text" id="password" name="password" /></label>
        <input type="submit" value="登录">
	</form>
	<h4>
    <%=msg==null ?"":msg%>
</h4>
</body>
</html>