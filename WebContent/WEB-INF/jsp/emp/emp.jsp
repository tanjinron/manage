<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>查询所有员工</title>
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
				<th>部门</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody id="tbodylist">
			<tr>
				<td></td>
			</tr>
		</tbody>
		<tfoot id="tfootpage"></tfoot>

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
		//显示员工信息
		pageemp();
		
	});
	
	//查看所有员工信息  分页显示
	function pageemp(){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/emp/pageTemp",
			data:{pageNo:0},
			dataType:"JSON",
			success:function(data){
				var content ="";
				$.each(data.result,function(i,emp){
					content += "<tr>";
					content += "<td>"+emp.tid+"</td>";
					content += "<td>"+emp.trealname+"</td>";
					if(emp.tsex==0){
						content += "<td>男</td>";
					}else{
						content += "<td>女</td>";
					}
					content += "<td>"+emp.taddress+"</td>";
					content += "<td>"+emp.tage+"</td>";
					content += "<td>"+emp.ttel+"</td>";
					content += "<td>"+emp.tpid.pname+"</td>";
					content += "<td><a onclick='ueditEmp("+emp.tid+")'>修改</a>&nbsp;&nbsp;&nbsp;<a onclick='deleteEmp("+emp.tid+")'>删除</a></td>";
					content += "</tr>";
				});
				$("#tbodylist").html(content);
				$("#tfootpage").html("<tr><td colspan='8'><a onclick='pageNex("+data.pageNo+")'>加载更多</a></td></tr>");
			}
		});
	}
	//加载下一页员工信息
	function pageNex(pageNo){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/emp/pageTemp",
			data:{pageNo:pageNo},
			dataType:"JSON",
			success:function(data){
				var content ="";
				$.each(data.result,function(i,emp){
					content += "<tr>";
					content += "<td>"+emp.tid+"</td>";
					content += "<td>"+emp.trealname+"</td>";
					if(emp.tsex==0){
						content += "<td>男</td>";
					}else{
						content += "<td>女</td>";
					}
					content += "<td>"+emp.taddress+"</td>";
					content += "<td>"+emp.tage+"</td>";
					content += "<td>"+emp.ttel+"</td>";
					content += "<td>"+emp.tpid.pname+"</td>";
					content += "<td><a onclick='ueditEmp("+emp.tid+")'>修改</a>&nbsp;&nbsp;&nbsp;<a onclick='deleteEmp("+emp.tid+")'>删除</a></td>";
					content += "</tr>";
				});
				$("#tbodylist").append(content);
				if(data.pageNo<data.totalPageNum){
					$("#tfootpage").html("<tr><td colspan='8'><a onclick='pageNex("+data.pageNo+")'>加载更多</a></td></tr>");
				}else{
					$("#tfootpage").html("");
				}
			}
		});
	}
	//删除员工信息
	function deleteEmp(tid){
		if(confirm("确认删除吗？")){
    		$.ajax({
    			type:"POST",
    			url:"${pageContext.request.contextPath}/emp/deleteEmp",
    			data:{tid:tid},
    			dataType:"json",
    			success:function(data){
    				if(data==true){
    					pageemp();       //重新查询员工信息    *****************
    					layer.msg("删除成功");
    				}else{
    					layer.msg("系统繁忙，请稍后重试");
    				}
    			}
    		});
			
		}
	}
	//修改员工信息
	function ueditEmp(tid){
	   $.ajax({
   			type:"POST",
   			url:"${pageContext.request.contextPath}/emp/getIDemp",
   			data:{tid:tid},
   			dataType:"json",
   			success:function(data){
   			   var content = '<form name="empForm" id="empForm">';
   			   content += '<h5 align="center">姓名：<input type="text" name="trealname" value="'+data.temp.trealname+'" /></h5>';
   			   content += '<h5 align="center">性别：';
   			   if(data.temp.tsex==0){
   					content += ' <input type="radio" name="tsex" checked="checked" value=0 />男';
    			    content += ' <input type="radio" name="tsex" value=1 />女</h5>';
   			   }else{
	   				content += ' <input type="radio" name="tsex" value=0 />男';
				    content += ' <input type="radio" name="tsex" checked="checked" value=1 />女</h5>';
   			   }
   			   content += '<input type="hidden" name="tid" value="'+data.temp.tid+'" />';
   			   content += '<h5 align="center">地址：<input type="text" name="taddress" value="'+data.temp.taddress+'" /></h5>';
   			   content += '<h5 align="center">年龄：<input type="text" name="tage" value="'+data.temp.tage+'" /></h5>';
   			   content += '<h5 align="center">电话：<input type="text" name="ttel" value="'+data.temp.ttel+'" /></h5>';
   			   content += '<h5 align="center">部门：<select name="tpid.pid">';
   			   $.each(data.listPart,function(i,part){
   			      	if(data.temp.tpid.pid==part.pid){
   			      		content += '<option value='+part.pid+' selected="selected">'+part.pname+'</option>';
   			      	}else{
   			      		content += '<option value='+part.pid+'>'+part.pname+'</option>';
   			      	}
   			   });
   			   content += '</select></h5>';
   			   content += '<h5 align="center"><input type="button" value="确认修改" onclick="eduit()" /></h5>';
   			   content += '</form>';
   			
    			layer.open({
					type:1,
    				title:'员工修改',
    				area: ['400px', '350px'],
    				shadeClose: true, //点击遮罩关闭
    				content:content
				});
   			}
   		});
	}
	//修改 
	function eduit(){
		var submitdata = $("#empForm").serialize();   //获取表单中的值
		$.post("${pageContext.request.contextPath}/emp/eduitEmp", submitdata,
				   function(data){
						if(data==true){
							layer.closeAll();
							pageemp();       //重新查询员工信息    *****************
							layer.msg("修改成功");
						}else{
							layer.msg("系统繁忙，请稍后重试");
						}
				   }, "json");
		
	}
	
  

</script>
</html>