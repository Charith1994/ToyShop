<%-- 
    Document   : user_manage
    Created on : Oct 26, 2016, 7:48:34 PM
    Author     : ZEE
--%>

<%@page import="cls.listner"%>
<%@page import="DB.UserType"%>
<%@page import="DB.ActiveState"%>
<%@page import="org.hibernate.Session"%>
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

            try {
                if (us != null) {
                    List<User> user = null;
                    Criteria cr = ss.createCriteria(User.class);
                    if (us.getUserType().getUserType().equals("admin") | us.getUserType().getUserType().equals("superAdmin")) {

                        ActiveState status = new ActiveState();
                        UserType utype = new UserType();
                        String utpeid = request.getParameter("utype");
                        String statusid = request.getParameter("status");
                        if (statusid != null) {
                            status = (ActiveState) ss.load(ActiveState.class, Integer.parseInt(statusid));
                        }

                        if (utpeid != null) {

                        }

                        if (statusid == null & utpeid == null) {
                            Query qU = ss.createQuery("from User");
                            user = qU.list();
                        } else if (statusid != null & utpeid == null) {
                            cr.add(Restrictions.eq("activeState", status));
                            user = cr.list();
                        }

                        if (utpeid != null & statusid == null) {
                            utype = (UserType) ss.load(UserType.class, Integer.parseInt(utpeid));
                            cr.add(Restrictions.eq("userType", utype));
                            user = cr.list();
                        } else if (utpeid != null & statusid != null) {
                            cr.add(Restrictions.eq("activeState", status));
                            utype = (UserType) ss.load(UserType.class, Integer.parseInt(utpeid));
                            cr.add(Restrictions.eq("userType", utype));
                            user = cr.list();

                        }
                        
                        if(request.getParameter("uname")!=null){
                      cr.add(Restrictions.like("lname", "%" +request.getParameter("uname")+"%"));
                       user = cr.list();
                      }

                    }

                    int noofpro_forPage = 8;
                    int page_id = 0;

                    int bck = page_id - 1;

                    int wadi_tika = user.size() % noofpro_forPage;
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

                                <li class="active">User Managment</li>
                            </ol></div>
                        <div class="col-lg-6 form-inline">
                            <form action="user_manage.jsp">
                            <span class="pull-right form-group"> <input type="text" name="uname" value="" class=" form-control" placeholder="Serch by invoice id" />   <button class="btn btn-primary fa fa-search btn-lg"   ></button></span>
</form>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-user fa-0"></i>  User Managment </h3>
                            </div>
                            <div class="panel-body">
                                                                <div class="col-lg-4 form-group">Status :
                                                                    <a style="text-decoration: none" href="<%=url%>&status=1">   <span> <input type="radio" name="actiontype"  />  Active </span>    </a>
                                                                    <a style="text-decoration: none" href="<%=url%>&status=2">   <span><input type="radio" name="actiontype"/>  De-active </span> </a>
                                                                    <a style="text-decoration: none" href="<%=url%>&status=3"> <span><input type="radio" name="actiontype" />   Pending</span> </a>
                                                                </div> <div class="col-lg-4">
                                                                </div> <div class="col-lg-4 form-group">User Type:
                                                                    <a style="text-decoration: none" href="<%=url%>&utype=1">   <span><input type="radio" name="Utype" />   Staff</span> </a>
                                                                    <a style="text-decoration: none" href="<%=url%>&utype=2">   <span> <input type="radio" name="Utype"/>   User</span> </a>
                                                                </div>
                                <%

                                    if (user.size() > 0) {
                                %>
                                <div class="flot-chart">
                                    <table width="95%" class="table table-bordered table-hover table-striped">
                                        <thead>
                                            <tr>
                                                <th>User ID </th>
                                                <th>User Name</th>
                                                <th>Email</th>
                                                <th>Con no</th>

                                                <th>Status</th>
                                                <th>User Type</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <%
                                                cls.listner counter = (listner) session.getAttribute(listner.COUNTER);
                                                List<String> actuser= counter.getSessions();
                                                boolean flag = true;
                                                boolean act = false;
                                                for (int us_list_id = noofpro_forPage * page_id; us_list_id < (noofpro_forPage + (page_id * noofpro_forPage)); us_list_id++) {

                                                    DB.User u;
                                                    try {
                                                         u = user.get(us_list_id);
                                                            

                                                    } catch (Exception eeee) {
                                                        //  eeee.printStackTrace();
                                                        break;

                                                    }


                                            %>

                                            <tr>
                                                <td>
                                                    <%=u.getIduser()%></td>
                                                <td><a href="user_detail_view.jsp?uid=<%=u.getIduser()%>"><%=u.getFname() + " " + u.getLname()%></a></td>
                                                <td><%=u.getEmail()%></td>
                                                <td><%=u.getTelnumber()%></td>

                                                <td><%=u.getActiveState().getStateType()%></td>
                                                <td><%=u.getUserType().getUserType()%></td>

                                                <td>
                                                    <form action="User_managment" method="POST">
                                                        <input type="hidden" name="uid" value="<%=u.getIduser()%>">
                                                        <input type="hidden" name="state" value="<%=u.getActiveState().getIdactiveState()%>">
                                                        <input type="hidden" name="url" value="<%=url%>">

                                                        <%
                                                            if (("admin".equals(u.getUserType().getUserType()) & "superAdmin".equals(us.getUserType().getUserType())) | (!"admin".equals(u.getUserType().getUserType()) & "admin".equals(us.getUserType().getUserType())) | (!"admin".equals(u.getUserType().getUserType()) & "superAdmin".equals(us.getUserType().getUserType())) | ("superAdmin".equals(u.getUserType().getUserType()) & "superAdmin".equals(us.getUserType().getUserType()))) {
                                                                flag = true;
                                                            } else {
                                                                flag = false;
                                                            }

                                                            if (flag) {
                                                                if (u.getActiveState().getStateType().equals("deactive")) {
                                                        %>

                                                        <button class="btn btn-success"   > Active  </button>
                                                        <%
                                                        } else if (!u.getActiveState().getStateType().equals("pending")) {
                                                        %>
                                                        <button class="btn btn-danger"   >De-Active</button>

                                                        <%  }
                                                            } %>

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
                                } else {
                                %>
                                <br/>
                                <br/>
                                <i>You have No task to Complete</i>

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

                                <%                         for (int page_id_pg = 0; page_id_pg < (user.size() / noofpro_forPage) + wadi_page_eka; page_id_pg++) {

                                        if (thispage == page_id_pg) {
                                %>
                                <li class="active">
                                    <a  href="user_manage.jsp?page=<%="" + page_id_pg%>">


                                        <%=(page_id_pg + 1) + ""%>
                                    </a>   </li>



                                <%

                                } else {
                                %>
                                <li>
                                    <a  href="user_manage.jsp?page=<%="" + page_id_pg%>">


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
 <%@include file="include/fotter.jsp" %>
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
                response.sendRedirect("home.jsp");
            }
        %>
    </body>
</html>
