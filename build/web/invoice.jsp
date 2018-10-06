<%-- 
    Document   : invoice
    Created on : Oct 8, 2016, 11:10:47 PM
    Author     : ZEE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        
        <script type="text/javascript">
            
            function payment(a){
               
        var p=a;
               document.getElementById("payment").value=p;
               
             
                
            }
            
            
             function print123(){
               
                window.print();
            }
        </script>
        
        
        
    </head>
    <body>
        <%@include file="include/header.jsp" %>
        <%
            try{
            double tot = 0.00;
            if (us != null) {
                System.out.print("ethule");
                Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", us)).uniqueResult();
                if (ad != null) {
                    String cregid = request.getParameter("cart_reg_id");
int creg2=0;
                    List<CartReg> creg;

                    if (cregid == null) {
                        creg = ss.createCriteria(CartReg.class).add(Restrictions.eq("user", us)).list();
                            creg2=0;
                    } else {
                        creg = ss.createCriteria(CartReg.class).add(Restrictions.eq("idcartReg", Integer.parseInt(cregid))).list();
                    creg2=Integer.parseInt(cregid);
                    }


        %>


        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Invoice</h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active"><a href="My_cart.jsp">Cart</a></li>
                            <li class="active">Invoice</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <!-- Flot Charts -->
                <div class="row"></div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-shopping-basket fa-0"></i>    Invoice </h3>
                            </div>
                            <div class="panel-body">
                                <div class="flot-chart">
                                    <table width="95%" class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th width="17%">Iteam No</th>
                                                <th width="14%">Iteam</th>
                                                <th width="9%">Qty</th>
                                                <th width="19%">Amount (Rs)</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <%  
                                                if(creg.size()>0){
                                                for (CartReg cr : creg) {
                                                    tot += Integer.parseInt(cr.getQty()) * cr.getProduct().getSellingPrice();
                                            %>     
                                            <tr>
                                                <td><%=cr.getProduct().getIdproduct()%></td>
                                                <td> <%=cr.getProduct().getProduct()%></td>
                                                <td><%=cr.getQty()%></td>
                                                <td>RS:<%= df.format(Integer.parseInt(cr.getQty()) * cr.getProduct().getSellingPrice())%></td>
                                            </tr>

                                            <%
                                                }}else{
response.sendRedirect("Products_SERCH.jsp");
}

                                            %>


                                        </tbody>
                                    </table>

                                    <div class="col-lg-12">
                                         <div class="col-lg-4">


                                        </div>
                                        <div class="col-lg-4 ">
                                            <div class="panel panel-danger">
                                                <div class="panel-heading"><span class=" glyphicon glyphicon-check">Select Payment Method Here   </span>    </div>
                                                <div class="panel-body">
                                                    
                                                    <p>
                                                        This Service accept cash on dilivery. Please select card payment if you wan't to pay by card when dilivered. All VISA and MASTER card are accepted.
                                                        
                                                    </p>
                                                    
                                                   
                                                    
                                                    <span ><input type="radio" name="pMethod" value="Cash" checked="checked" onclick="payment(1)"/>Pay with cash</span>
                                                    <span>   <input type="radio" name="pMethod" value="Card" onclick="payment(2)" />Pay with Card</span>
                                                    
                                                </div>
                                            </div>



                                            
                                        </div>
                                       
                                        <div class="col-lg-4">


                                            <table  width="208" border="1" cellpadding="2" class="table table-bordered table-hover table-striped">

                                                <tr >
                                                    <td >Cost for Items</td>
                                                    <td><form id="form2" name="form1" method="post" action="">
                                                            RS: <%=tot%>
                                                        </form></td>
                                                </tr>
                                                <tr >
                                                    <td>Delivery Cost</td>
                                                    <td><form id="form3" name="form1" method="post" action="">
                                                            RS: <%=df.format(ad.getDistric().getDiliveryCost())%>
                                                            <%
                                                                tot += ad.getDistric().getDiliveryCost();

                                                            %>
                                                        </form></td>
                                                </tr>
                                                <tr>
                                                    <th width="70%" scope="col">Total</th>
                                                    <th width="30%" scope="col"><form id="form1" name="form1" method="post" action="">
                                                            RS: <%=df.format(tot)%>
                                                        </form></th>
                                                </tr>








                                                <tr>
                                                    <td>&nbsp;</td>

                                                    <td>
                                                        <form action="Invoice_save" >
                                                            <input type="hidden" value="1" name="payment" id="payment"/>
                                                            <input type="hidden" value="<%=creg2%>" name="cart_reg_id"/> 
                                                            <button class="btn btn-primary" onclick="print123()"> Purchase</button>
                                                        </form>
                                                    </td>


                                                </tr>
                                                
                                               
                                            </table>
                                        </div>  
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row"></div>
                <!-- /.row -->

                <div class="row"></div>
                <!-- /.row -->

                <!-- Morris Charts -->
                <div class="row"></div>
                <!-- /.row -->

                <div class="row"></div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-4"></div>
                </div>
                <!-- /.row -->
 <%
                } else {
System.out.print("eliye2");
//                    response.sendRedirect("register_3.jsp?url=My_cart.jsp");
                }
            } else {
 System.out.print("eliye");
//                response.sendRedirect("login2.jsp");
RequestDispatcher rd=request.getRequestDispatcher("login2.jsp");  
        rd.forward(request, response);
            }}catch(Exception e){

e.printStackTrace();
}
        %>
            </div>
            <!-- /.container-fluid -->
<%@include file="include/fotter.jsp" %> 
        </div>
        <!-- /#page-wrapper -->


        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

       
    </body>
</html>
