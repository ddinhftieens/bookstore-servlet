<%-- 
    Document   : cart
    Created on : Oct 17, 2019, 12:15:11 PM
    Author     : Dell
--%>

<%@page import="java.util.Map"%>
<%@page import="Model.Cart"%>
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
            input[type="number"],input[type="submit"]{
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
        %>
        <jsp:include page="/headerHome.jsp"></jsp:include>
            <h2 class="text-center mt-3" style="color: slategray">Giỏ hàng</h2>
            <div class="container mt-3">
                <table class="table table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>Bìa</th>
                        <th>Tên sách</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Tổng</th>
                        <th>Xóa</th>
                    </tr>
                <c:forEach items="${mapCart}" var="i">
                    <tr>
                        <td><a href="/customer/product?IDcode=${i.key}">${i.key}</a></td>
                        <td><img src="/image/product?IDcode=${i.value.IDcode}" style="width: 160px;height: 160px"></td>
                        <td>${i.value.name}</td>
                        <td>${i.value.quantity}</td>
                        <td>${i.value.price}</td>
                        <td>${i.value.totalPrice}</td>
                        <td><a href="/customer/cart/delete?IDproduct=${i.key}">Bỏ</a></td>
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
                    <td colspan="5" align="right">Tổng cộng</td>
                    <td colspan="2"><%= money%></td>
                </tr>
                <tr>
                    <td colspan="7"><button class="btn btn-secondary" onclick="window.location.href='/customer/logined/payment'">Thanh toán</button></td>
                </tr>
            </table>
        </div>
    </body>
</html>
