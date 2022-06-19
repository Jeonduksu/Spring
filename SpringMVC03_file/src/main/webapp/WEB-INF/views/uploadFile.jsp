<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	파일명 : ${fileobj.filename }
	<br>
	설명:${fileobj.desc }
	
	<img src="storage/img04.png">
<!-- 	http://localhost:8080/file/form.do
	http://localhost:8080/file/storage/img04.png -->
	<!-- <img src="storage/${fileobj.filename }"> -->
	<!-- <img src="http://localhost:8080/file/storage/img04.png"> -->
</body>
</html>