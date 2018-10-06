<%-- 
    Document   : Add_new_toy
    Created on : Sep 28, 2016, 12:49:31 PM
    Author     : ZEE
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="sqlcon.db"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="blurBg-false" style="background-color:#EBEBEB">
<link href="fonts/font-awesome.min.css" rel="stylesheet" >
       <link href="fonts/font-awesome.css" rel="stylesheet" >
       <link rel="stylesheet" href="form_styles/formoid1/formoid-metro-cyan.css" type="text/css">
    
<link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">
</body>
<!-- Start Formoid form-->

<%
    String sql="select * from category ";
sqlcon.db db=new db();
ResultSet rs=db.getdata(sql);

%>



<form action="product_save" enctype="multipart/form-data" class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Open Sans','Helvetica Neue','Helvetica',Arial,Verdana,sans-serif;color:#666666;max-width:480px;min-width:150px" method="post"><div class="title"><h2>Add New Product</h2></div>
	<div class="element-input"><label class="title">Product Name</label><input class="large" type="text" name="pname" /></div>
	<div class="element-select"><label class="title">Category</label><div class="large"><span><select name="selectcat" >
<%
while(rs.next()){

%>
<option value="<%=rs.getString("idcategory")%>"><%=rs.getString("name")%></option>}
<% } %>
		</select><i></i></span></div></div>
	<div class="element-input"><label class="title">Pakage weight</label><input class="large" type="text" name="pakweight"  /></div>
	<div class="element-textarea"><label class="title">Discription</label><textarea class="medium" name="discription" cols="20" rows="5" ></textarea></div>
       	<div class="element-file"><label class="title">Choose Image</label><label class="large" ><div class="button">Choose File</div><input type="file" class="file_input" name="img" /><div class="file_text">No file selected</div></label></div>
	<div class="element-number"><label class="title">Warrenty(Days)</label><input class="large" type="text" min="0" max="30" name="warday"  value=""/></div>
	<div class="element-input"><label class="title">Buying Price</label><input class="large" type="text" name="b_price" /></div>
	<div class="element-input"><label class="title">Selling Price</label><input class="large" type="text" name="s_price" /></div>
<div class="submit"><input type="submit" value="Submit"/></div></form>
<script type="text/javascript" src="form_styles/formoid1/formoid-metro-cyan.js"></script>
<!-- Stop Formoid form-->

<script type="text/javascript" src="form_styles/formoid1/jquery.min.js"></script>


        <!-- Custom Fonts -->
        
  
    



</html>
