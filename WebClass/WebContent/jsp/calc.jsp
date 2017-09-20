<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<input type="number" name="num" required>
<button type="submit">계산</button>
</form>
<%
	String num = request.getParameter("num");
	int sum = 0;
	if(num != null) {
		for(int i=1; i<=Integer.parseInt(num); i++) {
			sum += i;
		}
%>
<h1>1 ~ <%=num%>까지의 합은 <%=sum%>입니다. </h1>
<%
	}
	// 현재 일시 구하기
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a"); 
	out.println(sdf.format(new Date()));
%>
</body>
</html>