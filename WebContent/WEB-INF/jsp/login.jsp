<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta charset="UTF-8">

<title>CSS3动态背景登录框代码</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/styles.css">

</head>
<body>


	<div class="wrapper">

		<div class="container">
			<h1>MOOC 后台管理</h1>
			<form method="post"
				action="${pageContext.request.contextPath}/tuser/login">
				<input type="text" placeholder="Username" name="gusername">
				<input type="password" placeholder="Password" name="gpassword"><br>
				<button type="submit">
					<strong>登录</strong>
				</button>

			</form>
		</div>

		<ul class="bg-bubbles">
			<li></li>
			<li></li>

		</ul>

	</div>



</body>
</html>