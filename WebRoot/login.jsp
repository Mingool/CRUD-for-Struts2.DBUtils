<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人力资源管理系统</title><!--  background-color:#CCCC99; -->
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <style type="text/css">
    	*{ font-size: 13px; margin: 0; padding: 0; }
    	body{ background-color:#353535; }
    	.main_div{ background-image:url(images/login.png);
    		 width:564px; height:353px; margin: 70px auto 0;}
    	.inner_div{ margin:0 auto; width: 80%; text-align: center;
    		  padding-top: 110px;}
    	.main_table{   margin:0 auto;
    		 height:80px; width:50%; text-align: center;}
    	.main_table tr td{  height: 30px;}
    </style>
  </head>
  <!-- body{ background-color:#FFFFCC; } -->
  <body>
  	<div class="main_div">
  		<form action="${pageContext.request.contextPath}/login.action" method="post">
  			<div class="inner_div">
	  			<table class="main_table">
	  				<tr>
	  					<td>用户名:</td>
	  					<td><input type="text" name="username" /></td>
	  				</tr>
	  				<tr>
	  					<td>密码:</td>
	  					<td><input type="password" name="password"/></td>
	  				</tr>
	  				<tr>
	  					<td colspan="2" style="height:50px;"><input type="submit" value="登录"/></td>
	  				</tr>
	  				<tr>
	  					<td colspan="2" style="height:50px;"><s:property value="#message" /></td>
	  				</tr>
	  			</table>
  			</div>
  		</form>
  	</div>
  </body>
</html>
