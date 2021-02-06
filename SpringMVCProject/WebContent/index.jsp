<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#testJson").click(function(){
			//通过Ajax请求springmvc
			$.post(
				"testJson",//请求地址
				//{"name":"zs"},//参数
				function(result){	//服务端处理完毕后的回调函数
					for(var i=0;i<result.length;i++){
						alert(result[i].id+"-"+result[i].name+"-"+result[i].age);
					}
				}
			);
		})
		
	});
</script>
</head>
<body>
	<h1><a href="hello">hello world!</a></h1>
	
	<input type="button" value="testJson" id="testJson" /><br><br>
	
	<form action="testPost/123" method="post">
		<input type="submit" value="增加" />
	</form>
	<form action="testDelete/123" method="post">
		<input type="hidden" name="_method" value="DELETE" />
		<input type="submit" value="删除" />
	</form>
	<form action="testPut/123" method="post">
		<input type="hidden" name="_method" value="PUT" />
		<input type="submit" value="修改" />
	</form>
	<form action="testGet/123" method="get">
		<input type="submit" value="查询" />
	</form>
	<br>
	<form action="testObjectProperties" method="post">
		id:<input type="text" name="id" />
		name;<input type="text" name="name" />
		homeAddress;<input type="text" name="address.homeAddress" />
		schoolAddress;<input type="text" name="address.schoolAddress" />
		<input type="submit" value="提交" />
	</form><br>
	<a href="testRequestHeader">testRequestHeader</a>
	<a href="testCookieValue">testCookieValue</a>
	<a href="testModelAndView">testModelAndView</a>
	<a href="testModelMap">testModelMap</a>
	<a href="testModel">testModel</a>
	<a href="testMap">testMap</a>
	<a href="testI18n">testI18n</a>
	<a href="testMvcViewController">testMvcViewController</a>
	
	<a href="testInterceptor">testInterceptor</a>
	<a href="testExceptionHandler">testExceptionHandler</a>
	
	<br><br>
	<form action="testModelAttributes" method="post">
		id:<input type="hidden" name="id" value="23" />
		name;<input type="text" name="name" />
		<input type="submit" value="提交" />
	</form><br>
	
	<form action="testConverter" method="post">
		学生信息:<input type="text" name="studentInfo" />
		<input type="submit" value="转换" />
	</form><br>
	
	
	<form action="testDateTimeFormat" method="post">
		id:<input type="text" name="id" value="23" />
		name;<input type="text" name="name" />
		birthday:<input type="text" name="birthday" />
		Email:<input type="text" name="email" />
		<input type="submit" value="提交" />
	</form><br>
	
	<form action="testUpload" method="post" enctype="multipart/form-data">
		file:<input type="file" name="file" />
		描述:<input type="text" name="desc" />
		<input type="submit" value="提交" />
	</form><br>
	
</body>
</html>