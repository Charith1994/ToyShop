<%-- 
    Document   : Products_SERCH
    Created on : Oct 5, 2016, 5:37:02 PM
    Author     : ZEE
--%>



<%@page import="org.hibernate.criterion.Order"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="DB.ActiveState"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Toyz</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="fonts/font-awesome.min.css" rel="stylesheet" >
        <link href="fonts/font-awesome.css" rel="stylesheet" >
        <link href="css/hover.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <%@include file="include/header.jsp" %>
    

        <%
            Session se = Connection.conn.getSessionFactory().openSession();
            HashMap<Integer, DB.Product> map = new HashMap<Integer, DB.Product>();

            Criteria pro = se.createCriteria(DB.Product.class);
            try {

                String serchtxt = "";
                if (request.getParameter("serchtxt")!=null) {
                    serchtxt = request.getParameter("serchtxt");
                    pro.add(Restrictions.like("product", "%" + serchtxt + "%"));
                }

                Category cat2 = new Category();
                String catid ="0" ;
                int cat_id = 0;
                if (request.getParameter("catid")==null) {
                    cat2 = new Category();
                } else {
                    
                    catid=request.getParameter("catid");
                    cat_id = Integer.parseInt(catid);
                    cat2 = (Category) se.load(Category.class, cat_id);

                }
                if (cat_id != 0) {

                    pro.add(Restrictions.eq("category", cat2));

                }
               
                
                if (us == null || (us!=null && us.getUserType().getUserType().equals("user")) ) {
                    ActiveState act = (ActiveState) se.load(ActiveState.class, 1);
                    pro.add(Restrictions.eq("activeState", act));
                     pro.add(Restrictions.ne("qty", 0));

                } else {
                    pro.addOrder(Order.asc("qty"));

                }
                List<DB.Product> l = pro.list();

                int noofpro_forPage = 12;
                int page_id = 0;

                int bck = page_id - 1;

                int wadi_tika = l.size() % noofpro_forPage;
                int wadi_page_eka = 0;
                if (wadi_tika > 0) {
                    wadi_page_eka = 1;

                }

                try {
                    page_id = Integer.parseInt(request.getParameter("page"));

                } catch (Exception eee) {
                    page_id = 0;
                }
        %>



        <div    id="page-wrapper">


            <div class="container-fluid"><br/>
                <div class="row col-lg-12">

                    <%
                        if(l.size()>0){
                        for (int pro_list_id = noofpro_forPage * page_id; pro_list_id < (noofpro_forPage + (page_id * noofpro_forPage)); pro_list_id++) {
                            DB.Product p;
//
                            
                            try {

                                p = l.get(pro_list_id);

                            } catch (Exception eeee) {
                                //  eeee.printStackTrace();
                                break;

                            }
//}

                    %>
                    <!--"-->
                    <form  method="GET" action="sescart" >
                        <div class="col-sm-3">
                            <%                               if (us != null && !us.getUserType().getUserType().equals("user")) {
                                    if ((p.getActiveState().getIdactiveState() == 1 && p.getQty() >= 10)) {     %>
                            <div class="panel panel-primary"  >
                                <%  } else if (p.getActiveState().getIdactiveState() == 1 && p.getQty() == 0) {     %>
                                <div class="panel panel-default"  >
                                    <%  } else if (p.getActiveState().getIdactiveState() == 1 && p.getQty() <= 10) {     %>
                                    <div class="panel panel-warning"  >
                                        <%  } else {     %>
                                        <div class="panel panel-danger"  >
                                            <%
                                                }
                                            } else {
                                            %>
                                            <div class="panel panel-primary"  >


                                                <%
                                                    }
                                                %>
                                                <div class="panel-heading">
                                                    <h3 class="panel-title"><%= p.getProduct()%></h3>
                                                </div>
                                                <div class="panel-body" >
                                                    <div class="hovereffect">
                                                        <img class="img-responsive" src="<%=p.getImage()%>" alt="image here" style="height: 150px; width: 200px;" >
                                                        <div class="overlay">
                                                            <h2><%= p.getProduct()%></h2>
                                                            <a class="info" href="Product_view.jsp?pid=<%=p.getIdproduct()%>">View More</a>
                                                        </div>
                                                    </div>
                                                    <h4 id="tot"> RS: <%=df.format(p.getSellingPrice())%></h4>
                                                    <input type="hidden" value="<%=df.format(p.getSellingPrice())%>" id="uprice"/>
                                                    <input type="hidden" name="id" id="pid" value="<%=p.getIdproduct()%>">
                                                    <input type="hidden" value="<%=url%>" name="url"/>
                                                    <input type="hidden" value="1" name="qty">
                                                    <%
                                                        if (us == null || us.getUserType().getUserType().equals("user")) {
                                                    %>
                                                    <button type="submit" class="btn btn-primary" >
                                                        Add to cart
                                                        <span class="glyphicon glyphicon-shopping-cart"> </span>
                                                    </button>
                                                    <%
                                                        }
                                                    %>
                                                </div>
                                            </div>
                                        </div></form>
                                        <%
                                            }
                                        %>
                                    </div>
                                    <br/>
                                    <div class="col-sm-12 row">
                                        <div class="col-sm-4"></div>
                                        <div class="col-sm-4">
                                            <ul class="pagination">

                                                <%
                                                    for (int page_id_pg = 0; page_id_pg < (l.size() / noofpro_forPage) + wadi_page_eka; page_id_pg++) {
                                                        if (thispage == page_id_pg) {
                                                %>
                                                <li class="active">
                                                    <a  href="Products_SERCH_2.jsp?page=<%="" + page_id_pg%>">
                                                        <%=(page_id_pg + 1) + ""%>
                                                    </a>   </li>
                                                    <%
                                                    } else {
                                                    %>
                                                <li>
                                                    <a  href="Products_SERCH_2.jsp?catid=<%=cat_id%>&serchtxt=<%=serchtxt%>&page=<%="" + page_id_pg%>">
                                                        <%=(page_id_pg + 1) + ""%>
                                                    </a>  </li>
                                                    <%
                                                                }
                                                            }}else{
%>
                                                    
                                             
                                                <center>  <img src="img/no-result-found.jpg" alt=""/></center>
                                                
                                                
                                                
                                                
                                                <%


}
                                                            se.clear();
                                                            se.close();
                                                        } catch (Exception ex) {
    //                                                        RequestDispatcher rd = request.getRequestDispatcher("Products_SERCH_2.jsp?catid=0&serchtxt=");
    //                                                        rd.forward(request, response);
                                                            ex.printStackTrace();
                                                        }
                                                        ss.clear();
                                                        ss.close();
                                                    %>
                                            </ul>
                                        </div>
                                        <div class="col-sm-4"></div></div>
                                </div>
                                <br/>
                                 <%@include file="include/fotter.jsp" %>
                            </div> 

                            <script src="js/jquery.js"></script>
                            <script src="js/jquery-1.9.1.min.js"></script>
                            <script src="js/bootstrap.min.js"></script>
                           


                            </body>


                            </html>
