<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>Save Currency</title>
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
    <h1><p class="text-center">Save Currency</p></h1>
    <c:if test="${inspection.equals('edit')}">
    <form method="post" action="/PurseCRUD-1.0-SNAPSHOT/edit/currency/${editCurrency.id}">
        </c:if>
        <c:if test="${inspection.equals('add')}">
        <form method="post" action="/PurseCRUD-1.0-SNAPSHOT/add/currency">
            </c:if>
            <div class="form-group">
                <label>Name</label>
                <input class="form-control" name="saveCurrencyName" value="${editCurrency.name}" placeholder="Name">
            </div>
            <input class=" btn btn-success btn-xs" type="submit" value="save">
            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/all/currency" role="button">cancel</a>
        </form>
    </form>
</body>
</html>