<%-- 
    Document   : productDetail
    Created on : Oct 17, 2019, 8:30:19 AM
    Author     : Dell
--%>

<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <style>
            input[type="number"],input[type="submit"]{
                font-family: "Times New Roman";
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #cccccc;
                box-sizing: border-box;
            }
            td{
                text-align: left;
                font-family: "Times New Roman";
                font-size: large;
            }
        </style>
    </head>
    <body>
        <%
            Product product = (Product) request.getAttribute("product");
        %>
        <%--<%@include file="/headerHome.jsp" %>--%>
        <jsp:include page="/headerHome.jsp"></jsp:include>
            <div class="container mt-3 text-center">
                <h2 style="color: slategray">Thông tin</h2>
                <div class="row">
                    <div class="col-4">
                        <img src="/image/product?IDcode=<%=product.getIDcode()%>" style="width: 250px;height: 250px">
                </div>
                <div class="col-7">
                    <form action="/customer/tocart?IDproduct=<%=product.getID() %>" method="post">
                        <table class="table table-borderless">
                            <tr>
                                <td align="left">Số lượt xem</td>
                                <td align="left">${viewCount}</td>
                            </tr>
                            <tr>
                                <td>Tên điện thoại</td>
                                <td><%=product.getNameBook()%></td>
                            </tr>
                            <tr>
                                <td>Màu sắc</td>
                                <td><%=product.getAuthor()%></td>
                            </tr>
                            <tr>
                                <td>Nơi sản xuất</td>
                                <td><%=product.getNXB()%></td>
                            </tr>
                            <tr>
                                <td>Năm sản xuất</td>
                                <td><%=product.getDateofissue()%></td>
                            </tr>
                            <tr>
                                <td colspan="2"><%=product.getDescription()%></td>
                            </tr>
                            <tr>
                                <td>Dung lượng</td>
                                <td><%=product.getNumberpage()%></td>
                            </tr>
                            <tr style="color: green">
                                <td>Trạng thái</td>
                                <c:if test="${product.getQuantity() > 0}">
                                    <td>Còn hàng</td>
                                </c:if>
                                <c:if test="${product.getQuantity() <= 0}">
                                    <td>Tạm hết hàng</td>
                                </c:if>
                            </tr>
                            <tr style="color: red">
                                <td>Giá</td>
                                <td><%=product.getPrice()%></td>
                            </tr>
                            <tr>
                                <td>Sale</td>
                                <td><%=product.getSale()%></td>
                            </tr>
                            <c:if test="${product.getQuantity() > 0 }">
                                <tr>
                                    <td><input type="number" value="1" name="quantity" required=""></td>
                                    <td><input type="submit" value="Thêm vào giỏ" class="btn btn-secondary"></td>
                                </tr>
                            </c:if>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
