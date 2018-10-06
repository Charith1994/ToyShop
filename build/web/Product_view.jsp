<%-- 
    Document   : Product_view
    Created on : Oct 20, 2016, 3:06:56 PM
    Author     : ZEE
--%>

<%@page import="org.hibernate.criterion.Projections"%>
<%@page import="DB.Product"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="fonts/font-awesome.min.css" rel="stylesheet" >
        <link href="fonts/font-awesome.css" rel="stylesheet" >
        <style type="text/css">
            .sideimages{
                width: 75px;
                height: 75px;

            }


            .imagelist{
                padding-bottom: 20px;
            }
        </style>


        <script>

            function back() {

                window.history.back();
            }

            function setqty0(pid) {
                $.post("setQty0", {pid: pid}, function (data) {
                    document.getElementById("qty").innerHTML = 0;


                });
            }

            function deact(pid) {


                $.post("deactive_product", {pid: pid}, function (data) {

                    location.reload();

                });

            }
        </script>
    </head>
    <body>

        <%@include file="include/header.jsp" %>  


        <%
            Product p = null;
            try {
                String pid = request.getParameter("pid");
                p = (Product) Connection.conn.getSessionFactory().openSession().load(Product.class, Integer.parseInt(pid));


        %>

        <div    id="page-wrapper">


            <div class="container-fluid">
                <a class="btn" href="Products_SERCH_2.jsp?catid=0&serchtxt=">Back to search</a>
                <div class="row">


                    <div class="col-md-6">
                        <div class='row'>
                            <div class="col-md-4"></div>
                            <div class="col-md-8">

                                <div class="row ">
                                    <div class="largeImage">


                                        <div style="border:1px solid #cccccc; margin-bottom: 2px;">
                                            <img  id="zoom_01" src="<%=p.getImage()%>" data-zoom-image="" class="sideimagesLage"  width='400' height='300' alt='Daisy on the Ohoopee'>

                                        </div>
                                    </div>
                                    <div  id="gal" > 
 <%
                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("superAdmin"))) {
                                        %>
                                        <!--<span><a class="btn btn-sm btn-default glyphicon glyphicon-edit" data-toggle="modal" data-target="#imageModal">Edit image</a></span>-->

                                        <%    }

                                        %>
