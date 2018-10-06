<%-- 
    Document   : dash_board
    Created on : Oct 4, 2016, 11:56:06 PM
    Author     : ZEE
--%>

<%@page import="cls.listner"%>
<%@page import="DB.Report"%>
<%@page import="java.util.List"%>
<%@page import="DB.Product"%>
<%@page import="DB.User"%>
<%@page import="SRC.user_reg"%>
<%@page import="org.hibernate.Session"%>
<%@page import="DB.ActiveState"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.criterion.Projections"%>
<%@page import="org.hibernate.criterion.Projection"%>
<%@page import="DB.Invoice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>


    <body>




        <%
            Session hbss = Connection.conn.getSessionFactory().openSession();
            User us = (User) request.getSession().getAttribute("loging");
            Session hbs = Connection.conn.getSessionFactory().openSession();
            if (us == null) {
                response.sendRedirect("home.jsp");
            } else {
                ActiveState act = (ActiveState) hbss.load(ActiveState.class, 1);
                Criteria cr2 = hbss.createCriteria(Product.class);
                cr2.add(Restrictions.eq("activeState", act));
                int count = 0;
                List<Product> pr = cr2.list();
                for (Product pro : pr) {
                    if (pro.getQty() <= 10) {
                        count++;
                    }

                }

        %>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->

                <!-- /.row -->
                <%    if (us != null && !us.getUserType().getUserType().equals("user")) {


                %>
                <div class="row"><a href="#">
                        <div class="col-lg-12">
                            <div class="alert alert-danger alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <i class="fa fa-info-circle"></i>  <strong><%=count%>  Products are less quantity</strong></div>
                        </div></a>
                </div>
                <!-- /.row -->
                <%
                    }
                %>
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-users fa-5x"></i>
                                    </div>

                                    <%
                                        Session ss = Connection.conn.getSessionFactory().openSession();
                                        ActiveState actv = (ActiveState) ss.load(ActiveState.class, 2);
                                        Criteria cc = ss.createCriteria(DB.User.class);
                                        cc.add(Restrictions.ne("activeState", actv));
                                        List<User> uslst = cc.list();

                                        cls.listner counter;
                                        int size = 0;
                                      
                                            counter = (listner) session.getAttribute(
                                                    listner.COUNTER);
                                            if (counter != null) {
                                                size = uslst.size();
                                            }

                                        

                                    %>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"> <%=size%></div>
                                        <div>Active Users!</div>
                                    </div>
                                </div>
                            </div>

                            <%
                                if (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("superAdmin")) {
                            %>   
                            <a href="user_manage.jsp">
                                <div class="panel-footer">
                                    <span class="pull-left"><%= counter.getActiveSessionNumber()%>  Online users</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right "></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                            <%} else {%>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"><%= counter.getActiveSessionNumber()%>  Online users</span>
                                    <!--<span class="pull-right"><i class="fa fa-arrow-circle-right "></i></span>-->
                                    <div class="clearfix"></div>
                                </div>
                            </a>

                            <%}%>     
                        </div>
                    </div>
                    <%

                        ActiveState purchased = (ActiveState) hbs.load(ActiveState.class, 4);
                        ActiveState confirmed = (ActiveState) hbs.load(ActiveState.class, 5);
                        ActiveState dispatch = (ActiveState) hbs.load(ActiveState.class, 6);
                        ActiveState dilivered = (ActiveState) hbs.load(ActiveState.class, 7);
                        ActiveState deleted = (ActiveState) hbs.load(ActiveState.class, 8);

                        Criteria cr = Connection.conn.getSessionFactory().openSession().createCriteria(Invoice.class);
                        int taskcount;
                        if (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("superAdmin")) {

                            cr.add(Restrictions.ne("activeState", dilivered));
                            cr.add(Restrictions.ne("activeState", deleted));

                            taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        } else if (us.getUserType().getUserType().equals("user")) {
                            cr.add(Restrictions.eq("user", us));
                            taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();

                        } else if (us.getUserType().getUserType().equals("caller")) {
                            cr.add(Restrictions.eq("activeState", purchased));

                            taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        } else if (us.getUserType().getUserType().equals("deliveryManager")) {
                            cr.add(Restrictions.eq("activeState", confirmed));
                            taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        } else if (us.getUserType().getUserType().equals("diliveryGuy")) {
                            cr.add(Restrictions.eq("activeState", dispatch));
                            taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();

                        } else {
                            taskcount = 0;
                        }


                    %>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-shopping-cart fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><%=taskcount%></div>
                                        <div>New Tasks!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="Tasks.jsp">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>

                    <%

                        List<Product> p = ss.createCriteria(Product.class).add(Restrictions.eq("activeState", act)).list();

                    %>


                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa- fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><%=p.size()%></div>
                                        <div>Products!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="Oder.html">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>

                    <%
                        int reportcount = 0;
                        Criteria c3 = hbs.createCriteria(Report.class);
                        if (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("superAdmin")) {
                            c3.add(Restrictions.eq("activeState", act));
                            reportcount = c3.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        } else if (us.getUserType().getUserType().equals("user")) {
                            c3.add(Restrictions.eq("user", us));
                            c3.add(Restrictions.eq("activeState", act));
                            reportcount = c3.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        }


                    %>   

                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-support fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><%=reportcount%></div>
                                        <div>Reported!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#" onclick="load_report_view()">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row"></div>
                <!-- /.row -->

                <div class="row">

                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                </div>
            </div>
            <!-- /.row -->

        </div>
        <!-- /.container-fluid -->


        <!-- /#page-wrapper -->


        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <!--        <script src="js/bootstrap.min.js"></script>-->

        <!-- Morris Charts JavaScript -->
        <script src="js/plugins/morris/raphael.min.js"></script>
        <script src="js/plugins/morris/morris.min.js"></script>
        <script src="js/plugins/morris/morris-data.js"></script>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="fonts/font-awesome.min.css" rel="stylesheet" >
        <link href="fonts/font-awesome.css" rel="stylesheet" >

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <%
            }
        %>

    </body>
</html>
