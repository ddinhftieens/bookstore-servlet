<%-- 
    Document   : forgotPass-findUser
    Created on : Oct 19, 2019, 12:43:37 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone Store</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <style type="text/css">
            input[type="text"],input[type="submit"]{
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
            String message = (String) request.getAttribute("message");
            if(message==null){
                message = "Xin vui lòng nhập tài khoản !";
            }
        %>
        <div class="container mt-3 text-center">
            <img src="/image/product?IDcode=logo" style="width: 670px;height: 200px" class="mt-3">
            <h2 class="mt-3">Xác minh tài khoản</h2>
            <form action="/customer/forgot" method="post" class="mt-3">
                <table class="table table-borderless">
                    <tr>
                        <td style="color: red" align="left"><%=message %></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="user" placeholder="Tài khoản" required=""></td>
                        <td><input type="submit" value="Tìm"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
