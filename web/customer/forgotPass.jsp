<%-- 
    Document   : forgotPass
    Created on : Oct 19, 2019, 11:44:34 AM
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
            input[type="text"],input[type="password"],input[type="email"],button{
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
            String userName = (String) session.getAttribute("userName");
            String email = (String) session.getAttribute("email");
            String codeconfim = (String) request.getAttribute("codeconfim");
            if(codeconfim == null){
                codeconfim = "Nhập mã xác minh";
            }
        %>
        <div class="container mt-3 text-center">
            <img src="/image/product?IDcode=logo" style="width: 670px;height: 200px" class="mt-3">
            <h1>Thiết lập mật khẩu mới</h1>
            <form action="/customer/getconfim" method="post">
                <table style="font-size: large" class="table table-borderless mt-3">
                    <tr>
                        <td>Tài khoản</td>
                        <td><input type="text" name="user" value="<%=userName %>" readonly=""></td>
                        <td>Email</td>
                        <td><input type="email" name="email" value="<%=email %>" readonly=""></td>
                    </tr>
                    <tr>
                        <td>Mật khẩu mới</td>
                        <td><input type="password" name="newpass" id="pass1" placeholder="Mật khẩu mới" required=""></td>
                        <td>Xác nhận mật khẩu mới</td>
                        <td><input type="password" id="pass2" placeholder="Xác nhận mật khẩu mới" required=""></td>
                    </tr>
                    <tr>
                        <td>Mã xác minh</td>
                        <td><input type="text" name="code" placeholder="Mã xác minh" required=""></td>
                        <td align="left"><a href="/customer/getconfim" id="getconfim">Lấy lại mã xác minh</a></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red"><%=codeconfim %></td>
                        <td colspan="2" align="left"><p>Mã xác minh đã được gửi tới email đăng kí của bạn !</p></td>
                    </tr>
                    <tr>
                        <td align="right"><button onclick="cancel()" class="btn-danger">Hủy</button></td>
                        <td align="right" colspan="3"><button type="sumbit" id="confim">Xác nhận</button></td>
                    </tr>
                </table>
            </form>
        </div>
        <script type="text/javascript">
            function cancel() {
                window.location.href = '/';
//                history.back();
                // body...
            }
            $(document).ready(function () {
                    $("#confim").click(function () {
                        var pass1 = $("#pass1").val();
                        var pass2 = $("#pass2").val();
                        if (pass1 == pass2 && pass1 != "") {
                            return true;
                        } else {
                            pass1 = $("#pass1").val("");
                            pass2 = $("#pass2").val("");
                            alert("Mật khẩu không trùng khớp");
                            return false;
                        }
                    })
                    $("#getconfim").click(function (){
                        alert("Mã xác minh đã được gửi tới email của bạn");
                    })
                })
        </script>
    </body>
</html>
