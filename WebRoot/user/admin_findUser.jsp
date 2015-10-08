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
    <script type="text/javascript">
    	function updateUser(){
    		window.location.href = "${pageContext.request.contextPath}/user/user_updateUser.action?id=<s:property value="#user.id" />";
    	}
    </script>
  </head>
  
  <body>
    <div style="background-image: url(../images/admin_main.png); width: 863px; height: 469px;">
    	<div style="padding-top: 10px;">
    		<table style="width: 80%; margin:0 auto; ">
    			<tr>
    				<td>人员信息</td>
    				<td colspan="3" style="text-align: right;"><label><img src="../images/admin_addUser_back.gif" />&nbsp;<a href="${pageContext.request.contextPath }/user/user_listUsers.action">返回</a></label></td>
    			</tr>
			    <tr>
			    	<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
			    </tr>
			    <tr>
			    	<td><B>登录名:</B></td>
			    	<td><s:property value="#user.username" /></td>
			    	<td rowspan="5" colspan="2" style="text-align:center;">
			    		<div>
			    		<img alt="下载简历" src="../images/admin_findUser_download.png">
			    		<label>
			    			<s:if test="#user.userIntro==null">
			    				该用户尚未上传简历
			    			</s:if>
			    			<s:else>
			    				<a href="${pageContext.request.contextPath }/user/user_download?id=<s:property value="#user.id" />&introFileName=<s:property value="#user.userIntro.oldFileName" />"><img src="../images/admin_findUser_down.gif" />下载简历</a>
			    			</s:else>
			    		</label>
			    		</div>
			    	</td>
			    </tr>
			    <tr>
			    	<td><B>用户姓名:</B></td>
			    	<td><s:property value="#user.nickname" /></td>
			    </tr>
			    <tr>
			    	<td><B>用户性别:</B></td>
			    	<td><s:property value="#user.gender==1? '男' : '女' " /></td>
			    </tr>
			    <tr>
			    	<td><B>电话:</B></td>
			    	<td><s:property value="#user.telephone" /></td>
			    </tr>
			    <tr>
			    	<td><B>出生日期:</B></td>
			    	<td><s:property value="#user.birthday" /></td>
			    </tr>
			    <tr>
			    	<td><B>学历:</B></td>
			    	<td><s:property value="#user.education" /></td>
			    	<td><B>兴趣爱好:</B></td>
			    	<td><s:property value="#user.hobby" /></td>
			    </tr>
			    <tr>
			    	<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
			    </tr>
			    <tr>
			    	<td><B>说明:</B></td>
			    	<td colspan="3"><textarea name="remark" disabled="disabled" style="width: 100%; height:80px;" resize="none"><s:property value="#user.remark" /></textarea></td>
			    </tr>
			    <tr>
			    	<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
			    </tr>
			    <tr>
			    	<td colspan="4" style="text-align: center;"><input type="button" value="修改信息" onclick="javascript:updateUser();" /></td>
			    </tr>
	    	</table>
    	</div>
    </div>
  </body>
</html>
