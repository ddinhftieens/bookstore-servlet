<%-- 
    Document   : register
    Created on : Oct 15, 2019, 1:01:04 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookStore</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <style type="text/css">
            input[type="text"],input[type="number"],input[type="email"],input[type="password"],textarea,button{
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
        <div class="container mt-3" style="text-align: center;">
            <h1>Đăng nhập</h1>
            <form action="/register" method="post" class="mt-3">
                <table style="font-size: large" class="table table-borderless">
                    <tr>
                        <td>Tài khoản</td>
                        <td><input type="text" name="user" required="" placeholder="Tài khoản"></td>
                        <td>Mật khẩu</td>
                        <td><input type="password" name="pass" required="" placeholder="Mật khẩu"></td>
                    </tr>
                    <tr>
                        <td>Tên</td>
                        <td><input type="text" name="firstName" required="" placeholder="Tên"></td>
                        <td>Họ</td>
                        <td><input type="text" name="lastName" required="" placeholder="Họ"></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ</td>
                        <td colspan="4"><input type="text" name="address" required="" placeholder="Địa chỉ"></td>
                    </tr>
                    <tr>
                        <td>Số điện thoại</td>
                        <td><input type="text" name="phone" required="" placeholder="Số điện thoại"></td>
                        <td>Email</td>
                        <td><input type="email" name="email" required="" placeholder="Email"></td>
                    </tr>
                    <tr>
                        <td colspan="1" align="right"><button onclick="cancel()" class="btn-danger">Hủy</button></td>
                        <td colspan="3" align="right"><button type="sumbit">Đăng kí</button></td>
                    </tr>
                </table>
            </form>
        </div>
        <script type="text/javascript">
            function cancel() {
                history.back();
                // body...
            }
        </script>
    </body>
</html>
