<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309</title>
</head>
<body>
	<form method="GET"
		action="/SP22B2_SOF3011_IT16309/HelloServlet">
		<label>Họ tên</label>
		<input type="text" name="ho_ten" />
		<button>Gửi</button>
	</form>
	<h3>Hello ${ name }</h3>
</body>
</html>
