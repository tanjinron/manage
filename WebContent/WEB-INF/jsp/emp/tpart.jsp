<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common.js"></script>

<style type="text/css">
body {
	font-size: 20px;
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

	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>部门介绍</th>
				<th>部门编辑</th>
			</tr>
		</thead>
		<tbody id="tbodypart">
			<tr>
				<td>复仇者联盟</td>
				<td>电影</td>
				<td><a href="studentdetail.html">小强</a></td>
				<td>2016.07.22</td>
				<td>
					<button type="submit">删除</button>
					</a>
				</td>
			</tr>
		</tbody>
	</table>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/layer.js"></script>
<script type="text/javascript">
    $(function(){
    	partlist();  //查看所有部门信息
    });
    
     //查看所有部门信息
    function partlist(){
    	$.ajax({
    		type:"POST",
    		url:"${pageContext.request.contextPath}/part/partlist",
    		dataType:"json",
    		success:function(data){
    			var content = "";
    			$.each(data,function(i,part){
    				content += "<tr>";
    				content += "<td>"+part.pid+"</td>";
    				content += "<td><a href='${pageContext.request.contextPath}/emp/TpaetANDTemp/"+part.pid+"'>"+part.pname+"</a></td>";
    				content += "<td>"+part.premark+"</td>";
    				content += "<td><a onclick='updatepart("+part.pid+")'>编辑</a>&nbsp;&nbsp;&nbsp;<a onclick='deletepart("+part.pid+")'>删除</a></td>";
    				content += "</tr>";
    			});
    	    
    			$("#tbodypart").html(content);
    		}
    	});
    	
    }
    
    //删除部门
    function deletepart(pid){
    	
    	if(confirm("确认删除？")){
    		$.ajax({
    			type:"POST",
    			url:"${pageContext.request.contextPath}/part/deleteTpart",
    			data:{pid:pid},
    			dataType:"json",
    			success:function(data){
    				if(data==true){
    					partlist();  //查看所有部门信息
    					layer.msg("删除成功");
    				}else{
    					layer.msg("系统繁忙，请稍后重试");
    				}
    			}
    		});
    	}
    }
    //修改部门信息   显示
    function updatepart(pid){
    	$.ajax({
    		type:"POST",
			url:"${pageContext.request.contextPath}/part/idpart",
			data:{pid:pid},
			dataType:"json",
			success:function(data){
				layer.open({
					type:1,
    				title:'部门修改',
    				area: ['400px', '220px'],
    				shadeClose: true, //点击遮罩关闭
    				content:'<h5 align="center">部门名称：<input type="text" id="pname" value="'+data.pname+'" /></h5>'+
    				  		'<h5 align="center">部门详情：<input type="text" id="premark" value="'+data.premark+'" /></h5>'+
    				  		'<h5 align="center"><input type="button" value="确认修改" onclick="eduit('+pid+')" /></h5>'
				});
				
			}
    	});
    }
    //修改部门信息
    function eduit(pid){
    	var pname=$("#pname").val();
    	var premark=$("#premark").val();
    	$.ajax({
    		type:"POST",
			url:"${pageContext.request.contextPath}/part/uppart",
			data:{pid:pid,pname:pname,premark:premark},
			dataType:"json",
			success:function(data){
				if(data==true){
					layer.closeAll();
					partlist();  //查看所有部门信息
					layer.msg("修改成功");
				}else{
					layer.closeAll();
					layer.msg("系统繁忙，请稍后重试");
				}
				
			}
    	});
    	
    }

</script>
</html>
