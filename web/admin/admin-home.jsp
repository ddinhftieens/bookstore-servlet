<%-- 
    Document   : admin-home
    Created on : Sep 23, 2019, 10:29:43 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookStore</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <style type="text/css">
            input[type="text"],input[type="number"],textarea,button{
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
    <body style="text-align: center">
        <div class="container mt-3">
            <img src="/image/product?IDcode=logo" style="width: 670px;height: 200px">
            <table style="font-size: large" class="table table-borderless">
                <tr>
                    <td align="right"><button onclick="window.location.href='/admin/catalog'" class="btn-danger">Danh mục</button></td>
                    <td align="right"><button onclick="window.location.href='/admin/customer'" class="btn-success">Khách hàng</button></td>
                    <td align="right"><button onclick="window.location.href='/admin/order'" class="btn-primary">Đơn hàng</button></td>
                    <td align="right"><button onclick="window.location.href='/'" class="btn-secondary">Home</button></td>
                </tr>
            </table>
        </div>
    </body>
</html>
