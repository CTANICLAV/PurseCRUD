<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>All User</title>
    <jsp:include page="setupBootstrapPage.jsp" flush="true"/>
</head>
<body>
<div class="container">
    <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All User</p></h1>
    <p align="right"><a class="btn btn-info btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/save/user" role="button">add user</a></p>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <thbody>
                <tr>
                    <td> ${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>
                        <p>
                            <a class="btn btn-danger btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/delete/user/${user.id}" role="button">delete</a>
                            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/save/user/${user.id}" role="button">edit</a>
                            <a class="btn btn-info btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/user/save/purse/${user.id}" role="button">add purse</a>
                        </p>
                    </td>
                </tr>
            </thbody>
        </c:forEach>
    </table>
</div>
</body>
</html>