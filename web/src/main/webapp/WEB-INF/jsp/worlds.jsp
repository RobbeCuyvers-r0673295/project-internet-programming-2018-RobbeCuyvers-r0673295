<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Robbe
  Date: 07/03/2018
  Time: 08:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Worlds"/>
</jsp:include>
<body>
<div class="container">
    <div class="page-header">
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="Remove"/>
        </jsp:include>
    </div>
    <div class="jumbotron">

        <table class="table table-bordered table-striped table-hover">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Edit</th>
                <th>Remove</th>
            </tr>
            <c:forEach var="world" items="${worlds}">
                <tr>
                    <td>${world.key}</td>
                    <td>${world.value.name}</td>
                    <td>
                        <a href="<c:url value="worlds/${world.key}/edit.htm"/>">
                            Edit
                        </a>
                    </td>
                    <td>
                        <a href="<c:url value="worlds/${world.key}/remove.htm"/>">
                            Remove
                        </a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" class="text-center"><a href="<c:url value="/worlds/new.htm"/>" class="btn btn-primary">New</a></td>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
