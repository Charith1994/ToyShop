<%@page import="org.hibernate.Query"%>
<%@page import="DB.Category"%>
<%@page import="DB.Adress"%>
<%@page import="DB.CartReg"%>
<%@page import="DB.User"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="cls.cart"%>
<%@page import="products_management.cartOp"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>

<script>

    function chngcat(cat) {
        alert(cat);

    }

    function forgot(){
       
        var mail=document.getElementById("uemaiPwF").value;
                
         alert(mail);
        $.post("forgotpassword", {uemail : mail}, function (data) {
            
            alert(data);
             $('#myModal2').modal('show');

        });
        
        
    }
    function emailsent() {
        $.post("EmailVeryficatio", "", function (data) {
            alert("Successfully sent your email. Plese check your email.");
            
             $('#myModal2').modal('show');

        });




    }

    function count() {

        var c = document.getElementById("bellcount").innerHTML;
        c++;

        document.getElementById("bellcount").innerHTML = c;

    }
</script>

<%
    String serchtxt2 = request.getParameter("serchtxt");
    String catid2 = request.getParameter("catid");

    int cid = 0;

    if (catid2 == null) {
        cid = 0;
    } else {
        cid = Integer.parseInt(catid2);
    }

    if (serchtxt2 == null) {
        serchtxt2 = "";
    }

