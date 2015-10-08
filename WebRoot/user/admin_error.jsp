<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>操作区</title>
    <style type="text/css">
    	a:link,a:visited{ color:#000; text-decoration:none;}
		a:hover{ text-decoration:underline; }
    	*{ margin: 0; padding: 0;}
    	table tr td{ font-size: 11px; }table tr th{ font-size: 11px; }
    	table tr{ border:1px solid blue;}
    	
    	.inner_table {border-color: blue; border: 1px solid;}
    	.inner_table tr{border-color: blue; border: 1px solid;}
    	.inner_table tr td{border-color: blue; border: 1px solid;}
    </style>
  </head>
  
  <body>
    <div style="background-image: url(../images/admin_main.png); width: 863px; height: 469px;">
    	<div style="padding-top: 10px;">
    		<table style="width: 80%; margin:0 auto; ">
			    <tr>
			    	<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
			    </tr>
			    <tr>
			    	<td>ERROR:</td>
			    </tr>
			    <tr>
			    	<td>Im here sorry to tell you that the server had exceptions.</td>
			    </tr>
			    <tr>
			    	<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
			    </tr>
	    	</table>
    	</div>
    </div>
  </body>
</html>