<!--                                        <a style="border:1px solid #cccccc;" data-image="" data-zoom-image="" ><img id="zoom_01" class="sideimages" src="img/PileOfToys_2014_03_24__12h38.jpg" alt="..."></a> 
                                        <a style="border:1px solid black;" data-image="" data-zoom-image="" ><img id="zoom_01" class="sideimages" src="img/PileOfToys_2014_03_24__12h38.jpg" alt="..."></a> -->

                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>
                    <form  method="GET" action="sescart" >    


                        <div class="col-md-6">
                            <div class="row">
                                <h2><%=p.getProduct()%></h2>
                                <div class="col-md-6">


                                    <div  class="form-group">
                                        <span style="font-size: larger">Category :</span>
                                        <span><%=p.getCategory().getName()%></span>
                                    </div> 





                                    <div class="form-group">
                                        <span class="label label-primary" style="font-size: larger ">Rs: <%=df.format(p.getSellingPrice())%></span>
                                        <input id="price" type="hidden" value="">


                                        <%
                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("admin"))) {
                                        %>
                                        <span><a class="btn btn-sm btn-default glyphicon glyphicon-edit " data-toggle="modal" data-target="#PriceModal"></a></span>
                                        <br>
                                        <span><label>Buying price: rs:<%=p.getBuyingPrice() %></label>
                                        <a class="btn btn-sm btn-default glyphicon glyphicon-edit " data-toggle="modal" data-target="#BPriceModal"></a></span>
                                        <%    }

                                        %>
                                    </div>


                                </div>
                                <div class="col-md-6"> </div>


                            </div>
                            <div class="row">
                                <div  class="col-md-12">



                                    <div class="form-group">

                                        <span style="font-size: large"> Delivery:</span>
                                        <%                                            if (us != null) {
                                                Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", us)).uniqueResult();

                                                if (ad != null) {
                                        %>
                                        <span class="">RS: <%=df.format(ad.getDistric().getDiliveryCost())%></span>
                                        <%}
                                        } else {
                                        %>
                                        <a id="DC" href="register_3.jsp?url=<%=url%>">Delivery cost added per District</a>
                                        <% } %>
                                    </div>


                                </div>



                            </div>

                            <div class="row ">
                                <div class="col-md-6">


                                </div>

                                <div class="col-md-4"></div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">

                                    <div  class="form-group">
                                        <span style="font-size: larger">Quentity:</span>
                                        <%
                                            if (us == null || us.getUserType().getUserType().equals("user")) {
                                                if (p.getQty() > 0) {
                                        %>

                                        <select id="qtySelector" style="min-width: 20%" name="qty" >


                                            <%
                                                for (int i = 1; i <= 10 && i <= p.getQty(); i++) {
                                            %>
                                            <option><%=i%></option>

                                            <%
                                                }
                                            %>
                                        </select>

                                        <%
                                        } else {
                                        %>

                                        Stock Currently unavailable
                                        <%
                                            }
                                        } else {
                                        %>


                                        <span id="qty"><%=p.getQty()%></span>

                                        <% }%>

                                    </div>

                                    <div  class="form-group">
                                        <span style="font-size: larger">Description :</span>
                                        <span><%=p.getDiscription()%></span>

                                        <%
                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("admin"))) {
                                        %>
                                        <span><a class="btn btn-sm btn-default glyphicon glyphicon-edit" data-toggle="modal" data-target="#DescriptionModal"></a></span>

                                        <%    }

                                        %>
                                    </div>

                                    <div  class="form-group">
                                        <span style="font-size: larger">Pakege Weight :</span>
                                        <span><%= p.getPaketWeight()%>kg</span>

                                        <%
                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("admin"))) {
                                        %>
                                        <span><a class="btn btn-sm btn-default glyphicon glyphicon-edit" data-toggle="modal" data-target="#weight"></a></span>

                                        <%    }

                                        %>
                                    </div>

                                    <div  class="form-group">
                                        <span style="font-size: larger">Warrenty :</span>
                                        <span><%=p.getWarenty()%> day(s) *</span>

                                        <%
                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("admin"))) {
                                        %>
                                        <span><a class="btn btn-sm btn-default glyphicon glyphicon-edit" data-toggle="modal" data-target="#warrent"></a></span>

                                        <%    }

                                        %>

                                    </div>
                                    <div  class="form-group">



                                        <%                                
                                            Criteria cri = ss.createCriteria(DB.InvoiceReg.class);
                                            cri.add(Restrictions.eq("product", p));
                                            cri.setProjection(Projections.sum("qty"));
                                            Object obj = cri.uniqueResult();

                                            long sum = 0;

                                            if (obj != null) {
                                                sum = (Long) obj;
                                            }
                                        %>
                                        <span><%=sum%></span>
                                        <span >Sold</span>
                                        <%

                                        %>

                                    </div>

                                </div>   
                                <div class="col-md-6"></div>   
                            </div>
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <input  type="hidden" value="<%=p.getIdproduct()%>" name="id">
                                        <input  type="hidden" value="<%=url%>" name="url">

                                        <%     if (us == null || us.getUserType().getUserType().equals("user")) {

                                        %>
                                        <button id="addToCart" class="button btn-primary btn-lg " onclick="sescart()"><span class="glyphicon glyphicon-shopping-cart"> </span><span>  Add to Cart</span></button>
                                        <%} else if (us != null && us.getUserType().getUserType().equals("admin")) {
                                        %>
                                        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Add new stock</button>
                                        <button type="button" class="btn btn-warning btn-lg" onclick="setqty0(<%=pid%>)" >Set Qty 0</button>

                                        <%
                                            if (p.getActiveState().getIdactiveState() == 1) {
                                        %>
                                        <button type="button" class="btn btn-danger btn-lg" onclick="deact(<%=pid%>)">Deactive</button>

                                        <%
                                        } else if (p.getActiveState().getIdactiveState() == 2) {
                                        %>

                                        <button type="button" class="btn btn-success btn-lg" onclick="deact(<%=pid%>)">Active</button>
                                        <%
                                                }
                                            }

                                        %>
                                        <%
                                        %> 
                                    </div>
                                    *Conditions : Warrenty must claim within below days after Dilivery. we accept only issues cased by Dilivery or company Failiers. You have to carry it to ower any show room by your own for replacement.
                                </div>


                            </div> 
                            <br>


                        </div>
                    </form>



                    <!--modal for edit-->         
                    <%@include file="include/modal.jsp" %>  


                </div>
                <br>
                <br>
            </div>
        </div>


                    
           <!--image-->
<form action="#">
<div id="imageModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-sm">
        
             Modal content
             
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Image</h4>
                </div>
                <div class="modal-body">
                    <p>Select here new image you wants to add</p>
                    <p><input class="form-control  " type="file" name="newimg"></p>
                </div>
                <p><input type="hidden" name="pid" value="<%=p.getIdproduct()%>">

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
            </div>
        
    </div>
</div>         
                    
</form>              
                    
                    
                    
                    
                    
                    
                    
                    
                    
        <script src="js/jquery.js"></script>
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script> 

        <%            } catch (NumberFormatException ex) {
                RequestDispatcher rd = request.getRequestDispatcher("Products_SERCH_2.jsp");
                rd.forward(request, response);
            } catch (NullPointerException ex) {
                out.write(ex + "");
                RequestDispatcher rd = request.getRequestDispatcher("Products_SERCH_2.jsp");
                rd.forward(request, response);
            }

        %>
    </body>








</html>
