

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
                        <form class="form-inline" method="post" action="/Admin/searchDanhMuc" >
                            <input class="form-control mr-sm" name="name" type="search" placeholder="Search" size="30px" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm Kiếm</button>
                        </form>
                    </nav>



                    <table class="table" style="background: white;">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Tên</th>
                                <th scope="col">Giới Tính </th>
                                <th scope="col">Số Điện Thoại</th>
                                <th scope="col">Email</th>
                                <th scope="col">Địa Chỉ</th>
                                  <th scope="col">Chức Năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${l}">
                                <tr>

                                    <td>${item.name}</td>

                                    <td>${item.gender}</td>
                                    <td>${item.phone}</td>
                                    <td>${item.email}</td>
                                    <td>${item.address}</td>
                                    <td> <a class="btn btn-danger" href="/Admin/deleteProduct?id=${item.maKH}">Xóa</a>

                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>   
                <div class="clearfix"></div>
            </div>

    </body>
</html>
