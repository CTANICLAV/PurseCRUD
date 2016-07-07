 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>

 <c:set var="checkEditOfAddPurse" value="${checkEditOfAddPurse}"/>
<c:if test="${checkEditOfAddPurse.equals('editPurse')}">
     <html>
     <head>
         <title>Edit Purse</title>
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
         <center><h1>Edit Purse</h1></center>
         <form method="post" action="/PurseCRUD-1.0-SNAPSHOT/edit/purse/${editPurse.id}">
             <div class="form-group">
                 <label>Name</label>
                 <input class="form-control" name="editPurseName" value="${editPurse.name}">
             </div>
             <div>
                 <label>Currency</label>
                 <select class="form-control" name="editPurseCurrency">
                   <c:forEach var="allCurrencyName" items="${allCurrencyName}">
                      <option value="${allCurrencyName.id}">${allCurrencyName.name}</option>
                     </c:forEach>
                 </select>
             </div>
             <div class="form-group">
                 <label>Amount</label>
                 <input class="form-control" name="editPurseAmount" value="${editPurse.amount}">
             </div>
             <input class="btn btn-default btn-xs" type="submit" value="edit">
             <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT" role="button">cancel</a>
         </form>
     </div>
     </body>
     </html>
 </c:if>

 <c:set var="checkEditOfAddPurse" value="${checkEditOfAddPurse}"/>
<c:if test="${checkEditOfAddPurse.equals('addPurse')}">
     <html>
     <head>
         <title>Add Purse</title>
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
         <center><h1>Add Purse</h1></center>
         <form method="post" action="/PurseCRUD-1.0-SNAPSHOT/add/purse">
             <div class="form-group">
                 <label>Name</label>
                 <input class="form-control" name="addPurseName" placeholder="Purse Name">
             </div>
             <div>
                 <label>Currency</label>
                 <select class="form-control" name="addPurseCurrency">
                    <c:forEach var="allCurrencyName" items="${allCurrencyName}">
                        <option value="${allCurrencyName.id}">${allCurrencyName.name}</option>
                     </c:forEach>
                 </select>
             </div>
             <div class="form-group">
                 <label>Amount</label>
                 <input class="form-control" name="addPurseAmount" placeholder="Amount">
             </div>
             <input class="btn btn-default btn-xs" type="submit" value="add">
             <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT" role="button">cancel</a>
         </form>
     </div>
     </body>
     </html>
 </c:if>