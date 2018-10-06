

<%@page import="DB.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>
        
       
    </head>
    <%
//        User us=(User)request.getSession().getAttribute("loging");
        
    String url=request.getParameter("comeBackurl");
    
        if(url=="" | url==null){
        url="home.jsp";
        }
        
        
        
    %>
    <body style="background: #eee;">
        
        <%    
//        if(us==null){
        %>
        
        <div class="container">
            <p><br/></p>
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="panel panel-title">
                        <div class="panel-body">
                            <div class="page-header">
                                <h3>Sign In</h3>
                            </div>
                            <form action="logingtest" method="POST">
                                 <input type="hidden" value="<%=url%>" name="url"/>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">User Name or Email</label>
                                    
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
                                        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter User Email" name="uemail">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-star"></span></span>
                                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="upass">
                                    </div>
                                </div>

                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Remember me
                                    </label>
                                </div>
                                <hr/>
                                
                                <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-lock"></span>Login</button>
                                
                                or
                                <button type="button" class="btn btn-primary" onclick="location.href ='register_1.jsp';"><span class="glyphicon glyphicon-registration-mark"></span>Register</button>
                                <p><br/></p> 
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
   <%
//       } else{
//
//response.sendRedirect(url);
//}
    
    
    %>
    </body>
    
  
</html>
