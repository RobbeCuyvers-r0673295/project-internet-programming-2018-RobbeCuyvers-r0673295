<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
        <jsp:param name="title" value="Edit"/>
    </jsp:include>
</head>
<div class="container">
    <div class="page-header">
        <c:set var="pageTitle"><spring:message code="edit.title"/></c:set>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="${pageTitle}"/>
        </jsp:include>
    </div>
    <div class="jumbotron">

        <form:form class="Form" method="POST" action="${pageContext.request.contextPath}/worlds/${world.id}/edit.htm"
                   modelAttribute="world">
            <input type="hidden" id="id" name="id" value="${world.id}">
            <p>
                <label for="name"><spring:message code="edit.name"/></label>
                <input type="text" id="name" name="name" value="${world.name}">
            </p>
            <p>
                <input type="submit" name="submit" id="submit" value="<spring:message code="edit.submit"/>">
            </p>
        </form:form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
