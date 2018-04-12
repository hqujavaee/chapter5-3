<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div>
 <div><c:out value="${hquerMsg.message }"/> </div>
 <div><span><c:out value="${hquerMsg.time }"></c:out></span></div>
</div>
</body>
</html>