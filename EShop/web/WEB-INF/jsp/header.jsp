<%-- 
    Document   : header
    Created on : Sep 19, 2019, 1:18:06 AM
    Author     : Toan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>

       
        

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


        <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <style>
            #input{
                width: 400px;
                padding-left: 10px; 

                font-size: 13px;   
            }
        </style>
    </head>
    <body>
        <header>
            <!-- top Header -->

            <!-- /top Header -->
            <c:if test="${not empty  check}">
                <script>
                    $(document).ready(function () {
                        function check() {
                            Swal.fire({
                                type: 'success',
                                title: '${check}',
                                timer: 2000
                            })
                        }
                        ;

                        check();
                    });
                </script>
            </c:if>

            <!-- header -->
            <div id="header">
                <div class="container">
                    <div class="pull-left">
                        <!-- Logo -->
                        <div class="header-logo">
                            <a class="logo" href="http://localhost:8080/EShop">
                                <img src="http://localhost:8080/EShop/img/logoEshop.png" alt="">
                            </a>
                        </div>
                        <!-- /Logo -->

                        <!-- Search -->
                        <div class="header-search">
                            <spring:form action="http://localhost:8080/EShop/search" modelAttribute="p" >
                                <spring:input class="input search-input" type="text" id="input" path="name" autocomplete="off"   placeholder="Nhập Tên,Danh Mục hoặc Thương Hiệu của sản phẩm "/>

                                <button class="search-btn" style="background: #f8694a;color: white;width: 50px;"><i class="fa fa-search" style="font-size: 25px;"></i></button>
                                </spring:form>
                        </div>
                        <!-- /Search -->
                    </div>
                    <div class="pull-right">
                        <ul class="header-btns">
                            <!-- Account -->

                            <li class="header-account dropdown default-dropdown" style="margin-right: 50px;">
                                <div class="header-btns-icon">
                                    <i class="fa fa-user-o"></i>
                                </div>

                                <c:if test="${not empty name}">

                                    <strong class="dropdown-toggle text-uppercase" data-toggle="dropdown" aria-expanded="true" style="margin-left:60px; ">${name}</strong>
                                </c:if>
                                <c:if test="${ empty name}">
                                    <button type="button" id="login" style="background: #f8694a;border: none"  class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenterlg">ĐĂNG NHẬP</button>  /  <button style="background: #f8694a;border: none" type="button" class="btn btn-primary text-uppercase" data-toggle="modal"  data-target="#exampleModalCenter" data-whatever="@mdo">Đăng Ký</button>  
                                </c:if>
                                <ul class="custom-menu">
                                    <li><a href="/EShop/myAcount?id=${makh}"><i class="fa fa-user-o"></i> Tài Khoản Của Tôi</a></li>
                                    <li><a href="/EShop/gioHang"><i class="fa fa-shopping-cart"></i> Giỏ Hàng</a></li>

                                    <li><a href="/EShop/DangXuat"><i class="fa fa-unlock-alt"></i> Đăng Xuất</a></li>

                                </ul>
                            </li>
                            <!-- /Account -->

                            <!-- Cart -->

                            <li class="header-cart dropdown default-dropdown" id="giohang" style="width: 200px;">
                                <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                    <div class="header-btns-icon">
                                        <i class="fa fa-shopping-cart"></i>
                                        <span class="qty">${soluong}</span>
                                    </div>
                                    <strong class="text-uppercase">Giỏ Hàng</strong>
                                    <br>
                                    <span style="color: #f8694a">${money}</span>
                                </a>
                                <div class="custom-menu">
                                    <div id="shopping-cart">
                                        <div class="shopping-cart-list">
                                            <c:forEach var="item" items="${cart}">
                                                <div class="product product-widget">
                                                    <div class="product-thumb">
                                                        <img src="/EShop/img/${item.image}" alt="">
                                                    </div>
                                                    <div class="product-body">
                                                        <h3 class="product-price"><span style="color: #f8694a">${item.newPrice}</span>  <span class="qty">x${item.soLuong}</span></h3>
                                                        <h2 class="product-name" style="font-size: 12px;"><a href="http://localhost:8080/EShop/ChiTietProduct?id=${item.maSP}">${item.name}</a></h2>
                                                    </div>
                                                    <a href="/EShop/deleteCart?id=${item.maSP}"> <button class="cancel-btn" onclick=""><i class="fa fa-trash"></i></button></a>
                                                </div>

                                            </c:forEach>
                                        </div>
                                        <c:if test="${not empty cart}">
                                            <div class="shopping-cart-btns">
                                                <a href="/EShop/gioHang"> <button class="main-btn">Chi Tiết</button></a>
                                                <a href="/EShop/ThanhToan">  <button class="primary-btn">Thanh Toán Ngay<i class="fa fa-arrow-circle-right"></i></button></a>
                                            </div></c:if>
                                        </div>
                                    </div>
                                </li>
                                <!-- /Cart -->

                                <!-- Mobile nav toggle-->
                                <li class="nav-toggle">
                                    <button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
                                </li>
                                <!-- / Mobile nav toggle -->
                            </ul>
                        </div>
                    </div>
                    <!-- header -->
                </div>
                <!-- container -->
            </header>



        <%@include file="register.jsp" %>
        <%@include file="Login.jsp" %>

        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script>
                    $(document).ready(function () {
                    function deleteGioHang() {
                    var masp = $(".maspgh").val();
                            $.get("/EShop/deleteCart?id=" + masp, function (data) {

                            });
                            $("#giohang").html("<p>ok</p>");
                    }
                    );
                            function listCart() {

                            $.get("/EShop/list?id="${masp}, function (data) {


                            }
                            );
                            }



                    });</script>


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
    </body>
</html>
