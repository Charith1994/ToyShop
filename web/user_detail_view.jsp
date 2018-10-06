<%-- 
    Document   : user_detail
    Created on : Nov 4, 2016, 10:22:44 AM
    Author     : ZEE
--%>

<%@page import="DB.UserType"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="DB.Adress"%>
<%@page import="org.hibernate.Session"%>
<%@page import="DB.Province"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Custom CSS -->

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="fonts/font-awesome.min.css" rel="stylesheet" >
        <link href="fonts/font-awesome.css" rel="stylesheet" >
    </head>

    <body>

        <%@include file="include/header.jsp" %>

        <%
            
            String uid = request.getParameter("uid");
            url=url+"&uid="+uid;
            DB.User u = new DB.User();
            if (uid != null) {

                u = (DB.User) ss.load(User.class, Integer.parseInt(request.getParameter("uid")));
            }
            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("superAdmin"))) {

        %>
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="container">

                    <div class="row">
                        <div class="col-lg-12">

                            <ol class="breadcrumb">
                                <li>
                                    <i class="fa fa-dashboard"></i>  <a href="uprofile.jsp">Dashboard</a>
                                </li>

                                <li class="active">User profiles </li>
                            </ol>
                        </div>
                    </div>



                    <div class="row">

                        <div class="col-lg-12  ">


                            <h2>

                                Name: 
                                <%=u.getFname() + " " + u.getLname()%><br/>
                                Type: <%=u.getUserType().getUserType() %>
                                <form action="User_managment" method="POST">
                                                <input type="hidden" name="uid" value="<%=u.getIduser()%>">
                                                <input type="hidden" name="state" value="<%=u.getActiveState().getIdactiveState()%>">
                                                 <input type="hidden" name="url" value="<%=url%>">
                                                <%
                                                    boolean flag = true;

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
                                                            
                                                              <%
                                                                if(us.getUserType().getUserType().equals("superAdmin")){
                                                                %>
                                                            <form action="utype_change">
                                                                <input type="hidden" name="uid" value="<%=uid%>">
                                                                <input type="hidden" name="url" value="<%=url%>">
                                                                <select name="utype" >
                                                                    
                                                                    <%
                                                          List<DB.UserType> ut=ss.createCriteria(UserType.class).list();
                                                            for(UserType uut:ut){
                                                            %>
                                                                    <option><%= uut.getUserType()%></option>
                                                                     <%
                                                                }
                                                                %>
                                                                </select> 
                                                              
                                                                <input class="btn btn-warning" type="submit" value="Change type">
                                                              
                                                            </form>                 
                                                            
                                                              <%
                                                                }
                                                                %>

                            </h2>

                                
                                
                                
                                
                                
                                
                                
                            <form action="user_reg"   >      
                                <div class="col-lg-5  panel panel-info">

                                    <div class="panel-heading">User details </div> 
                                    <div class="panel-body">
                                        <div class="col-lg-6">

                                            <div class="form-group" >
                                                <span class="label  label-default " style="font-size: medium">   First Name </span>
                                                <div class="input-group">
                                                    <label class="form-control" style="padding-left: 60px; padding-right:60px"> <%=u.getFname()%> </label>

                                                </div>
                                            </div>
                                            <div class="form-group" >
                                                <span class="label label-default" style="font-size: medium">   Last Name </span>
                                                <div class="input-group">
                                                    <label class="form-control" style="padding-left: 60px; padding-right:60px"> <%=u.getLname()%></label>

                                                </div>
                                            </div>
                                            <div class="form-group" >
                                                <span class="label label-default" style="font-size: medium">   Email: </span>
                                                <div class="input-group">
                                                    <label class="form-control" style="padding-left: 60px; padding-right:60px"> <%=u.getEmail()%></label>

                                                </div>
                                            </div>





                                            <div class="form-group" >
                                                <span class="label label-default" style="font-size: medium">Land number: </span>
                                                <div class="input-group">
                                                    <label class="form-control" style="padding-left: 60px; padding-right:60px"> <%= u.getTelnumber()%></label>

                                                </div>
                                            </div>



                                        </div>




                                    </div>

                                </div>

                            </form>

                            <div class="col-lg-1"></div>              
                            <div class="col-lg-5  panel panel-info">

                                <div class="panel-heading">Delivery details </div> 
                                <div class="panel-body">
                                   

                                        <div class="col-lg-6">

                                            <div class="form-group" >
                                                <span class="label  label-default " style="font-size: medium">   Select Province </span>
                                                <div class="input-group">

                                                    <%

                                                        Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", u)).uniqueResult();
                                                   

                                                    %>



                                                    <label class="form-control" style="padding-left: 60px; padding-right:60px"> <%=ad.getDistric().getProvince().getProvince()%></label>

                                                    </i>
                                                </div>
                                            </div>
                                            <div class="form-group" >
                                                <span class="label  label-default " style="font-size: medium">   Select Town </span>
                                                <div class="input-group">

                                                    <label class="form-control" style="padding-left: 60px; padding-right:60px"> <%=ad.getDistric().getDistric()%></label>




                                                    <i></i>
                                                </div>
                                            </div>
                                            <div class="form-group" >
                                                <span class="label label-default" style="font-size: medium">   First line </span>
                                                <div class="input-group">
                                                    <label class="form-control" style="padding-left: 60px; padding-right:60px"> <%=ad.getLine1()%></label>

                                                </div>
                                            </div>
                                            <div class="form-group" >
                                                <span class="label label-default" style="font-size: medium">   Second line </span>
                                                <div class="input-group">
                                                    <label class="form-control" style="padding-left: 10px; padding-right:10px"> <%=ad.getLine2()%></label>

                                                </div>
                                            </div>


                                            <div class="form-group"  >
                                                <span class="label label-default" style="font-size: medium">Land number: </span>
                                                <div class="input-group">
                                                    <label class="form-control" style="padding-left: 10px; padding-right:10px"> <%=ad.getLine3()%></label>

                                                </div>
                                            </div>
                                            <div>
                                                <div>


                                                </div>  

                                            </div>  

                                           
                                        </div>  

                                






                                </div>
                                    
                            </div>
                                    
                                                    
                        </div>                  
 



                    </div></div></div>
                        
                                                     <%@include file="include/fotter.jsp" %>
        </div>

        <%
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);

            }
        %>

        <script src="js/jquery.js"></script>
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script> 

    </body>
</html>
