<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <c:set var="pageTitle"><spring:message code="overview.title"/></c:set>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="${pageTitle}"/>
        </jsp:include>
    </div>
    <div class="jumbotron">

        <table class="table table-bordered table-striped table-hover">
            <tr>
                <th><spring:message code="table.id"/></th>
                <th><spring:message code="table.name"/></th>
                <th><spring:message code="table.edit"/></th>
                <th><spring:message code="table.remove"/></th>
            </tr>
            <c:forEach var="world" items="${worlds}">
                <tr>
                    <td>${world.key}</td>
                    <td>${world.value.name}</td>
                    <td>
                        <a href="<c:url value="worlds/${world.key}/edit.htm"/>">
                            <spring:message code="table.edit"/>
                        </a>
                    </td>
                    <td>
                        <a href="<c:url value="worlds/${world.key}/remove.htm"/>">
                            <spring:message code="table.remove"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" class="text-center"><a href="<c:url value="/worlds/new.htm"/>" class="btn btn-primary"><spring:message code="table.new"/></a></td>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
