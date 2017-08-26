function menu_over(elem) {
	elem.setAttribute("class", "nav-item active");
}
function menu_out(elem) {
	elem.setAttribute("class", "nav-item");
}
$(document).ready(function() {
	$('#loginForm').submit(function (event) {
		// Stop form from submitting normally
		event.preventDefault();
		
		//var id = document.getElementById("id").value;
		var id = $("#id").val();
		var pwd = $("#pwd").val();
		console.log(id, pwd);

		// 서버로 post 전송
		$.post("http://httpbin.org/post", 
				{ id: id, pwd: pwd },
				function(data) {
					//console.log(data.form.id, data.form.pwd);
				  	alert(data.form.id + '님 로그인되었습니다');
			    });
	});	
});