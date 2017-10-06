<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- session 실습 시 chrome에서 실행한 후 IE에서 실행해보기 -->
<form action="/WebClass/scope" method="post">
<input type="text" name="id" value="testid" />
<input type="hidden" name="pwd" value="testpwd" />
<button type="submit">전송</button>
</form>
<h1>request : ${ key }</h1>
<h1>session : ${ sessionScope.key }</h1>
<h1>application : ${ applicationScope.key }</h1>
<h1>id : ${ param.id }</h1>
<h1>pwd : ${ param.pwd }</h1>
<hr>
<form action="/WebClass/jsp/scope2.jsp" method="post">
<button type="submit">전송</button>
</form>
</body>
</html>