<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Add Purse</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<center><h1>Add Purse</h1></center>
<form method="post" action="/PurseCRUD-1.0-SNAPSHOT/addPurse">
    <div class="form-group">
        <label>Name</label>
        <input class="form-control" name="addName" placeholder="Purse Name">
    </div>
    <div>
        <label>Currency</label>
        <select class="form-control" name="addCurrency">
            <option>RUR</option>
            <option>EUR</option>
            <option>USD</option>
        </select>
    </div>
    <div class="form-group">
        <label>Amount</label>
        <input class="form-control" name="addAmount" placeholder="Amount">
    </div>
    <input class="btn btn-default btn-xs" type="submit" value="add">
    <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/cancel" role="button">cancel</a>
</form>
</body>
</html>
