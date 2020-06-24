<%-- 
    Document   : admin-add-product
    Created on : Sep 23, 2019, 10:34:28 AM
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
            <h1>Thêm sản phẩm</h1>
            <form action="/admin/catalog/product/add" method="post" enctype="multipart/form-data" class="mt-3">
                <table style="font-size: large" class="table table-borderless">
                    <tr>
                        <td>Tên điện thoại</td>
                        <td><input type="text" name="nameBook" required="" placeholder="Tên điện thoại"></td>
                        <td>Màu sắc</td>
                        <td><input type="text" name="author" required="" placeholder="Màu sắc"></td>
                    </tr>
                    <tr>
                        <td>Xuất xứ</td>
                        <td><input type="text" name="NXB" required="" placeholder="Xuất xứ"></td>
                        <td>Năm sản xuất</td>
                        <td><input type="text" name="dateofissue" required="" placeholder="Năm xuất bản"></td>
                    </tr>
                    <tr>
                        <td>Dung lượng</td>
                        <td><input type="number" name="numberPage" required="" placeholder="Dung lượng"></td>
                        <td>Số lượng</td>
                        <td><input type="number" name="quantity" required="" placeholder="Số lượng"></td>
                    </tr>
                    <tr><td>Mô tả</td>
                        <td colspan="3"><textarea type="text" name="description" required="" placeholder="Mô tả" style="height: 100px"></textarea></td>
                    </tr>
                    <tr>
                        <td>Giá</td>
                        <td><input type="number" name="price" required="" placeholder="Giá"></td>
                        <td>Sale</td>
                        <td><input type="number" name="sale" required="" placeholder="Sale"></td>
                    </tr>
                    <tr>
                        <td>Ảnh</td>
                        <td><input type="file" name="fileImage" required=""></td>
                        <td>Trạng thái</td>
                        <td><input type="text" name="status" value="New" required="" placeholder="Trạng thái"></td>
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
