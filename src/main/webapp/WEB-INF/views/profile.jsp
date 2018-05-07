<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<h1>个人信息</h1>
<img src="<%=request.getContextPath()%>/hquer/pic/<c:out value="${hquer.userName}"/>.jpeg" class="img-rounded">
<c:out value="${hquer.userName}"/><br/>
<c:out value="${hquer.firstName }"/><br/>
<c:out value="${hquer.email }"/><br/>
</body>
</html>