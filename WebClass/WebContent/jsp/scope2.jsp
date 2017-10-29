<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request : <%= request.getAttribute("key") %></h1>
<h1>session : <%= session.getAttribute("key") %></h1>
<h1>application : <%= application.getAttribute("key") %></h1>
<h1>id : <%= request.getParameter("id") %></h1>
<h1>pwd : <%= request.getParameter("pwd") %></h1>
</body>
</html>