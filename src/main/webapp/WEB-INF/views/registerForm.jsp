<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>注册</h1>
<sf:form method="POST" commandName="hquer">
   <sf:errors path="*" element="div" cssClass="alert alert-danger"/>
   <sf:label path="firstName" cssErrorClass="badge badge-danger" class="badge">姓</sf:label>:<sf:input path="firstName" cssErrorClass="text-danger"/><br/>
   <sf:label path="lastName" cssErrorClass="badge badge-danger" class="badge">名</sf:label>:<sf:input path="lastName"  cssErrorClass="text-danger"/><br/>
   <sf:label path="email" cssErrorClass="badge badge-danger" class="badge">E-mail</sf:label>:<sf:input path="email"  cssErrorClass="text-danger"/><br/>
   <sf:label path="userName" cssErrorClass="badge badge-danger" class="badge">用户名</sf:label>:<sf:input path="userName"  cssErrorClass="text-danger"/><br/>
   <sf:label path="password" cssErrorClass="badge badge-danger" class="badge">密码</sf:label>:<sf:input path="password"  cssErrorClass="text-danger"/><br/>
   <input type="submit" value="注册"/>
</sf:form>
</body>
</html>