<%-- 
    Document   : admin-product
    Created on : Sep 25, 2019, 9:54:55 AM
    Author     : Dell
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookStore</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
            img,image{
                width: 200px;
                height: 200px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/admin/admin-home.jsp"></jsp:include>
        <div class="container mt-3">
            <h1 style="text-align: center">Thông tin sách</h1>
            <div class="row">
                <input type="text" name="" class="col-5" placeholder="Search by name ..." id="myInput">
                <div class="col-1"></div>
                <button class="col-4" onclick="window.location.href='/admin/catalog/product/add?IDcatalog=${IDcatalog}'">Add</button>
            </div>
        </div>
        <div class="container-fluid mt-3">
            <table class="table" style="font-size: large">
                <tr>
                    <th>IDcode</th>
                    <th>Ảnh</th>
                    <th>Tên</th>
                    <th>Tác giả</th>
                    <th>Năm xuất bản</th>
                    <th>Số lượng</th>
                    <th>Giá</th>
                    <th>Sale</th>
                    <th>Trạng thái</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <tbody id="myTable">
                <c:forEach items="${listProduct}" var="i">
                        <tr>
                            <td><c:out value="${i.getIDcode()}"/></td>
                            <td><img src="/image/product?IDcode=${i.getIDcode()}"></td>
                            <td><c:out value="${i.getNameBook()}"/></td>
                            <td><c:out value="${i.getAuthor()}"/></td>
                            <td><c:out value="${i.getDateofissue()}"/></td>
                            <td><c:out value="${i.getQuantity()}"/></td>
                            <td><c:out value="${i.getPrice()}"/></td>
                            <td><c:out value="${i.getSale()}"/></td>
                            <td><c:out value="${i.getStatus()}"/></td>
                            <td><a href="/admin/catalog/product/edit?IDproduct=${i.getID()}&IDcatalog=${IDcatalog}">edit</a></td>
                            <td><a href="/admin/catalog/product/delete?IDproduct=${i.getID()}&IDcatalog=${IDcatalog}">delete</a></td>
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
