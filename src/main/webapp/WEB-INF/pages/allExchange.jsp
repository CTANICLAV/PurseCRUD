<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>All Exchange</title>
    <jsp:include page="setupPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All Exchange</p></h1>
    <p align="right"><a class="btn btn-info btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/save/exchange" role="button">add exchange</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Source Currnecy</th>
            <th>Target Currency</th>
            <th>Rate</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="exchange" items="${exchanges}">
            <thbody>
                <tr>
                    <td> ${exchange.id}</td>
                    <td>${exchange.sourceCurrency.name}</td>
                    <td>${exchange.targetCurrency.name}</td>
                    <td>${exchange.exchangeRate}</td>
                    <td>
                        <p>
                            <a class="btn btn-danger btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/delete/exchange/${exchange.id}"
                               role="button">delete</a>
                            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/save/exchange/${exchange.id}"
                               role="button">edit</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>
</body>
</html>