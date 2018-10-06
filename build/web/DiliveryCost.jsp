<%-- 
    Document   : DiliveryCost
    Created on : Dec 6, 2016, 2:34:46 PM
    Author     : ZEE
--%>

<%@page import="DB.Distric"%>
<%@page import="DB.Province"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Toy Admin panal</title>

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
    <link href="form_styles/formoid1/formoid-metro-cyan.css" rel="stylesheet" type="text/css"/>
     <script type="text/javascript">
             function loadtown(){
               var pro=  document.getElementById("provinsel").value;
                 $.post("loadTown",{prov:pro},function (data){
                    
                     $("#twns").html(data+"");
                 });
                 
             }
             
            
         </script>
</head>

<body>

   <%@include file="include/header.jsp" %>  

        <!-- Navigation -->
        <%
         if (us != null &&( us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("superAdmin"))) {

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
                            
                            <li class="active">Delivery</li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <!-- Flot Charts -->
                <div class="row"></div>
                <!-- /.row -->

              <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-envelope fa-0"></i>  Delivery Cost management</h3>
                            </div>
                            <div class="panel-body">
                                <div class="flot-chart">
                                   <% 
                                    List<Distric> twn=ss.createCriteria(Distric.class).list();
                                    
                                    %>
                                  <table width="208" border="1" cellpadding="2" class="table table-bordered table-hover table-striped">
                                    <tr>
                                      <th  scope="col">Province</th>
                                      <th  scope="col">Town</th>
                                      <th  scope="col">Cost</th>
                                      
                                    </tr>
                                    <tr>
                                        <%
                                        for(Distric ds:twn){
                                        
                                        %>
                                        
                                        <td><%=ds.getProvince().getProvince() %></td>
                                        <td><%=ds.getDistric() %></td>
                                        <td><form action="change_dil_cost">
                                                <input type="hidden" value="<%=ds.getIdDistric()%>" name="disid">
                                               
                                                
                                                <input type="text" value="<%=ds.getDiliveryCost() %>" name="cost">
                                      
                                          <button style="float: right" class="btn button btn-success">Change</button>
                                      </form></td>
                                      
                                      
                                    </tr>
                                   <%
                                      }
                                      %>
                                  </table>
                                   <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-3"></div>
                    <div class="col-lg-3"></div>
                    <div class="col-lg-3"> <button class="btn button btn-default" data-toggle="modal" data-target="#newtown">New town</button></div>
                </div>
                                </div>
                                  
                            </div>
                                  
                        </div>
                    </div>
                                  
                </div>
            

            </div>
 <%@include file="include/fotter.jsp" %>
        </div>


    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    
    
    <!--modal-->
    <form action="Save_twn">
<div id="newtown" class="modal fade" role="dialog">
    <div class="modal-dialog modal-m">
        
            <!-- Modal content-->
             
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">New Town</h4>
                </div>
                <div class="modal-body">
                <p><input type="hidden" name="pid" value=""></p>
                <p><div class="country">
            <label class="subtitle">Province</label>
            <select name="province" id="provinsel" >
	<%
          List<Province> province=ss.createQuery("from Province").list();

        %>
        <option selected="selected"   value="null" >--- Select a Province ---</option>
               <%
                   for(Province p:province){
               %>
                
                <option>
                    
                    <%=p.getProvince()%>
                </option>
            <%
                }
            %>
            </select><i></i>
            
        </div>
            
                    <p>Enter here new Town name</p>
                    <p><input class="form-control  " type="text" name="twn"></p>
                    <p>Enter here Delivery cost</p>
                    <p><input class="form-control  " type="text" name="cost"></p>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                </div>
            </div>
      
    </div>
</div>
  </form>
            
            <%}
            %>
</body>
</html>
