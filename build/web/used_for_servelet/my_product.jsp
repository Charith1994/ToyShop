<%-- 
    Document   : my_product
    Created on : Jul 21, 2016, 11:55:56 AM
    Author     : ZEE
--%>

<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="DB.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  
    <body>
        
        <%
        DB.Product p=new Product();
        Session s=Connection.conn.getSessionFactory().openSession();
        Criteria cr=s.createCriteria(DB.Product.class);
        
        int tot=cr.list().size();
        
        List<DB.Product> li=(List<DB.Product>)cr.list();
        
        if(tot!=0){
           
        %>
         <div    id="page-wrapper">
               
            
           <div class="container-fluid">
              <%  for (Product pr : li) { %>
               <div class="col-sm-3"  >
                   
                   <div class="panel panel-yellow" style="height: 339px" >
                            <div class="panel-heading">
                                <h3 class="panel-title"><%=pr.getProduct()%></h3>
                            </div>
                            <div class="panel-body">
                                <div class="thumbnail">
                                    <img style="height: 180px" src="<%=pr.getImage()%>" alt="product image" height="100px">
                                </div>
                                <%=pr.getDiscription()%>
                            </div>
                            <div class="panel-footer"><a href="###"> <div class="fa fa-gear"></div></a></div>
                        </div>
                    </div><% } %>
           </div></div>
         <% } else{ %>
         
         <div style = "margin-top: 100px;"> <p style ="font-size: 20px;" > Sorry, No result found</p> <a class ="btn btn-warning" href="home.jsp"><< Back to Home </a></div>\n
  <% } %>
    
    </body>
</html>
