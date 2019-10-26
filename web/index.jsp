<%@page import="Model.User"%>
<%@page import="java.util.List"%>
<%@page import="Model.Product"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>BookStore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
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
            a>div:hover{
                border: 1px solid #cccccc;
            }
            a{
                color: black;
            }
            .roww{
                display: flex;
                flex-wrap: wrap;
            }
        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String display = "";
            String displayUser = "none";
            if (user != null) {
                display = "none";
                displayUser = "block";
            }
        %>
        <div class="container-fluid mt-3" style="background-color: slategrey">
            <div class="row">
                <div class="dropdown" style="display: <%=displayUser%>">
                    <button type="button" class="btn dropdown-toggle mb-0 mt-0" data-toggle="dropdown" style="color: white;font-size: larger">
                        <i class="fas fa-user-cog" style="font-size: larger;color: white"></i>
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/customer/logined/infor">Thông tin</a>
                        <a class="dropdown-item" href="/customer/logined/history">Đơn hàng</a>
                        <a class="dropdown-item" href="/logout">Đăng xuất</a>
                    </div>
                </div>
                <ul class="nav" style="display: <%=display%>">
                    <li class="nav-item">
                        <a class="nav-link" href="/login"><b style="color: white">Đăng nhập</b></a>
                    </li>
<!--                    <li class="nav-item">
                        <a class="nav-link" href="/register"><b style="color: white">Đăng kí</b></a>
                    </li>-->
                </ul>
                    <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#1"><i class="fas fa-envelope-open" style="font-size: larger;color: white"></i><b style="color: white"> Email: tiennd2503@gmail.com</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#2"><i class="fas fa-phone" style="font-size: larger;color: white"></i><b style="color: white"> SĐT: 0865672503</b></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#2"><i class="fas fa-globe-asia" style="font-size: larger;color: white"></i><b style="color: white"> Địa chỉ: Hà Nội</b></a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="container mt-3" style="text-align: center"><img src="/image/product?IDcode=logo" style="width: 670px;height: 200px"/></div>
        <div class="container mt-3">
            <div class="row">
                <div class="col-3">
                    <div class="dropdown">
                        <button type="button" class="btn btn-light mt-0 mb-0 dropdown-toggle" data-toggle="dropdown">
                            Danh mục
                        </button>
                        <div class="dropdown-menu">
                            <c:forEach items="${catalog}" var="i" >
                                <a class="dropdown-item" href="/customer/catalog?IDcatalog=${i.getID()}">${i.getNameCatalog()}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <ul class="nav" id="menu-header-home">
                        <li class="nav-item">
                            <a class="nav-link" href=""><b>Trang chủ</b></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#1"><b>Giới thiệu</b></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#2"><b>Tin tức</b></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/home"><b>Admin</b></a>
                        </li>
                    </ul>
                </div>
                <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                    <a class="nav-link" href="/customer/cart"><i class="fas fa-cart-plus" style="font-size: larger;float: right"></i></a>
                </div>
            </div>
        </div>
        <%
            List<Product> listProductNewww = (List<Product>) request.getAttribute("listProductNew");
        %>
        <div class="container mt-3 text-center">
            <h2>Sách mới</h2>
            <div class="roww" align="center">
                <c:forEach items="<%=listProductNewww %>" var="i">
                    <div style="width: 200px;height: 320px;margin-right: 10px;margin-left: 10px">
                        <a href="/customer/product?IDcode=${i.getID()}"><div class="text-center mt-2"><img src="/image/product?IDcode=${i.getIDcode()}" style="width: 160px;height: 160px"><p class="text-truncate">${i.getNameBook()}</p><p>${i.getPrice()} (-${i.getSale()}%)</p><p style="color: red">Giá bán ${i.getPrice() - i.getPrice()*i.getSale()/100} đ</p></div></a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="container mt-3 text-center">
            <h2>Sách bán chạy nhất</h2>
            <div class="roww" align="center">
                <c:forEach items="${listTopSale}" var="i">
                    <div style="width: 200px;height: 320px;margin-right: 10px;margin-left: 10px">
                        <a href="/customer/product?IDcode=${i.getID()}"><div class="text-center mt-2"><img src="/image/product?IDcode=${i.getIDcode()}" style="width: 160px;height: 160px"><p class="text-truncate">${i.getNameBook()}</p><p>${i.getPrice()} (-${i.getSale()}%)</p><p style="color: red">Giá bán ${i.getPrice() - i.getPrice()*i.getSale()/100} đ</p></div></a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="container mt-3 text-center">
            <h2>Sách giảm giá nhiều nhất</h2>
            <div class="roww" align="center">
                <c:forEach items="${listBestSale}" var="i">
                    <div style="width: 200px;height: 320px;margin-right: 10px;margin-left: 10px">
                        <a href="/customer/product?IDcode=${i.getID()}"><div class="text-center mt-2"><img src="/image/product?IDcode=${i.getIDcode()}" style="width: 160px;height: 160px"><p class="text-truncate">${i.getNameBook()}</p><p>${i.getPrice()} (-${i.getSale()}%)</p><p style="color: red">Giá bán ${i.getPrice() - i.getPrice()*i.getSale()/100} đ</p></div></a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <footer class="container-fluid mt3" style="background-color: #cccccc">
            <table class="table table-borderless">
                <tr>
                    <td><a href="#1">Liên hệ</a></td>
                    <td><a href="#1">Chính sách đổi trả</a></td>
                    <td><a href="#2">Chi nhánh</a></td>
                    <td><a href="#3">Hình thức thanh toán</a></td>
                </tr>
            </table>
        </footer>
    </body>
</html>
