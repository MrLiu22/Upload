<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="jquery-3.3.1.min.js"></script>
  <script type="text/javascript">
  var a={
  username:$("#userText").val()
  
  }
  
  
			
			$(function() {
				$("#jiaoyan").click(function() {
					$.get("UsernameServlet", a, function(data) {

						if (data.trim() == "OK") {
							alert("用户名正确!");
							$("#result").html("用户名正确！");

						} else {
							alert("用户名错误!");
							$("#result").html("用户名错误！");

						}

					});
					alert("OK")

				});
				$("#load1")
						.click(
								function() {
								
                                     //第一参数：发送请求的URL   第二参数：回调函数--成功后执行方法
									$.get("GetAllProv",function(data){
									//局部刷新
									$("#prov").empty().append(data);
									
									});
											

								});
				$("#load3")
						.click(
								function() {
								
                                     //第一参数：发送请求的URL   第二参数：回调函数--成功后执行方法
									$.getJSON("GetAllProv",function(data){
									//局部刷新
									console.log(data);
									
									$("#prov").empty();
									for(i=0;i<data.length;i++){
									//局部刷新
									$("#prov").append("<option value='"+data[i].provinceid+"'>"+data[i].province+"</option>");
									}
									
									});
											

								});
								
			$("#prov").change(function() {
					//显示当前的省的id
					$.getJSON("GetCityByProv", {
						provid : $("#prov").val()
					}, function(data) {
					
					$("#p1").empty().append("[");
					$("#city").empty();
						for (i = 0; i < data.length; i++) {
							$("#p1").append(data[i].city + ",");
							$("#city").append("<option value='"+data[i].cityid+"'>"+data[i].city+"</option>");
						}
					});
					

				    $("#p1").append("]");
					

				});

			});
		</script>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <form>
   <p>
   用户名：<input type="text" name="username" id="userText"><a href="#" id="jiaoyan">校验</a>
   [<span id="result">校验结果</span>]
   </p>
   <p>省份列表：
   <select name="prov" id="prov">
   
   
   
   </select>
   <a href="#" id="load1">载入所有省份</a>
   
   <a href="#" id="load3">使用Json载入所有省份</a>
   
   </p>
   <p>市列表：
   <select name="prov" id="city">
   </select>
   <p id="p1">
   [显示所有的地区]
   </p>
  
   </form>
  </body>
</html>
