<%-- 
    Document   : register
    Created on : Sep 23, 2019, 4:00:36 PM
    Author     : Toan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script>
            function check() {
                var name = document.forms["myForm"]["name"].value;
                var sdt = document.forms["myForm"]["phone"].value;
                var email = document.forms["myForm"]["email"].value;
                var password = document.forms["myForm"]["password"].value;
                var address = document.forms["myForm"]["address"].value;

                if (name == "" || sdt == "" || email == "" || password == "" || address == "" ) {
                    Swal.fire({
                        type: 'error',
                        title: 'Thông Tin Không được để trống',
                        timer: 3000

                    })
                    return false;
                }
            }
        </script>
    </head>
    <body>

        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" style="margin-top: 150px; ">
                    <div class="modal-header">
                        <center>   <h5 class="modal-title" id="exampleModalLongTitle" style="color: #f8694a">Đăng Ký</h5></center>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="http://localhost:8080/EShop/register"  onsubmit="return check()" name="myForm">
                            <div class="form-group row">

                                <div class="col-sm-3" >Họ tên  </div>
                                <div class="col-sm-9" > <input type="text" name="name"   class="form-control" id="formGroupExampleInput" placeholder="Nhập họ tên"/></div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3 float-left">SĐT  </div>
                                <div class="col-sm-9" > <input type="text"  name="phone" class="form-control" id="formGroupExampleInput" placeholder="Nhập số điện thoại"/></div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3" >Email  </div>
                                <div class="col-sm-9" > <input type="email" name="email"  class="form-control" id="formGroupExampleInput" placeholder="Nhập email"/></div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3" >Mật khẩu  </div>
                                <div class="col-sm-9" > <input type="password"  name="password" class="form-control" id="formGroupExampleInput" placeholder="Nhập mật khẩu"/></div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3 float-left"> Địa Chỉ </div>
                                <div class="col-sm-9" > <input type="text"  name="address" class="form-control" id="formGroupExampleInput" placeholder="Nhập Địa chỉ"/></div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3" >Giới tính  </div>
                                <div class="form-check " >
                                    <input class="form-check-input"  type="radio"  name="sexx" id="exampleRadios1" value="Nam" checked="" ><span style="margin-left: 20px;">Nam</span>
                                </div>
                                <div class="form-check " style="margin-left: 100px;">
                                    <input class="form-check-input" type="radio"  name="sexx" id="exampleRadios2" value="Nữ" ><span style="margin-left: 20px;">Nữ</span>
                                </div> 
                            </div>


                            <center><button type="submit" style="width: 50%;margin-top: 30px;padding: 10px 10px;background: #f8694a;border: none" class="btn btn-primary btn-sm">Đăng ký</button></center>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
