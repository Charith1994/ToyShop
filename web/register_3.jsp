<%-- 
    Document   : register_3
    Created on : Apr 7, 2016, 11:12:35 AM
    Author     : Zee
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="DB.Province"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
<!--        <link href="css/bootstrap.css" rel="stylesheet"/>-->
        <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>-->
        <script type="text/javascript">
             function loadtown(){
               var pro=  document.getElementById("provinsel").value;
                 $.post("loadTown",{prov:pro},function (data){
                    
                     $("#twns").html(data+"");
                 });
                 
             }
             
            
         </script>
        
    </head>
   <body class="blurBg-false" style="background-color:#EBEBEB">
<%
  //  String url=request.getParameter("url");
 DB.User us = (DB.User) request.getSession().getAttribute("loging");
 Session hbses=Connection.conn.getSessionFactory().openSession();
String url = request.getParameter("url");
if(us!=null){
%>

       <link href="form_styles/formoid1/formoid-metro-cyan.css" rel="stylesheet" type="text/css"/>
<!-- Start Formoid form-->
<link rel="stylesheet" href="adress_files/formoid1/formoid-metro-cyan.css" type="text/css" />
<script type="text/javascript" src="adress_files/formoid1/jquery.min.js"></script>
<form action="Save_address" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Open Sans','Helvetica Neue','Helvetica',Arial,Verdana,sans-serif;color:#666666;max-width:480px;min-width:150px" method="GET"><div class="title"><h2>Configure Your Adress</h2></div>
    <input type="hidden" value="<%=url%>" name="url">
    
    <div class="element-address">
	<label class="title">Address</label><br/>
       
        <span class="addr1">
             <label class="subtitle">House No</label>
            <input  type="text" name="address[addr1]" /></span>
           
	<span class="addr2">
            <label class="subtitle">Address Line 2</label> 
            <input  type="text" name="address[addr2]" />
	</span>
           
        <span class="addr2">
            <label class="subtitle">Address Line 3</label>
            <input  type="text" name="address[addr3]" /></span>
	
	
        
        <div class="country">
            <label class="subtitle">Province</label>
            <select name="province" id="provinsel" onchange="loadtown()">
	<%
          List<Province> province=hbses.createQuery("from Province").list();

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
	
        
        <div class="country">
             <label class="subtitle">Town</label>
            <select name="town" id="twns">
	<option selected="selected" value="" disabled="disabled">--- Select a Town ---</option>
        
            
            
            
            </select>
            
       </div>
        
        
        </div><div> <i>   If you can't Find Your town here, that means our delivery service is not available in your area. set it N/A. We will contact you when you place order.</i></div>
<div class="submit"><input type="submit" value="Submit"/></div></form>

<script type="text/javascript" src="adress_files/formoid1/formoid-metro-cyan.js"></script>
<!-- Stop Formoid form-->


<script src="form_styles/formoid1/jquery.min.js" type="text/javascript"></script>
<script src="form_styles/formoid1/formoid-metro-cyan.js" type="text/javascript"></script>
</body>

<%
    }else{
response.sendRedirect("login2.jsp?comeBackurl="+url);
}
%>
</html>
