<%-- 
    Document   : profit
    Created on : Dec 6, 2016, 12:07:34 AM
    Author     : ZEE
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Formatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.hibernate.criterion.Expression"%>
<%@page import="java.util.Date"%>
<%@page import="org.hibernate.criterion.Projections"%>
<%@page import="DB.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>BUY? Admin panal</title>

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


    <script>
        function print123(){
               
                window.print();
            }
        
        
//        function check_maxdate(){
//            
//            var date=Document.getElementById('date_to').value;
//            alert(date);
//        }
    </script>
</head>

<body>


    <%@include file="include/header.jsp" %>  


    <div id="page-wrapper">

        <div class="container-fluid">

            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-8">

                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i>  <a href="uprofile.jsp">Dashboard</a>
                        </li>
                        <li class="active"><span class="panel-title"><i class="fa fa-money"></i> My Profit </span></li>
                    </ol>
                </div>
                <div class="col-lg-4">
                  
                </div>
            </div>
            <!-- /.row -->

            <!-- date -->

            <%
                
                if(us.getUserType().getUserType().equals("admin")||us.getUserType().getUserType().equals("superAdmin")){}
                Date to = new Date();
                
                Date from = new Date();
                from.setDate(1);
                String dfrom = new SimpleDateFormat("yyyy-MM-dd").format(from);
                String dto = new SimpleDateFormat("yyyy-MM-dd").format(to);
                try {
                    if (!request.getParameter("from").equals(null)) {
                        dfrom = request.getParameter("from");
                        from = new SimpleDateFormat("yyyy-MM-dd").parse(dfrom);

                    }

                    if (!request.getParameter("to").equals(null)) {
                        dto = request.getParameter("to");
                        to = new SimpleDateFormat("yyyy-MM-dd").parse(dto);

                    }

                } catch (Exception e) {

                }

                List<DB.Product> pr = ss.createCriteria(Product.class).list();
                int noofpro_forPage = 8;
                int page_id = 0;

                int bck = page_id - 1;

                int wadi_tika = pr.size() % noofpro_forPage;
                int wadi_page_eka = 0;
                if (wadi_tika > 0) {
                    wadi_page_eka = 1;

                }

                try {
                    page_id = Integer.parseInt(request.getParameter("page"));

                } catch (Exception eee) {
                    page_id = 0;
                }

                if (page_id == 0) {
            %>

            <div class="row">
                <form   class="formoid-metro-cyan" style="background-color:#FFFFFF;font-size:14px;font-family:'Open Sans','Helvetica Neue','Helvetica',Arial,Verdana,sans-serif;color:#666666;" method="get">
                    <div class="element-date col-lg-12">
                        <div class="col-lg-3">
                            <label class="title">From</label><input class="large" data-format="yyyy-mm-dd" placeholder="<%=dfrom%>"  type="date" name="from"/>
                        </div>
                        <div class="col-lg-3">
                            <label class="title">To</label><input class="large" data-format="yyyy-mm-dd" type="date" placeholder="<%=dto%>" name="to" id="date_to"/>
                        </div>
                        <div class="col-lg-3"><div class="submit" ><input onmousemove="check_maxdate()" type="submit" value="Process"/></div></div>


                    </div>
                </form>
            </div>

            <%
                }
            %>
            <!-- /.row -->
            <%

            %>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-warning">

                        <div class="panel-body">
                            <div class="flot-chart">
                                <div class="diver" id="div_sd">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <tr>

                                                <th>Item Id</th>
                                                <th>Item Name</th>

                                                <th>Buying Price</th>
                                                <th>Selling Price</th>
                                                <th>Qty</th>
                                                <th>Total Sale</th>
                                                <th style="float: right">Net profit</th>


                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%                                                for (int pro_list_id = noofpro_forPage * page_id; pro_list_id < (noofpro_forPage + (page_id * noofpro_forPage)); pro_list_id++) {
                                                    DB.Product p;

                                                    try {

                                                        p = pr.get(pro_list_id);

                                                    } catch (Exception eeee) {
                                                        //  eeee.printStackTrace();
                                                        break;

                                                    }

                                                    from.setDate(1);
                                                    Criteria cri = ss.createCriteria(DB.InvoiceReg.class);
                                                    cri.add(Restrictions.eq("product", p));
                                                    cri.createAlias("invoice", "d");
                                                    cri.add(Restrictions.lt("d.date", to));
                                                    cri.add(Restrictions.ge("d.date", from));
                                                    cri.setProjection(Projections.sum("qty"));
                                                    Object obj = cri.uniqueResult();

                                                    long sum = 0;

                                                    if (obj != null) {
                                                        sum = (Long) obj;
                                                    }

                                                    


                                            %>
                                            <tr>

                                                <td><%=p.getIdproduct()%></td>
                                                <td><%=p.getProduct()%></td>

                                                <td><%=p.getBuyingPrice()%></td>
                                                <td><%=p.getSellingPrice()%></td>
                                                <td><%=sum%></td>
                                                <td ><%=p.getSellingPrice() * sum + "0"%></td>
                                                <td style="float: right"><%=(p.getSellingPrice() * sum) - (p.getBuyingPrice() * sum) + "0"%></td>
                                            </tr>
                                            <% }

                                                double net = 0.00;
                                                double tot = 0.00;
                                                int qty = 0;
                                                if (thispage == (pr.size() / noofpro_forPage) + wadi_page_eka - 1) {
                                                    for (Product p : pr) {

                                                        
                                                        Criteria cri = ss.createCriteria(DB.InvoiceReg.class);
                                                        cri.add(Restrictions.eq("product", p));
                                                        cri.createAlias("invoice", "d");
                                                        cri.add(Restrictions.lt("d.date", to));
                                                        cri.add(Restrictions.ge("d.date", from));
                                                        cri.setProjection(Projections.sum("qty"));
                                                        Object obj = cri.uniqueResult();

                                                        long sum = 0;

                                                        if (obj != null) {
                                                            sum = (Long) obj;
                                                        }

                                                        net += (p.getSellingPrice() * sum) - (p.getBuyingPrice() * sum);
                                                        tot += p.getSellingPrice() * sum;
                                                        qty += sum;
                                                    }


                                            %>


                                            <tr style="border: 2px #000 solid">
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <th>Total</th>
                                                <th><%=qty%></th>
                                                <th><%=tot%></th>
                                                <th style="float: right"><%=net + "0"%></th>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                         <div class="col-lg-3"></div> 
                <div class="col-lg-3"></div> 
                <div class="col-lg-3"></div> 
               
                <div class="col-lg-3">
                    <button style="float: right" class="btn btn-default" onclick="print123()"> print</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                                        
                                        
                                        
                                         <div class="row">
                <div class="col-lg-4"></div> 
                <div class="col-lg-4"></div> 
               
                <div class="col-lg-4">
                    
                </div>
            </div>
            <!-- /.row -->

            <div class="col-sm-12 row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                    <ul class="pagination">

                        <%
                            for (int page_id_pg = 0; page_id_pg < (pr.size() / noofpro_forPage) + wadi_page_eka; page_id_pg++) {
                                if (thispage == page_id_pg) {
                        %>
                        <li class="active">
                            <a  href="profit.jsp?page=<%="" + page_id_pg%>">
                                <%=(page_id_pg + 1) + ""%>
                            </a>   </li>
                            <%
                            } else {
                            %>
                        <li>
                            <a  href="profit.jsp?from=<%=dfrom%>&to=<%=dto%>&page=<%="" + page_id_pg%>">
                                <%=(page_id_pg + 1) + ""%>
                            </a>  </li>
                            <%
                                    }

                                }

                            %>
                    </ul>
                </div>
                <div class="col-sm-4"></div></div>
            <!-- /.row -->

            <div class="row"></div>
            <!-- /.row -->

            <!-- Morris Charts -->
            <div class="row"></div>
            <!-- /.row -->

            <div class="row"></div>
            <!-- /.row -->

           
            <!-- /.row -->

        </div>
        <!-- /.container-fluid -->
<%@include file="include/fotter.jsp" %> 
    </div>
    <!-- /#page-wrapper -->


    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <script src="form_styles/formoid1/formoid-metro-cyan.js" type="text/javascript"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script src="form_styles/formoid1/jquery.min.js" type="text/javascript"></script>


</body>

</html>
