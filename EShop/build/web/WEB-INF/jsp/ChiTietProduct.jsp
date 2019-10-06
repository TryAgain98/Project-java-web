
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


        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
                        <h2 class="title">CHI TIẾT SẢN PHẨM</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 col-12">
                        <c:forEach var="item" items="${lsp}">
                            <img src="http://localhost:8080/EShop/img/${item.image} " style="width: 300px;height: auto;" >
                        </c:forEach>

                    </div>
                    <div class="col-md-7 col-12" style="padding-bottom: 20px;">
                        <!-- Ram -->
                        <c:forEach var="item" items="${lsp}">
                            <h3 style="font-weight: bold">${item.name}</h3>
                            <hr>
                            <p> Giá : <span style="color: #f8694a;font-size: 20px;">${item.newPrice}</span></p>
                                <c:if test="${item.giamGia < 100}">
                                <p> Tiết Kiệm :<span class="sale">-${item.giamGia}%</span></p></c:if>
                            <c:if test="${not empty item.oldPrice}">
                                <p> Giá Thị Trường : <span>${item.oldPrice}</span></p>  </c:if>
                            <p>Thương Hiệu : <span>${item.thuongHieu}</span></p>
                        </c:forEach>


                        <c:if test="${not empty ram}">
                            <p style="">Ram :${ram} </p>
                        </c:if>


                        <!-- Rom -->
                        <c:if test="${not empty rom}">
                            <p >DUNG LƯỢNG LƯU TRỮ :  ${rom}
                            </p>

                        </c:if>

                        <!-- CPU -->
                        <c:if test="${not empty cpu}">
                            <p>CPU : ${cpu}</br>
                            </p>

                        </c:if>


                        <!-- HDH -->
                        <c:if test="${not empty hdh}">
                            <p >HỆ ĐIỀU HÀNH : ${hdh}</br>
                            </p>

                        </c:if>

                        <!-- Màn Hình -->
                        <c:if test="${not empty mh}">
                            <p >ĐỘ PHÂN GIẢI MÀN HÌNH :  ${mh}</br>
                            </p>

                        </c:if>


                        <!-- Card ĐỒ họa -->
                        <c:if test="${not empty cdh}">
                            <p >CARD ĐỒ HỌA : ${cdh}</br>
                            </p>

                        </c:if>


                        <!-- Sim -->
                        <c:if test="${not empty sim}">
                            <p >SỐ LƯỢNG SIM :  ${sim}</br>
                            </p>

                        </c:if>


                        <!-- CameraT -->
                        <c:if test="${not empty cameraT}">
                            <p >CAMERA TRƯỚC : ${cameraT}</br>
                            </p>

                        </c:if>


                        <!-- CameraS -->
                        <c:if test="${not empty cameraS}">
                            <p >CAMERA SAU : ${cameraS}</br>
                            </p>
                        </c:if>
                        <c:forEach var="item" items="${lsp}">



                            <div class="container" style="padding-left:  0px;">
                                <div class="row">
                                    <div class="col-2 col-md-2">
                                        <form name="myForm" method="post">
                                            <fieldset>
                                                
                                                <div class="form-group">
                                                    <c:if test="${item.soLuong > 0}">
                                                    <label class="control-label">Số Lượng :</label>
                                                   
                                                    <input id="colorful" class="form-control quantity" type="number" value="1" min="1" max="${item.soLuong}"  style="margin-left:   20px;height: auto;" />
                                                    </c:if>
                                                     <c:if test="${item.soLuong < 1}">
                                                         <p style="color: red;">Hết Hàng</p>
                                                         <h3 style="color: red;font-weight: bold">Sorry</h3>
                                                     </c:if>
                                                    </div>

                                            </fieldset>
                                            <c:if test="${not empty name && item.soLuong > 0}">
                                                <input  type="submit" id="addCard" value="Thêm Vào Giỏ Hàng"  style="margin-top: 10px;width: 350px;height: 50px;background:#f8694a;border: 1px solid #f8694a;border-radius: 6px;color: white "/>
                                            </c:if>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <c:if test="${ empty name && item.soLuong > 0}">
                                <button type="button" id="login" style="margin-top: 10px;font-size: 14px;;width: 350px;height: 50px;background:#f8694a;border: 1px solid #f8694a;border-radius: 6px;color: white "  class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenterlg">Thêm Vào Giỏ Hàng</button>   
                            </c:if>

                        </c:forEach>


                    </div>

                </div>
                <hr>
                <c:forEach var="item" items="${lsp}">
                    <h4 style="font-weight: bold">Mô Tả Sản Phẩm</h4>
                    <p>${item.ghiChu}</p>
                </c:forEach>

            </div>

        </div>

        <%@include file="Login.jsp" %>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script>
            $(document).ready(function () {


                $("#addCard").click(function () {
                    var x = $(".quantity").val();


                    $.get("/EShop/addCard?id=" +${maSP} + "&quantity=" + x, function (data) {
                        $("#giohang").html("");
                    });
                });
            });
        </script>

        <%@include file="footer.jsp" %>
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js" ></script>
        <script src="http://localhost:8080/EShopjs/bootstrap.min.js" ></script>
        <script src="http://localhost:8080/EShop/js/bootstrap-number-input.js" ></script>
        <script>
            // Remember set you events before call bootstrapSwitch or they will fire after bootstrapSwitch's events
            $("[name='checkbox2']").change(function () {
                if (!confirm('Do you wanna cancel me!')) {
                    this.checked = true;
                }
            });

            $('#after').bootstrapNumber();
            $('#colorful').bootstrapNumber({
                upClass: 'success',
                downClass: 'danger'
            });
        </script> 
        <script src="http://localhost:8080/EShop/js/jquery.min.js"></script>
        <script src="http://localhost:8080/EShop/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/EShop/js/slick.min.js"></script>
        <script src="http://localhost:8080/EShop/js/nouislider.min.js"></script>
        <script src="http://localhost:8080/EShop/js/jquery.zoom.min.js"></script>
        <script src="http://localhost:8080/EShop/js/main.js"></script>

    </body>

</html>
