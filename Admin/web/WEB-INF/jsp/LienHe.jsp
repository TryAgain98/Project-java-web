

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



    </head>

    <body>





        <div id="right-panel" class="right-panel">
            <%@include file="header.jsp" %>
            <div class="content" style="background: white;">
                <div class="animated fadeIn"><!-- content -->


                    <spring:form action="/Admin/saveLienHe" method="post"  modelAttribute="lh">




                        <div class="form-group">
                            <label for="exampleFormControlInput1" id="label">Tên Công Ty</label>
                            <spring:input type="text" path="name" value="${lh.name}" class="form-control"  id="exampleFormControlInput1" placeholder="Nhập Tên"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1" id="label">Email</label>
                            <spring:input type="text" path="email" value="${lh.email}" class="form-control"  id="exampleFormControlInput1" placeholder="Nhập Giá Hiện Tại"/>
                        </div>

                         <div class="form-group">
                            <label for="exampleFormControlInput1" id="label">Điện Thoại</label>
                            <spring:input type="text" path="phone" value="${lh.phone}" class="form-control"  id="exampleFormControlInput1" placeholder="Nhập Giá Hiện Tại"/>
                        </div>
                        

                        <div class="form-group">
                            <label for="exampleFormControlTextarea1" id="label">Địa Chỉ</label>
                            <textarea class="form-control" name="address"  id="exampleFormControlTextarea1"  rows="4"/>${lh.address}</textarea>
                        </div>

                         <div class="form-group">
                            <label for="exampleFormControlTextarea1" id="label">Thêm</label>
                            <textarea class="form-control" name="them" id="exampleFormControlTextarea1"  rows="4"/>${lh.them}</textarea>
                        </div>
                        <center> <button type="submit" class="btn btn-primary" style="width: 50%;">Cập Nhật</button></center>
                    </spring:form>



                </div>   
                <div class="clearfix"></div>
            </div>

    </body>
</html>
