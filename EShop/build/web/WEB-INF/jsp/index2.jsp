
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>E-SHOP HTML Template</title>

        <!-- Google font -->
        <link href="http://localhost:8080/EShop/css?family=Hind:400,700" rel="stylesheet">


        <link type="text/css" rel="stylesheet" href="http://localhost:8080/EShop/css/bootstrap.min.css" />

        <link type="text/css" rel="stylesheet" href="http://localhost:8080/EShop/css/slick.css" />
        <link type="text/css" rel="stylesheet" href="http://localhost:8080/EShop/css/slick-theme.css" />


        <link type="text/css" rel="stylesheet" href="http://localhost:8080/EShop/css/nouislider.min.css" />


        <link rel="stylesheet" href="http://localhost:8080/EShop/css/font-awesome.min.css">

        <link type="text/css" rel="stylesheet" href="http://localhost:8080/EShop/css/style.css" />
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            a:link, a:visited {

                color: black;


                text-decoration: none;
            }
            a:hover, a:active {
                color: #f8694a;
            }
            *{
                font-family: Arial;
                font-size: small;
            }

        </style>
    </head>

    <body>
        <!-- HEADER -->

        <%@include file="header.jsp" %>
        <!-- /HEADER -->

        <!-- NAVIGATION -->
        <div id="navigation">
            <!-- container -->
            <div class="container" style="height: 50px;">
                <div id="responsive-nav"  >

                    <div class="menu-nav">
                        <span class="menu-header">Menu <i class="fa fa-bars"></i></span>
                        <ul class="menu-list">
                            <li class="dropdown default-dropdown"><a  data-toggle="dropdown" aria-expanded="true">   Danh mục sản phẩm  <i class="fa fa-list"></i></a>
                                <ul class="custom-menu">
                                    <c:forEach var="item" items="${l}">
                                        <li>  <a  href="http://localhost:8080/EShop/SearchDM?id=${item.maDM}">${item.name}</a></li>
                                        </c:forEach>

                                </ul>
                            </li>
                            <li><a href="#">Home</a></li>
                            <li><a href="#">Liên hệ</a></li>

                        </ul>
                    </div>
                    <!-- menu nav -->
                </div>
            </div>
            <!-- /container -->
        </div>
        <!-- /NAVIGATION -->
        <div class="section" style="background: #f4f4f4">
            <div class="container" style="background: white">
                <!-- section title -->
                <div >
                    <div class="section-title">
                        <h2 class="title">Dành Riêng cho bạn</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-3 col-3" style="padding-bottom: 20px;">
                        <!-- Ram -->
                        <c:forEach var="item" items="${lram}" end="0">
                            <h5 style="margin-top: 10px; font-weight: bold">Ram</h5>

                        </c:forEach>
                        <c:forEach var="item" items="${lram}">

                            <a  href="http://localhost:8080/EShop/SearchCTRam?id=${item}&madm=${maDM}" style="padding-left: 5px;">${item}</a></br>
                        </c:forEach>
                        <!-- Rom -->
                        <c:forEach var="item" items="${lrom}" end="0">
                            <H5 style="margin-top: 10px;padding-top: 10px;;border-top: 1px solid #e6e6e6; font-weight: bold">DUNG LƯỢNG LƯU TRỮ</h5>

                        </c:forEach>
                        <c:forEach var="item" items="${lrom}">

                            <a href="http://localhost:8080/EShop/SearchCTRom?id=${item}&madm=${maDM}" style="padding-left: 5px;">${item}</a></br>
                        </c:forEach>    
                        <!-- CPU -->
                        <c:forEach var="item" items="${lcpu}" end="0">
                            <h5 style="margin-top: 10px;padding-top:10px ;border-top: 1px solid #e6e6e6; font-weight: bold">CPU</h5>

                        </c:forEach>
                        <c:forEach var="item" items="${lcpu}">

                            <a href="http://localhost:8080/EShop/SearchCTCPU?id=${item}&madm=${maDM}" style="padding-left: 5px;">${item}</a></br>
                        </c:forEach>   

                        <!-- HDH -->
                        <c:forEach var="item" items="${lhdh}" end="0">
                            <h5 style="margin-top: 10px;padding-top:10px ;border-top: 1px solid #e6e6e6; font-weight: bold">HỆ ĐIỀU HÀNH</h5>

                        </c:forEach>
                        <c:forEach var="item" items="${lhdh}">

                            <a href="http://localhost:8080/EShop/SearchCTHDH?id=${item}&madm=${maDM}" style="padding-left: 5px;">${item}</a></br>
                        </c:forEach>   
                        <!-- Màn Hình -->
                        <c:forEach var="item" items="${lmh}" end="0">
                            <h5 style="margin-top: 10px;padding-top:10px ;border-top: 1px solid #e6e6e6; font-weight: bold">ĐỘ PHÂN GIẢI MÀN HÌNH</h5>

                        </c:forEach>
                        <c:forEach var="item" items="${lmh}">

                            <a href="http://localhost:8080/EShop/SearchCTMH?id=${item}&madm=${maDM}" style="padding-left: 5px;">${item}</a></br>
                        </c:forEach>   

                        <!-- Card ĐỒ họa -->


                        <!-- Sim -->
                        <c:forEach var="item" items="${lsim}" end="0">
                            <h5 style="margin-top: 10px;padding-top:10px ;border-top: 1px solid #e6e6e6; font-weight: bold">SỐ LƯỢNG SIM</h5>

                        </c:forEach>
                        <c:forEach var="item" items="${lsim}">

                            <a href="http://localhost:8080/EShop/SearchCTSim?id=${item}&madm=${maDM}" style="padding-left: 5px;">${item}</a></br>
                        </c:forEach>  

                        <!-- CameraT -->
                        <c:forEach var="item" items="${lcameraT}" end="0">
                            <h5 style="margin-top: 10px;padding-top:10px ;border-top: 1px solid #e6e6e6; font-weight: bold">CAMERA TRƯỚC</h5>

                        </c:forEach>
                        <c:forEach var="item" items="${lcameraT}">

                            <a href="http://localhost:8080/EShop/SearchCTCameraT?id=${item}&madm=${maDM}" style="padding-left: 5px;">${item}</a></br>
                        </c:forEach>  

                        <!-- CameraS -->
                        <c:forEach var="item" items="${lcameraS}" end="0">
                            <h5 style="margin-top: 10px;padding-top:10px ;border-top: 1px solid #e6e6e6; font-weight: bold">CAMERA SAU</h5>

                        </c:forEach>
                        <c:forEach var="item" items="${lcameraS}">

                            <a href="http://localhost:8080/EShop/SearchCTCameraS?id=${item}&madm=${maDM}" style="padding-left: 5px;">${item}</a></br>
                        </c:forEach>  
                        <c:forEach var="item" items="${cdh}" end="0">
                            <h5 style="margin-top: 10px;padding-top:10px ;border-top: 1px solid #e6e6e6; font-weight: bold">CARD ĐỒ HỌA</h5> 

                        </c:forEach>
                        <c:forEach var="item" items="${cdh}">

                            <a href="http://localhost:8080/EShop/SearchCTCDH?id=${item}&madm=${maDM}" style="padding-left: 5px;">${item}</a></br>
                        </c:forEach>  

                    </div>
                    <div class="col-xl-9 col-9">

                        <div class="row">
                            <c:forEach var="item" items="${lsp}">

                                <div class="col-xl-4 col-md-6   col-12" >
                                    <div class="product product-single">
                                        <div class="product-thumb">
                                            <div class="product-label">
                                                <c:if test="${not empty item.trangThai}">
                                                    <span style="color: #ffffff;background: #000">${item.trangThai}</span>
                                                </c:if>

                                                <c:if test="${item.giamGia < 100}">
                                                    <span class="sale">-${item.giamGia}%</span></c:if>
                                                </div>
                                                <a href="http://localhost:8080/EShop/ChiTietProduct?id=${item.maSP}" class="main-btn quick-view"><i class="fa fa-search-plus"></i> Chi Tiết</a>
                                            <img style="width: 250px;height: 250px;" src="http://localhost:8080/EShop/img/${item.image}" alt="">
                                        </div>
                                        <div class="product-body">
                                            <h4 class="product-price" style="color: #f8694a">${item.newPrice}<p style="font-size: 15px;" > <c:if test="${item.oldPrice != '0 đ'}"> <del class="product-old-price" style="color: #bbb1b1">${item.oldPrice}</del></c:if></p></h4>
                                            
                                            <h2 class="product-name"><a href="#">${item.name}</a></h2>

                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </div>

        </div>


        <%@include file="footer.jsp" %>
        <script src="http://localhost:8080/EShop/js/jquery.min.js"></script>
        <script src="http://localhost:8080/EShop/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/EShop/js/slick.min.js"></script>
        <script src="http://localhost:8080/EShop/js/nouislider.min.js"></script>
        <script src="http://localhost:8080/EShop/js/jquery.zoom.min.js"></script>
        <script src="http://localhost:8080/EShop/js/main.js"></script>

    </body>

</html>
