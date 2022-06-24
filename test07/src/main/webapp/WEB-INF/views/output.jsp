<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="out" method="post">
		<table border="1">
			<tr>
				<th>NAME</th>
				<td>${dto.name }</td>
			</tr>
			<tr>
				<th>AGE</th>
				<td>${dto.age }</td>
			</tr>
			<tr>
				<th>ADDR</th>
				<td>${dto.addr }</td>
			</tr>
		</table>
	</form>
</body>
</html>