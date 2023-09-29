<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>market</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>상품명</th>
			<th>바코드 번호</th>
		</tr>

		<tr>
			<td>오징어 땅콩</td>
			<td>4383927</td>
		</tr>

		<tr>
			<td>초코우유</td>
			<td>0832137</td>
		</tr>

		<tr>
			<td>벌꿀피자</td>
			<td>9841631</td>
		</tr>

		<tr>
			<td>샌드위치</td>
			<td>5587578</td>
		</tr>
	</table>
	<br>
	<form action="/cashier" method="post">
		<label>
		상품 바코드 입력
		<input type="text" name="barcode"/>
		</label>
	</form>
</body>
</html>