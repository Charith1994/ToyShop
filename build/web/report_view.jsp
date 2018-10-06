<%-- 
    Document   : report_view
    Created on : Oct 5, 2016, 5:03:44 PM
    Author     : ZEE
--%>

<%@page import="org.hibernate.criterion.Projections"%>
<%@page import="org.hibernate.criterion.Order"%>
<%@page import="DB.Report"%>
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

        <script>
            $(function () {

                $(".reply").click(
                        function () {

                            var selectButn = $(this).parent().parent();
                            var reply2 = $(selectButn).find('#reply').val();
                            var id = $(selectButn).find('#inid').val();



                            $.post("report_reply", {id: id, reply: reply2}, function (data) {

                                alert(data);
                                location.reload();

                            });

                        });
            });
        </script>

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
                                <i class="fa fa-dashboard"></i>  <a href="uprofile.jsp">Dashboard</a>
                            </li>
                            <li class="active"><span class="panel-title"><i class="fa fa-warning"></i> Reported from customer</span></li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <!-- Flot Charts -->
                <div class="row"></div>
                <!-- /.row -->


                <%
                    Session hbs = Connection.conn.getSessionFactory().openSession();
                    Criteria cr = hbs.createCriteria(Report.class);
                    cr.addOrder(Order.asc("activeState"));

                   
boolean flag=false;
                      
                                    
                                      if (us.getUserType().getUserType().equals("admin")||us.getUserType().getUserType().equals("superAdmin")) {
                                          
                          flag=true;
                        } else if (us.getUserType().getUserType().equals("user")) {
                            cr.add(Restrictions.eq("user", us));
                            flag=false;
                        }
                           List<Report> rep = cr.list();           
                    
                    int noofpro_forPage = 7;
                    int page_id = 0;

                    int bck = page_id - 1;

                    int wadi_tika = rep.size() % noofpro_forPage;
                    int wadi_page_eka = 0;
                    if (wadi_tika > 0) {
                        wadi_page_eka = 1;

                    }

                    try {
                        page_id = Integer.parseInt(request.getParameter("page"));
                    } catch (Exception eee) {
                        // eee.printStackTrace();
                    }


                %>


                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-warning">
                            <!--                            <div class="panel-heading">
                                                            <h3 class="panel-title"><i class="fa fa-warning"></i>
                                                                Reported</h3>
                                                        </div>-->
                            <div class="panel-body">
                                <div class="flot-chart">
                                    <div class="diver" id="div_sd">

                                        <%                                             if (rep.size() > 0) {
                                        %>

                                        <table class="table table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Invoice Id</th>
                                                    <th>Customer Name</th>
                                                    <th>T.P no</th>
                                                    <th>Reason</th>
                                                    <th>Description</th>
                                                    <th>Action</th>

                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>                                                   
                                                    <%
                                                        for (int inv_list_id = noofpro_forPage * page_id; inv_list_id < (noofpro_forPage + (page_id * noofpro_forPage)); inv_list_id++) {
                                                            DB.Report i;
                                                            try {
                                                                i = rep.get(inv_list_id);
                                                            } catch (Exception eeee) {
                                                                //  eeee.printStackTrace();
                                                                break;
                                                            }
                                                    %>

                                                    <td><a href="view_inv.jsp?invid=<%=i.getInvoice().getIdinvoice()%>"><%=i.getInvoice().getIdinvoice()%></a></td>
                                                    <td><%=i.getInvoice().getUser().getFname() + " " + i.getInvoice().getUser().getLname()%></td>
                                                    <td><%=i.getInvoice().getUser().getTelnumber()%></td>
                                                    <td><%=i.getReason()%></td>
                                                    <td><%=i.getDescription()%></td>
                                                    <td>
                                                        <%
                                                        if(flag){
                                                        %>
                                                        <textarea id="reply"><%=i.getReply()%></textarea>
                                                    <%
                                                    }else{
                                                    %>
                                                    <%=i.getReply()%>
                                                    <%  } %>
                                                    </td>
                                                    <td>
                                                     <%   if(flag){         %>
                                                        
                                                        <input type="hidden" id="inid" value="<%=i.getIdReport()%>"><button class="btn btn-info reply "  > Take action</button>
                                                    
                                                        <% } else{
                                                        
                                                        %>
                                                        
                                                        <%
                                                        }
                                                        %>
                                                    </td>
                                                </tr>

                                                <%
                                                    }
                                                %>

                                            </tbody>
                                        </table>
                                        <%
                                        } else {
                                        %>
                                        <i>You have No Reports</i>

                                        <%
                                            }
                                        %>
                                        <!--<span class="btn btn-success" onclick="location.href ='Add_product.html';">Pay For All Iteam</span><br/>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="col-sm-12 row">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4">

                        <ul class="pagination">

                            <%                         for (int page_id_pg = 0; page_id_pg < (rep.size() / noofpro_forPage) + wadi_page_eka; page_id_pg++) {

                                    if (thispage == page_id_pg) {
                            %>
                            <li class="active">
                                <a  href="report_view.jsp?url=report_view.jsp&page=<%="" + page_id_pg%>">


                                    <%=(page_id_pg + 1) + ""%>
                                </a>   </li>



                            <%

                            } else {
                            %>
                            <li>
                                <a  href="report_view.jsp?url=report_view.jsp&page=<%="" + page_id_pg%>">


                                    <%=(page_id_pg + 1) + ""%>
                                </a>  </li>


                            <%
                                    }
                                }
                            %>
                        </ul>

                    </div>



                    <div class="col-sm-4"></div></div>
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
