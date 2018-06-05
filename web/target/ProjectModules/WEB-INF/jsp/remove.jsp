<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Robbe
  Date: 07/03/2018
  Time: 08:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Remove ${world.id}"/>
    </jsp:include>
</head>
<body>
<div class="container">
    <div class="page-header">
        <c:set var="pageTitle"><spring:message code="remove.title"/></c:set>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="${pageTitle}"/>
        </jsp:include>
    </div>
    <div class="jumbotron">
        <form:form class="Form" action="${pageContext.request.contextPath}/worlds/${world.id}/remove.htm"
                     method="post" modelAttribute="world">

            <p>
                <spring:message code="remove.text"/>: ${world.name}?
            </p>
            <input type="hidden" id="id" name="id" value="${world.id}">
            <input type="hidden" id="name" name="name" value="${world.name}">


            <input type="submit" value="<spring:message code="remove.submit"/>" name="remove" id="remove">
        </form:form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
