<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test" method="post">
	<h1>Data 입력</h1>
	<table>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>AGE</th>
			<td><input type="text" name="age"></td>
		</tr>
		<tr>
			<th>ADDR</th>
			<td><input type="text" name="addr"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="확인">
			</td>	
		</tr>
	</table>
	</form>
</body>
</html>