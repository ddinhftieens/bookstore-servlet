<%-- 
    Document   : getProductbyCatalog
    Created on : Oct 17, 2019, 3:18:12 PM
    Author     : Dell
--%>

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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <style>
            a>div:hover{
                border: 1px solid #cccccc;
            }
            .roww{
                display: flex;
                flex-wrap: wrap;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/headerHome.jsp"></jsp:include>
        <div class="container mt-3 text-center">
            <h2>${nameCatalog}</h2>
            <div class="roww" align="center">
                <c:forEach items="${product}" var="i">
                    <div style="width: 200px;height: 320px;margin-right: 10px;margin-left: 10px">
                        <a href="/customer/product?IDcode=${i.getID()}"><div class="text-center mt-2"><img src="/image/product?IDcode=${i.getIDcode()}" style="width: 160px;height: 160px"><p class="text-truncate">${i.getNameBook()}</p><p>${i.getPrice()} (-${i.getSale()}%)</p><p style="color: red">Giá bán ${i.getPrice() - i.getPrice()*i.getSale()/100} đ</p></div></a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
