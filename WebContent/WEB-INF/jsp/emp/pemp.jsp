<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>查询部门下的所有员工</title>
<meta charset="UTF-8">
<meta name="description"
	content="Creating Modal Window with Twitter Bootstrap">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>

<style type="text/css">
body {
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
	<form class="form-inline definewidth m20" action="#" method="get">
		<h3>${pname }</h3>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>性别</th>
				<th>地址</th>
				<th>年龄</th>
				<th>电话</th>
			</tr>
		</thead>
		<tbody id="tbodylist">
			<c:if test="${empty list }">
				<tr>
					<td colspan="6">该部门还没有员工</td>
				</tr>
			</c:if>
			<c:if test="${not empty list }">
				<c:forEach items="${list }" var="e">
					<tr>
						<td>${e.tid }</td>
						<td>${e.trealname }</td>
						<c:if test="${e.tsex==0 }">
							<td>男</td>
						</c:if>
						<c:if test="${e.tsex==1 }">
							<td>女</td>
						</c:if>
						<td>${e.taddress }</td>
						<td>${e.tage }</td>
						<td>${e.ttel }</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tr>
			<td colspan="6" align="right"><input type="button"
				onclick="javascript:window.history.back(-1);" value="返回" /></td>
		</tr>
	</table>
</body>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-tooltip.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-popover.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/layer.js"></script>
<script>
	$(function ()
	{ 

		
	});

</script>
</html>