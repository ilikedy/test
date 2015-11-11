<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String a = "";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/test/encoding" method="get">
	名字：<input type="text" name="name"></input>
	<input type="text" name="action" value="formget" style="display:none;"></input>
	<input type="submit" value="submit"></input>

	<a href="/test/encoding?action=link&name=中文">中文链接测试</a>
</form>

<form action="/test/encoding" method="post">
	名字：<input type="text" name="name"></input>
	<input type="text" name="action" value="formpost" style="display:none;"></input>
	<input type="submit" value="submit"></input>

	<a href="/test/encoding?action=link&name=中文">中文链接测试</a>
</form>
</body>
</html>