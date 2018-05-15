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
        <jsp:param name="title" value="Create new World"/>
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
        <spring:form class="Form" method="POST" action="${pageContext.request.contextPath}/worlds.htm"
                     modelAttribute="world">
            <p>
                    <%--<spring:label path="id">User ID:</spring:label>--%>
                    <%--<spring:input path="id" id="id"/>--%>
            <div class="form-group">
                <label for="id">User Id: ${world.id}</label>
                <input type="hidden" class="form-control" id="id" name="id" value="${world.id}">
            </div>

            </p>
            <p>
                    <%--<spring:label path="name">World Name:</spring:label>--%
                <label for="name">World name</label>
                    <%--<spring:input path="name" id="name"/>--%>

            <div class="form-group">
            <label for="name">World name: </label>
                <input type="text" class="form-control" id="name" name="name" value="${world.name}">
            </div>
            </p>

            <p>
            <span>
                <spring:errors path="name" class="alert alert-danger"/>
            </span>
            </p>

            <p>
                <input type="submit" id="submit" value="Submit" name="submit">
            </p>

        </spring:form>

    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>