<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN PAGE</title>
</head>
<body>

<h1>login</h1>
<form action="/login" method="post" >

<input name="id"  type="text"/>
<input name="pw" type="password"/>
<button>로그인</button>
</form>


</body>
</html>