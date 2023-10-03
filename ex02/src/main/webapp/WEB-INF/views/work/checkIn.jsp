<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체크인</title>
</head>
<body>
	<form action="/getToWork" name="checkInForm">
		<input type="text" name="name">
		<br>
		<button>출근</button>
		<button type="button">퇴근</button>
	</form>
</body>
<script>
	let form = checkInForm;
	let button = document.querySelector("button[type='button']");
	
	form.setAttribute("action", "/getToWork");
	
	//console.log(form.getAttribute("action"));
	button.addEventListener("click", function(){
		form.setAttribute("action", "/leaveWork");
		form.submit();
	});
</script>
</html>