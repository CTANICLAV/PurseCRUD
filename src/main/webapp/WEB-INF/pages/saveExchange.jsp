<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>Save Exchange</title>
    <jsp:include page="setupBootstrapPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">Save Exchange</p></h1>
    <form:form method="post" action="/PurseCRUD-1.0-SNAPSHOT/save/exchange" commandName="exchangeForm">
        <form:input class="form-control" id="id" path="id" value="${exchangeForm.id}" type="hidden"/>
        <div>
            <label>Source Currency</label>
            <form:select path="sourceCurrencyId" class="form-control">
                <c:forEach var="currency" items="${sourceCurrencies}">
                    <option value="${currency.id}">${currency.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <div>
            <label>Target Currency</label>
            <form:select path="targetCurrencyId" class="form-control">
                <c:forEach var="currency" items="${targetCurrencies}">
                    <option value="${currency.id}">${currency.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <label>Rate</label><br/>

        <div class="form-group">
            <form:input class="form-control" id="exchangeRate" path="exchangeRate" placeholder="Rate"
                        value="${exchangeForm.exchangeRate}"/>
            <form:errors path="exchangeRate" cssStyle="color: #ff0000;"/>
        </div>
        <input class=" btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/all/exchange" role="button">cancel</a>
    </form:form>
</div>
</body>
</html>
