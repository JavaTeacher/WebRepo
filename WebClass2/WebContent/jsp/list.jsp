<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
<div class="container">
<table class="table">
  <thead>
    <tr>
      <th>#</th>
      <th>id</th>
      <th>name</th>
      <th>nickname</th>
    </tr>
  </thead>
  <tbody>
  <%--<c:if test="${list != null}">--%>
  <c:if test="${!empty list}">
  	<c:forEach var="item" items="${list}" varStatus="status">
		<tr>
	  		<th>${status.count}</th>
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td>${item.nickname}</td>
		</tr>
	</c:forEach>
  </c:if>
  <%--<c:if test="${list == null || list.size() == 0}">--%>
  <c:if test="${empty list}">
  	<tr><td colspan="4" align="center">데이터가 없습니다.</td></tr>
  </c:if>
  </tbody>
</table>
</div>
</body>
</html>