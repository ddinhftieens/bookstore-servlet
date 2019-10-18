<%-- 
    Document   : order
    Created on : Oct 17, 2019, 9:03:30 PM
    Author     : Dell
--%>

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
            input[type="text"],input[type="email"],textarea,input[type="submit"],input[type="radio"],select{
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
            <div class="container mt-3 text-center">
                <h2>Thông tin</h2>
                <form action="/customer/logined/payment" method="post">
                    <table class="table table-borderless">
                        <tr>
                            <td>Họ tên *</td>
                            <td colspan="3"><input type="text" name="name" placeholder="Họ tên" required=""></td>
                        </tr>
                        <tr>
                            <td>Số điện thoại *</td>
                            <td><input type="text" name="phone" placeholder="Số điện thoại" required=""></td>
                            <td>Email</td>
                            <td><input type="email" name="email" placeholder="Email"></td>
                        </tr>
                        <tr>
                            <td>Địa chỉ *</td>
                            <td colspan="3"><input type="text" name="address" placeholder="Địa chỉ" required=""></td>
                        </tr>
                        <tr>
                            <td>Ghi chú</td>
                            <td colspan="3"><textarea style="height: 100px" name="note"></textarea></td>
                        </tr>
                        <tr>
                            <td>Thời gian dự kiến</td>
                            <td>${time}</td>
                        </tr>
                        <tr>
                            <td>Hình thức thanh toán</td>
                            <td>
                                <select name="pay">
                                    <option selected="" value="Thanh toán tiền mặt">Thanh toán tiền mặt</option>
                                    <option value="Chuyển khoản">Chuyển khoản</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td colspan="2"><input type="submit" value="Xác nhận"></td>
                            <td></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="container mt-3 text-center">
                <h3>Đơn hàng</h3>
                <table class="table table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>Bìa</th>
                        <th>Tên sách</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Tổng</th>
                    </tr>
                    <c:forEach items="${mapCart}" var="i">
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
                    <td colspan="1">0.0</td>
                </c:if>
                <c:if test="${totalMoney<150000}">
                    <td colspan="1">15000.0</td>
                </c:if>
                </tr>
                <tr>
                    <td colspan="5" align="right">Tổng cộng</td>
                    <td colspan="1"><%= money%></td>
                </tr>
            </table>
        </div>
    </body>
</html>
