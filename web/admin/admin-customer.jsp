<%-- 
    Document   : admin-customer
    Created on : Oct 18, 2019, 11:06:26 PM
    Author     : Dell
--%>

<%@page import="Model.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <<title>BookStore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <style>
            input[type="submit"],select,input[type="number"]{
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
        <div class="container mt-3 text-center">
            <h2 class="mt-3">Danh sách khách hàng</h2>
            <div class="row ml-0">
                <form class="col-12">
                    <input type="number" name="findUser" class="col-5" placeholder="Tìm ID user" required="">
                    <input type="submit" class="col-4" value="Tìm">
                </form>
            </div>
        </div>
        <div class="container-fluid mt-3 text-center">
            <%
                List<User> listUser = (List<User>) request.getAttribute("listUser");
            %>
            <table class="table table-bordered mt-3">
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Họ</th>
                    <th>Địa chỉ</th>
                    <th>Số điện thoại</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Kích hoạt</th>
                </tr>
                <c:forEach items="<%=listUser %>" var="i">
                    <form action="/admin/customer?IDuser=${i.getID()}" method="post">
                        <tr>
                            <td>${i.getID()}</td>
                            <td>${i.getFristName()}</td>
                            <td>${i.getLastName()}</td>
                            <td>${i.getAddress()}</td>
                            <td>${i.getPhone()}</td>
                            <td>${i.getEmail()}</td>
                            <td>
                                <select name="role">
                                    <option selected="" hidden="" value="${i.getRole()}">${i.getRole()}</option>
                                    <option value="ROLE_USER">ROLE_USER</option>
                                    <option value="ROLE_ADMIN">ROLE_ADMIN</option>
                                </select>
                            </td>
                            <td>
                                <input type="submit" value="Kích hoạt">
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
