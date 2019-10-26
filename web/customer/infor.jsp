<%-- 
    Document   : infor
    Created on : Oct 18, 2019, 2:14:05 PM
    Author     : Dell
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            input[type="text"],input[type="password"],button,input[type="submit"],input[type="email"],input[type="button"]{
                font-family: "Times New Roman";
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #cccccc;
                box-sizing: border-box;
            }
            td{
                font-size: large;
                font-family: "Times New Roman";
            }
        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <div class="container mt-3 text-center">
            <img src="/image/product?IDcode=logo" style="width: 670px;height: 200px" class="mt-3">
            <h2>Thông tin khách hàng</h2>
            <form action="/customer/logined/infor" method="post" id="changeinfor">
                <table class="table table-borderless mt-3">
                    <tr>
                        <td>ID</td>
                        <td align="left"><%=user.getID()%></td>
                        <td>Tài khoản</td>
                        <td><input type="text" name="user" value="<%=user.getUser()%>" readonly=""></td>
                    </tr>
                    <tr>
                        <td>Tên</td>
                        <td align="left"><%=user.getFristName()%></td>
                        <td>Họ</td>
                        <td align="left"><%=user.getLastName()%></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ</td>
                        <td colspan="3"><input type="text" required="" name="address" value="<%=user.getAddress()%>"></td>
                    </tr>
                    <tr>
                        <td>Số điện thoại</td>
                        <td><input type="text" name="phone" required="" value="<%=user.getPhone()%>"></td>
                        <td>Email</td>
                        <td><input type="email" name="email" required="" value="<%=user.getEmail()%>"></td>
                    </tr>
                    <tr>
                        <td>Vai trò</td>
                        <td colspan="3" align="left"><%=user.getRole()%></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Lưu"></td>
                        <td colspan="2"><input type="button" class="btn-danger" onclick="window.location.href = '/customer/logined/pass'" value="Đổi mật khẩu"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
