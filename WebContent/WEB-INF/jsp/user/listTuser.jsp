<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
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
		<h3>管理员账号查询</h3>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>账户编号</th>
				<th>真实姓名</th>
				<th>用户名</th>
				<th>修改</th>
			</tr>
		</thead>
		<tbody id="tbodylist">
			<tr>
				<td>人生何处不青山</td>
				<td><a href="#" id="xiangqing" rel="popover"
					data-original-title="公告标题"
					data-content="后来回头的时候，才发现那时候可能是最好的时光，再也回不去的时光，再也做不了的事，再也鼓不起的勇气，再也浪不起来的我们">详情</a></td>
				<td>2016-4-4</td>
				<td>2016-4-8</td>
				<td><a href="placardEdit.html">修改</a></td>
			</tr>
		</tbody>
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
		//查询所有账户信息
		listuser();
		
	});

    function listuser(){
	   $.ajax({
		   type:"POST",
		   url:"${pageContext.request.contextPath}/tuser/listTuser",
		   dataType:"json",
		   success:function(data){
			   var content = "";
			   $.each(data,function(i,tuser){
				   content += "<tr>";
				   content += "<td>"+tuser.gid+"</td>";
				   content += "<td>"+tuser.grealname+"</td>";
				   content += "<td>"+tuser.gusername+"</td>";
				   content += "<td><a href='#' onclick='eduituser("+tuser.gid+")'>修改</a></td>";
				   content += "</tr>";
			   });
		
			   $("#tbodylist").html(content);
		   }
	   });
	
    }
    //修改点击事件
    function eduituser(gid){
    	//根据编号查询管理员信息
    	$.ajax({
    		type:"POST",
    		url:"${pageContext.request.contextPath}/tuser/getidTuser",
    		data:{gid:gid},
    		dataType:"json",
    		success:function(data){
    			layer.open({
    				type:1,
    				title:'信息修改',
    				area: ['400px', '220px'],
    				shadeClose: true, //点击遮罩关闭
    				content: '<h5 align="center">真实姓名：<input type="text" id="grealname" value="'+data.grealname+'" /></h5>'+
    				         '<h5 align="center">用 户 名 ：<input type="text" id="gusername" value="'+data.gusername+'" /></h5>'+
    				         '<h5 align="center"><input type="button" value="确认修改" onclick="eduit('+gid+')" /></h5>'
    			});
    			
    		}
    	});
    	
    }
    
    //修改
    function eduit(gid){
    	var grealname = $("#grealname").val();
    	var gusername = $("#gusername").val();
    	$.ajax({
    		type:"POST",
    		url:"${pageContext.request.contextPath}/tuser/eduit",
    		data:{grealname:grealname,gusername:gusername,gid:gid},
    		dataType:"json",
    		success:function(data){
    			if(data==true){
    				listuser();
    				layer.closeAll();
    				layer.msg("修改成功");
    			}else{
    				listuser();
    				layer.msg("系统繁忙，请稍后重试");
    			}
    			
    		}
    	});
    }

	
</script>
</html>