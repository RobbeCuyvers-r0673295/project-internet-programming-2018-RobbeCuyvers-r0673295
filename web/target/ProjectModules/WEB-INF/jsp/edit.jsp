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
        <jsp:param name="title" value="Edit ${world.id}"/>
    </jsp:include>
</head>
<div class="container">
    <div class="page-header">
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="Remove"/>
        </jsp:include>
    </div>
    <div class="jumbotron">

        <spring:form class="Form" method="POST" action="${pageContext.request.contextPath}/worlds/${world.id}/edit.htm"
                     modelAttribute="world">
            <input type="hidden" id="id" name="id" value="${world.id}">
            <p>
                <label for="name">World name</label>
                <input type="text" id="name" , name="name" , value="${world.name}">
            </p>
            <p>
                <input type="submit" name="submit" id="submit" value="Submit">
            </p>
        </spring:form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
