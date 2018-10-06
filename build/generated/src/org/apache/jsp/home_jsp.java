package org.apache.jsp;

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

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/include/header.jsp");
    _jspx_dependants.add("/with-jquery.html");
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <title>Toys</title>\r\n");
      out.write("\r\n");
      out.write("   <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <!-- Custom CSS -->\r\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom Fonts -->\r\n");
      out.write("        <link href=\"fonts/font-awesome.min.css\" rel=\"stylesheet\" >\r\n");
      out.write("       <link href=\"fonts/font-awesome.css\" rel=\"stylesheet\" >\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("  ");
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
      out.write("                        <label for=\"exampleInputEmail1\">User  Email</label>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"input-group\">\r\n");
      out.write("                            <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-user\"></span></span>\r\n");
      out.write("                            <input type=\"email\" class=\"form-control\" id=\"exampleInputEmail1\" placeholder=\"Enter User Email\" name=\"uemail\">\r\n");
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
      out.write("\r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("<!--    \r\n");
      out.write("        \r\n");
      out.write("         -->\r\n");
      out.write("         \r\n");
      out.write("       <div    id=\"page-wrapper\">\r\n");
      out.write("               \r\n");
      out.write("           \r\n");
      out.write("           <div class=\"container-fluid\">\r\n");
      out.write("               <div class=\"col-lg-3\"></div>\r\n");
      out.write("               \r\n");
      out.write("             <div class=\"jumbotron col-lg-12\">\r\n");
      out.write("                 <div class=\"container\">\r\n");
      out.write("                      ");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"padding:0px; margin:0px; background-color:#fff;font-family:Arial, sans-serif\">\r\n");
      out.write("\r\n");
      out.write("    <!-- #region Jssor Slider Begin -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Generated by Jssor Slider Maker Online. -->\r\n");
      out.write("    <!-- This demo works with jquery library -->\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jssor.slider.mini.js\"></script>\r\n");
      out.write("    <!-- use jssor.slider.debug.js instead for debug -->\r\n");
      out.write("    <script>\r\n");
      out.write("        jQuery(document).ready(function ($) {\r\n");
      out.write("            \r\n");
      out.write("            var jssor_1_options = {\r\n");
      out.write("              $AutoPlay: true,\r\n");
      out.write("              $SlideWidth: 600,\r\n");
      out.write("              $Cols: 2,\r\n");
      out.write("              $Align: 100,\r\n");
      out.write("              $ArrowNavigatorOptions: {\r\n");
      out.write("                $Class: $JssorArrowNavigator$\r\n");
      out.write("              },\r\n");
      out.write("              $BulletNavigatorOptions: {\r\n");
      out.write("                $Class: $JssorBulletNavigator$\r\n");
      out.write("              }\r\n");
      out.write("            };\r\n");
      out.write("            \r\n");
      out.write("            var jssor_1_slider = new $JssorSlider$(\"jssor_1\", jssor_1_options);\r\n");
      out.write("            \r\n");
      out.write("            //responsive code begin\r\n");
      out.write("            //you can remove responsive code if you don't want the slider scales while window resizing\r\n");
      out.write("            function ScaleSlider() {\r\n");
      out.write("                var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;\r\n");
      out.write("                if (refSize) {\r\n");
      out.write("                    refSize = Math.min(refSize, 800);\r\n");
      out.write("                    jssor_1_slider.$ScaleWidth(refSize);\r\n");
      out.write("                }\r\n");
      out.write("                else {\r\n");
      out.write("                    window.setTimeout(ScaleSlider, 30);\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            ScaleSlider();\r\n");
      out.write("            $(window).bind(\"load\", ScaleSlider);\r\n");
      out.write("            $(window).bind(\"resize\", ScaleSlider);\r\n");
      out.write("            $(window).bind(\"orientationchange\", ScaleSlider);\r\n");
      out.write("            //responsive code end\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        \r\n");
      out.write("        /* jssor slider bullet navigator skin 01 css */\r\n");
      out.write("        /*\r\n");
      out.write("        .jssorb01 div           (normal)\r\n");
      out.write("        .jssorb01 div:hover     (normal mouseover)\r\n");
      out.write("        .jssorb01 .av           (active)\r\n");
      out.write("        .jssorb01 .av:hover     (active mouseover)\r\n");
      out.write("        .jssorb01 .dn           (mousedown)\r\n");
      out.write("        */\r\n");
      out.write("        .jssorb01 {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("        }\r\n");
      out.write("        .jssorb01 div, .jssorb01 div:hover, .jssorb01 .av {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            /* size of bullet elment */\r\n");
      out.write("            width: 12px;\r\n");
      out.write("            height: 12px;\r\n");
      out.write("            filter: alpha(opacity=70);\r\n");
      out.write("            opacity: .7;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            border: #000 1px solid;\r\n");
      out.write("        }\r\n");
      out.write("        .jssorb01 div { background-color: gray; }\r\n");
      out.write("        .jssorb01 div:hover, .jssorb01 .av:hover { background-color: #d3d3d3; }\r\n");
      out.write("        .jssorb01 .av { background-color: #fff; }\r\n");
      out.write("        .jssorb01 .dn, .jssorb01 .dn:hover { background-color: #555555; }\r\n");
      out.write("\r\n");
      out.write("        /* jssor slider arrow navigator skin 13 css */\r\n");
      out.write("        /*\r\n");
      out.write("        .jssora13l                  (normal)\r\n");
      out.write("        .jssora13r                  (normal)\r\n");
      out.write("        .jssora13l:hover            (normal mouseover)\r\n");
      out.write("        .jssora13r:hover            (normal mouseover)\r\n");
      out.write("        .jssora13l.jssora13ldn      (mousedown)\r\n");
      out.write("        .jssora13r.jssora13rdn      (mousedown)\r\n");
      out.write("        */\r\n");
      out.write("        .jssora13l, .jssora13r {\r\n");
      out.write("            display: block;\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            /* size of arrow element */\r\n");
      out.write("            width: 40px;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            background: url('img/a13.png') no-repeat;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("        }\r\n");
      out.write("        .jssora13l { background-position: -10px -35px; }\r\n");
      out.write("        .jssora13r { background-position: -70px -35px; }\r\n");
      out.write("        .jssora13l:hover { background-position: -130px -35px; }\r\n");
      out.write("        .jssora13r:hover { background-position: -190px -35px; }\r\n");
      out.write("        .jssora13l.jssora13ldn { background-position: -250px -35px; }\r\n");
      out.write("        .jssora13r.jssora13rdn { background-position: -310px -35px; }\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div id=\"jssor_1\" style=\"position: relative; margin: 0 auto; top: 0px; left: 0px; width: 800px; height: 300px; overflow: hidden; visibility: hidden;\">\r\n");
      out.write("        <!-- Loading Screen -->\r\n");
      out.write("        <div data-u=\"loading\" style=\"position: absolute; top: 0px; left: 0px;\">\r\n");
      out.write("            <div style=\"filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;\"></div>\r\n");
      out.write("            <div style=\"position:absolute;display:block;background:url('img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div data-u=\"slides\" style=\"cursor: default; position: relative; top: 0px; left: 0px; width: 800px; height: 300px; overflow: hidden;\">\r\n");
      out.write("            <div data-p=\"112.50\" style=\"display: none;\">\r\n");
      out.write("                <img data-u=\"image\" src=\"img/002.jpg\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div data-p=\"112.50\" style=\"display: none;\">\r\n");
      out.write("                <img data-u=\"image\" src=\"img/003.jpg\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div data-p=\"112.50\" style=\"display: none;\">\r\n");
      out.write("                <img data-u=\"image\" src=\"img/004.jpg\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div data-p=\"112.50\" style=\"display: none;\">\r\n");
      out.write("                <img data-u=\"image\" src=\"img/005.jpg\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div data-p=\"112.50\" style=\"display: none;\">\r\n");
      out.write("                <img data-u=\"image\" src=\"img/006.jpg\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div data-p=\"112.50\" style=\"display: none;\">\r\n");
      out.write("                <img data-u=\"image\" src=\"img/007.jpg\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div data-p=\"112.50\" style=\"display: none;\">\r\n");
      out.write("                <img data-u=\"image\" src=\"img/008.jpg\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div data-p=\"112.50\" style=\"display: none;\">\r\n");
      out.write("                <img data-u=\"image\" src=\"img/009.jpg\" />\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Bullet Navigator -->\r\n");
      out.write("        <div data-u=\"navigator\" class=\"jssorb01\" style=\"bottom:16px;right:16px;\" data-autocenter=\"1\">\r\n");
      out.write("            <div data-u=\"prototype\" style=\"width:12px;height:12px;\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Arrow Navigator -->\r\n");
      out.write("        <span data-u=\"arrowleft\" class=\"jssora13l\" style=\"top:0px;left:30px;width:40px;height:50px;\" data-autocenter=\"2\"></span>\r\n");
      out.write("        <span data-u=\"arrowright\" class=\"jssora13r\" style=\"top:0px;right:30px;width:40px;height:50px;\" data-autocenter=\"2\"></span>\r\n");
      out.write("        <a href=\"http://www.jssor.com\" style=\"display:none\">Bootstrap Carousel</a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- #endregion Jssor Slider End -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write(" \r\n");
      out.write("                 </div>\r\n");
      out.write("                       \r\n");
      out.write("                   \r\n");
      out.write("             </div>\r\n");
      out.write("                    <div class=\"col-lg-1\"></div>\r\n");
      out.write("                    \r\n");
      out.write("           \r\n");
      out.write("            \r\n");
      out.write("             \r\n");
      out.write("               <br/>\r\n");
      out.write("               <br/>\r\n");
      out.write("               \r\n");
      out.write("               <div class=\"col-lg-2\"></div>\r\n");
      out.write("                   \r\n");
      out.write("                    <div class=\"row col-lg-12\">\r\n");
      out.write("                       \r\n");
      out.write("                    <div class=\"col-sm-3\">\r\n");
      out.write("                        <div class=\"panel panel-success\">\r\n");
      out.write("                            <div class=\"panel-heading\">\r\n");
      out.write("                                <h3 class=\"panel-title\">Sport Items</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-body\">\r\n");
      out.write("                                <div class=\"thumbnail\">\r\n");
      out.write("                                    \r\n");
      out.write("                                    <img src=\"img/bb-autograph-miniature-cricket-bat-165-inch.jpg\" alt=\"\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                Sports are most easy and convenient ways for the very good physical and mental exercise. It is very useful for growth and development of the individual as well as the country. We can never unseen the benefits and importance of playing the sports on regular basis. Sports provide a person the feeling of well being and encourage living a healthy life.\r\n");
      out.write("                            </div>\r\n");
      out.write("                             <div class=\"panel-footer\">\r\n");
      out.write("                                 <a href=\"Products_SERCH_2.jsp?catid=3\">\r\n");
      out.write("                             <span class=\"pull-left\">  View More</span>\r\n");
      out.write("                                    <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right \"></i></span>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                 </a>\r\n");
      out.write("                             </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                       \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-3\">\r\n");
      out.write("                        <div class=\"panel panel-primary\">\r\n");
      out.write("                            <div class=\"panel-heading\">\r\n");
      out.write("                                <h3 class=\"panel-title\">Soft Toys</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-body\">\r\n");
      out.write("                                <div class=\"thumbnail\">\r\n");
      out.write("                                   \r\n");
      out.write("                                    <img src=\"img/bear_PNG1185.png\" alt=\"\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                The teddy bear is normally a cub or baby bear.In Russia, bears were used as children's toys for many years before they became popular in the United States.The teddy bear in Russia has been the subject of folklore or stories for many years.Some people believe that teddy bears are only a children's toy but the bear is more than that. The teddy bear is used to comfort people and also to teach.\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-footer\">\r\n");
      out.write("                                \r\n");
      out.write("                                 <a href=\"Products_SERCH_2.jsp?catid=2\">\r\n");
      out.write("                             <span class=\"pull-left\">  View More</span>\r\n");
      out.write("                                    <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right \"></i></span>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                 </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                             \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-3\">\r\n");
      out.write("                        <div class=\"panel panel-yellow\">\r\n");
      out.write("                            <div class=\"panel-heading\">\r\n");
      out.write("                                <h3 class=\"panel-title\">Model Toys</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-body\">\r\n");
      out.write("                                <div class=\"thumbnail\">\r\n");
      out.write("                                  \r\n");
      out.write("                                    <img src=\"img/model-car.jpg\" alt=\"\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                A model vehicle or toy vehicle is a miniature representation of an automobile. Other miniature motor vehicles, such as trucks, buses, or even ATVs, etc. are often included in this general category. Because many miniature vehicles were originally aimed at children as playthings, there is no precise difference between a model car and a toy car, yet the word 'model' implies either assembly required or the accurate rendering of an actual vehicle at smaller scale.\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-footer\">\r\n");
      out.write("                                \r\n");
      out.write("                                <a href=\"Products_SERCH_2.jsp?catid=5\">\r\n");
      out.write("                             <span class=\"pull-left\">  View More</span>\r\n");
      out.write("                                    <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right \"></i></span>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                 </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-3\">\r\n");
      out.write("                        <div class=\"panel panel-default\">\r\n");
      out.write("                            <div class=\"panel-heading\">\r\n");
      out.write("                                <h3 class=\"panel-title\">Puzzles</h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-body\">\r\n");
      out.write("                                <div class=\"thumbnail\">\r\n");
      out.write("                                   \r\n");
      out.write("                                    <img src=\"img/download (2).jpg\" alt=\"\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                               A puzzle is a game, problem, or toy that tests a person's ingenuity or knowledge. In a puzzle, one is required to put pieces together in a logical way, in order to arrive at the correct solution of the puzzle. There are different types of puzzles for different ages, such as crossword puzzles, word-search puzzles, number puzzles, or logic puzzles.\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-footer\">\r\n");
      out.write("                                \r\n");
      out.write("                                 <a href=\"Products_SERCH_2.jsp?catid=4\">\r\n");
      out.write("                             <span class=\"pull-left\">  View More</span>\r\n");
      out.write("                                    <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right \"></i></span>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                 </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                        \r\n");
      out.write("                    \r\n");
      out.write("                \r\n");
      out.write("                </div>\r\n");
      out.write("               <div class=\"row col-lg-12\">\r\n");
      out.write("                   \r\n");
      out.write("                   <video  autoplay=\"\" loop=\"\" style=\"width: 1200px ; height:400px\" >\r\n");
      out.write("                                <source src=\"img/Toy Commercial 2014 - Toys R Us - Teenage Mutant Ninja Turtles & Curls - Come On.mp4\" type=\"video/mp4\">\r\n");
      out.write("                                Your browser does not support the <code>video</code> tag.\r\n");
      out.write("                            </video>\r\n");
      out.write("              \r\n");
      out.write("               </div>\r\n");
      out.write("               \r\n");
      out.write("                     </div>\r\n");
      out.write("                \r\n");
      out.write("             \r\n");
      out.write("                </div>\r\n");
      out.write("           \r\n");
      out.write("\r\n");
      out.write("                      ");
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
      out.write("\r\n");
      out.write("     \r\n");
      out.write("       \r\n");
      out.write("                   \r\n");
      out.write("   <script src=\"js/jquery.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
