<%-- 
    Document   : admin-add-catalog
    Created on : Sep 27, 2019, 2:58:38 PM
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
    <body>
        <jsp:include page="/admin/admin-home.jsp"></jsp:include>
        <div class="container mt-3" style="text-align: center;">
            <h1>Thêm danh mục</h1>
            <form action="/admin/catalog/add" method="post" class="mt-3">
                <table style="font-size: large" class="table table-borderless">
                    <tr>
                        <td>Tên danh mục</td>
                        <td colspan="3"><input type="text" name="catalog" required="" placeholder="Tên danh mục"></td>
                    </tr>
                    <tr>
                        <td colspan="1" align="right"><button onclick="cancel()" class="btn-danger">Hủy</button></td>
                        <td colspan="3" align="right"><button type="sumbit">Lưu</button></td>
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
