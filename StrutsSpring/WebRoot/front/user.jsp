<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
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
   	<a href="user/user_getData">添加用户</a> <br>
     <s:iterator value="list" var="user">
       <s:property value="#user.userid"/> --
       <s:property value="username"/> --
       <s:property value="sex"/> --
       <s:property value="deptid"/>
       <a href="user/user_queryById?userid=<s:property value="#user.userid"/>">修改</a>
     <a href="user/user_delete?userid=<s:property value="#user.userid"/>">删除</a> <br/> 
    </s:iterator>
     <s:debug></s:debug>
  </body>
</html>
