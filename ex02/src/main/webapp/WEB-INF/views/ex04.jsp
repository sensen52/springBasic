<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04PAGE</title>

<style>
table{text-align:center
}</style>
</head>
<body>

<h1>ex04PAGE</h1>
<table border="1">
<tr>
<th>이름</th>
<th>나이</th>
</tr>

<tr>
<td><c:out value="${infoDTO.name}"></c:out></td>
<td><c:out value="${infoDTO.age}"></c:out></td>
</tr>

</table>
</body>
</html>