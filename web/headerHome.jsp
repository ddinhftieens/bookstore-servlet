<%-- 
    Document   : headerHome
    Created on : Oct 17, 2019, 8:39:11 AM
    Author     : Dell
--%>

<%@page import="Model.Catalog"%>
<%@page import="java.util.List"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>BookStore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <style>
            input[type="text"],input[type="number"],textarea,button{
                font-family: "Times New Roman";
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #cccccc;
                box-sizing: border-box;
            }
            a{
                color: black;
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
            List<Catalog> catalogg = (List<Catalog>) request.getAttribute("catalog");
        %>
        <div class="container-fluid mt-3" style="background-color: slategrey">
            <div class="row">
                <div class="dropdown" style="display: <%=displayUser%>">
                    <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" style="color: white;font-size: larger">
                        <i class="fas fa-user" style="font-size: larger;color: white"></i>
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
                    <li class="nav-item">
                        <a class="nav-link" href="/register"><b style="color: white">Đăng kí</b></a>
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
                            <%
                                for (Catalog i : catalogg) {
                            %>
                            <a class="dropdown-item" href="/customer/catalog?IDcatalog=<%=i.getID()%>"><%=i.getNameCatalog()%></a>
                            <%    }
                            %>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <ul class="nav" id="menu-header-home">
                        <li class="nav-item">
                            <a class="nav-link" href="/"><b>Trang chủ</b></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#1"><b>Giới thiệu</b></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#2"><b>Tin tức</b></a>
                        </li>
                    </ul>
                </div>
                <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                    <a class="nav-link" href="/customer/cart"><i class="fas fa-cart-plus" style="font-size: larger;float: right"></i></a>
                </div>
            </div>
        </div>
    </body>
</html>