%>
<nav class="navbar navbar-inverse   navbar-fixed-top bg-primary"  role="navigation" >
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <a class="navbar-brand" href="home.jsp">Toy</a> </div>
    <!-- Top Menu Items -->

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
<!--            <li class="active">
                <a href="#">Link</a>
            </li>
            <li>
                <a href="Products_SERCH_2.jsp">Prroduct</a>
            </li>-->
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories<strong class="caret"></strong></a>
                    <%                        Session ss = Connection.conn.getSessionFactory().openSession();
                        Query q = ss.createQuery("from Category c");
                        List<Category> catlist = q.list();
                    %>


                <ul class="dropdown-menu">
                    <li>
                        <a href="Products_SERCH_2.jsp" >All</a>
                    </li>              
                    <% for (int i = 0; i < catlist.size(); i++) {
                            Category cat = catlist.get(i);

                    %>
                    <li>
                        <a onclick ="chngcat(vat)"  href="Products_SERCH_2.jsp?catid=<%=cat.getIdcategory()%>&serchtxt=<%=serchtxt2%>"><%=cat.getName()%></a>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-left" action="Products_SERCH_2.jsp" role="search">
            <div class="form-group">
                <input type="hidden" value="<%=cid%>" name="catid">
                <input type="text" class="form-control" name="serchtxt" value="<%=serchtxt2%>">
            </div> 
            <button type="submit" class="btn btn-default">
                Search
            </button>
        </form>




        <%
            DB.User us = null;
            us = (DB.User) request.getSession().getAttribute("loging");
            int thispage;
            if (request.getParameter("page") == null) {
                thispage = 0;
            } else {

                thispage = Integer.parseInt(request.getParameter("page"));
            }

            StringBuffer s = request.getRequestURL();
            String url = s + "?page=" + thispage;

        %>

        <%            DecimalFormat df = new DecimalFormat("##0.00");
            HttpSession SES = request.getSession();
            int items = 0;
            boolean sescart_exsist = false;
            boolean dbcart_exsist = false;
            cartOp cop = (cartOp) SES.getAttribute("mycart");
            List<DB.CartReg> n2 = null;
            if (us != null) {
                dbcart_exsist = true;

                Criteria cc = ss.createCriteria(DB.CartReg.class);
                cc.add(Restrictions.eq("user", us));
                n2 = (List<DB.CartReg>) cc.list();
                items = n2.size();
            }
            if (cop != null) {

                items = cop.getArrayData().size();
                sescart_exsist = true;
            }

        %>


        <ul class="nav navbar-right top-nav">

            <!--  cart dropdown beging -->

            <%          if (us == null || us.getUserType().getUserType().equals("user")) {
            %>
            <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cart-arrow-down" ><span id="cartcount" class="badge pull-right"><%=items%></span></i> <b class="caret"></b></a>
                <ul class="dropdown-menu message-dropdown">
                    <%

                        //session cart  
                        if (sescart_exsist) {
                            List<cart> n = cop.getArrayData();

                            ss = Connection.conn.getSessionFactory().openSession();

                            for (cart ni : n) {
                                Criteria cc = ss.createCriteria(DB.Product.class);
                                cc.add(Restrictions.eq("idproduct", ni.getId()));
                                DB.Product lg = (DB.Product) cc.uniqueResult();

                    %>
                    <li class="message-preview"> <a href="#">
                            <div class="media"> <span class="pull-left"> <img class="media-object" width="123" height="123" src="<%=lg.getImage()%>" alt=""> </span>
                                <div class="media-body">
                                    <h5 class="media-heading"><strong><%= lg.getProduct()%></strong> </h5>
                                    <!--<p class="small text-muted"><i class="fa fa-clock-o"></i> Available Qty:<%=lg.getQty()%></p>-->
                                    <p>Qty:<%=ni.getQty()%></p>
                                    <p>Price:<%=df.format(ni.getQty() * lg.getSellingPrice())%></p>

                                    <div class="btn-group">
                                        <form action="invoice.jsp">
                                            <input type="hidden" value="<%=ni.getId()%>" name="pid"/>
                                            <button type="submit" class="btn-xs btn-primary" >
                                                Pay
                                                <span class="glyphicon glyphicon-shopping-cart"> </span>

                                            </button></form>
                                        <form action="delete_from_cart">

                                            <button style="margin-top:  5px" type="submit" class="pull-right btn-xs btn-danger" onclick="">
                                                <input type="hidden" value="<%=ni.getId()%>" name="pid"/>
                                                <input type="hidden" value="<%=url%>" name="url"/>
                                                Remove
                                                <span class="glyphicon glyphicon-remove"> </span>

                                            </button>
                                        </form> 
                                    </div>



                                </div>
                            </div>
                        </a> </li>

                    <% }
                        }%>

                    <%

                        //db cart
                        if (dbcart_exsist) {

                            for (CartReg ni : n2) {


                    %>
                    <li class="message-preview"> <a href="#">
                            <div class="media"> <span class="pull-left"> <img class="media-object" width="123" height="123" src="<%=ni.getProduct().getImage()%>" alt=""> </span>
                                <div class="media-body">
                                    <h5 class="media-heading"><strong><%= ni.getProduct().getProduct()%></strong> </h5>
                                    <!--<p class="small text-muted"><i class="fa fa-clock-o"></i> Available Qty:<%=ni.getQty()%></p>-->
                                    <p>Qty:<%=ni.getQty()%></p>
                                    <p>Price:<%=df.format(Double.parseDouble(ni.getQty()) * ni.getProduct().getSellingPrice())%></p>

                                    <div class="btn-group">
                                        <form action="invoice.jsp">
                                            <input type="hidden" value="<%=ni.getIdcartReg()%>" name="cart_reg_id"/>   
                                            <button type="submit" class="btn-xs btn-primary" onclick="">
                                                Purchase
                                                <span class="glyphicon glyphicon-shopping-cart"> </span>

                                            </button></form>

                                        <form action="delete_from_dbcart" method="POST">

                                            <button style="margin-top:  5px" type="submit" class="pull-right btn-xs btn-danger" onclick="">
                                                <input type="hidden" value="<%=ni.getIdcartReg()%>" name="cart_reg_id"/>
                                                <input type="hidden" value="<%=url%>" name="url"/>
                                                Remove
                                                <span class="glyphicon glyphicon-remove"> </span>

                                            </button>
                                        </form> 
                                    </div>



                                </div>
                            </div>
                        </a> </li>

                    <% }
                        }%>




                    <%
                        if (items != 0) {
                    %>
                    <li class="message-footer"> <a href="My_cart.jsp">See All items</a> </li>
                        <%
                        } else {
                        %>
                    <li class="message-footer"> <a href="#">No Items</a> </li>
                        <% } %>
                </ul>
            </li>

            <%
                }
            %>




            <%  if (us == null) {
            %>
            <li>
                <input type="hidden" value="<%=url%>" name="url"/>
         <!--//   <a href="login2.jsp?comeBackurl=<%=url%>">Login</a>-->


                <a  class="" data-toggle="modal" data-target="#myModal2" href="#">Loging</a>

            </li>
            <%
            } else {


            %>

            <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"> <span id="bellcount" class="badge pull-right">0</span></i><b class="caret"></b></a>
                <ul class="dropdown-menu alert-dropdown">

                    <%                        if (us != null & us.getActiveState().getIdactiveState() == 3) {

                    %>

                    <li> 
                        <script type="text/javascript">
                            count();
                        </script>
                        <a href="#" onclick="emailsent()"><span class="label label-danger ">Confirm Email</span></a> </li>
                        <%                            }
                            Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", us)).uniqueResult();
                            if (ad == null) {

                        %>

                    <li> 
                        <script type="text/javascript">
                            count();
                        </script>
                        <a href="register_3.jsp?url=<%=url%>"><span class="label label-danger ">Config Address</span></a> </li>
                        <%   }

                        %>


                    <li class="divider"></li>
                    <li> <a href="#">View All</a> </li>
                </ul>
            </li>

            <%    if (us.getUserType().getUserType().equals("admin")) {
            %>





            <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Welcome <%=us.getFname()%><b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li> <a href="uprofile.jsp"><i class="fa fa-fw fa-user"></i> Profile</a> </li>
<!--                    <li> <a href="#"><i class="fa fa-fw fa-envelope"></i> Admin Panal</a> </li>
                    <li> <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a> </li>-->
                    <li class="divider"></li>
                    <li> <a  href="Logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a> </li>
                </ul>
            </li>
            <%
            } else {

            %>






            <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Welcome <%=us.getFname()%><b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li> <a href="uprofile.jsp"><i class="fa fa-fw fa-user"></i> Profile</a> </li>

<!--                    <li> <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a> </li>-->
                    <li class="divider"></li>
                    <li> <a  href="Logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a> </li>
                </ul>
            </li>
            <%
                    }

                }%>


        </ul>






</nav>

<!--//loging modal-->




<div id="myModal2" class="modal fade bs-example-modal-lg" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Loging</h4>
            </div>
            <div class="modal-body">


                <form action="logingtest" method="POST">
                    <input type="hidden" value="<%=url%>">
                    <div class="form-group">
                        <label for="exampleInputEmail1">User  Email</label>

                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter User Email" name="uemail">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>

                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-star"></span></span>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="upass">
                        </div>
                    </div>

                    <div><a data-toggle="modal" data-target="#myModalemail" href="#">
                        <label>
                           Forget password
                        </label></a>
                    </div>
                    <hr/>

                    <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-lock"></span>Login</button>

                    or
                    <button type="button" class="btn btn-primary" onclick="location.href = 'register_1.jsp';"><span class="glyphicon glyphicon-registration-mark"></span>Register</button>
                    <p><br/></p> 
                </form>


            </div>
        </div>
    </div></div>
                    
                    
                    
                    <div id="myModalemail" class="modal fade bs-example-modal-lg" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Forget password</h4>
            </div>
            <div class="modal-body">


               
                    <input type="hidden" value="<%=url%>">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Enter Email</label>

                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" class="form-control" id="uemaiPwF" placeholder="Enter User Email" name="uemail">
                        </div>
                    </div>
               

              
                    <hr/>

                    <button onclick="forgot()" data-dismiss="modal" class="btn btn-primary"><span class="glyphicon glyphicon-lock"></span>Next</button>

           
                 
                    <p><br/></p> 
              


            </div>
        </div>
    </div></div>


