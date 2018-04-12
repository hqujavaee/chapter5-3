<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div> 
<h1>欢迎来到华萌</h1>
<form method="post" name="HquerMsgForm">
<input type="hidden" name="latitude">
<input type="hidden" name="longitude">
<textarea name="message" cols="80" rows="5"></textarea><br/>
<input type="submit" value="添加"/>
</form>
</div>
<div>
<h1>最近消息</h1>
<ul>
  <c:forEach items="${hquerMsgList}" var="hquerMsg">
     <li id="hquerMsg_<c:out value="hauerMsg.id"/>">
     <div><c:out value="${hquerMsg.message }"/></div>
     <div>
        <span><c:out value="${hquerMsg.time }"/></span>
        <span><c:out value="${hquerMsg.latitude }"/></span>
     </div>
     </li>
  </c:forEach>
</ul>
<c:if test="${fn:length(hquerMsgList) gt 20 }">
  <hr/>
  <s:url value="/hquerMsg?count=${nextCount }" var="more_url"/>
  <a href="${more_url }">显示更多</a>
</c:if>
</div>


</body>
</html>