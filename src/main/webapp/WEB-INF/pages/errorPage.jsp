<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
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

    <div class="alert alert-danger" role="alert"><p class="text-center">Something broke.</p></div>
</div>
</body>
</html>