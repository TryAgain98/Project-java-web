<%-- 
    Document   : footer
    Created on : Sep 19, 2019, 1:19:50 AM
    Author     : Toan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <footer id="footer" class="section section-grey" style="font-family: Arial;color: #000;">
            <!-- container -->
            <div class="container">
                <center>
                    <h4>${lh.name}</h4>
                    <h4>Email :${lh.email}</h4>
                    <h4>Phone :${lh.phone}</h4>
                    <h4>Address :${lh.address}</h4>
                    <h4>${lh.them}</h4>
                </center>
            </div>
        </footer>
    </body>
</html>
