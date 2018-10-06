package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.Session;
import DB.Province;
import java.util.List;

public final class register_005f3_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("<!--        <link href=\"css/bootstrap.css\" rel=\"stylesheet\"/>-->\r\n");
      out.write("        <!--<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\" rel=\"stylesheet\"/>-->\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("             function loadtown(){\r\n");
      out.write("               var pro=  document.getElementById(\"provinsel\").value;\r\n");
      out.write("                 $.post(\"loadTown\",{prov:pro},function (data){\r\n");
      out.write("                    \r\n");
      out.write("                     $(\"#twns\").html(data+\"\");\r\n");
      out.write("                 });\r\n");
      out.write("                 \r\n");
      out.write("             }\r\n");
      out.write("             \r\n");
      out.write("            \r\n");
      out.write("         </script>\r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("   <body class=\"blurBg-false\" style=\"background-color:#EBEBEB\">\r\n");

  //  String url=request.getParameter("url");
 DB.User us = (DB.User) request.getSession().getAttribute("loging");
 Session hbses=Connection.conn.getSessionFactory().openSession();
String url = request.getParameter("url");
if(us!=null){

      out.write("\r\n");
      out.write("\r\n");
      out.write("       <link href=\"form_styles/formoid1/formoid-metro-cyan.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<!-- Start Formoid form-->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"adress_files/formoid1/formoid-metro-cyan.css\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"adress_files/formoid1/jquery.min.js\"></script>\r\n");
      out.write("<form action=\"Save_address\" class=\"formoid-metro-cyan\" style=\"background-color:#FFFFFF;font-size:14px;font-family:'Open Sans','Helvetica Neue','Helvetica',Arial,Verdana,sans-serif;color:#666666;max-width:480px;min-width:150px\" method=\"GET\"><div class=\"title\"><h2>Configure Your Adress</h2></div>\r\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(url);
      out.write("\" name=\"url\">\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"element-address\">\r\n");
      out.write("\t<label class=\"title\">Address</label><br/>\r\n");
      out.write("       \r\n");
      out.write("        <span class=\"addr1\">\r\n");
      out.write("             <label class=\"subtitle\">House No</label>\r\n");
      out.write("            <input  type=\"text\" name=\"address[addr1]\" /></span>\r\n");
      out.write("           \r\n");
      out.write("\t<span class=\"addr2\">\r\n");
      out.write("            <label class=\"subtitle\">Address Line 2</label> \r\n");
      out.write("            <input  type=\"text\" name=\"address[addr2]\" />\r\n");
      out.write("\t</span>\r\n");
      out.write("           \r\n");
      out.write("        <span class=\"addr2\">\r\n");
      out.write("            <label class=\"subtitle\">Address Line 3</label>\r\n");
      out.write("            <input  type=\"text\" name=\"address[addr3]\" /></span>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"country\">\r\n");
      out.write("            <label class=\"subtitle\">Province</label>\r\n");
      out.write("            <select name=\"province\" id=\"provinsel\" onchange=\"loadtown()\">\r\n");
      out.write("\t");

          List<Province> province=hbses.createQuery("from Province").list();

        
      out.write("\r\n");
      out.write("        <option selected=\"selected\"   value=\"null\" >--- Select a Province ---</option>\r\n");
      out.write("               ");

                   for(Province p:province){
               
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                <option>\r\n");
      out.write("                    \r\n");
      out.write("                    ");
      out.print(p.getProvince());
      out.write("\r\n");
      out.write("                </option>\r\n");
      out.write("            ");

                }
            
      out.write("\r\n");
      out.write("            </select><i></i>\r\n");
      out.write("        </div>\r\n");
      out.write("\t\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"country\">\r\n");
      out.write("             <label class=\"subtitle\">Town</label>\r\n");
      out.write("            <select name=\"town\" id=\"twns\">\r\n");
      out.write("\t<option selected=\"selected\" value=\"\" disabled=\"disabled\">--- Select a Town ---</option>\r\n");
      out.write("        \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            </select>\r\n");
      out.write("            \r\n");
      out.write("       </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        </div><div> <i>   If you can't Find Your town here, that means our delivery service is not available in your area. set it N/A. We will contact you when you place order.</i></div>\r\n");
      out.write("<div class=\"submit\"><input type=\"submit\" value=\"Submit\"/></div></form>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"adress_files/formoid1/formoid-metro-cyan.js\"></script>\r\n");
      out.write("<!-- Stop Formoid form-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"form_styles/formoid1/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"form_styles/formoid1/formoid-metro-cyan.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");

    }else{
response.sendRedirect("login2.jsp?comeBackurl="+url);
}

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
