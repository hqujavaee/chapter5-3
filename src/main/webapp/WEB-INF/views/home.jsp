<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="false" %>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<h1>欢迎来到华萌</h1>
<a href="<c:url value="/hquerMsgList"/>">消息列表</a>
<a href="<c:url value="/hquer/register"/>">注册</a>
</body>
</html>