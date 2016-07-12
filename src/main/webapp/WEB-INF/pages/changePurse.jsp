<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <p>
        <a class="btn btn-primary btn-xs" href="/PurseCRUD-1.0-SNAPSHOT" role="button">All Purse</a>
        <a class="btn btn-primary btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/all/currency" role="button">All Currency</a>
        <a class="btn btn-primary btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/all/user" role="button">All User</a>
    </p>
    <center><h1>Save Purse</h1></center>
    <c:if test="${inspection.equals('edit')}">
    <form method="post" action="/PurseCRUD-1.0-SNAPSHOT/edit/purse/${editPurse.id}">
        </c:if>
        <c:if test="${inspection.equals('add')}">
        <form method="post" action="/PurseCRUD-1.0-SNAPSHOT/add/purse">
            </c:if>
            <div>
                <label>User</label>
                <select class="form-control" name="savePurseOwnerId">
                    <c:forEach var="user" items="${users}">
                        <option>${user.id}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Name</label>
                <input class="form-control" name="savePurseName" value="${editPurse.name}" placeholder="Name">
            </div>
            <div>
                <label>Currency</label>
                <select class="form-control" name="savePurseCurrencyId">
                    <c:forEach var="currency" items="${currencies}">
                        <option value="${currency.id}">${currency.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Amount</label>
                <input class="form-control" name="savePurseAmount" value="${editPurse.amount}" placeholder="Amount">
            </div>
            <input class="btn btn-success btn-xs" type="submit" value="save">
            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT" role="button">cancel</a>
        </form>
    </form>
</div>
</body>
</html>