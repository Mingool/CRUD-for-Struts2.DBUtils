<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>操作区</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
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
    	window.onload = function(){
    		var check_1 = document.getElementById("check_1");
    		var check_2 = document.getElementById("check_2");
    		var check_3 = document.getElementById("check_3");
    		
    		var hobbies = "${user.hobby}";
    		if(hobbies.indexOf('足球') >=0 )
    			check_1.checked="checked";
    		if(hobbies.indexOf('篮球') >=0 )
    			check_2.checked="checked";
    		if(hobbies.indexOf('乒乓球') >=0 )
    			check_3.checked="checked";
    	}
    </script>
  </head>
  
  <body>
    <div style="background-image: url(../images/admin_main.png); width: 863px; height: 469px;">
    	<s:form action="user_updateUser" namespace="/user" enctype="multipart/form-data">
    	<input type="hidden" name="token" value="<s:property value="#token"/>" />
    	<div style="padding-top: 10px;">
    		<table style="width: 80%; margin:0 auto; ">
    			<tr>
    				<td>修改信息</td>
    				<td colspan="3" style="text-align: right;"><label><img src="../images/admin_addUser_back.gif" />&nbsp;<a href="${pageContext.request.contextPath }/user/user_listUsers.action">返回</a></label></td>
    			</tr>
    			<tr>
    				<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
    			</tr>
    			<tr>
    				<td>登录名:</td>
    				<td><input type="text" name="username" disabled="disabled" value="<s:property value="#user.username" />"/></td>
    				<td>密码:</td>
    				<td>
    					<input type="password" name="password" value="#user.password"/>
    					<input type="hidden" name="id" value="<s:property value="#user.id" />" />
    				</td>
    			</tr>
    			<tr>
    				<td>用户姓名:</td>
    				<td><input type="text" name="nickname" value="<s:property value="#user.nickname" />"/></td>
    				<td>性别:</td>
    				<td>
    					<select name="gender">
    						<option value="">--选择性别--</option>
    						<option <s:property value="#user.gender==1? 'selected' : '' " /> value="1">男</option>
    						<option <s:property value="#user.gender==0? 'selected' : '' " /> value="0">女</option>
    					</select>
    					<!-- 
    						 selected="<s:property value="#user.gender==0 ? 'selected' : 'false' " />"
    					 -->
    				</td>
    			</tr>
    			<tr>
    				<td>电话:</td>
    				<td><input type="text" name="telephone" value="<s:property value="#user.telephone" />"/></td>
    				<td>生日:</td>
    				<td><input type="text" name="birthday" value="<s:property value="#user.birthday" />"/></td>
    			</tr>
    			<tr>
    				<td>学历:</td>
    				<td>
    					<select name="education">
    						<option value="">--选择学历--</option>
    						<option <s:property value="#user.education=='博士'? 'selected' : '' " /> value="博士">博士</option>
    						<option <s:property value="#user.education=='研究生'? 'selected' : '' " /> value="研究生">研究生</option>
    						<option <s:property value="#user.education=='本科'? 'selected' : '' " /> value="本科">本科</option>
    						<option <s:property value="#user.education=='专科'? 'selected' : '' " /> value="专科">专科</option>
    						<option <s:property value="#user.education=='高中'? 'selected' : '' " /> value="高中">高中</option>
    					</select>
    				</td>
    				<td>兴趣爱好:</td>
    				<td>
    					<input type="checkbox" id="check_1" name="hobbies" value="足球">&nbsp;足球&nbsp;
    					<input type="checkbox" id="check_2" name="hobbies" value="篮球">&nbsp;篮球&nbsp;
    					<input type="checkbox" id="check_3" name="hobbies" value="乒乓球">&nbsp;乒乓球
    				</td>
    			</tr>
    			<tr>
    				<td colspan="4" height="4px"></td>
    			</tr>
    			<tr>
    				<td colspan="4" height="3px" bgcolor="#7F7F7F"></td>
    			</tr>
    			<tr>
    				<td colspan="4" height="4px"></td>
    			</tr>
    			<tr>
    				<td>上传简历:</td>
    				<td colspan="1"><input type="file" name="intro" style="width: 100%; height: 20px;"/></td>
    				<s:if test="#user.userIntro==null">
    					<td colspan="2"><label><img src="../images/admin_updateUser_0.gif" />&nbsp;<font style="color: red">该用户尚未上传简历</font></label></td>
    				</s:if>
    				<s:else>
    					<td colspan="2"><label><img src="../images/admin_updateUser_1.gif" />&nbsp;该用户已上传简历</label></td>
    				</s:else>
    			</tr>
    			<tr>
    				<td>说明:</td>
    				<td colspan="3"><textarea name="remark" style="width: 100%; height:80px;" resize="none"><s:property value="#user.remark" /></textarea></td><!-- rows="7" cols="80" -->
    			</tr>
    			<tr>
    				<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
    			</tr>
    			<tr>
    				<td colspan="4" style="text-align: center;"><input type="submit" value="保存信息" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" /></td>
    			</tr>
    			<tr>
    				<td colspan="4" height="4px" bgcolor="#7F7F7F"></td>
    			</tr>
    		</table>
    	</div>
    	</s:form>
    </div>
  </body>
</html>
