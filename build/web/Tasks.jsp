<%-- 
    Document   : Tasks
    Created on : Oct 22, 2016, 9:45:02 AM
    Author     : ZEE
--%>

<%@page import="org.hibernate.criterion.Order"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="DB.ActiveState"%>
<%@page import="org.hibernate.Query"%>
<%@page import="DB.Invoice"%>
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


        <script type="text/javascript">
            function go(btn) {
                var param = btn.parentElement.parentElement.id;
                var size = param.find('.productSize').val();
                alert(size);
            }
        </script>


    </head>
    <body>
        <%@include file="include/header.jsp" %> 

        <%
            
            Session hbs = Connection.conn.getSessionFactory().openSession();
            ActiveState purchased = (ActiveState) hbs.load(ActiveState.class, 4);
            ActiveState confirmed = (ActiveState) hbs.load(ActiveState.class, 5);
            ActiveState dispatch = (ActiveState) hbs.load(ActiveState.class, 6);
            try {
                if (us != null) {
                    List<Invoice> inv = null;
 ActiveState status = new ActiveState();
                    if (us.getUserType().getUserType().equals("admin")||us.getUserType().getUserType().equals("superAdmin")) {
                        Criteria cr=ss.createCriteria(Invoice.class);
                        cr.addOrder(Order.asc("date"));
                        
                         String statusid = request.getParameter("status");
                        if (statusid != null) {
                            status = (ActiveState) ss.load(ActiveState.class, Integer.parseInt(statusid));
                             cr.add(Restrictions.eq("activeState", status));
                        }
                       
                        
                        
                        
                        
                      if(request.getParameter("invid")!=null){
                      cr.add(Restrictions.eq("idinvoice", Integer.parseInt(request.getParameter("invid"))));
                      
                      }
                        
                        inv = cr.list();
                      

                    }

                    if (us.getUserType().getUserType().equals("user")) {
                        inv = ss.createCriteria(Invoice.class).add(Restrictions.eq("user", us)).list();

                    } else if (us.getUserType().getUserType().equals("caller")) {
                        inv = ss.createCriteria(Invoice.class).add(Restrictions.eq("activeState", purchased)).list();

                    } else if (us.getUserType().getUserType().equals("deliveryManager")) {
                        inv = ss.createCriteria(Invoice.class).add(Restrictions.eq("activeState", confirmed)).list();

                    } else if (us.getUserType().getUserType().equals("diliveryGuy")) {
                        inv = ss.createCriteria(Invoice.class).add(Restrictions.eq("activeState", dispatch)).list();

                    }

                    int noofpro_forPage = 8;
                    int page_id = 0;

                    int bck = page_id - 1;

                    int wadi_tika = inv.size() % noofpro_forPage;
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



        <div id="page-wrapper">

            <div class="container-fluid">


                <!-- /.row -->

                <!-- Flot Charts -->
                <div class="row"></div>
                 <div class="row">
                    <div class="col-lg-12">
                        <div class="col-lg-6">
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="uprofile.jsp">Dashboard</a>
                            </li>
                            
                            <li class="active">Tasks</li>
                        </ol>
                        </div>
                        <div class="col-lg-6 form-inline">
                            <form action="Tasks.jsp">
                                <span class="pull-right form-group"> <input type="text" name="invid" value="" class=" form-control" placeholder="Serch by invoice id"/>   <button class="btn btn-primary fa fa-search btn-lg"   ></button></span>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-shopping-cart fa-0"></i>   Tasks</h3>
                            </div>
                            <div class="panel-body">
                                
                                 <label><a style="text-decoration: none" href="<%=url%>&status=4"> <input type="radio" name="actiontype" value="Purchased"/>  Purchased </a></label>
                                <span><a style="text-decoration: none" href="<%=url%>&status=5"> <input type="radio" name="actiontype" value="Dispatch" />  Confirmed</a></span> 
                                <span><a style="text-decoration: none" href="<%=url%>&status=6"> <input type="radio" name="actiontype" value="Confirmed" /> Dispatch </a></span> 
                                <span><a style="text-decoration: none" href="<%=url%>&status=7"> <input type="radio" name="actiontype" value="Deliverd" />  Delivered</a></span> 
                                <span><a style="text-decoration: none" href="<%=url%>&status=8">  <input type="radio" name="actiontype" value="Declined" />  Declined</a></span> 
                                <span> <a style="text-decoration: none" href="<%=url%>">  <input type="radio" name="actiontype" value=""  />All</a></span> 
                        <%        
                              
                              if(inv.size()>0){
                              %>
                                <div class="flot-chart">
                                    <table width="95%" class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>Invoice ID </th>
                                                <th>Invoice Date/Time</th>
                                                <th>User Name</th>
                                                <th>Status</th>

                                                <th>P. Method</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <%                                            for (int inv_list_id = noofpro_forPage * page_id; inv_list_id < (noofpro_forPage + (page_id * noofpro_forPage)); inv_list_id++) {

                                                    DB.Invoice i;
                                                    try {

                                                        i = inv.get(inv_list_id);

                                                    } catch (Exception eeee) {
                                                        //  eeee.printStackTrace();
                                                        break;

                                                    }


                                            %>

                                            <tr>
                                                <td><%=i.getIdinvoice()%></td>
                                                <td><%=i.getDate()%></td>
                                                <td><a href="user_detail_view.jsp?uid=<%=i.getUser().getIduser()%>"><%=i.getUser().getFname() + " " + i.getUser().getLname()%></a></td>
                                                <td><%=i.getActiveState().getStateType()%></td>

                                                <td><%=i.getPaymentMethod().getPaymentMethod()%></td>
                                                <td>
                                                    <form action="view_inv.jsp" >
                                                        <input type="hidden" name="invid" value="<%=i.getIdinvoice()%>">
                                                        <button class="btn btn-warning"   >View</button>
                                                        
                                                    </form>

                                                </td>
                                            </tr>

                                            <%
                                                }
                                            %>

                                        </tbody>
                                    </table>
                                </div>
                              
                              <%
                              }else{
                              %>
                              <br/>
                              <br/>
                              <i>You have No Oders</i>
                              
                              <%
                              }
                              %>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <%

                    %> 

                    <div class="col-sm-12 row">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4">

                            <ul class="pagination">

                                <%                         for (int page_id_pg = 0; page_id_pg < (inv.size() / noofpro_forPage) + wadi_page_eka; page_id_pg++) {

                                        if (thispage == page_id_pg) {
                                %>
                                <li class="active">
                                    <a  href="Tasks.jsp?page=<%="" + page_id_pg%>">


                                        <%=(page_id_pg + 1) + ""%>
                                    </a>   </li>



                                <%

                                } else {
                                %>
                                <li>
                                    <a  href="Tasks.jsp?page=<%="" + page_id_pg%>">


                                        <%=(page_id_pg + 1) + ""%>
                                    </a>  </li>


                                <%
                                        }
                                    }
                                %>
                            </ul>

                        </div>



                        <div class="col-sm-4"></div></div>

                </div>
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

        </div>
                            
                            
        <!-- /#page-wrapper -->


        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>



        <%
                } else {
                    response.sendRedirect("home.jsp");
                }
            } catch (NullPointerException ex) {
ex.printStackTrace();
                response.sendRedirect("home.jsp");

            }
        %>
        
        
    </body>
</html>
