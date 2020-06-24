<%-- 
    Document   : changePass
    Created on : Oct 18, 2019, 8:46:26 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="container mt-3 text-center">
            <img src="/image/product?IDcode=logo" style="width: 670px;height: 200px" class="mt-3">
            <form action="/customer/logined/pass" method="post" id="changepass">
                <table class="table table-borderless">
                    <tr>
                        <td>Mật khẩu cũ</td>
                        <td colspan="3"><input type="password" name="oldpass" placeholder="Mật khẩu cũ" required=""></td>
                    </tr>
                    <tr>
                        <td>Mật khẩu mới</td>
                        <td><input type="password" name="newpass" id="pass1" placeholder="Mật khẩu mới" required=""></td>
                        <td>Xác nhận mật khẩu mới</td>
                        <td><input type="password" id="pass2" placeholder="Xác nhận mật khẩu mới" required=""></td>
                    </tr>
                    <tr>
                        <td><button class="btn-danger" onclick="cancel()">Hủy</button></td>
                        <td colspan="3"><button type="submit" id="confim">Xác nhận</button></td>
                    </tr>
                </table>
            </form>
            <script>
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
                })
                function cancel() {
                    document.location.href = '/';
                }
            </script>
        </div>
    </body>
</html>
