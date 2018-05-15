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
        <jsp:include page="header.jsp">
            <jsp:param name="title" value="Home"/>
        </jsp:include>
    </div>

    <div class="jumbotron">
        <h2>Quote of the day</h2>
        <div id="quote">
            <p>${quote.quote}</p>
            <p>- ${quote.author}</p>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
