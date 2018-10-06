<%-- 
    Document   : view_inv
    Created on : Oct 22, 2016, 2:54:53 PM
    Author     : ZEE
--%>

<%@page import="DB.InvoiceReg"%>
<%@page import="DB.Invoice"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
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

        <script>
            function print123() {
              
                window.print();
            }
        </script>
    </head>
    <body>



        <%@include file="include/header.jsp" %>

        <%
            double tot = 0.00;
            if (us != null) {

                Session hbs = Connection.conn.getSessionFactory().openSession();

                List<InvoiceReg> ireg;

                try {
                    int invid = Integer.parseInt(request.getParameter("invid"));
                    Invoice i = (Invoice) hbs.createCriteria(Invoice.class).add(Restrictions.eq("idinvoice", invid)).uniqueResult();
                    ireg = hbs.createCriteria(InvoiceReg.class).add(Restrictions.eq("invoice", i)).list();
                    User us2 = (User) hbs.load(User.class, i.getUser().getIduser());
                    Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", us2)).uniqueResult();
        %>


        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">

                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="uprofile.jsp">Dashboard</a>
                            </li>
                            <li class="active"><a href="Tasks.jsp" >Tasks</a></li>
                            <li class="active">Invoice View</li>
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
                                <h3 class="panel-title"><i class="fa fa-shopping-basket fa-0"></i>    Invoice View  (Invoice ID:<%=invid%>)</h3>
                            </div>
                            <div class="panel-body">
                                <div class="flot-chart">
                                    <table width="95%" class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th width="17%">Iteam No</th>
                                                <th width="14%">Iteam</th>
                                                <th width="9%">Qty</th>
                                                <th width="19%">Amount (USD)</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <%                                                if (ireg.size() > 0) {
                                                    for (InvoiceReg cr : ireg) {
                                                        tot += cr.getQty() * cr.getProduct().getSellingPrice();
                                            %>     
                                            <tr>
                                                <td><%=cr.getProduct().getIdproduct()%></td>
                                                <td> <%=cr.getProduct().getProduct()%></td>
                                                <td><%=cr.getQty()%></td>
                                                <td>RS:<%= df.format(cr.getQty() * cr.getProduct().getSellingPrice())%></td>
                                            </tr>

                                            <%
                                                    }
                                                } else {
                                                    response.sendRedirect("Tasks.jsp");
                                                }

                                            %>


                                        </tbody>
                                    </table>

                                    <div class="col-lg-12">
                                        <div class="col-lg-4">

                                            <div class="panel panel-success">
                                                <div class="panel-heading"><span class=" glyphicon glyphicon-heart">  Coustomer Details   </span>    </div>
                                                <div class="panel-body"></div>
                                                <ul>
                                                    <%//                                                        ad
//                                                    Adress adz=(Adress)ss.createCriteria(Adress.class).add(Restrictions.eq("", us2)).uniqueResult();
%>
                                                    <li>Name: <%= i.getUser().getFname() + " " + i.getUser().getFname()%></li>
                                                    <li>Adress:<%= ad.getLine1() + "," + ad.getLine2() + "," + ad.getLine3() + "," + ad.getDistric().getDistric()%> </li>
                                                    <li>Con no:<%= i.getUser().getTelnumber()%> </li>


                                                </ul> 




                                            </div>
                                        </div>
                                        <div class="col-lg-4 ">
                                            <div class="panel panel-success">
                                                <div class="panel-heading"><span class=" glyphicon glyphicon-bishop">  Take Actions   </span>    </div>
                                                <div class="panel-body">

                                                    <p>

                                                    </p>

                                                    <form action="TakeAction">
                                                        <input type="hidden" name="invid" value="<%=i.getIdinvoice()%>">
                                                        <input type="hidden" name="url" value="<%=url%>">

                                                        <%
                                                            if (i.getActiveState().getStateType().equals("Purchased") && (us.getUserType().getUserType().equals("admin") || (us.getUserType().getUserType().equals("caller")))) {
                                                        %>
                                                        <span><button class="btn btn-warning btn-block " > Call Confirmed</button></span>  
                                                        <%
                                                        } else if (i.getActiveState().getStateType().equals("Phone Call Confirmed") && (us.getUserType().getUserType().equals("admin") || (us.getUserType().getUserType().equals("deliveryManager")))) {
                                                        %>                                                  
                                                        <span> <button class="btn btn-block btn-info" > Dispatched for deliver</button></span>
                                                        <%
                                                        } else if (i.getActiveState().getStateType().equals("Dispatch For Dliver") && (us.getUserType().getUserType().equals("admin") || (us.getUserType().getUserType().equals("diliveryGuy")))) {
                                                        %>

                                                        <span> <button class="btn btn-success btn-block " > Delivered</button></span>

                                                        <%
                                                        } else if (i.getActiveState().getStateType().equals("Dilivered") && us.getUserType().getUserType().equals("user")) {
                                                        %>
                                                        <span><i>This Product is successfully Delivered</i></span>
                                                        <span>
                                                            
                                                            <a class="btn btn-danger btn-block " data-toggle="modal" data-target="#report" > Report</a></span>
                                                        <%  } else {%>
                                                        <span><i>Status : <%=i.getActiveState().getStateType()%></i></span><br/>



                                                        <%
                                                            }
                                                            if (!i.getActiveState().getStateType().equals("Deleted")) {
                                                        %>
                                                    </form>


                                                    <form action="invoice_delete" >
                                                        <input type="hidden" name="url" value="<%=url%>">
                                                        <input type="hidden" name="invid" value="<%=i.getIdinvoice()%>">
                                                        <%
                                                            if (((us.getUserType().getUserType().equals("admin") ||us.getUserType().getUserType().equals("superAdmin"))&& !i.getActiveState().getStateType().equals("Dilivered")) || (us.getUserType().getUserType().equals("caller") && i.getActiveState().getStateType().equals("Purchased"))) {
                                                        %> <br/>
                                                        <span> <button class="btn btn-danger btn-block " > Delete</button></span>
                                                        <%   }

                                                        %>

                                                    </form>

                                                    <%    }
                                                    %>



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

                                                <tr><td></td><td>
                                                        <button onclick="print123()" >Print</button>
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



            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->


        <!-- /#wrapper -->


        <!--report problem-->

        <div id="report" class="modal fade" role="dialog">
            <div class="modal-dialog modal-lg">
                <form action="report">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Report </h4>

                        </div>
                        <div class="modal-body">
                            <p> Products <select name="product">
                                        <%    for (InvoiceReg cr : ireg) {          %>
                                        <option ><%=cr.getProduct().getProduct()%></option>
                                           <%
                                           }
                                           %>   
                                </select></p>
                            <p>Reason</p>
                            <p><input class="form-control  " type="text" name="reason"></p>
                            <p>Description</p>
                            <p><textarea class="form-control  "  name="Description"></textarea></p>
                        </div>
                        <input type="hidden" value="<%=invid%>" name="invid" />

                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" >Report</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                        </div>
                    </div>
                </form>
            </div>
                         <%@include file="include/fotter.jsp" %>
        </div>


        <%
                } catch (Exception ex) {
                    out.write(ex + "");
//                response.sendRedirect("home.jsp");
                }

            }
        %>
        <!-- jQuery -->
        <script src="js/jquery.js"></script>
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script> 


    </body>
</html>
