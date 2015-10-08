<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎使用人力资源管理系统</title>
    <style type="text/css">
    	body{background-color: #353535 ;}
    </style>
  </head>
  <!-- #D3D3D5-->
	<body>
		<div style="height: 620px; width: 1022px; margin: 0 auto;">
			<div style="width:100%; text-align: center;">
				<iframe style="height: 123px; width:1022px; margin: 0 auto;" src="${pageContext.request.contextPath }/admin_top.jsp" scrolling="no" name="TopFrame" frameborder="0"></iframe>
			</div>
			<div style="width: 100%; text-align: center;">
				<div style="width:159px; height:469px; float: left;">
					<iframe frameborder="0" name="LeftFrame" style="width:159px; height:469px;" src="${pageContext.request.contextPath }/admin_menu.jsp" ></iframe>
				</div>
				<div style="height: 469px;" >
					<iframe frameborder="0" name="MainFrame" style=" width: 863px;height: 469px;" src="${pageContext.request.contextPath }/user/user_listUsers.action" ></iframe>
				</div>
			</div>
		</div>
	</body>
</html>
