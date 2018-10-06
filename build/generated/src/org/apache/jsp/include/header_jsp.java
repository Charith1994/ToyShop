package org.apache.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.Query;
import DB.Category;
import DB.Adress;
import DB.CartReg;
import DB.User;
import java.text.DecimalFormat;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import cls.cart;
import products_management.cartOp;
import org.hibernate.Session;
import java.util.List;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    function chngcat(cat) {\r\n");
      out.write("        alert(cat);\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function forgot(){\r\n");
      out.write("       \r\n");
      out.write("        var mail=document.getElementById(uemaiPwF).value;\r\n");
      out.write("                \r\n");
      out.write("         alert(mail);\r\n");
      out.write("        $.post(\"forgotpassword\", {uemail : mail}, function (data) {\r\n");
      out.write("            \r\n");
      out.write("            alert(\"Successfully sent your email. Plese check your email. Use the given password for Loging. And reset the Password after loging\");\r\n");
      out.write("            alert(data);\r\n");
      out.write("             $('#myModal2').modal('show');\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    }\r\n");
      out.write("    function emailsent() {\r\n");
      out.write("        $.post(\"EmailVeryficatio\", \"\", function (data) {\r\n");
      out.write("            alert(\"Successfully sent your email. Plese check your email.\");\r\n");
      out.write("            \r\n");
      out.write("             $('#myModal2').modal('show');\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function count() {\r\n");
      out.write("\r\n");
      out.write("        var c = document.getElementById(\"bellcount\").innerHTML;\r\n");
      out.write("        c++;\r\n");
      out.write("\r\n");
      out.write("        document.getElementById(\"bellcount\").innerHTML = c;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");

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


      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-inverse   navbar-fixed-top bg-primary\"  role=\"navigation\" >\r\n");
      out.write("    <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> </button>\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"home.jsp\">Toy</a> </div>\r\n");
      out.write("    <!-- Top Menu Items -->\r\n");
      out.write("\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("        <ul class=\"nav navbar-nav\">\r\n");
      out.write("            <li class=\"active\">\r\n");
      out.write("                <a href=\"#\">Link</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"Products_SERCH_2.jsp\">Prroduct</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Categories<strong class=\"caret\"></strong></a>\r\n");
      out.write("                    ");
                        Session ss = Connection.conn.getSessionFactory().openSession();
                        Query q = ss.createQuery("from Category c");
                        List<Category> catlist = q.list();
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"Products_SERCH_2.jsp\" >All</a>\r\n");
      out.write("                    </li>              \r\n");
      out.write("                    ");
 for (int i = 0; i < catlist.size(); i++) {
                            Category cat = catlist.get(i);

                    
      out.write("\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a onclick =\"chngcat(vat)\"  href=\"Products_SERCH_2.jsp?catid=");
      out.print(cat.getIdcategory());
      out.write("&serchtxt=");
      out.print(serchtxt2);
      out.write('"');
      out.write('>');
      out.print(cat.getName());
      out.write("</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <form class=\"navbar-form navbar-left\" action=\"Products_SERCH_2.jsp\" role=\"search\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.print(cid);
      out.write("\" name=\"catid\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"serchtxt\" value=\"");
      out.print(serchtxt2);
      out.write("\">\r\n");
      out.write("            </div> \r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-default\">\r\n");
      out.write("                Search\r\n");
      out.write("            </button>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");

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

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
            DecimalFormat df = new DecimalFormat("##0.00");
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

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <ul class=\"nav navbar-right top-nav\">\r\n");
      out.write("\r\n");
      out.write("            <!--  cart dropdown beging -->\r\n");
      out.write("\r\n");
      out.write("            ");
          if (us == null || us.getUserType().getUserType().equals("user")) {
            
      out.write("\r\n");
      out.write("            <li class=\"dropdown\"> <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-cart-arrow-down\" ><span id=\"cartcount\" class=\"badge pull-right\">");
      out.print(items);
      out.write("</span></i> <b class=\"caret\"></b></a>\r\n");
      out.write("                <ul class=\"dropdown-menu message-dropdown\">\r\n");
      out.write("                    ");


                        //session cart  
                        if (sescart_exsist) {
                            List<cart> n = cop.getArrayData();

                            ss = Connection.conn.getSessionFactory().openSession();

                            for (cart ni : n) {
                                Criteria cc = ss.createCriteria(DB.Product.class);
                                cc.add(Restrictions.eq("idproduct", ni.getId()));
                                DB.Product lg = (DB.Product) cc.uniqueResult();

                    
      out.write("\r\n");
      out.write("                    <li class=\"message-preview\"> <a href=\"#\">\r\n");
      out.write("                            <div class=\"media\"> <span class=\"pull-left\"> <img class=\"media-object\" width=\"123\" height=\"123\" src=\"");
      out.print(lg.getImage());
      out.write("\" alt=\"\"> </span>\r\n");
      out.write("                                <div class=\"media-body\">\r\n");
      out.write("                                    <h5 class=\"media-heading\"><strong>");
      out.print( lg.getProduct());
      out.write("</strong> </h5>\r\n");
      out.write("                                    <!--<p class=\"small text-muted\"><i class=\"fa fa-clock-o\"></i> Available Qty:");
      out.print(lg.getQty());
      out.write("</p>-->\r\n");
      out.write("                                    <p>Qty:");
      out.print(ni.getQty());
      out.write("</p>\r\n");
      out.write("                                    <p>Price:");
      out.print(df.format(ni.getQty() * lg.getSellingPrice()));
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"btn-group\">\r\n");
      out.write("                                        <form action=\"invoice.jsp\">\r\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(ni.getId());
      out.write("\" name=\"pid\"/>\r\n");
      out.write("                                            <button type=\"submit\" class=\"btn-xs btn-primary\" >\r\n");
      out.write("                                                Pay\r\n");
      out.write("                                                <span class=\"glyphicon glyphicon-shopping-cart\"> </span>\r\n");
      out.write("\r\n");
      out.write("                                            </button></form>\r\n");
      out.write("                                        <form action=\"delete_from_cart\">\r\n");
      out.write("\r\n");
      out.write("                                            <button style=\"margin-top:  5px\" type=\"submit\" class=\"pull-right btn-xs btn-danger\" onclick=\"\">\r\n");
      out.write("                                                <input type=\"hidden\" value=\"");
      out.print(ni.getId());
      out.write("\" name=\"pid\"/>\r\n");
      out.write("                                                <input type=\"hidden\" value=\"");
      out.print(url);
      out.write("\" name=\"url\"/>\r\n");
      out.write("                                                Remove\r\n");
      out.write("                                                <span class=\"glyphicon glyphicon-remove\"> </span>\r\n");
      out.write("\r\n");
      out.write("                                            </button>\r\n");
      out.write("                                        </form> \r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a> </li>\r\n");
      out.write("\r\n");
      out.write("                    ");
 }
                        }
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");


                        //db cart
                        if (dbcart_exsist) {

                            for (CartReg ni : n2) {


                    
      out.write("\r\n");
      out.write("                    <li class=\"message-preview\"> <a href=\"#\">\r\n");
      out.write("                            <div class=\"media\"> <span class=\"pull-left\"> <img class=\"media-object\" width=\"123\" height=\"123\" src=\"");
      out.print(ni.getProduct().getImage());
      out.write("\" alt=\"\"> </span>\r\n");
      out.write("                                <div class=\"media-body\">\r\n");
      out.write("                                    <h5 class=\"media-heading\"><strong>");
      out.print( ni.getProduct().getProduct());
      out.write("</strong> </h5>\r\n");
      out.write("                                    <!--<p class=\"small text-muted\"><i class=\"fa fa-clock-o\"></i> Available Qty:");
      out.print(ni.getQty());
      out.write("</p>-->\r\n");
      out.write("                                    <p>Qty:");
      out.print(ni.getQty());
      out.write("</p>\r\n");
      out.write("                                    <p>Price:");
      out.print(df.format(Double.parseDouble(ni.getQty()) * ni.getProduct().getSellingPrice()));
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"btn-group\">\r\n");
      out.write("                                        <form action=\"invoice.jsp\">\r\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(ni.getIdcartReg());
      out.write("\" name=\"cart_reg_id\"/>   \r\n");
      out.write("                                            <button type=\"submit\" class=\"btn-xs btn-primary\" onclick=\"\">\r\n");
      out.write("                                                Purchase\r\n");
      out.write("                                                <span class=\"glyphicon glyphicon-shopping-cart\"> </span>\r\n");
      out.write("\r\n");
      out.write("                                            </button></form>\r\n");
      out.write("\r\n");
      out.write("                                        <form action=\"delete_from_dbcart\" method=\"POST\">\r\n");
      out.write("\r\n");
      out.write("                                            <button style=\"margin-top:  5px\" type=\"submit\" class=\"pull-right btn-xs btn-danger\" onclick=\"\">\r\n");
      out.write("                                                <input type=\"hidden\" value=\"");
      out.print(ni.getIdcartReg());
      out.write("\" name=\"cart_reg_id\"/>\r\n");
      out.write("                                                <input type=\"hidden\" value=\"");
      out.print(url);
      out.write("\" name=\"url\"/>\r\n");
      out.write("                                                Remove\r\n");
      out.write("                                                <span class=\"glyphicon glyphicon-remove\"> </span>\r\n");
      out.write("\r\n");
      out.write("                                            </button>\r\n");
      out.write("                                        </form> \r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </a> </li>\r\n");
      out.write("\r\n");
      out.write("                    ");
 }
                        }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");

                        if (items != 0) {
                    
      out.write("\r\n");
      out.write("                    <li class=\"message-footer\"> <a href=\"My_cart.jsp\">See All items</a> </li>\r\n");
      out.write("                        ");

                        } else {
                        
      out.write("\r\n");
      out.write("                    <li class=\"message-footer\"> <a href=\"#\">No Items</a> </li>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
  if (us == null) {
            
      out.write("\r\n");
      out.write("            <li>\r\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.print(url);
      out.write("\" name=\"url\"/>\r\n");
      out.write("         <!--//   <a href=\"login2.jsp?comeBackurl=");
      out.print(url);
      out.write("\">Login</a>-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <a  class=\"\" data-toggle=\"modal\" data-target=\"#myModal2\" href=\"#\">Loging</a>\r\n");
      out.write("\r\n");
      out.write("            </li>\r\n");
      out.write("            ");

            } else {


            
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <li class=\"dropdown\"> <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-bell\"> <span id=\"bellcount\" class=\"badge pull-right\">0</span></i><b class=\"caret\"></b></a>\r\n");
      out.write("                <ul class=\"dropdown-menu alert-dropdown\">\r\n");
      out.write("\r\n");
      out.write("                    ");
                        if (us != null & us.getActiveState().getIdactiveState() == 3) {

                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <li> \r\n");
      out.write("                        <script type=\"text/javascript\">\r\n");
      out.write("                            count();\r\n");
      out.write("                        </script>\r\n");
      out.write("                        <a href=\"#\" onclick=\"emailsent()\"><span class=\"label label-danger \">Confirm Email</span></a> </li>\r\n");
      out.write("                        ");
                            }
                            Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", us)).uniqueResult();
                            if (ad == null) {

                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <li> \r\n");
      out.write("                        <script type=\"text/javascript\">\r\n");
      out.write("                            count();\r\n");
      out.write("                        </script>\r\n");
      out.write("                        <a href=\"register_3.jsp?url=");
      out.print(url);
      out.write("\"><span class=\"label label-danger \">Config Address</span></a> </li>\r\n");
      out.write("                        ");
   }

                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li> <a href=\"#\">View All</a> </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            ");
    if (us.getUserType().getUserType().equals("admin")) {
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <li class=\"dropdown\"> <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-user\"></i> Welcome ");
      out.print(us.getFname());
      out.write("<b class=\"caret\"></b></a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li> <a href=\"uprofile.jsp\"><i class=\"fa fa-fw fa-user\"></i> Profile</a> </li>\r\n");
      out.write("                    <li> <a href=\"#\"><i class=\"fa fa-fw fa-envelope\"></i> Admin Panal</a> </li>\r\n");
      out.write("                    <li> <a href=\"#\"><i class=\"fa fa-fw fa-gear\"></i> Settings</a> </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li> <a  href=\"Logout\"><i class=\"fa fa-fw fa-power-off\"></i> Log Out</a> </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            ");

            } else {

            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <li class=\"dropdown\"> <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-user\"></i> Welcome ");
      out.print(us.getFname());
      out.write("<b class=\"caret\"></b></a>\r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                    <li> <a href=\"uprofile.jsp\"><i class=\"fa fa-fw fa-user\"></i> Profile</a> </li>\r\n");
      out.write("\r\n");
      out.write("                    <li> <a href=\"#\"><i class=\"fa fa-fw fa-gear\"></i> Settings</a> </li>\r\n");
      out.write("                    <li class=\"divider\"></li>\r\n");
      out.write("                    <li> <a  href=\"Logout\"><i class=\"fa fa-fw fa-power-off\"></i> Log Out</a> </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            ");

                    }

                }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<!--//loging modal-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"myModal2\" class=\"modal fade bs-example-modal-lg\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog modal-lg\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                <h4 class=\"modal-title\">Loging</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <form action=\"logingtest\" method=\"POST\">\r\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print(url);
      out.write("\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"exampleInputEmail1\">User Name or Email</label>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-user\"></span></span>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" placeholder=\"Enter User Email\" name=\"uemail\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"exampleInputPassword1\">Password</label>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-star\"></span></span>\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Password\" name=\"upass\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div><a data-toggle=\"modal\" data-target=\"#myModalemail\" href=\"#\">\r\n");
      out.write("                        <label>\r\n");
      out.write("                           Forget password\r\n");
      out.write("                        </label></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <hr/>\r\n");
      out.write("\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-lock\"></span>Login</button>\r\n");
      out.write("\r\n");
      out.write("                    or\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary\" onclick=\"location.href = 'register_1.jsp';\"><span class=\"glyphicon glyphicon-registration-mark\"></span>Register</button>\r\n");
      out.write("                    <p><br/></p> \r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div></div>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <div id=\"myModalemail\" class=\"modal fade bs-example-modal-lg\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog modal-lg\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                <h4 class=\"modal-title\">Forget password</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("               \r\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print(url);
      out.write("\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label for=\"exampleInputEmail1\">Enter Email</label>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-user\"></span></span>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"uemaiPwF\" placeholder=\"Enter User Email\" name=\"uemail\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("               \r\n");
      out.write("\r\n");
      out.write("              \r\n");
      out.write("                    <hr/>\r\n");
      out.write("\r\n");
      out.write("                    <button onclick=\"forgot()\"  class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-lock\"></span>Next</button>\r\n");
      out.write("\r\n");
      out.write("           \r\n");
      out.write("                 \r\n");
      out.write("                    <p><br/></p> \r\n");
      out.write("              \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
