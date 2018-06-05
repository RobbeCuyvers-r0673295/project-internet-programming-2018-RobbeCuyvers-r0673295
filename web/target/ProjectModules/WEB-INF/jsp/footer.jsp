<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<%--<select id="languages">
    <option value=""></option>
    <option value="en" th:text="#{lang.eng}"></option>
    <option value="fr" th:th:text="#{lang.fr}"></option>
</select>--%>
Language : <a href="?lang=en">English</a>|<a href="?lang=nl">Nederlands</a>
<script type="text/javascript">
    $(document).ready(function() {
        $("#locales").change(function () {
            var selectedOption = $('#languages').val();
            if (selectedOption != ''){
                window.location.replace('?lang=' + selectedOption);
            }
        });
    });
</script>
<!--
<c:set var="languageCookie" value="${cookie['org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE']}"/>
<li>
    <div class="dropdown" id="languageSelect">
        <button class="btn btn-primary dropdown-toggle" type="button" id="languageDropdownButton" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <c:choose>
                <%-- when the url contains the lang parameter and the language was just changed,
                    set the right icon. (Cookie value isn't right yet) --%>
                <c:when test="${param.lang != null}">
                    <c:if test="${param.lang == 'nl'}">
                        <p>param.lang=='nl'</p>
                        <img src="${pageContext.request.contextPath}/images/flags/nl.svg" alt="Dutch flag" width="50">
                    </c:if>
                    <c:if test="${param.lang == 'en'}">
                        <p>param.lang=='en'</p>
                        <img src="${pageContext.request.contextPath}/images/flags/gb.svg" alt="Great Britain flag"
                             width="50">
                    </c:if>
                </c:when>
                <%-- if there's no language change request, set the icon according to the cookie--%>
                <c:otherwise>
                    <%-- if there is no language cookie yet, set GB flag (default locale in DispatcherServletConfig is UK --%>
                    <%--TODO better to solve this in Config (set cookie immediately instead of after lang change) --%>
                    <c:choose>
                        <c:when test="${languageCookie == null}">
                            <p>languageCookie==null</p>
                            <img src="${pageContext.request.contextPath}/images/flags/gb.svg" alt="Great Britain flag"
                                 width="50">
                        </c:when>
                        <c:otherwise>
                            <c:if test="${languageCookie.value == 'nl'}">
                                <p>languageCookie=='nl'</p>
                                <img src="${pageContext.request.contextPath}/images/flags/nl.svg" alt="Dutch flag"
                                     width="50">
                            </c:if>
                            <c:if test="${languageCookie.value == 'en'}">
                                <p>languageCookie=='en'</p>
                                <img src="${pageContext.request.contextPath}/images/flags/gb.svg"
                                     alt="Great Britain flag" width="50">
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </button>
        <div class="dropdown-menu" aria-labelledby="languageDropdownButton" id="languageDropdown">
            <p>${languageLabel}</p>
            <a class="dropdown-item" href="#" id="nl">
                <img src="${pageContext.request.contextPath}/images/flags/nl.svg" alt="Dutch flag" width="50">
            </a>
            <a class="dropdown-item" href="#" id="en">
                <img src="${pageContext.request.contextPath}/images/flags/gb.svg" alt="Great Britain flag" width="50">
            </a>
        </div>
    </div>
</li>

<script type="text/javascript">
    $('#languageDropdown a').on('click', function(){
        var selectedOption = $(this).attr("id");
        if (selectedOption != ''){
            window.location.replace('?lang=' + selectedOption);
        }
    });
</script>-->