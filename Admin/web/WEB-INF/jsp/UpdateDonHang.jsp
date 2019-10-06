

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


                    <div class="row">

                        <div class="col-7">
                            <h3>Thông Tin Sản Phẩm</h3>
                            <c:forEach var="lsp" items="${lsp}">
                                <img src="/Admin/images/${lsp.image}">
                                <p style="margin-top: 10px;"> <span id="tt">
                                        Tên Sản Phẩm :
                                    </span>
                                    <span>
                                        ${lsp.name}
                                    </span>
                                </p >
                                <p > <span id="tt">
                                        Số Lượng :
                                    </span>
                                    <span>
                                        ${lsp.soluongDH}
                                    </span>
                                </p>
                                <p > <span id="tt">
                                        Giá :
                                    </span>
                                    <span>
                                        ${lsp.priceDH}
                                    </span>
                                </p >
                                <hr/>
                            </c:forEach>

                        </div>

                        <div class="col-5">
                            <h3>Thông Tin Khách hàng</h3>
                            <c:forEach var="lkh" items="${l}">
                                <p style="margin-top: 20px"><span id="tt">Họ Tên :</span>
                                    <span>${lkh.name}</span> 
                                </p>
                                <p><span id="tt">Email :</span>
                                    <span>${lkh.email}</span> 
                                </p>
                                <p><span id="tt">Số Điện Thoại:</span>
                                    <span>${lkh.phone}</span> 
                                </p>
                                <p><span id="tt">Tổng Số Sản Phẩm :</span>
                                    <span>${lkh.soluong}</span> 
                                </p>
                                <p><span id="tt">Tổng Tiền:</span>
                                    <span>${lkh.price}</span> 
                                </p >
                                <hr/>


                                <form method="post" action="/Admin/saveUpdateDonHang">

                                    <div class="form-group">
                                        <label for="exampleFormControlSelect1" style="font-weight: bold">Giao Hàng</label>
                                        <select class="form-control" id="exampleFormControlSelect1" name="giaoHang">

                                            <c:if test="${lkh.giaoHang == 'Chưa Giao'}">

                                                <option selected="">Chưa Giao</option>
                                            </c:if>
                                                <c:if test="${lkh.giaoHang != 'Chưa Giao'}">

                                                <option >Chưa Giao</option>
                                            </c:if>
                                                 <c:if test="${lkh.giaoHang != 'Đã Giao'}">
                                            <option >Đã Giao</option>
                                                 </c:if>
                                             <c:if test="${lkh.giaoHang == 'Đã Giao'}">
                                            <option selected="" >Đã Giao</option>
                                                 </c:if>
                                        </select>
                                    </div>
                                    <input type="hidden" name="makh" value="${lkh.maKH}" />
                                    <button type="submit" class="btn btn-primary" style="width: 100%">Cập Nhật </button>
                                </form>
                            </c:forEach>

                        </div>
                    </div>   
                    <div class="clearfix"></div>
                </div>

                </body>
                </html>
