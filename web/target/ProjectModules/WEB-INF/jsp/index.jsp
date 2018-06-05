<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

<body>
<div class="container">
    <div class="page-header">
        <c:set var="pageTitle"><spring:message code="index.title"/></c:set>
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="${pageTitle}"/>
        </jsp:include>
    </div>

    <div class="jumbotron">
        <h2><spring:message code="quote.title"/></h2>
        <div id="quote">
            <p>${quote.quote}</p>
            <p>- <a href="https://www.google.com/${quote.author}">${quote.author}</a></p>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
