<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap 실습</title>
<!-- Bootstrap css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<style>
div.container {
  padding-top: 30px;
  padding-bottom: 20px;
}
</style>
<link rel="stylesheet" href="/WebClass/css/footer.css">
</head>
<body>
<!-- navbar-dark bg-dark -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  	<%@ include file="menu.jsp" %>
  	
    <div id="loginDiv">
    <form class="form-inline my-2 my-lg-0" id="loginForm">
      <input class="form-control mr-sm-2" type="text" placeholder="ID" aria-label="ID" id="id" required >
      <input class="form-control mr-sm-2" type="password" placeholder="PWD" aria-label="PWD" id="pwd" required >

      <button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="login">Login</button>&nbsp;
      <button class="btn btn-outline-success my-2 my-sm-0" type="button" id="join" data-toggle="modal" data-target="#joinModal">Join</button>
    </form>
    </div>
    <div id="logoutDiv">
      <button class="btn btn-outline-success my-2 my-sm-0" type="button" id="logout">Logout</button>
    </div>
  </div>
</nav>
<div class="container">
<h1>Hello, Bootstrap</h1>
<p>
Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,
</p>
</div>

<%@ include file="modal.jsp" %>
<%@ include file="footer.jsp" %>
	
<!-- Bootstrap js -->
<!-- slim 버전에는 ajax를 포함하지 않음 -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!--  
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<script>
$(document).ready(function() {
	<% String id = (String)request.getSession().getAttribute("id"); %>
	<% if(id == null) { %>
		$('#loginDiv').show();	
		$('#logoutDiv').hide();		
	<% } else { %>
		$('#logoutDiv').show();	
		$('#loginDiv').hide();
	<% } %>
	$('#loginForm').submit(function (event) {
		// Stop form from submitting normally
		event.preventDefault();
		
		//var id = document.getElementById("id").value;
		var id = $("#id").val();
		var pwd = $("#pwd").val();
		console.log(id, pwd);
		
		$.post("/WebClass/login", 
				{ "id": id, "pwd": pwd },
				function(data) {
					console.log("msg:" + data.msg);
					$('#loginForm')[0].reset();
				  	if(data.msg == "error") {		  		
					  	var myModal = $('#myModal');
					  	myModal.modal('show');
					  	myModal.find('.modal-title').text('Login Error');
					  	//console.log(data.id + '님 로그인되었습니다');
					    myModal.find('.modal-body').text('Invalid username or password');
				  	} else if(data.msg == "success") {
				  		$('#loginDiv').hide();
				  		$('#logoutDiv').show();
				  		location.reload();
				  	}
			    });
	});	
	
	$('#logout').click(function () {
		$.post("/WebClass/logout", 
				function(data) {
					console.log("msg2:" + data.msg);
					if(data.msg == "success") {
						$('#loginDiv').show();
						$('#logoutDiv').hide();
						location.reload();
					}
		});
	});	
});

//간단하게 쓰기
$(function() {

});
</script>
</body>
</html>