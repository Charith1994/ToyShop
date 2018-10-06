<%-- 
    Document   : index
    Created on : Apr 7, 2016, 11:12:35 AM
    Author     : ZEE
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        
         <link href="register_1.jsp" type="text/javascript"/>
         <script>
           
            
         </script>
        
    </head>
    <body ng-app="myModule" style="background: #bce8f1;">
         <%
          
            String Fname=request.getParameter("fname");
            String Lname=request.getParameter("lname");
            String Email=request.getParameter("email");
            String Tel=request.getParameter("contactno");




          
         %>
        <p><br/></p>
       
       
        <div class="row" ng_app="mymodule">
            <div class="col-md-3" ng-controller="myController">
                <div>
                    
                </div>    
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="page-header" style="margin-top: 5px;">
                            <h3>Register Here</h3>
                        </div>
                        <form class="form-horizontal"  method="POST" action="user_reg">
                            <div class="form-group"></div>
                            <div class="form-group">
                                <input type="hidden" name="fname" value="<%=Fname%>">
                                <input type="hidden" name="lname" value="<%=Lname%>">
                                <input type="hidden" name="email" value="<%=Email%>">
                                <input type="hidden" name="contactno" value="<%=Tel%>">
                              
                              <label for="inputConEmail3" class="col-sm-5 control-label">Set your account Security</label>
                          </div>
                           
                            <div class="form-group">
                              <label for="inputun3" class="col-sm-3 control-label">User Name</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user" id="basic-addon1"></span></span>
                                    
                                        <input type="text" class="form-control" id="inputun3" placeholder="User Name" name="username" required="required"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-3 control-label">Password</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-star" id="basic-addon1"></span></span>
                                        <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="userpassword" required="required"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputConPassword3" class="col-sm-3 control-label">Conform Password</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-star" id="basic-addon1"></span></span>
                                        <input type="password" class="form-control" id="inputConPassword3" placeholder="Conform Password" required="required"></div>
                                </div>
                            </div>

                            <div class="form-group">
                              <div class="col-sm-offset-2 col-sm-10">
                                
                                 <button type="submit" class="btn btn-primary" >Previous</button> 
                                <button type="submit" class="btn btn-primary" >Next</button>
                              </div>
                            </div>
                        </form>
                        <form >
                      
                    </div>
                </div>
            </div>
        </div>
       
        
        <script src="js/bootstrap.js"></script>
        
         <script src="js/jquery.js"></script>
    <script src="js/jquery-1.9.1.min.js"></script>
     <script src="js/angular.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
