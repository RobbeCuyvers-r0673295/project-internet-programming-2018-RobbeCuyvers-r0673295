<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
    <!--<img alt="Books" src="images/books.jpg">-->
    <h1><span>Worlds</span></h1>
    <div class="btn-group">
        <button type="button" class="btn btn-primary dropdown-toggle btn-lg" data-toggle="dropdown">Menu</button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/index.htm">Home</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/worlds.htm">Worlds</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/worlds/new.htm">Create new</a>
            <a class="dropdown-item" href="<c:url value="/logout"/>">Log out</a>
        </div>
    </div>
    <%--
    <ul class="dropdown-menu">

            <li><a href="${pageContext.request.contextPath}/index.htm">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/worlds.htm">Overview</a></li>
            <li><a href="${pageContext.request.contextPath}/worlds/new.htm">Create new</a></li>
            <c:if test="${_csrf != null}">
                <li><a href="<c:url value="/logout" />">Log out</a></li>
            </c:if><!-- //TODO check logged in -->
        </ul>
    <nav>
        <c:choose>
               <c:when test="${param.title=='Home'}">
                   <li id="actual"><a href="index.htm">Home</a></li>
               </c:when>
               <c:when test="${param.title=='Overview'}">
                   <li id="actual"><a href="worlds.htm">Overview</a></li>
               </c:when>
               <c:otherwise>
                       <li><a href="worlds.htm">Overview</a> </li>
                       <li><a href="index.htm">Home</a></li>
               </c:otherwise>
           </c:choose>
    </nav>--%>
    <h2>
        ${param.title}
    </h2>

</header>
