<%-- 
    Document   : login
    Created on : Oct 15, 2019, 12:54:30 PM
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
            input[type="text"],input[type="password"],textarea,button{
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
            <form action="/login" method="post" class="mt-3">
                <table style="font-size: large" class="table table-borderless">
                    <tr>
                        <td>Tài khoản</td>
                        <td><input type="text" name="user" required="" placeholder="Tài khoản"></td>
                    </tr>
                    <tr>
                        <td>Mật khẩu</td>
                        <td><input type="password" name="pass" required="" placeholder="Mật khẩu"></td>
                    </tr>
                    <tr>
                        <td align="right"><input type="checkbox" name="remember" value="remember"></td>
                        <td align="left">Lưu mật khẩu</td>
                    </tr>
                    <tr>
                        <td align="right"><button onclick="cancel()" class="btn-danger">Hủy</button></td>
                        <td align="right"><button type="sumbit">Đăng nhập</button></td>
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
