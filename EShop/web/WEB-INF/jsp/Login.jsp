<%-- 
    Document   : Login
    Created on : Sep 23, 2019, 4:00:13 PM
    Author     : Toan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

        <title>JSP Page</title>
    </head>
    <body>
        <div  class="modal fade" id="exampleModalCenterlg" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title"  id="exampleModalLongTitle" style="color: #f8694a">Đăng Nhập</h5>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body" >
                        <spring:form action="http://localhost:8080/EShop/login" modelAttribute="c" name="myForm">
                            <div class="form-group row">
                                <div class="col-sm-3" >Email  </div>
                                <div class="col-sm-9" > <spring:input type="email" path="email" class="form-control" id="formGroupExampleInput" placeholder="Nhập email"/></div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3" >Mật khẩu  </div>
                                <div class="col-sm-9" > <spring:input type="password" path="password"  class="form-control" id="formGroupExampleInput" placeholder="Nhập mật khẩu"/></div>
                            </div>
                            <center><button type="submit" id="submit" style="width: 50%;margin-top: 30px;padding: 10px 10px;background: #f8694a;border: none" class="btn btn-primary btn-sm">Đăng Nhập</button></center>
                            </spring:form>

                    </div>

                </div>
            </div>
        </div>



    </body>
</html>
