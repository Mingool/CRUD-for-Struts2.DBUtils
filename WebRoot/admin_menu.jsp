<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>请选择</title>
    <style type="text/css">
    	*{ margin: 0; padding: 0;}
    	body{ font-size: 13px;}
    	a:link,a:visited{ color:#000; text-decoration:none;}
		a:hover{ text-decoration:underline; }
		ul{ list-style: none;}
		ul li{ padding-top: 10px;}
    </style>
  </head>
  
  <body>
    <div style="width: 159px; height: 469px; background-image: url(images/admin_left.png)">
    	<div style="padding-left: 20px;padding-top: 20px;">
	    	<ul>
	    		<li><img src="images/admin_menu_folder.gif" /><label><a href="${pageContext.request.contextPath }/user/user_listUsers.action" target="MainFrame">人员信息</a></label></li>
	    		<li><img src="images/admin_menu_folder.gif" /><label><a href="javascript:void(0)">就业方向</a></label></li>
	    		<li><img src="images/admin_menu_folder.gif" /><label><a href="javascript:void(0)">人员去向</a></label></li>
	    		<li><img src="images/admin_menu_folder.gif" /><label><a href="javascript:void(0)">留言统计</a></label></li>
	    	</ul>
    	</div>
    </div>
  </body>
</html>
