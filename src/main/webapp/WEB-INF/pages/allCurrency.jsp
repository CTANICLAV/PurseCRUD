 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
 <html>
 <head>
     <title>All Currency</title>
     <jsp:include page="setupPage.jsp" flush="true"/>
 </head>
 <body>
 <div class="container">
     <jsp:include page="topNavigationButtons.jsp" flush="true"/>
    <h1><p class="text-center">All Currency</p></h1>
     <p align="right"><a class="btn btn-info btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/save/currency" role="button">add currency</a></p>

     <table class="table">
         <thead>
         <tr>
             <th>ID</th>
             <th>Name</th>
            <th>Actions</th>
         </tr>
         </thead>
         <c:forEach var="currency" items="${currencies}">
             <thbody>
                 <tr>
                     <td> ${currency.id}</td>
                     <td>${currency.name}</td>
                    <td>
                        <p>
                            <a onclick="deleteCurrency(${currency.id})" class="btn btn-danger btn-xs" role="button">delete</a>
                            <a class="btn btn-default btn-xs" href="/PurseCRUD-1.0-SNAPSHOT/save/currency/${currency.id}" role="button">edit</a>
                        </p>
                    </td>
                 </tr>
             </thbody>
         </c:forEach>
     </table>
 </div>
 </body>
 </html>