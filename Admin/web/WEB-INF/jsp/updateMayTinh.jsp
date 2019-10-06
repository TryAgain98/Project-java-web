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
        <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
        <style>

            #label{
                font-weight: bold;
            }
        </style>
    </head>

    <body>
        <div id="right-panel" class="right-panel">
            <%@include file="header.jsp" %>
            <div class="content" style="background: white;">
                <div class="animated fadeIn"><!-- content -->


                    <h3> Cập Nhật Sản Phẩm Máy Tính</h3>
                    <hr>
                    <spring:form action="/Admin/saveUpdateMayTinh" method="post"  modelAttribute="p" >


                        <c:forEach var="item" items="${lsp}" >
                            <spring:input type="hidden" path="maSP"  class="form-control" value="${item.maSP}" id="exampleFormControlInput1" placeholder="Nhập Tên"/>

                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Tên</label>
                                <spring:input type="text" path="name"  class="form-control" value="${item.name}" id="exampleFormControlInput1" placeholder="Nhập Tên"/>
                            </div>
                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Giá Hiện Tại</label>
                                <spring:input type="text" path="newPrice" class="form-control" value="${item.newPrice}" id="exampleFormControlInput1" placeholder="name@example.com"/>
                            </div>

                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Giá Cũ</label>
                                <spring:input type="text" path="oldPrice" class="form-control" value="${item.oldPrice}" id="exampleFormControlInput1" placeholder="name@example.com"/>
                            </div>
                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Thương Hiệu</label>
                                <spring:input type="text" path="thuongHieu" class="form-control" value="${item.thuongHieu}" id="exampleFormControlInput1" placeholder="name@example.com"/>
                            </div>
                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Số Lượng</label>
                                <spring:input type="text" path="soLuong" class="form-control" value="${item.soLuong}" id="exampleFormControlInput1" placeholder="name@example.com"/>
                            </div>

                            <div class="form-group">
                                <label for="exampleFormControlTextarea1" id="label">Ghi Chú</label>
                                <textarea class="form-control" name="ghiChu" id="exampleFormControlTextarea1"  rows="4"/>${item.ghiChu}</textarea>
                            </div>

                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Trạng Thái</label>
                                <spring:input type="text" class="form-control" path="trangThai" value="${item.trangThai}" id="exampleFormControlInput1" placeholder="name@example.com"/>
                            </div>


                            <div class="form-group">
                                <label for="exampleFormControlFile1" id="label">Ảnh</label>
                                <img src="/Admin/images/${item.image}" style="width: 50px;height: auto">
                                <input type="hidden" name="img"  class="form-control" value="${item.image}" id="exampleFormControlInput1" placeholder="Nhập Tên"/>

                                <spring:input type="file" path="image"   class="form-control-file" id="exampleFormControlFile1" />
                            </div>


                            <div class="form-group">
                                <label for="exampleFormControlSelect1">Danh Mục Sản Phẩm</label>
                                <select class="form-control" id="exampleFormControlSelect1" name="madm">
                                    <c:forEach var="ldm" items="${l}">
                                        <c:if test="${ldm.name == dmsp.name}">
                                            <option selected="selected" value="${ldm.maDM}" >${ldm.name}</option>
                                        </c:if>
                                        <c:if test="${ldm.name != dmsp.name}">
                                            <option value="${ldm.maDM}"  >${ldm.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>

                            <h4 id="label"> Chi Tiết Sản Phẩm</h4>
                        <hr>
                        
                        
                        <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Ram</label>
                                <input type="text" class="form-control" name="ram" value="${ctmt.ram}" id="exampleFormControlInput1" />
                            </div>
                            
                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Ổ cứng</label>
                                <input type="text" class="form-control" name="rom" value="${ctmt.rom}" id="exampleFormControlInput1" />
                            </div>
                            
                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">CPU</label>
                                <input type="text" class="form-control" name="cpu" value="${ctmt.cpu}" id="exampleFormControlInput1" />
                            </div>
                            
                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Hệ Điều Hành</label>
                                <input type="text" class="form-control" name="heDH" value="${ctmt.heDH}" id="exampleFormControlInput1" />
                            </div>
                            
                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Màn Hình</label>
                                <input type="text" class="form-control" name="manHinh" value="${ctmt.manHinh}" id="exampleFormControlInput1" />
                            </div>
                            
                            <div class="form-group">
                                <label for="exampleFormControlInput1" id="label">Card Đồ Họa</label>
                                <input type="text" class="form-control" name="cardDH" value="${ctmt.cardDH}" id="exampleFormControlInput1" />
                            </div>
                            
                           
                            
                        
                        
                        </c:forEach>
                        <center> <button type="submit" class="btn btn-primary" style="width: 50%;">Cập Nhật</button></center>
                        </spring:form>


                </div>
            </div>   
            <div class="clearfix"></div>
        </div>
    </body>
</html>
