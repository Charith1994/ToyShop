<%-- 
    Document   : uprofile
    Created on : Mar 24, 2016, 2:36:39 PM
    Author     : ZEE
--%>

<%@page import="DB.ActiveState"%>
<%@page import="DB.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> JSP Page</title>
        <!-- Bootstrap Core CSS -->



        <script src="js/bootstrap.min.js"></script>
        <script type=text/javascript>

            function my_navBar(a) {
                $.post(a, "", function (data) {

                    $("#probody").html(data);
                });


            }

            function load_add_new() {
                $('#probody').load('Add_new_toy.jsp');

            }
            
            function load_report_view() {
                $('#probody').load('report_view.jsp');
url='report_view.jsp';
            }

            function load_dash() {
                $('#probody').load('dash_board.jsp');

            }
            function load_cart() {
                $('#probody').load('My_cart.jsp');

            }
            
            function load_details() {
                $('#probody').load('user_detail.jsp');

            }


            function add(a) {
                alert("sdasa");
                var b = $('#pn').val();
                var c = $('#pw').val();
                alert(a);
                alert(b);
                $('#probody').load('Add_new_batch.jsp?id=' + a + '&product=' + b + '&weight=' + c);



            }
            
            
          function loadwhenload(){
               
               url=${'url'};
               alert(url);
               $('#probody').load(url);
                
            }
        </script>




        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="fonts/font-awesome.min.css" rel="stylesheet" >
        <link href="fonts/font-awesome.css" rel="stylesheet" >

        <link href="favicon.ico" />

    </head>
    <body onload="load_dash()()">

        <%@include file="include/header.jsp" %>

        <%        DB.User u = (DB.User) session.getAttribute("loging");

            if (u != null) {
             

        %>
        <div    id="page-wrapper">


            <div class="container-fluid">
                <div class="container">
                  
                    <div id="page-wrapper">
                        <div class="row">
                            <div class="col-lg-2" >
                                <a style="margin: 4px" class="form-control btn btn-primary" onclick="load_dash()"><span style="padding-right:10px " id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>My dashboard</a><br/>
                                <!--<a style="margin: 4px" class="form-control btn btn-primary" onclick="my_navBar('my_products')"><i style="padding-right: 10px" class=" fa fa-product-hunt" aria-hidden="true" ></i>My Products</a><br/>-->
                              <%
                              if(us!=null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("superAdmin"))){
                              %>
                                <a style="margin: 4px" class="form-control btn btn-primary" onclick="load_add_new()"><i style="padding-right: 10px"  class=" fa fa-adn" aria-hidden="true" ></i>Add new product</a><br/>
                                <a style="margin: 4px" class="form-control btn btn-primary"  href="profit.jsp"><i style="padding-right: 10px"  class=" fa fa-money" aria-hidden="true" ></i>My profit</a><br/>
                                <!--<a style="margin: 4px" class="form-control btn btn-primary"  href="user_manage.jsp"><i style="padding-right: 10px"  class=" fa fa-users" aria-hidden="true" ></i>Users Manage</a><br/>-->
                               
                               
                                <%
                                }
                                %>
                                
                                 <%
                              if(us!=null && (us.getUserType().getUserType().equals("user") )){
                              %>
                                <a style="margin: 4px" class="form-control btn btn-primary" onclick="load_cart()"><i style="padding-right: 10px"  class=" fa fa-adn" aria-hidden="true" ></i>My Cart</a><br/>
                                
                                 <%
                                }
                                %> 
                                <a style="margin: 4px" class="form-control btn btn-primary" onclick="load_details()"><i style="padding-right: 10px"  class=" fa fa-adn" aria-hidden="true" ></i>My Details</a><br/>


                            </div>


                            <% } else {
                                response.sendRedirect("home.jsp");

                            }%>


                            <div id="probody" class="col-lg-10" >



                            </div>
                        </div>
                    </div>
                </div>
            </div>
                
                             <%@include file="include/fotter.jsp" %>
        </div>



        <script src="js/jquery.js"></script>
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>





    </body>
</html>
