<%-- 
    Document   : admin-order
    Created on : Oct 18, 2019, 9:41:02 AM
    Author     : Dell
--%>

<%@page import="Model.Invoice"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>BookStore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <style type="text/css">
            input[type="text"]{
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
            <div class="container mt-3 text-center">
            <%
                List<Invoice> invoice = (List<Invoice>) request.getAttribute("listInvoice");
            %>
            <h2>Danh sách đơn hàng</h2>
            <div class="row ml-0">
                <input type="text" name="" class="col-5" placeholder="Tìm đơn hàng" id="myInput">
            </div>
            <table class="table table-bordered mt-3">
                <tr>
                    <th>STT</th>
                    <th>Tên</th>
                    <th>Địa chỉ</th>
                    <th>Số điện thoại</th>
                    <th>Ngày đặt</th>
                    <th>Trạng thái</th>
                    <th>Chi tiết</th>
                </tr>
                <tbody id="myTable">
                    <c:forEach items="<%=invoice%>" var="i" varStatus="k">
                        <tr>
                            <td>${k.index + 1}</td>
                            <td>${i.getName()}</td>
                            <td>${i.getAddress()}</td>
                            <td>${i.getPhone()}</td>
                            <td>${i.getDateCreated()}</td>
                            <td>${i.getStatus()}</td>
                            <td><a href="/admin/showOrder?IDorder=${i.getId()}">Xem</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>
    </body>
</html>
