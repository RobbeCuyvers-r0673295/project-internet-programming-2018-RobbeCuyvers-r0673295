<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="Remove"/>
        </jsp:include>
    </div>
    <div class="jumbotron">
        <spring:form class="Form" action="${pageContext.request.contextPath}/worlds/${world.id}/remove.htm"
                     method="post" modelAttribute="world">

            <p>
                Zeker dat je ${world.name} wilt verwijderen?
            </p>
            <input type="hidden" id="id" name="id" value="${world.id}">


            <input type="submit" value="Remove" name="remove" id="remove">
        </spring:form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
