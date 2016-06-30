<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="checkEditOfAddPurse" value="${checkEditOfAddPurse}"/>
<c:if test="${checkEditOfAddCurrency.equals('editCurrency')}">
    <html>
    <head>
        <title>Edit Currency</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="container">
       <p>
            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT" role="button">All Purse</a>
            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/all/currency" role="button">All Currency</a>
        </p>
        <center><h1>Edit Currency</h1></center>
        <form method="post" action="/PurseCRUD-1.0-SNAPSHOT/edit/currency/${editCurrency.id}">
            <div class="form-group">
                <label>Name</label>
                <input class="form-control" name="editCurrencyName" value="${editCurrency.name}">
            </div>
            <input class=" btn btn-default btn-xs" type="submit" value="edit">
            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/all/currency" role="button">cancel</a>
        </form>
    </div>
    </body>
    </html>
</c:if>

<c:set var="checkEditOfAddPurse" value="${checkEditOfAddPurse}"/>
<c:if test="${checkEditOfAddCurrency.equals('addCurrency')}">
    <html>
    <head>
        <title>Add Currency</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="container">
        <p>
            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT" role="button">All Purse</a>
            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/all/currency" role="button">All Currency</a>
        </p>
        <center><h1>Add Currency</h1></center>
        <form method="post" action="/PurseCRUD-1.0-SNAPSHOT/add/currency">
            <div class="form-group">
                <label>Name</label>
                <input class="form-control" name="addCurrencyName" placeholder="Currency Name">
            </div>
            <input class="btn btn-default btn-xs" type="submit" value="add">
           <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/all/currency" role="button">cancel</a>
        </form>
    </div>
    </body>
    </html>
</c:if>