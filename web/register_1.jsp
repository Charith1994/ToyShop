<%-- 
    Document   : index
    Created on : Apr 7, 2016, 11:12:35 AM
    Author     : Zee
--%>

<%@page import="org.hibernate.Session"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        


         
        
    </head>
    <body style="background: #bce8f1;">
        <p><br/></p>

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="page-header" style="margin-top: 5px;">
                            <h3>Register Here</h3>
                        </div>
                        <form class="form-horizontal" action="register_2.jsp" method="POST" >
                            <div class="form-group">
                                <label for="inputfn3" class="col-sm-2 control-label">First Name</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user" id="basic-addon1"></span></span>
                                    
                                        <input type="text" class="form-control" value="" id="fname" placeholder="First Name" name="fname" required="required"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputfn3" class="col-sm-2 control-label">Last Name</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user" id="basic-addon1"></span></span>
                                    
                                        <input type="text" class="form-control" value="" id="lname" placeholder="Last Name" name="lname" required="required"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1">@</span>
                                        <input type="email" class="form-control" value="" id="email" placeholder="Email" name="email" required="required"></div>
                                </div>
                            </div>
                            
                            
                            
                            
                            <div class="form-group">
                                <label for="telnum" class="col-sm-2 control-label"> Contact no</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-phone"> </span></span>
                                        <input type="tel" class="form-control" value="" id="connum" placeholder="contactno" name="contactno" required="required"></div>
                                </div>
                            </div>
                            
                           
                          
                           
                            
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-primary"  onsubmit="subm()" >Confirm</button>
                                    
                               
                                    <button type="button" class="btn btn-link"><a href="login.jsp">Log in</a></button>
                                    
                                </div>
                            </div>
                            
                                </form>  

                            
                            </div>
                            
                            
                                

                            
                  
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        
       
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
         <script src="js/jquery.js"></script>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>

