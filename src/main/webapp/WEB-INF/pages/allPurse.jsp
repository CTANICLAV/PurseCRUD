<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>All Purse</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<center><h1>All Purse</h1></center>
<p align="right"><a class="btn btn-default btn-xs" href="/addPurse" role="button">add purse</a></p>

<table class="table">
    <thead>
    <tr     >
        <th>ID</th>
        <th>Name</th>
        <th>Currency</th>
        <th>Amount</th>
        <th>Actions</th>
    </tr>
    </thead>
    <c:forEach var="purse" items="${purse}">
        <thbody>
            <tr>
                <td> ${purse.id}</td>
                <td>${purse.name}</td>
                <td> ${purse.currency}</td>
                <td>${purse.amount}</td>
                <td>
                    <p>
                        <a class="btn btn-default btn-xs" href="/delete/${purse.id}" role="button">delete</a>
                        <a class="btn btn-default btn-xs" href="/edit/${purse.id}" role="button">edit</a>
                    </p>
                </td>
            </tr>
        </thbody>
    </c:forEach>
</table>
</body>
</html>