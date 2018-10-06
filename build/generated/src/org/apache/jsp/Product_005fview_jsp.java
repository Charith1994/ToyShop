package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.criterion.Projections;
import DB.Product;
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

public final class Product_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/include/header.jsp");
    _jspx_dependants.add("/include/modal.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"fonts/font-awesome.min.css\" rel=\"stylesheet\" >\n");
      out.write("        <link href=\"fonts/font-awesome.css\" rel=\"stylesheet\" >\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .sideimages{\n");
      out.write("                width: 75px;\n");
      out.write("                height: 75px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            .imagelist{\n");
      out.write("                padding-bottom: 20px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            function back() {\n");
      out.write("\n");
      out.write("                window.history.back();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function setqty0(pid) {\n");
      out.write("                $.post(\"setQty0\", {pid: pid}, function (data) {\n");
      out.write("                    document.getElementById(\"qty\").innerHTML = 0;\n");
      out.write("\n");
      out.write("\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function deact(pid) {\n");
      out.write("\n");
      out.write("\n");
      out.write("                $.post(\"deactive_product\", {pid: pid}, function (data) {\n");
      out.write("\n");
      out.write("                    location.reload();\n");
      out.write("\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
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
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            Product p = null;
            try {
                String pid = request.getParameter("pid");
                p = (Product) Connection.conn.getSessionFactory().openSession().load(Product.class, Integer.parseInt(pid));


        
      out.write("\n");
      out.write("\n");
      out.write("        <div    id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <a class=\"btn\" href=\"Products_SERCH_2.jsp?catid=0&serchtxt=\">Back to search</a>\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class='row'>\n");
      out.write("                            <div class=\"col-md-4\"></div>\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("\n");
      out.write("                                <div class=\"row \">\n");
      out.write("                                    <div class=\"largeImage\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <div style=\"border:1px solid #cccccc; margin-bottom: 2px;\">\n");
      out.write("                                            <img  id=\"zoom_01\" src=\"");
      out.print(p.getImage());
      out.write("\" data-zoom-image=\"\" class=\"sideimagesLage\"  width='400' height='300' alt='Daisy on the Ohoopee'>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div  id=\"gal\" > \n");
      out.write(" ");

                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("superAdmin"))) {
                                        
      out.write("\n");
      out.write("                                        <!--<span><a class=\"btn btn-sm btn-default glyphicon glyphicon-edit\" data-toggle=\"modal\" data-target=\"#imageModal\">Edit image</a></span>-->\n");
      out.write("\n");
      out.write("                                        ");
    }

                                        
      out.write("\n");
      out.write("<!--                                        <a style=\"border:1px solid #cccccc;\" data-image=\"\" data-zoom-image=\"\" ><img id=\"zoom_01\" class=\"sideimages\" src=\"img/PileOfToys_2014_03_24__12h38.jpg\" alt=\"...\"></a> \n");
      out.write("                                        <a style=\"border:1px solid black;\" data-image=\"\" data-zoom-image=\"\" ><img id=\"zoom_01\" class=\"sideimages\" src=\"img/PileOfToys_2014_03_24__12h38.jpg\" alt=\"...\"></a> -->\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <form  method=\"GET\" action=\"sescart\" >    \n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <h2>");
      out.print(p.getProduct());
      out.write("</h2>\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <div  class=\"form-group\">\n");
      out.write("                                        <span style=\"font-size: larger\">Category :</span>\n");
      out.write("                                        <span>");
      out.print(p.getCategory().getName());
      out.write("</span>\n");
      out.write("                                    </div> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <span class=\"label label-primary\" style=\"font-size: larger \">Rs: ");
      out.print(df.format(p.getSellingPrice()));
      out.write("</span>\n");
      out.write("                                        <input id=\"price\" type=\"hidden\" value=\"\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        ");

                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("admin"))) {
                                        
      out.write("\n");
      out.write("                                        <span><a class=\"btn btn-sm btn-default glyphicon glyphicon-edit \" data-toggle=\"modal\" data-target=\"#PriceModal\"></a></span>\n");
      out.write("                                        <br>\n");
      out.write("                                        <span><label>Buying price: rs:");
      out.print(p.getBuyingPrice() );
      out.write("</label>\n");
      out.write("                                        <a class=\"btn btn-sm btn-default glyphicon glyphicon-edit \" data-toggle=\"modal\" data-target=\"#BPriceModal\"></a></span>\n");
      out.write("                                        ");
    }

                                        
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6\"> </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div  class=\"col-md-12\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("\n");
      out.write("                                        <span style=\"font-size: large\"> Delivery:</span>\n");
      out.write("                                        ");
                                            if (us != null) {
                                                Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", us)).uniqueResult();

                                                if (ad != null) {
                                        
      out.write("\n");
      out.write("                                        <span class=\"\">RS: ");
      out.print(df.format(ad.getDistric().getDiliveryCost()));
      out.write("</span>\n");
      out.write("                                        ");
}
                                        } else {
                                        
      out.write("\n");
      out.write("                                        <a id=\"DC\" href=\"register_3.jsp?url=");
      out.print(url);
      out.write("\">Delivery cost added per District</a>\n");
      out.write("                                        ");
 } 
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"row \">\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-md-4\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-6\">\n");
      out.write("\n");
      out.write("                                    <div  class=\"form-group\">\n");
      out.write("                                        <span style=\"font-size: larger\">Quentity:</span>\n");
      out.write("                                        ");

                                            if (us == null || us.getUserType().getUserType().equals("user")) {
                                                if (p.getQty() > 0) {
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                        <select id=\"qtySelector\" style=\"min-width: 20%\" name=\"qty\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            ");

                                                for (int i = 1; i <= 10 && i <= p.getQty(); i++) {
                                            
      out.write("\n");
      out.write("                                            <option>");
      out.print(i);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("\n");
      out.write("                                        ");

                                        } else {
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                        Stock Currently unavailable\n");
      out.write("                                        ");

                                            }
                                        } else {
                                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <span id=\"qty\">");
      out.print(p.getQty());
      out.write("</span>\n");
      out.write("\n");
      out.write("                                        ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div  class=\"form-group\">\n");
      out.write("                                        <span style=\"font-size: larger\">Description :</span>\n");
      out.write("                                        <span>");
      out.print(p.getDiscription());
      out.write("</span>\n");
      out.write("\n");
      out.write("                                        ");

                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("admin"))) {
                                        
      out.write("\n");
      out.write("                                        <span><a class=\"btn btn-sm btn-default glyphicon glyphicon-edit\" data-toggle=\"modal\" data-target=\"#DescriptionModal\"></a></span>\n");
      out.write("\n");
      out.write("                                        ");
    }

                                        
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div  class=\"form-group\">\n");
      out.write("                                        <span style=\"font-size: larger\">Pakege Weight :</span>\n");
      out.write("                                        <span>");
      out.print( p.getPaketWeight());
      out.write("kg</span>\n");
      out.write("\n");
      out.write("                                        ");

                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("admin"))) {
                                        
      out.write("\n");
      out.write("                                        <span><a class=\"btn btn-sm btn-default glyphicon glyphicon-edit\" data-toggle=\"modal\" data-target=\"#weight\"></a></span>\n");
      out.write("\n");
      out.write("                                        ");
    }

                                        
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div  class=\"form-group\">\n");
      out.write("                                        <span style=\"font-size: larger\">Warrenty :</span>\n");
      out.write("                                        <span>");
      out.print(p.getWarenty());
      out.write(" day(s) *</span>\n");
      out.write("\n");
      out.write("                                        ");

                                            if (us != null && (us.getUserType().getUserType().equals("admin") || us.getUserType().getUserType().equals("admin"))) {
                                        
      out.write("\n");
      out.write("                                        <span><a class=\"btn btn-sm btn-default glyphicon glyphicon-edit\" data-toggle=\"modal\" data-target=\"#warrent\"></a></span>\n");
      out.write("\n");
      out.write("                                        ");
    }

                                        
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div  class=\"form-group\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        ");
                                
                                            Criteria cri = ss.createCriteria(DB.InvoiceReg.class);
                                            cri.add(Restrictions.eq("product", p));
                                            cri.setProjection(Projections.sum("qty"));
                                            Object obj = cri.uniqueResult();

                                            long sum = 0;

                                            if (obj != null) {
                                                sum = (Long) obj;
                                            }
                                        
      out.write("\n");
      out.write("                                        <span>");
      out.print(sum);
      out.write("</span>\n");
      out.write("                                        <span >Sold</span>\n");
      out.write("                                        ");


                                        
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>   \n");
      out.write("                                <div class=\"col-md-6\"></div>   \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-md-8\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <input  type=\"hidden\" value=\"");
      out.print(p.getIdproduct());
      out.write("\" name=\"id\">\n");
      out.write("                                        <input  type=\"hidden\" value=\"");
      out.print(url);
      out.write("\" name=\"url\">\n");
      out.write("\n");
      out.write("                                        ");
     if (us == null || us.getUserType().getUserType().equals("user")) {

                                        
      out.write("\n");
      out.write("                                        <button id=\"addToCart\" class=\"button btn-primary btn-lg \" onclick=\"sescart()\"><span class=\"glyphicon glyphicon-shopping-cart\"> </span><span>  Add to Cart</span></button>\n");
      out.write("                                        ");
} else if (us != null && us.getUserType().getUserType().equals("admin")) {
                                        
      out.write("\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">Add new stock</button>\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-warning btn-lg\" onclick=\"setqty0(");
      out.print(pid);
      out.write(")\" >Set Qty 0</button>\n");
      out.write("\n");
      out.write("                                        ");

                                            if (p.getActiveState().getIdactiveState() == 1) {
                                        
      out.write("\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-danger btn-lg\" onclick=\"deact(");
      out.print(pid);
      out.write(")\">Deactive</button>\n");
      out.write("\n");
      out.write("                                        ");

                                        } else if (p.getActiveState().getIdactiveState() == 2) {
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-success btn-lg\" onclick=\"deact(");
      out.print(pid);
      out.write(")\">Active</button>\n");
      out.write("                                        ");

                                                }
                                            }

                                        
      out.write("\n");
      out.write("                                        ");

                                        
      out.write(" \n");
      out.write("                                    </div>\n");
      out.write("                                    *Conditions : Warrenty must claim within below days after Dilivery. we accept only issues cased by Dilivery or company Failiers. You have to carry it to ower any show room by your own for replacement.\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div> \n");
      out.write("                            <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!--modal for edit-->         \n");
      out.write("                    ");
      out.write("<script>\n");
      out.write("    \n");
      out.write("    function addstock(pid){\n");
      out.write("       \n");
      out.write("        var qty=document.getElementById(\"newqty\").value;\n");
      out.write("         $.post(\"Add_new_stock_batch\", {pid:pid,newqty:qty},function(data){\n");
      out.write("              alert(\"tadaa\");\n");
      out.write("        location.reload();\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    });\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("<!-- Add stock -->\n");
      out.write("\n");
      out.write("<div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\">\n");
      out.write("<!--        <form action=\"Add_new_stock_batch\">-->\n");
      out.write("            <!-- Modal content-->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\">Add New Stock</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>Enter here new quantity you wants to add</p>\n");
      out.write("                    <p><input class=\"form-control\" type=\"number\" min=\"0\"  id=\"newqty\"></p>\n");
      out.write("                </div>\n");
      out.write("                <p>\n");
      out.write("                   \n");
      out.write("                   \n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"submit\" data-dismiss=\"modal\" class=\"btn btn-primary\" onclick=\"addstock(");
      out.print(p.getIdproduct());
      out.write(")\">Add</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("<!--        </form>-->\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--Description-->\n");
      out.write("<form action=\"update_details\">\n");
      out.write("<div id=\"DescriptionModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\">\n");
      out.write("        \n");
      out.write("            <!-- Modal content-->\n");
      out.write("             \n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\">Edit Description</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>Enter here new quantity you wants to add</p>\n");
      out.write("                    <p><input class=\"form-control  \" type=\"text\" name=\"newDis\"></p>\n");
      out.write("                </div>\n");
      out.write("                <p><input type=\"hidden\" name=\"pid\" value=\"");
      out.print(p.getIdproduct());
      out.write("\">\n");
      out.write("\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" >Save</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        <!--</form>-->\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--Selling Price-->\n");
      out.write("\n");
      out.write("<div id=\"PriceModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\">\n");
      out.write("        <!--<form action=\"update_details\">-->\n");
      out.write("            <!-- Modal content-->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\">Price</h4>\n");
      out.write("                   \n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>Enter here new prices you wants to add</p>\n");
      out.write("                    <p><input class=\"form-control  \" type=\"text\" name=\"newPrice\"></p>\n");
      out.write("                </div>\n");
      out.write("                <p><input type=\"hidden\" name=\"pid\" value=\"");
      out.print(p.getIdproduct());
      out.write("\">\n");
      out.write("\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" >Save</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("<!--  </form>-->\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("                <!--Buying Price-->\n");
      out.write("\n");
      out.write("<div id=\"BPriceModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\">\n");
      out.write("        <!--<form action=\"update_details\">-->\n");
      out.write("            <!-- Modal content-->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\">Buying Price</h4>\n");
      out.write("                   \n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>Enter here new prices you wants to add</p>\n");
      out.write("                    <p><input class=\"form-control  \" type=\"text\" name=\"newbprice\"></p>\n");
      out.write("                </div>\n");
      out.write("                <p><input type=\"hidden\" name=\"pid\" value=\"");
      out.print(p.getIdproduct());
      out.write("\">\n");
      out.write("\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" >Save</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("<!--         </form>-->\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--weight-->\n");
      out.write("\n");
      out.write("<div id=\"weight\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\">\n");
      out.write("        <!--<form action=\"update_details\">-->\n");
      out.write("            <!-- Modal content-->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\">Weight</h4>\n");
      out.write("                     \n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>Enter weight</p>\n");
      out.write("                    <p><input class=\"form-control  \" type=\"text\" name=\"newWeight\"></p>\n");
      out.write("                </div>\n");
      out.write("                <p><input type=\"hidden\" name=\"pid\" value=\"");
      out.print(p.getIdproduct());
      out.write("\">\n");
      out.write("\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" >Save</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("<!--  </form>-->\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <!--warrenty-->\n");
      out.write("\n");
      out.write("<div id=\"warrent\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\">\n");
      out.write("        <!--<form action=\"update_details\">-->\n");
      out.write("            <!-- Modal content-->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\">Warrenty</h4>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>Enter here new warrenty date you wants to add</p>\n");
      out.write("                    <p><input class=\"form-control  \" type=\"text\" name=\"newarr\"></p>\n");
      out.write("                </div>\n");
      out.write("                <p><input type=\"hidden\" name=\"pid\" value=\"");
      out.print(p.getIdproduct());
      out.write("\">\n");
      out.write("\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" >Save</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("<!--  </form>-->\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <!--report problem-->\n");
      out.write("                \n");
      out.write("                <div id=\"report\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\">\n");
      out.write("        <!--<form action=\"update_details\">-->\n");
      out.write("            <!-- Modal content-->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\">Report </h4>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>Reason</p>\n");
      out.write("                    <p><input class=\"form-control  \" type=\"text\" name=\"reason\"></p>\n");
      out.write("                    <p>Description</p>\n");
      out.write("                    <p><textarea class=\"form-control  \"  name=\"Description\"></textarea></p>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" >Report</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("  <!--</form>-->\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</form>");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    \n");
      out.write("           <!--image-->\n");
      out.write("<form action=\"#\">\n");
      out.write("<div id=\"imageModal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\">\n");
      out.write("        \n");
      out.write("             Modal content\n");
      out.write("             \n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    <h4 class=\"modal-title\">Edit Image</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>Select here new image you wants to add</p>\n");
      out.write("                    <p><input class=\"form-control  \" type=\"file\" name=\"newimg\"></p>\n");
      out.write("                </div>\n");
      out.write("                <p><input type=\"hidden\" name=\"pid\" value=\"");
      out.print(p.getIdproduct());
      out.write("\">\n");
      out.write("\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" >Save</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("</div>         \n");
      out.write("                    \n");
      out.write("</form>              \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/jquery-1.9.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script> \n");
      out.write("\n");
      out.write("        ");
            } catch (NumberFormatException ex) {
                RequestDispatcher rd = request.getRequestDispatcher("Products_SERCH_2.jsp");
                rd.forward(request, response);
            } catch (NullPointerException ex) {
                out.write(ex + "");
                RequestDispatcher rd = request.getRequestDispatcher("Products_SERCH_2.jsp");
                rd.forward(request, response);
            }

        
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
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
