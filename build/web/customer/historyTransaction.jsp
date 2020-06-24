<%-- 
    Document   : historyTransaction
    Created on : Oct 18, 2019, 8:09:36 AM
    Author     : Dell
--%>

<%@page import="Model.Invoice"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Phone Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="/headerHome.jsp"></jsp:include>
        <div class="container mt-3 text-center">
            <%
                List<Invoice> invoice = (List<Invoice>) request.getAttribute("listInvoice");
            %>
            <h2>Đơn hàng</h2>
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
                <c:forEach items="<%=invoice %>" var="i" varStatus="k">
                    <tr>
                        <td>${k.index + 1}</td>
                        <td>${i.getName()}</td>
                        <td>${i.getAddress()}</td>
                        <td>${i.getPhone()}</td>
                        <td>${i.getDateCreated()}</td>
                        <td>${i.getStatus()}</td>
                        <td><a href="/customer/logined/showOrder?IDorder=${i.getId()}">Xem</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
