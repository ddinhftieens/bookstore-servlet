<%-- 
    Document   : test
    Created on : Sep 25, 2019, 7:09:25 PM
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
            img,image{
                width: 300px;
                height: 300px;
            }
        </style>
    </head>
    <body>
        <%@page import="Model.Product"%>
        
        <%
            Product pro = (Product) request.getAttribute("product");
        %>
        <jsp:include page="/admin/admin-home.jsp"></jsp:include>
        <div class="container mt-3" style="text-align: center;">
        <h1>Cập nhật sách</h1>
        <form action="/admin/catalog/product/edit?IDcatalog=<%=pro.getIDcatalog()%>" method="post" class="mt-3">
            <table style="font-size: large" class="table table-borderless">
                <tr>
                    <td colspan="2"><img src="/image/product?IDcode=<%=pro.getIDcode()%>"></td>
                    <td>Trạng thái</td>
                    <td><input type="text" value="<%=pro.getStatus()%>" name="status"></td>
                </tr>
                <tr>
                    <td>Tên sách</td>
                    <td><input type="text" name="tensach" value="<%=pro.getNameBook() %>" required="" placeholder="Tên sách"></td>
                    <td>Tên tác giả</td>
                    <td><input type="text" name="tacgia" value="<%= pro.getAuthor() %>" required="" placeholder="Tên tác giả"></td>
                </tr>
                <tr>
                    <td>Nhà xuất bản</td>
                    <td><input type="text" name="nhaxuatban" value="<%= pro.getNXB() %>" required="" placeholder="Nhà xuất bản"></td>
                    <td>Năm xuất bản</td>
                    <td><input type="text" name="ngayphathanh" value="<%= pro.getDateofissue() %>" required="" placeholder="Năm xuất bản"></td>
                </tr>
                <tr>
                    <td>Số trang</td>
                    <td><input type="number" name="sotrang" value="<%= pro.getNumberpage() %>" required="" placeholder="Số trang"></td>
                    <td>Số lượng</td>
                    <td><input type="number" name="soluong" value="<%= pro.getQuantity() %>" required="" placeholder="Số lượng"></td>
                </tr>
                <tr><td>Mô tả</td>
                    <td colspan="3"><textarea type="text" name="mota" required="" placeholder="Mô tả" style="height: 100px"><%= pro.getDescription()%></textarea></td>
                </tr>
                <tr>
                    <td>Giá</td>
                    <td><input type="number" name="gia" value="<%= pro.getPrice() %>" required="" placeholder="Giá"></td>
                    <td>Sale</td>
                    <td><input type="number" name="giamgia" value="<%= pro.getSale() %>" required="" placeholder="Sale"></td>
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
            }
        </script>
    </body>
</html>
