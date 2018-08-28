<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
   
    <s:form action="user_save" namespace="/user" method="post">
    	<s:textfield name="username" label="姓名"></s:textfield>
    	<s:radio list="#{1:'男',2:'女' }" name="sex" label="性别" value="1"></s:radio>
    	<s:select list="basicList.{? #this.pid==4}" name="deptid" label="部门" listKey="bid" listValue="bname"></s:select>
    	<s:checkboxlist list="roleList" name="depts" label="角色" listKey="roleid" listValue="rolename"></s:checkboxlist>
    	<s:submit value="提交"></s:submit>
    </s:form>
    <s:debug></s:debug>
  </body>
</html>
