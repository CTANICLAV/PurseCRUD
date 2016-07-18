<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Purse</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">Add purse user.</p></h1>
    <form:form method="post" action="/PurseCRUD-1.0-SNAPSHOT/user/save/purse/${ownerId}" commandName="purseForm">
        <form:input class="form-control" id="id" path="id" type="hidden"/>
        <form:input class="form-control" id="ownerId" path="ownerId" value="${ownerId}" type="hidden"/>
        <div class="form-group">
            <label>Name</label>
            <form:input class="form-control" id="name" path="name" placeholder="Name" value="${purseForm.name}"/>
            <form:errors path="name" cssStyle="color: #ff0000;"/>
        </div>
        <div>
            <label>Currency</label>
            <form:select path="currencyId" class="form-control">
                <c:forEach var="currency" items="${currencies}">
                    <option value="${currency.id}">${currency.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <label>Amount</label>
            <form:input class="form-control" id="name" path="amount" placeholder="Amount"
                        value="${editPurse.amount}"/>
            <form:errors path="amount" cssStyle="color: #ff0000;"/>
        </div>
        <input class="btn btn-success btn-xs" type="submit" value="save">
        <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT" role="button">cancel</a>
    </form:form>
    </form>
</div>
</body>
</html>