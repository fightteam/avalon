<%--
  所有页面的头部
  基本上必须引入
  User: faith
  Date: 13-8-3
  Time: 下午2:26
  包括引入样式文件等等
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="${lang}">
<head>
    <title><spring:message code="application.services.title" /></title>
    <meta charset="utf-8">
    <c:forEach items="${styles}" var="entry">
        <link rel="stylesheet" href="${entry.value}"/>
    </c:forEach>
    <script type="text/javascript" src="${scripts.jquery}"></script>
    <link rel="stylesheet" href="<spring:theme code="style"/>"/>
</head>
<body>


