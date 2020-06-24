<%-- 
    Document   : admin-catalog
    Created on : Sep 27, 2019, 2:23:49 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" media="screen" th:href="@{/css/media.css}">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <style type="text/css">
            input[type="text"],input[type="number"],textarea,button{
                font-family: "Times New Roman";
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #cccccc;
                box-sizing: border-box;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/admin/admin-home.jsp"></jsp:include>
        <div class="container mt-3">
            <h1 style="text-align: center">Danh mục</h1>
            <div class="row">
                <input type="text" name="" class="col-5" placeholder="Search by name ..." id="myInput">
                <div class="col-1"></div>
                <button class="col-4" onclick="window.location.href='/admin/catalog/add'">Add</button>
            </div>
        </div>
        <div class="container-fluid mt-3">
            <table class="table" style="font-size: large">
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Ngày tạo</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <tbody id="myTable">
                <c:forEach items="${listCatalog}" var="i">
                        <tr>
                            <td><c:out value="${i.getID()}"/></td>
                            <td><a href="/admin/catalog/product?IDcatalog=${i.getID()}&name=${i.getNameCatalog()}"><c:out value="${i.getNameCatalog()}"/></a></td>
                            <td><c:out value="${i.getDatecreated()}"/></td>
                            <td><a href="/admin/catalog/edit?IDcatalog=${i.getID()}">edit</a></td>
                            <td><a href="/admin/catalog/delete?IDcatalog=${i.getID()}">delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
            $(document).ready(function(){
                $("#myInput").on("keyup", function() {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function() {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>
    </body>
</html>
