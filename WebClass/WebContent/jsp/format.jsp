<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setAttribute("price", 1000000); %>
<c:set var="price" value="2000000" />
${price}<br/>
<fmt:formatNumber value="${price}" type="number"/><br/>
<fmt:formatNumber value="${price}" type="percent" /><br/>
<fmt:formatNumber value="${price}" type="currency" /><br/>

<c:set var="now" value="<%=new java.util.Date() %>" />
<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br/>
<fmt:formatDate value="${now}" type="date" dateStyle="medium"/><br/>
<fmt:formatDate value="${now}" type="time" timeStyle="full" /><br/>
<fmt:formatDate value="${now}" type="both" pattern="yyyy/MM/dd hh:mm:ss"/><br/>
</body>
</html>