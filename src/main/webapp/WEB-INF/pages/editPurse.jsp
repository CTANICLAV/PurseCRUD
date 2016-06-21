<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Edit Purse</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<center><h1>Edit Purse</h1></center>
<form method="post" action="/edit/${purseId.id}">
    <div class="form-group">
        <label>Name</label>
        <input class="form-control" name="editName" value="${purseId.name}">
    </div>
    <div>
        <label>Currency</label>
        <select class="form-control" name="editCurrency">
            <option>RUR</option>
            <option>EUR</option>
            <option>USD</option>
        </select>
    </div>
    <div class="form-group">
        <label>Amount</label>
        <input class="form-control" name="editAmount" value="${purseId.amount}">
    </div>
    <input class="btn btn-default btn-xs" type="submit" value="edit">
    <a class="btn btn-default btn-xs" href="/cancel" role="button">cancel</a>
</form>
</body>
</html>