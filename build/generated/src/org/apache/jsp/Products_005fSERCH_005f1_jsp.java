package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import org.hibernate.criterion.Order;
import org.hibernate.Session;
import java.util.HashMap;
import java.util.Map;
import DB.ActiveState;
import java.text.DecimalFormat;
import java.util.List;
import org.hibernate.Criteria;
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

public final class Products_005fSERCH_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/include/header.jsp");
    _jspx_dependants.add("/include/fotter.jsp");
  }

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Toyz</title>\n");
      out.write("\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"fonts/font-awesome.min.css\" rel=\"stylesheet\" >\n");
      out.write("        <link href=\"fonts/font-awesome.css\" rel=\"stylesheet\" >\n");
      out.write("        <link href=\"css/hover.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
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
      out.write("        var mail=document.getElementById(\"uemaiPwF\").value;\r\n");
      out.write("                \r\n");
      out.write("         alert(mail);\r\n");
      out.write("        $.post(\"forgotpassword\", {uemail : mail}, function (data) {\r\n");
      out.write("            \r\n");
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
      out.write("<!--            <li class=\"active\">\r\n");
      out.write("                <a href=\"#\">Link</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"Products_SERCH_2.jsp\">Prroduct</a>\r\n");
      out.write("            </li>-->\r\n");
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
      out.write("<!--                    <li> <a href=\"#\"><i class=\"fa fa-fw fa-envelope\"></i> Admin Panal</a> </li>\r\n");
      out.write("                    <li> <a href=\"#\"><i class=\"fa fa-fw fa-gear\"></i> Settings</a> </li>-->\r\n");
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
      out.write("<!--                    <li> <a href=\"#\"><i class=\"fa fa-fw fa-gear\"></i> Settings</a> </li>-->\r\n");
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
      out.write("                    <button onclick=\"forgot()\" data-dismiss=\"modal\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-lock\"></span>Next</button>\r\n");
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
      out.write("\n");
      out.write("\n");
      out.write("        ");

             System.out.println("awaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            Session se = Connection.conn.getSessionFactory().openSession();
            HashMap<Integer, DB.Product> map = new HashMap<Integer, DB.Product>();

            Criteria pro = se.createCriteria(DB.Product.class);
            
            try {

               
//                if (us == null || !us.getUserType().getUserType().equals("admin")) {
//                    ActiveState act = (ActiveState) se.load(ActiveState.class, 1);
////                    pro.add(Restrictions.eq("activeState", act));
//
//                } else {
//                  //   pro.addOrder(Order.asc("activeState"));
//                  pro.addOrder(Order.asc("qty"));
//
//                }
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
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div    id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid\"><br/>\n");
      out.write("                <div class=\"row col-lg-12\">\n");
      out.write("\n");
      out.write("                    ");

                        
                       
                        if(l.size()>0){
                        for (int pro_list_id = noofpro_forPage * page_id; pro_list_id < (noofpro_forPage + (page_id * noofpro_forPage))+1; pro_list_id++) {
                            DB.Product p;
//
                            if (us == null || (us != null && !(us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("superAdmin")))) {
                                if (l.get(pro_list_id).getQty() <= 0) {
                                    l.remove(pro_list_id);
                                }
                            }
                            try {

                                p = l.get(pro_list_id);

                            } catch (Exception eeee) {
                                //  eeee.printStackTrace();
                                break;

                            }
//}

                    
      out.write("\n");
      out.write("                    <!--\"-->\n");
      out.write("                    <form  method=\"GET\" action=\"sescart\" >\n");
      out.write("                        <div class=\"col-sm-3\">\n");
      out.write("                            ");
                               if (us != null && !us.getUserType().getUserType().equals("user")) {
                                    if ((p.getActiveState().getIdactiveState() == 1 && p.getQty() >= 10)) {     
      out.write("\n");
      out.write("                            <div class=\"panel panel-primary\"  >\n");
      out.write("                                ");
  } else if (p.getActiveState().getIdactiveState() == 1 && p.getQty() == 0) {     
      out.write("\n");
      out.write("                                <div class=\"panel panel-default\"  >\n");
      out.write("                                    ");
  } else if (p.getActiveState().getIdactiveState() == 1 && p.getQty() <= 10) {     
      out.write("\n");
      out.write("                                    <div class=\"panel panel-warning\"  >\n");
      out.write("                                        ");
  } else {     
      out.write("\n");
      out.write("                                        <div class=\"panel panel-danger\"  >\n");
      out.write("                                            ");

                                                }
                                            } else {
                                            
      out.write("\n");
      out.write("                                            <div class=\"panel panel-primary\"  >\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                                <div class=\"panel-heading\">\n");
      out.write("                                                    <h3 class=\"panel-title\">");
      out.print( p.getProduct());
      out.write("</h3>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"panel-body\" >\n");
      out.write("                                                    <div class=\"hovereffect\">\n");
      out.write("                                                        <img class=\"img-responsive\" src=\"");
      out.print(p.getImage());
      out.write("\" alt=\"image here\" style=\"height: 150px; width: 200px;\" >\n");
      out.write("                                                        <div class=\"overlay\">\n");
      out.write("                                                            <h2>");
      out.print( p.getProduct());
      out.write("</h2>\n");
      out.write("                                                            <a class=\"info\" href=\"Product_view.jsp?pid=");
      out.print(p.getIdproduct());
      out.write("\">View More</a>\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <h4 id=\"tot\"> RS: ");
      out.print(df.format(p.getSellingPrice()));
      out.write("</h4>\n");
      out.write("                                                    <input type=\"hidden\" value=\"");
      out.print(df.format(p.getSellingPrice()));
      out.write("\" id=\"uprice\"/>\n");
      out.write("                                                    <input type=\"hidden\" name=\"id\" id=\"pid\" value=\"");
      out.print(p.getIdproduct());
      out.write("\">\n");
      out.write("                                                    <input type=\"hidden\" value=\"");
      out.print(url);
      out.write("\" name=\"url\"/>\n");
      out.write("                                                    <input type=\"hidden\" value=\"1\" name=\"qty\">\n");
      out.write("                                                    ");

                                                        if (us == null || us.getUserType().getUserType().equals("user")) {
                                                    
      out.write("\n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-primary\" >\n");
      out.write("                                                        Add to cart\n");
      out.write("                                                        <span class=\"glyphicon glyphicon-shopping-cart\"> </span>\n");
      out.write("                                                    </button>\n");
      out.write("                                                    ");

                                                        }
                                                    
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div></form>\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("                                    </div>}\n");
      out.write("                                    <br/>\n");
      out.write("                                    <div class=\"col-sm-12 row\">\n");
      out.write("                                        <div class=\"col-sm-4\"></div>\n");
      out.write("                                        <div class=\"col-sm-4\">\n");
      out.write("                                            <ul class=\"pagination\">\n");
      out.write("\n");
      out.write("                                                ");

                                                    for (int page_id_pg = 0; page_id_pg < (l.size() / noofpro_forPage) + wadi_page_eka; page_id_pg++) {
                                                        if (thispage == page_id_pg) {
                                                
      out.write("\n");
      out.write("                                                <li class=\"active\">\n");
      out.write("                                                    <a  href=\"Products_SERCH_1.jsp?page=");
      out.print("" + page_id_pg);
      out.write("\">\n");
      out.write("                                                        ");
      out.print((page_id_pg + 1) + "");
      out.write("\n");
      out.write("                                                    </a>   </li>\n");
      out.write("                                                    ");

                                                    } else {
                                                    
      out.write("\n");
      out.write("                                                <li>\n");
      out.write("                                                    <a  href=\"Products_SERCH_1.jsp?page=");
      out.print("" + page_id_pg);
      out.write("\">\n");
      out.write("                                                        ");
      out.print((page_id_pg + 1) + "");
      out.write("\n");
      out.write("                                                    </a>  </li>\n");
      out.write("                                                    ");

                                                                }
                                                            }}else{

      out.write("\n");
      out.write("                                                    \n");
      out.write("                                             \n");
      out.write("                                                <center>  <img src=\"img/no-result-found.jpg\" alt=\"\"/></center>\n");
      out.write("                                                \n");
      out.write("                                                \n");
      out.write("                                                \n");
      out.write("                                                \n");
      out.write("                                                ");



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
                                                    
      out.write("\n");
      out.write("                                            </ul>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-4\"></div></div>\n");
      out.write("                                </div>\n");
      out.write("                                <br/>\n");
      out.write("                                 ");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-inverse    bg-primary\"  role=\"navigation\" >\n");
      out.write("    <!-- Footer Section Starts -->\n");
      out.write("\t\t<footer id=\"footer-area\">\n");
      out.write("\t\t<!-- Footer Links Starts -->\n");
      out.write("\t\t\t<div class=\"footer-links\">\n");
      out.write("\t\t\t<!-- Container Starts -->\n");
      out.write("\t\t\t\t<div class=\"container\">\n");
      out.write("                                    <div class=\"row col-lg-12\">\n");
      out.write("\t\t\t\t\t<!-- Information Links Starts -->\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-6\">\n");
      out.write("\t\t\t\t\t\t\t<h1>Hot line:0112702754</h1>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<!--</div>-->\n");
      out.write("\t\t\t\t\t<!-- Information Links Ends -->\n");
      out.write("\t\t\t\t\t<!-- My Account Links Starts -->\n");
      out.write("\t\t\t\t\t\t<!--<div class=\"col-lg-3\">-->\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<!-- My Account Links Ends -->\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<!-- Customer Service Links Starts -->\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-3\">\n");
      out.write("<!--\t\t\t\t\t\t\t<h5>Service</h5>\n");
      out.write("\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"\">Contact Us</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("                                                        </ul>-->\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<!-- Customer Service Links Ends -->\n");
      out.write("\t\t\t\t\t<!-- Follow Us Links Starts -->\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<!-- Follow Us Links Ends -->\n");
      out.write("\t\t\t\t\t<!-- Contact Us Starts -->\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-3\">\n");
      out.write("\t\t\t\t\t\t\t<h5>Contact Us</h5>\n");
      out.write("                                                        <ul class=\"list\">\n");
      out.write("\t\t\t\t\t\t\t\t<li>Toy Shop</li>\n");
      out.write("\t\t\t\t\t\t\t\t<li>Colombo 05</li>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\tEmail: <a href=\"#\">playwithmetoyz@gmail.com</a>\n");
      out.write("\t\t\t\t\t\t\t\t</li>\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("                                    </div>\n");
      out.write("                                        \n");
      out.write("                                        \n");
      out.write("\t\t\t\t\t<!-- Contact Us Ends -->\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t<!-- Container Ends -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t<!-- Footer Links Ends -->\n");
      out.write("                </footer>\n");
      out.write("<!-- Copyright Area Starts -->\n");
      out.write("<center>\n");
      out.write("\t\t\t<div class=\"copyright\">\n");
      out.write("\t\t\t<!-- Container Starts -->\n");
      out.write("\t\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<!-- Starts -->\n");
      out.write("\t\t\t\t\t<p class=\"center-block\">\n");
      out.write("\t\t\t\t\t\t&nbsp; Copyright &copy; Toy Shop.All Rights Reserved.\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t<!-- Ends -->\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t<!-- Container Ends -->\n");
      out.write("                        </div>\n");
      out.write("</center>\n");
      out.write("</nav>\n");
      out.write("\t\t");
      out.write("\n");
      out.write("                            </div> \n");
      out.write("\n");
      out.write("                            <script src=\"js/jquery.js\"></script>\n");
      out.write("                            <script src=\"js/jquery-1.9.1.min.js\"></script>\n");
      out.write("                            <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </body>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </html>\n");
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
