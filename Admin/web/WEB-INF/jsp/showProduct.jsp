<%-- 
    Document   : showDanhMuc
    Created on : Oct 1, 2019, 3:05:15 PM
    Author     : Toan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Ela Admin - HTML5 Admin Template</title>
        <meta name="description" content="Ela Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
        <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
        <link rel="stylesheet" href="http://localhost:8080/Admin/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="http://localhost:8080/Admin/css/style.css">

        <link href="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/jqvmap@1.5.1/dist/jqvmap.min.css" rel="stylesheet">

        <link href="https://cdn.jsdelivr.net/npm/weathericons@2.1.0/css/weather-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.css" rel="stylesheet" />
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>

    <body>
        <div id="right-panel" class="right-panel">
            <%@include file="header.jsp" %>
            <div class="content" style="background: white;">
                <div class="animated fadeIn"><!-- content -->

                    <nav class="navbar navbar-light bg-light float-right" style="margin-bottom: 10px;" >
                        <form class="form-inline" method="post" action="/Admin/searchProduct" >
                            <input class="form-control mr-sm" name="name" type="search" placeholder="Tên,Thương Hiệu sản phẩm Hoặc Tên Danh Mục " size="60px" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm Kiếm</button>
                        </form>
                    </nav>



                    <table class="table" style="background: white;">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Ảnh</th>
                                <th scope="col">Tên </th>
                                <th scope="col">Giá Hiện Tại</th>
                                <th scope="col">Giá Cũ</th>
                                <th scope="col">Thương hiệu</th>
                                <th scope="col">Số Lượng</th>
                                <th scope="col">Trạng Thái</th>
                                <th scope="col">Chức Năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${lp}">
                                <tr>
                                    <td><img src="http://localhost:8080/Admin/images/${item.image}" style="width: 40px;height: auto"></td>
                                    <td>${item.name}</td>
                                    <td style="color: #ff9933">${item.newPrice}</td>
                                    <td style="color: #ff9933">${item.oldPrice}</td>
                                    <td>${item.thuongHieu}</td>
                                    <td>${item.soLuong}</td>
                                    <td>${item.trangThai}</td>

                                    <td> <a class="btn btn-danger" href="/Admin/deleteProduct?id=${item.maSP}">Xóa</a>
                            <a class="btn btn-primary" href="/Admin/updateProduct?&id=${item.maSP}">Sửa</a>
                           
                            </td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>



                </div>
            </div>   
            <div class="clearfix"></div>
        </div>
    </body>
</html>
