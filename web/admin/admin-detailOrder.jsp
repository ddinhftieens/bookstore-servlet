<%-- 
    Document   : admin-detailOrder
    Created on : Oct 18, 2019, 10:31:33 PM
    Author     : Dell
--%>

<%@page import="Model.Invoice"%>
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
        <style>
            input[type="submit"],select{
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
        <%
            float money = (float) request.getAttribute("totalMoney");
            if (money < 150000) {
                money += 15000;
            }
            Invoice invoice = (Invoice) request.getAttribute("invoice");
        %>
        <div class="container mt-3 text-center">
            <img src="/image/product?IDcode=logo" style="width: 670px;height: 200px" class="mt-3">
            <h2 class="mt-3">Đơn hàng</h2>
            <form action="/admin/showOrder" method="post">
                <table class="table table-borderless mt-3">
                    <tr>
                        <td>
                            <select name="status">
                                <option value="New">New</option>
                                <option value="Đã tiếp nhận">Đã tiếp nhận</option>
                                <option value="Thành công">Thành công</option>
                            </select>
                        </td>
                        <td colspan="3"><input type="submit" value="Xác nhận"></td>
                    </tr>
                </table>
            </form>
            <table class="table table-borderless mt-3">
                <tr>
                    <td>Họ tên</td>
                    <td><%=invoice.getName()%></td>
                    <td>Ngày mua</td>
                    <td><%=invoice.getDateCreated()%></td>
                </tr>
                <tr>
                    <td>Số điện thoại</td>
                    <td><%=invoice.getPhone()%></td>
                    <td>Email</td>
                    <td><%=invoice.getEmail()%></td>
                </tr>
                <tr>
                    <td>Địa chỉ</td>
                    <td><%=invoice.getAddress()%></td>
                </tr>
                <tr>
                    <td>Ghi chú</td>
                    <td><%=invoice.getNote()%></td>
                </tr>
                <tr>
                    <td>Ngày nhận</td>
                    <td><%=invoice.getTimerevice()%></td>
                    <td>Hình thức thanh toán</td>
                    <td><%=invoice.getPayment()%></td>
                </tr>
            </table>
            <table class="table table-bordered mt-3">
                <tr>
                    <th>ID</th>
                    <th>Bìa</th>
                    <th>Tên</th>
                    <th>Số lượng</th>
                    <th>Giá</th>
                    <th>Thành tiền</th>
                </tr>
                <c:forEach items="${myCart}" var="i">
                    <tr>
                        <td>${i.key}</td>
                        <td><img src="/image/product?IDcode=${i.value.IDcode}" style="width: 160px;height: 160px"></td>
                        <td>${i.value.name}</td>
                        <td>${i.value.quantity}</td>
                        <td>${i.value.price}</td>
                        <td>${i.value.totalPrice}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="5" align="right">Phí vận chuyển</td>
                    <c:if test="${totalMoney >= 150000}">
                        <td colspan="2">0.0</td>
                    </c:if>
                    <c:if test="${totalMoney<150000}">
                        <td colspan="2">15000.0</td>
                    </c:if>
                </tr>
                <tr>
                    <td colspan="5" align="right">Tổng tiền</td>
                    <td colspan="2"><%= money%></td>
                </tr>
            </table>
        </div>
    </body>
</html>
