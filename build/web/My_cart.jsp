<%-- 
    Document   : My_cart
    Created on : Oct 5, 2016, 5:03:44 PM
    Author     : ZEE
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="products_management.cartOp"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="cls.cart"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="fonts/font-awesome.min.css" rel="stylesheet" >
        <link href="fonts/font-awesome.css" rel="stylesheet" >
        <script src="js/jquery.js"></script>

        <script src="myjs/forcart.js" type="text/javascript"></script>
        
    </head>



    <body>
        <%@include file="include/header.jsp" %>
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
           
                <div class="row">
                    <div class="col-lg-12">

                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-home"></i>  <a href="dash_board.jsp">Dash Board</a>
                            </li>
                            <li class="active"><span class="panel-title"><i class="fa fa-shopping-cart"></i> My Cart</span></li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <!-- Flot Charts -->
                <div class="row"></div>
                <!-- /.row -->
                <%
                    if (cop != null) {

                        items = cop.getArrayData().size();
                        sescart_exsist = true;
                    }

                %>
                      
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-warning">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-shopping-cart"></i>
                                    My Cart</h3>
                            </div>
                            <div class="panel-body">
                                <div class="flot-chart">
                                    <div class="diver" id="div_sd">
                                        <table class="table table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Image</th>
                                                    <th>Item Id</th>
                                                    <th>Item Name</th>
                                                    
                                                    <th style="width: 200px; ">Quantity</th>
                                                    <th>Unit Price </th>
                                                    <th>Total Value</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                          
                                            <%                                               if (sescart_exsist) {
                                                    List<cart> n = cop.getArrayData();

                                                    ss = Connection.conn.getSessionFactory().openSession();
                                                    for (int cart_id = 0; cart_id < n.size(); cart_id++) {
                                                        cart ni = n.get(cart_id);
                                                        //        }
                                                        //        for (cart ni : n) {
                                                        Criteria cc = ss.createCriteria(DB.Product.class);
                                                        cc.add(Restrictions.eq("idproduct", ni.getId()));
                                                        DB.Product lg = (DB.Product) cc.uniqueResult();
                                                        int rr=lg.getQty();

                                            %>

                                            <!--ses cart-->        
                                            <tr >
                                                <td><img src="<%=lg.getImage()%>" width="120" height="60"></td>
                                                <td><span><input type="hidden" value="<%= lg.getIdproduct()%>" class="prodid"><%= lg.getIdproduct()%></span></td>
                                              <td ><%= lg.getProduct()%></td>
                                              
                                                <td ><%=ni.getQty()%><input type="number" min="1"   style="width: 40px ;"  value="1" id="qtychng" class="Qty" ><button  style="padding: 4px "  class=" ed glyphicon glyphicon-edit" type="button"></button></td>
                                                <td >   RS:<%= df.format(lg.getSellingPrice())%> </td>
                                                <td id="totl"><span class="val">RS:<%=df.format(ni.getQty() * lg.getSellingPrice())%></span></td>
                                                <td>
                                                    <form action="invoice.jsp">
                                                        <input type="hidden" value="<%=ni.getId()%>" name="pid"/>   

                                                        <button class="btn btn-primary glyphicon glyphicon-shopping-cart"> Purchase</button>


                                                    </form>
                                                    <form action="delete_from_cart">
                                                        <input type="hidden" value="<%=ni.getId()%>" name="pid"/>
                                                        <input type="hidden" value="<%=url%>" name="url"/>
                                                        <button class="btn btn-danger glyphicon glyphicon-remove" style="padding-right: 18px"> Remove</button>
                                                    </form>
                                                </td>
                                            </tr>

                                            <% }
                                            } else if (dbcart_exsist) {
                                                for (CartReg ni : n2) {


                                            %>

                                            <tr>
                                                <td><img src="<%=ni.getProduct().getImage()%>" width="120" height="60"></td>
                                                <td><input type="hidden" value="<%=ni.getProduct().getIdproduct()%>" class="prodid"><%=ni.getProduct().getIdproduct()%></td>
                                                <td><%=ni.getProduct().getProduct()%></td>
                                                <td><span id="qty" ><%=ni.getQty()%></span><input min="1"  style="width: 40px;" type="number" value="1" class="Qty" ><button  style="padding: 4px"  class=" ed glyphicon glyphicon-edit" type="button"></button></td>
                                                
                                                <td>RS:<%= df.format(ni.getProduct().getSellingPrice())%></td>
                                                <td id="totl">RS:<%=df.format(Integer.parseInt(ni.getQty()) * ni.getProduct().getSellingPrice())%></td>
                                                <td>
                                                    <form action="invoice.jsp" method="POST">
                                                        <input type="hidden" value="<%=ni.getIdcartReg()%>" name="cart_reg_id"/>   

                                                        <button class="btn btn-primary glyphicon glyphicon-shopping-cart"> Purchase</button>


                                                    </form>

                                                    <form action="delete_from_dbcart" method="POST">
                                                        <input type="hidden" value="<%=ni.getIdcartReg()%>" name="cart_reg_id"/>
                                                        <input type="hidden" value="<%=url%>" name="url"/>
                                                        <button class="btn btn-danger glyphicon glyphicon-remove" style="padding-right: 18px"> Remove</button>
                                                    </form>
                                                </td>
                                            </tr>






                                            <%
                                                    }
                                                }
                                            %>
                                            </tbody>
                                        </table>
                                        <span class="btn btn-primary" onclick="location.href = 'Products_SERCH_2.jsp';">Go Back To Shopping</span>
                                        <span class="btn btn-success" onclick="location.href = 'invoice.jsp';">Pay For All Iteam</span><br/>

                                        <label> *If yo going to pay all items at once, Dilivery cost may charge only at one time.</label>                                     
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->


                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->
 <%@include file="include/fotter.jsp" %>
        </div>
        <!-- /#page-wrapper -->


        <!-- /#wrapper -->

        <!-- jQuery -->

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>



    </body>
</html>
