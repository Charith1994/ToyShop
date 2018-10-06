<%-- 
    Document   : user_detail
    Created on : Nov 4, 2016, 10:22:44 AM
    Author     : ZEE
--%>

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
        <script>
            function updatePW() {

                var pw1 = document.getElementById("pw1").value;
                var pw2 = document.getElementById("pw2").value;

                if (pw2 !== "") {
                    if (pw1 === pw2) {
                        document.getElementById('pw2zz').setAttribute('class', 'label label-default');
                        document.getElementById('pw1zz').setAttribute('class', 'label label-default');


                    } else if (pw1 !== pw2) {
                        alert("passwords are does not match");
                        document.getElementById('pw2zz').setAttribute('class', 'label label-danger');
//             
                    }

                } else {
                    alert("Fill the password fields before submit");
                    document.getElementById('pw2zz').setAttribute('class', 'label label-danger');
                    document.getElementById('pw1zz').setAttribute('class', 'label label-danger');

                }

            }
            
            
            
              
             function loadtown(){
               var pro=  document.getElementById("provinsel").value;
                 $.post("loadTown",{prov:pro},function (data){
                    
                     $("#twns").html(data+"");
                 });
                 
             }
             
            
       
        </script>
    </head>

    <body>



        <%        DB.User u = (DB.User) session.getAttribute("loging");

            if (u != null) {

        %>
        <div class="container-fluid">
            <div class="container">
                <div class="row">

                    <div class="col-lg-10  ">


                        <h2>

                            Name: 
                            <%=u.getFname() + " " + u.getLname()%>

                        </h2>

                        <form action="user_reg"   >      
                            <div class="col-lg-12  panel panel-info">

                                <div class="panel-heading">Edit details </div> 
                                <div class="panel-body">
                                    <div class="col-lg-6">

                                        <div class="form-group" >
                                            <span class="label  label-default " style="font-size: medium">   First Name </span>
                                            <div class="input-group">
                                                <input class="form-control" name="fname" type="text" value="<%=u.getFname()%>" >

                                            </div>
                                        </div>
                                        <div class="form-group" >
                                            <span class="label label-default" style="font-size: medium">   Last Name </span>
                                            <div class="input-group">
                                                <input class="form-control" name="lname" type="text" value="<%=u.getLname()%>" >

                                            </div>
                                        </div>
                                        <div class="form-group" >
                                            <span class="label label-default" style="font-size: medium">   Email: </span>
                                            <div class="input-group">
                                                <input class="form-control" name="email" type="text" value="<%=u.getEmail()%>" >

                                            </div>
                                        </div>





                                        <div class="form-group" >
                                            <span class="label label-default" style="font-size: medium">Land number: </span>
                                            <div class="input-group">
                                                <input class="form-control" name="contactno" type="text" value="<%= u.getTelnumber()%>"> 

                                            </div>
                                        </div>
                                        <div>
                                            <input type="hidden" name="userpassword" value="<%= u.getUpassword()%>">
                                            <input class="button" type="submit" value="Update" />
                                        </div>  


                                    </div>


                                  

                                </div>

                            </div>

                        </form>
                                            
                            <div class="col-lg-12  panel panel-info">

                                <div class="panel-heading">Edit details </div> 
                                <div class="panel-body">
                                    <form action="update_adress">
                                    
                                    <div class="col-lg-6">

                                        <div class="form-group" >
                                            <span class="label  label-default " style="font-size: medium">   Select Province </span>
                                            <div class="input-group">
                                                <select name="province" id="provinsel" style="padding-left: 45px" onchange="loadtown()">
                                                    <%

                                                        Session ss = Connection.conn.getSessionFactory().openSession();
                                                        List<Province> province = ss.createQuery("from Province").list();
                                                        Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", u)).uniqueResult();
                                                    %>
                                                   
                                                           
                                                           
                                                           <option selected="selected"    ><%=ad.getDistric().getProvince().getProvince()%></option>
                                                    <%                   for (Province p : province) {
                                                    %>

                                                    <option>

                                                        <%=p.getProvince()%>
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select><i></i>
                                            </div>

                                            <span class="label  label-default " style="font-size: medium">   Select Town </span>
                                            <div class="input-group">
                                                <select name="town" id="twns" style="padding-right:  45px">
                                                    <option selected="selected" ><%=ad.getDistric().getDistric()%></option>




                                                </select><i></i>
                                            </div>
                                        </div>
                                        <div class="form-group" >
                                            <span class="label label-default" style="font-size: medium">   First line </span>
                                            <div class="input-group">
                                                <input class="form-control" name="address[addr1]" type="text" value="<%=ad.getLine1()%>" >

                                            </div>
                                        </div>
                                        <div class="form-group" >
                                            <span class="label label-default" style="font-size: medium">   Second line </span>
                                            <div class="input-group">
                                                <input class="form-control" name="address[addr2]" type="text" value="<%=ad.getLine2()%>" >

                                            </div>
                                        </div>





                                        <div class="form-group"  >
                                            <span class="label label-default" style="font-size: medium">Land number: </span>
                                            <div class="input-group">
                                                <input class="form-control" name="address[addr3]" type="text" value="<%=ad.getLine3()%>"> 

                                            </div>
                                        </div>
                                        <div>
<div>
                                           
                                            <input class="button" type="submit" value="Update" />
                                        </div>  

                                        </div>  


                                    </div>  
                                    
                                    </form>
                                    
                                    
                                    
                                    
                                    
                                    
                                </div></div></div>                  
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                        <form action="passwordUp">
                            <div class="col-lg-12  panel panel-info">

                                <div class="panel-heading">Change password</div> 
                                <div class="panel-body">

                                    <div class="form-group" >
                                        <span id="pw1zz" class="label label-default" style="font-size: medium">New password: </span>
                                        <div class="input-group">
                                            <input class="form-control" name="pw1" id="pw1" type="password"> 

                                        </div>
                                    </div>
                                    <div class="form-group" >
                                        <span id="pw2zz" class="label label-default" style="font-size: medium">Confirm new password: </span>
                                        <div class="input-group">
                                            <span>
                                                <input class="form-control" name="pw2" id="pw2" type="password" > 
                                                <img id="ok" src="#" style="width: 30px; height: 30px;" hidden="true"/>

                                            </span>
                                        </div>
                                    </div>

                                    <div>

                                        <input class="button" type="submit" value="Update" onmousemove="updatePW()"/>
                                    </div>   

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
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
    </body>
</html>
