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
    	
    	.inner_table { border: 1px solid #238BD4;}
    	.inner_table tr{ border: 1px solid #238BD4;}
    	.inner_table tr td{ border: 1px solid #238BD4;}
    </style>
  </head>
  
  <body>
    <div style="background-image: url(../images/admin_main.png); width: 863px; height: 469px;">
    	<s:form action="user_queryWhere" namespace="/user">
    	<div style="padding-top: 10px;">
    		<table style="width: 80%; margin:0 auto;" >
    			<tr>
    				<td>条件查询</td>
    			</tr>
    			<tr>
    				<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
    			</tr>
    			<tr>
    				<td>用户姓名:</td>
    				<td><input type="text" name="nickname" /></td>
    				<td>性别:</td>
    				<td>
    					<select name="gender">
    						<option value="" selected="selected">--选择性别--</option>
    						<option value="1">男</option>
    						<option value="0">女</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>学历</td>
    				<td>
    					<select name="education">
    						<option value="" selected="selected">--选择学历--</option>
    						<option value="博士">博士</option>
    						<option value="研究生">研究生</option>
    						<option value="本科">本科</option>
    						<option value="专科">专科</option>
    						<option value="高中">高中</option>
    					</select>
    				</td>
    				<td>是否上传简历</td>
    				<td>
    					<select name="isUploadIntro">
    						<option value="" >--请选择--</option>
    						<option value="1">已上传</option>
    						<option value="0">未上传</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
    			</tr>
    			<tr>
    				<td colspan="4" style="text-align: center;"><input type="submit" value="立即查询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" /></td>
    			</tr>
    			<tr>
    				<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
    			</tr>
    			<tr>
    				<td>用户列表</td>
    				<td colspan="3" style="text-align: right;"><label><img style="margin-top: 2px;" src="../images/admin_listUsers_add.gif" />&nbsp;<a href="${pageContext.request.contextPath }/user/admin_addUser.jsp">添加用户</a></label></td>
    			</tr>
    			<tr>
    				<td colspan="4" height="4px"></td>
    			</tr>
    			<tr>
    				<td colspan="4">
    					<table class="inner_table" style="width: 96%; margin:0 auto;text-align:center;" cellpadding="0" cellspacing="0">
    						<tr style="border:1px solid #238BD4; background-color: #E1EDFF">
    							<th>登录名</th>
    							<th>用户姓名</th>
    							<th>性别</th>
    							<th>联系电话</th>
    							<th>学历</th>
    							<th>编辑</th>
    							<th>查看</th>
    							<th>删除</th>
    						</tr>
	    						<s:iterator value="#users" var="user" status="vs">
		    						<tr style='background-color:<s:property value="vs.even ? 'grey':'green'"/>'>
				    					<td><s:property value="#user.username"/></td>
				    					<td><s:property value="#user.nickname"/></td>
				    					<td><s:property value="#user.gender==0 ? '女' : '男' "/></td>
				    					<td><s:property value="#user.telephone"/></td>
				    					<td><s:property value="#user.education"/></td>
				    					<td><a href="${pageContext.request.contextPath }/user/user_beforeUpdateUser.action?id=<s:property value="#user.id" />">编辑</a></td><!-- updateUser -->
				    					<td><a href="${pageContext.request.contextPath }/user/user_findUser.action?id=<s:property value="#user.id" />">查看</a></td>
				    					<td><a href="${pageContext.request.contextPath }/user/user_deleteUser.action?id=<s:property value="#user.id" />">删除</a></td>
		    						</tr>
	    						</s:iterator>
	    						
    					</table>
    				</td>
    			</tr>
    		</table>
    	</div>
    	</s:form>
    </div>
  </body>
</html>
