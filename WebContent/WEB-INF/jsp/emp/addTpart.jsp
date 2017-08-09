<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery2.sorted.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquerypicture.js"></script>

<style type="text/css">
body {
	font-size: 20px;
	padding-bottom: 40px;
	background-color: #e9e7ef;
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
<body>
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<font color="#777777"><strong>添加部门：</strong></font>
	<form action="${pageContext.request.contextPath}/part/addTpart"
		method="post" class="definewidth m20" enctype="multipart/form-data">
		<table style="margin-left: 10px; margin-top: 3px;">
			<tr>
				<td>部门名称：</td>
				<td><input type="text" name="pname" style="width: 400px;"
					placeholder='请输入部门名称' /></td>
			</tr>
			<tr>
				<td>部门介绍：</td>
				<td><input type="text" name="premark"
					style="height: 100px; width: 400px;" placeholder='请输入部门详情' /></td>
			</tr>

			<tr>
				<td></td>
				<td>
					<button style="margin-left: 5px;" type="submit"
						class="btn btn-primary" type="button">保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">
						<a href="classQuery.html"> 返回列表</a>
					</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>