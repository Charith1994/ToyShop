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

public final class invoice_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/include/header.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Morris Charts CSS -->\n");
      out.write("        <link href=\"css/plugins/morris.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"fonts/font-awesome.min.css\" rel=\"stylesheet\" >\n");
      out.write("        <link href=\"fonts/font-awesome.css\" rel=\"stylesheet\" >\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            function payment(a){\n");
      out.write("               \n");
      out.write("        var p=a;\n");
      out.write("               document.getElementById(\"payment\").value=p;\n");
      out.write("               \n");
      out.write("             \n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
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
      out.write("function chngcat(cat){\r\n");
      out.write("   alert(cat) ;\r\n");
      out.write("    \r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
      out.write("                <a href=\"#\">Link</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"dropdown\">\r\n");
      out.write("                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Categories<strong class=\"caret\"></strong></a>\r\n");
      out.write("                ");

                Session ss = Connection.conn.getSessionFactory().openSession();
                Query q=ss.createQuery("from Category c");
               List<Category> catlist=q.list();

      out.write("\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                <ul class=\"dropdown-menu\">\r\n");
      out.write("                     <li>\r\n");
      out.write("                         <a href=\"Products_SERCH_2.jsp\" >All</a>\r\n");
      out.write("                    </li>              \r\n");
 for(int i=0; i<catlist.size(); i++){
           Category cat=catlist.get(i);


      out.write("\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a onclick =\"chngcat(vat)\"  href=\"Products_SERCH_2.jsp?catid=");
      out.print(cat.getIdcategory());
      out.write('"');
      out.write('>');
      out.print(cat.getName());
      out.write("</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                   ");

                   }
                   
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <form class=\"navbar-form navbar-left\" action=\"Products_SERCH_2.jsp\" role=\"search\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\">\r\n");
      out.write("            </div> \r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-default\">\r\n");
      out.write("                Submit\r\n");
      out.write("            </button>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
  
		DB.User us=null;
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
      out.write("            \r\n");
      out.write("      <!--  cart dropdown beging -->\r\n");
      out.write("      \r\n");
      out.write("      ");

      if(us==null ||us.getUserType().getUserType().equals("user")){
      
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

}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!--<li>\r\n");
      out.write("             0   <a href=\"register_1.jsp\">Register</a>\r\n");
      out.write("            </li>-->\r\n");
      out.write("\r\n");
      out.write("            ");
  if (us == null) {
            
      out.write("\r\n");
      out.write("            <li>\r\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.print(url);
      out.write("\" name=\"url\"/>\r\n");
      out.write("                <a href=\"login2.jsp?comeBackurl=");
      out.print(url);
      out.write("\">Login</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            ");

            } else {


            
      out.write("\r\n");
      out.write("            <li class=\"dropdown\"> <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-bell\"></i> <b class=\"caret\"></b></a>\r\n");
      out.write("                <ul class=\"dropdown-menu alert-dropdown\">\r\n");
      out.write("                    <!--        <li> <a href=\"#\">Alert Name <span class=\"label label-default\">Alert Badge</span></a> </li>\r\n");
      out.write("                            <li> <a href=\"#\">Alert Name <span class=\"label label-info\">Alert Badge</span></a> </li>-->\r\n");
      out.write("\r\n");
      out.write("                    ");
            if (us != null & us.getActiveState().getIdactiveState() == 3) {
                    
      out.write("\r\n");
      out.write("                    <li> <a href=\"#\"><span class=\"label label-danger \">Confirm Email</span></a> </li>\r\n");
      out.write("                        ");

                            }
                            Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", us)).uniqueResult();
                            if (ad == null) {


      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    <li> <a href=\"register_3.jsp?url=");
      out.print(url);
      out.write("\"><span class=\"label label-danger \">Config Address</span></a> </li>\r\n");
      out.write("                         ");
   }

                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <!--        <li> <a href=\"#\">Alert Name <span class=\"label label-danger\">Alert Badge</span></a> </li>-->\r\n");
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
      out.write("</nav>\r\n");
      out.write("<link href=\"../boostnew/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"../boostnew/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>");
      out.write("\n");
      out.write("        ");

            double tot = 0.00;
            if (us != null) {
                Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", us)).uniqueResult();
                if (ad != null) {
                    String cregid = request.getParameter("cart_reg_id");
int creg2=0;
                    List<CartReg> creg;

                    if (cregid == null) {
                        creg = ss.createCriteria(CartReg.class).add(Restrictions.eq("user", us)).list();
                            creg2=0;
                    } else {
                        creg = ss.createCriteria(CartReg.class).add(Restrictions.eq("idcartReg", Integer.parseInt(cregid))).list();
                    creg2=Integer.parseInt(cregid);
                    }


        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                <!-- Page Heading -->\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <h1 class=\"page-header\">Invoice</h1>\n");
      out.write("                        <ol class=\"breadcrumb\">\n");
      out.write("                            <li>\n");
      out.write("                                <i class=\"fa fa-dashboard\"></i>  <a href=\"index.html\">Dashboard</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"active\"><a href=\"My_cart.jsp\">Cart</a></li>\n");
      out.write("                            <li class=\"active\">Invoice</li>\n");
      out.write("                        </ol>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <!-- Flot Charts -->\n");
      out.write("                <div class=\"row\"></div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <div class=\"panel panel-primary\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <h3 class=\"panel-title\"><i class=\"fa fa-shopping-basket fa-0\"></i>    Invoice </h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"flot-chart\">\n");
      out.write("                                    <table width=\"95%\" class=\"table table-bordered table-hover table-striped\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th width=\"17%\">Iteam No</th>\n");
      out.write("                                                <th width=\"14%\">Iteam</th>\n");
      out.write("                                                <th width=\"9%\">Qty</th>\n");
      out.write("                                                <th width=\"19%\">Amount (Rs)</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("\n");
      out.write("                                            ");
  
                                                if(creg.size()>0){
                                                for (CartReg cr : creg) {
                                                    tot += Integer.parseInt(cr.getQty()) * cr.getProduct().getSellingPrice();
                                            
      out.write("     \n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>");
      out.print(cr.getProduct().getIdproduct());
      out.write("</td>\n");
      out.write("                                                <td> ");
      out.print(cr.getProduct().getProduct());
      out.write("</td>\n");
      out.write("                                                <td>");
      out.print(cr.getQty());
      out.write("</td>\n");
      out.write("                                                <td>RS:");
      out.print( df.format(Integer.parseInt(cr.getQty()) * cr.getProduct().getSellingPrice()));
      out.write("</td>\n");
      out.write("                                            </tr>\n");
      out.write("\n");
      out.write("                                            ");

                                                }}else{
response.sendRedirect("Products_SERCH.jsp");
}

                                            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("\n");
      out.write("                                    <div class=\"col-lg-12\">\n");
      out.write("                                         <div class=\"col-lg-4\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-lg-4 \">\n");
      out.write("                                            <div class=\"panel panel-danger\">\n");
      out.write("                                                <div class=\"panel-heading\"><span class=\" glyphicon glyphicon-check\">Select Payment Method Here   </span>    </div>\n");
      out.write("                                                <div class=\"panel-body\">\n");
      out.write("                                                    \n");
      out.write("                                                    <p>\n");
      out.write("                                                        This Service accept cash on dilivery. Please select card payment if you wan't to pay by card when dilivered. All VISA and MASTER card are accepted.\n");
      out.write("                                                        \n");
      out.write("                                                    </p>\n");
      out.write("                                                    \n");
      out.write("                                                   \n");
      out.write("                                                    \n");
      out.write("                                                    <span ><input type=\"radio\" name=\"pMethod\" value=\"Cash\" checked=\"checked\" onclick=\"payment(1)\"/>Pay with cash</span>\n");
      out.write("                                                    <span>   <input type=\"radio\" name=\"pMethod\" value=\"Card\" onclick=\"payment(2)\" />Pay with Card</span>\n");
      out.write("                                                    \n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            \n");
      out.write("                                        </div>\n");
      out.write("                                       \n");
      out.write("                                        <div class=\"col-lg-4\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            <table  width=\"208\" border=\"1\" cellpadding=\"2\" class=\"table table-bordered table-hover table-striped\">\n");
      out.write("\n");
      out.write("                                                <tr >\n");
      out.write("                                                    <td >Cost for Items</td>\n");
      out.write("                                                    <td><form id=\"form2\" name=\"form1\" method=\"post\" action=\"\">\n");
      out.write("                                                            RS: ");
      out.print(tot);
      out.write("\n");
      out.write("                                                        </form></td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr >\n");
      out.write("                                                    <td>Delivery Cost</td>\n");
      out.write("                                                    <td><form id=\"form3\" name=\"form1\" method=\"post\" action=\"\">\n");
      out.write("                                                            RS: ");
      out.print(df.format(ad.getDistric().getDiliveryCost()));
      out.write("\n");
      out.write("                                                            ");

                                                                tot += ad.getDistric().getDiliveryCost();

                                                            
      out.write("\n");
      out.write("                                                        </form></td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <th width=\"70%\" scope=\"col\">Total</th>\n");
      out.write("                                                    <th width=\"30%\" scope=\"col\"><form id=\"form1\" name=\"form1\" method=\"post\" action=\"\">\n");
      out.write("                                                            RS: ");
      out.print(df.format(tot));
      out.write("\n");
      out.write("                                                        </form></th>\n");
      out.write("                                                </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>&nbsp;</td>\n");
      out.write("\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <form action=\"Invoice_save\" >\n");
      out.write("                                                            <input type=\"hidden\" value=\"1\" name=\"payment\" id=\"payment\"/>\n");
      out.write("                                                            <input type=\"hidden\" value=\"");
      out.print(creg2
                                                                   );
      out.write("\" name=\"cart_reg_id\"/> \n");
      out.write("                                                            <button class=\"btn btn-primary\" > Purchase</button>\n");
      out.write("                                                        </form>\n");
      out.write("                                                    </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                </tr>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>  \n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <div class=\"row\"></div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <div class=\"row\"></div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <!-- Morris Charts -->\n");
      out.write("                <div class=\"row\"></div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <div class=\"row\"></div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-4\"></div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /#page-wrapper -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- /#wrapper -->\n");
      out.write("\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core JavaScript -->\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        ");

                } else {
                    response.sendRedirect("register_3.jsp?url=" + "My_cart.jsp");
                }
            } else {
                response.sendRedirect("login2.jsp?comeBackurl=" + "My_cart.jsp");
            }
        
      out.write("\n");
      out.write("    </body>\n");
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
