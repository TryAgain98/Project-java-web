
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
                margin: 0px;
                border: 0px;
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
                    <!-- category nav -->
                    <div class="category-nav">
                        <span class="category-header" >Danh mục sản phẩm <i class="fa fa-list"></i></span>
                        <ul class="category-list">

                            <c:forEach var="item" items="${l}">
                                <li><a href="http://localhost:8080/EShop/SearchDM?id=${item.maDM}">${item.name}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                    <!-- /category nav -->

                    <!-- menu nav -->
                    <div class="menu-nav">
                        <span class="menu-header">Menu <i class="fa fa-bars"></i></span>
                        <ul class="menu-list">
                            <li><a href="#">Home</a></li>
                            <li><a href="#">Liên Hệ </a></li>
                        </ul>
                    </div>
                    <!-- menu nav -->
                </div>
            </div>
            <!-- /container -->
        </div>
        <!-- /NAVIGATION -->

        <div id="home">
            <!-- container -->
            <div class="container">
                <!-- home wrap -->
                <div class="home-wrap">
                    <!-- home slick -->
                    <div id="home-slick">
                        <!-- banner -->
                        <div class="banner banner-1">
                            <img src="http://localhost:8080/EShop/img/banner1.jpg" alt="">
                            <!--                            <div class="banner-caption text-center">
                                                            <h1>Bags sale</h1>
                                                            <h3 class="white-color font-weak">Up to 50% Discount</h3>
                                                            <button class="primary-btn">Shop Now</button>
                                                        </div>-->
                        </div>
                        <div class="banner banner-1">
                            <img src="http://localhost:8080/EShop/img/banner2.jpg" alt="">
                            <!--                            <div class="banner-caption">
                                                            <h1 class="primary-color">HOT DEAL<br><span class="white-color font-weak">Up to 50% OFF</span></h1>
                                                            <button class="primary-btn">Shop Now</button>
                                                        </div>-->
                        </div>

                    </div>
                </div>
            </div>

        </div>


        <!-- section -->





        <div class="section" >

            <div class="container">


                <!-- section title -->
                <div >
                    <div class="section-title">
                        <h2 class="title">Dành Riêng cho bạn</h2>
                    </div>
                </div>
                <div class="row">
                    <c:forEach var="item" items="${lsp}">

                        <div class="col-xl-3 col-sm-6 col-lg-4  col-12" >
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
                                    <h4 class="product-price" style="color: #f8694a">${item.newPrice}<p style="font-size: 15px;" ><c:if test="${item.oldPrice != '0 đ'}"> <del class="product-old-price" style="color: #bbb1b1">${item.oldPrice}</del></c:if></p></h4>

                                    <h2 class="product-name"><a href="#">${item.name}</a></h2>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

<!--                <center><button id="load" type="button" class="btn btn-light" style="height: 40px;font-size: 15px;">Tải Thêm</button></center>-->
            </div>

        </div>




<!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {

                function createProduct(prod) {
                    return '<div class="col-xl-3 col-sm-6 col-lg-4  col-12" >'
                            '<div class="product product-single">'
                               ' <div class="product-thumb">'
                                   ' <div class="product-label">'
                                      
                                           ' <span style="color: #ffffff;background: #000">'+prod.trangThai+'</span>'
                                    

                                     
//                                        '    <span class="sale">-'+prod.giamGia+'%</span>'
                                       ' </div>'
//                                        '<a href="http://localhost:8080/EShop/ChiTietProduct?id='+prod.maSP+'" class="main-btn quick-view"><i class="fa fa-search-plus"></i> Chi Tiết</a>'
//                                    '<img style="width: 250px;height: 250px;" src="http://localhost:8080/EShop/img/" alt="">'
                               ' </div>'
                                '<div class="product-body">'
//                                    '<h4 class="product-price" style="color: #f8694a"><p style="font-size: 15px;" > <del class="product-old-price" style="color: #bbb1b1"></del></p></h4>'
//
//                                    '<h2 class="product-name"><a href="#"></a></h2>'

                               ' </div>'
                           ' </div>'
                        '</div>';   
                }

                var page = 1;
                $("#load").click(function () {

                    $.get("/EShop/product?page=" + page, function (data) {
                        var content = $('.row');
                        const prod={trangThai: "new",giamGia: 20,maSP: 20};
                        $(content).append(createProduct(prod));
                    });
                    page++;
                });
            });
        </script>-->


        <%@include file="footer.jsp" %>
        <script src="http://localhost:8080/EShop/js/jquery.min.js"></script>
        <script src="http://localhost:8080/EShop/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/EShop/js/slick.min.js"></script>
        <script src="http://localhost:8080/EShop/js/nouislider.min.js"></script>
        <script src="http://localhost:8080/EShop/js/jquery.zoom.min.js"></script>
        <script src="http://localhost:8080/EShop/js/main.js"></script>

    </body>

</html>
