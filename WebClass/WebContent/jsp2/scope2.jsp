<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request : ${ key }</h1>
<h1>session : ${ sessionScope.key }</h1>
<h1>application : ${ applicationScope.key }</h1>
<h1>id : ${ param.id }</h1>
<h1>pwd : ${ param.pwd }</h1>
<hr>
</body>
</html>