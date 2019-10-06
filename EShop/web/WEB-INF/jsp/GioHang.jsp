
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
        <div class="container" style="margin-top: 50px;margin-bottom: 100px;"> 
            <c:if test="${not empty cart}">
            <div class="row"> <div class="col-9" style="padding-top: 20px;"> 
                    <c:forEach var="item" items="${cart}"> 
                        <div class="row" style="margin-bottom: 30px;"> 
                            <div class="col-2"> 
                                <img src="/EShop/img/${item.image}" style="width: 100px;height: auto" > 
                            </div> 
                            <div class="col-6"> 
                                <p>${item.name}</p> 
                            </div> 
                            <div class="col-2"> 
                                <p style="color: #f8694a">${item.newPrice}</p> <p><span style=" text-decoration: line-through;color: #b3b3b3">${item.oldPrice}</span><span> | ${item.giamGia}%</span></p>
                            </div> 
                            <div class="col-2"> 
                                <form action="/action_page.php">

                                    <a href="/EShop/TruGioHang?id=${item.maSP}" style="padding:5px 10px;cursor: pointer; ;background: #dc3545;">-</a><input type="text" style="padding-left: 20px;" name="soluong" value="${item.soLuong}" size="1px;" name="quantity" min="1" max="${item.maxSoLuong}"><a href="/EShop/CongGioHang?id=${item.maSP}" style="padding:5px 10px;cursor: pointer; ;background: #28a745;">+</a>
                                </form> 
                            </div> 
                        </div> 
                        <hr> 
                    </c:forEach> 
                </div> 
                <div class="col-3" style="padding-top: 20px;"> 
                    <h3>Tổng Tiền :<span style="color: #f8694a">${money}</span></h3>

                    <form action="/EShop/ThanhToan" method="">

                        
                        <button type="submit" class="btn btn-danger" style="width: 100%;height: auto;background: #f8694a;border: none;height: 50px;margin-top: 10px;">Thanh Toán</button>

                    </form>

                </div> 
            </div> 
            </c:if>
            <c:if test="${ empty cart}">
                <img src="/EShop/img/nullCart.jpg" style="width: 100%;height: auto">
            </c:if>
            
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
