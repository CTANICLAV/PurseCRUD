<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>Save Currency</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">Save Currency</p></h1>
    <form:form method="post" action="/PurseCRUD-1.0-SNAPSHOT/save/currency" commandName="currencyForm">
        <form:input class="form-control" id="id" path="id" value="${currencyForm.id}" type="hidden"/>
        <label>Name</label><br/>
        <div class="form-group">
            <form:input class="form-control" id="shortName" path="shortName" placeholder="Name"
                        value="${currencyForm.shortName}"/>
            <form:errors path="shortName" cssStyle="color: #ff0000;"/>
        </div>
        <input class=" btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/all/currency" role="button">cancel</a>
    </form:form>
</div>
</body>
</html>