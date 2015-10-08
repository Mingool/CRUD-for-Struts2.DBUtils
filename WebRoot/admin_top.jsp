<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎使用</title>
    <style type="text/css">
    	*{ margin: 0; padding: 0;}
    	a:link,a:visited{ color:#000; text-decoration:none;}
		a:hover{ text-decoration:underline; }
    </style>
    <script type="text/javascript">
    	function turn(){
    		parent.location.href = "${pageContext.request.contextPath }/logout.action";
    	}
    </script>
  </head>
  
  <body>
    <div style="height:123px; width:1022px; background-image:url(images/admin_top.png)">
    	<div style=" padding-left: 312px; padding-top: 10px;">
    		<img alt="河北工业大学" src="images/admin_top_logo.png">
    	</div>
    	<div style="text-align: right; margin-right: 36px;">
    		<label>
    			<font style="font-size: 11px;">欢迎您:<s:property value="#session.admin.nickname" /></font>&nbsp;&nbsp;
    			<img src="images/admin_top_logout.gif" />&nbsp;
    			<a href="javascript:turn()">
    				<font style="font-size: 11px;">注销登录</font>
    			</a>
    		</label>
    	</div>
    </div>
  </body>
</html>
