
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

        <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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
                            <li><a href="#">Liên Hệ</a></li>

                        </ul>
                    </div>
                    <!-- menu nav -->
                </div>
            </div>
            <!-- /container -->
        </div>
        <!-- /NAVIGATION -->
        <div class="row">
            <div class="col-3"></div>
            <div class="container col-9" style="margin-top: 50px;margin-bottom:  50px;border-left: 1px solid #dadada">
                <spring:form action="http://localhost:8080/EShop/updateAcount" modelAttribute="c"  name="myForm">
                    <div class="form-group row">
                        <spring:input type="hidden" path="maKH"  class="form-control" value="${c1.maKH}" id="exampleFormControlInput1" placeholder="Nhập Tên"/>

                        <div class="col-sm-2" >Họ tên  </div>
                        <div class="col-sm-7" > <spring:input type="text" path="name"  value="${c1.name}" class="form-control" id="formGroupExampleInput" placeholder="Nhập họ tên"/></div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2 float-left">Số Điện Thoại  </div>
                        <div class="col-sm-7" > <spring:input type="text"  path="phone" value="${c1.phone}" class="form-control" id="formGroupExampleInput" placeholder="Nhập số điện thoại"/></div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2" >Email  </div>
                        <div class="col-sm-7" > <spring:input type="email" path="email"  value="${c1.email}" class="form-control" id="formGroupExampleInput" placeholder="Nhập email"/></div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2" >Mật khẩu  </div>
                        <div class="col-sm-7" > <spring:input type="password"  path="password" value="${c1.password}" class="form-control" id="formGroupExampleInput" placeholder="Nhập mật khẩu"/></div>
                    </div>
                     <div class="form-group row">
                        <div class="col-sm-2 float-left">Địa chỉ  </div>
                        <div class="col-sm-7" > <spring:input type="text"  path="address" value="${c1.address}" class="form-control" id="formGroupExampleInput" placeholder="Nhập địa chỉ"/></div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2" >Giới tính  </div>
                        <c:if test="${c1.gender == 'Nam'}">
                            <div class="form-check " >
                                <input class="form-check-input"  type="radio"  name="sexx" id="exampleRadios1" value="Nam" checked="" ><span style="margin-left: 20px;">Nam</span>
                            </div>
                        </c:if>
                        <c:if test="${c1.gender != 'Nam'}">
                            <div class="form-check " >
                                <input class="form-check-input"  type="radio"  name="sexx" id="exampleRadios1" value="Nam"  ><span style="margin-left: 20px;">Nam</span>
                            </div>
                        </c:if>
                        <c:if test="${c1.gender == 'Nữ'}">
                            <div class="form-check " style="margin-left: 100px;">
                                <input class="form-check-input" type="radio"  name="sexx" id="exampleRadios2" value="Nữ"  checked=""><span style="margin-left: 20px;">Nữ</span>
                            </div> 
                        </c:if>

                        <c:if test="${c1.gender != 'Nữ'}">
                            <div class="form-check " style="margin-left: 100px;">
                                <input class="form-check-input" type="radio"  name="sexx" id="exampleRadios2" value="Nữ"  ><span style="margin-left: 20px;">Nữ</span>
                            </div> 
                        </c:if>
                    </div>


                    <center><button type="submit" style="width: 50%;margin-top: 30px;padding: 10px 10px;background: #f8694a;border: none" class="btn btn-primary btn-sm">Cập nhật</button></center>
                    </spring:form>
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

        <script src="http://localhost:8080/EShop/js/jquery.min.js"></script>
        <script src="http://localhost:8080/EShop/js/bootstrap.min.js"></script>
        <script src="http://localhost:8080/EShop/js/slick.min.js"></script>
        <script src="http://localhost:8080/EShop/js/nouislider.min.js"></script>
        <script src="http://localhost:8080/EShop/js/jquery.zoom.min.js"></script>
        <script src="http://localhost:8080/EShop/js/main.js"></script>

    </body>

</html>
