<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加管理员</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.sorted.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/showdate.js"></script>
<style type="text/css">
body {
	font-size: 20px;
	padding-bottom: 40px;
	background-color: #e9e7ef;
	font-size: 17px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<form action="${pageContext.request.contextPath}/tuser/addTuser"
	method="post">
	<table class="table table-bordered table-hover definewidth m10"
		style="margin-left: 3%; margin-top: 2%;">
		<tr>
			<td width="10%" class="tableleft">真实姓名</td>
			<td><input type="text" name="grealname"
				style="height: 41px; width: 546px" /></td>

		</tr>
		<tr>
			<td class="tableleft">账户名</td>
			<td><input type="text" name="gusername"
				style="height: 93px; width: 546px" /></td>
		</tr>
		<tr>
			<td class="tableleft">密码</td>
			<td><input type="password" name="gpassword"
				style="height: 93px; width: 546px" /></td>
		</tr>
		<tr>
			<td class="tableleft"></td>
			<td>
				<button style="margin-left: 180px;" type="submit"
					class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;
				<button type="button">
					<a href="afficheQuery.html">返回列表</a>
				</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
<script>
function jump(){
 window.location.href="placardQuery.html";
}
</script>