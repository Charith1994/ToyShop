package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import sqlcon.db;

public final class Add_005fnew_005ftoy_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body class=\"blurBg-false\" style=\"background-color:#EBEBEB\">\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("<!-- Start Formoid form-->\n");
      out.write("\n");

    String sql="select * from category ";
sqlcon.db db=new db();
ResultSet rs=db.getdata(sql);


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<form action=\"product_save\" enctype=\"multipart/form-data\" class=\"formoid-metro-cyan\" style=\"background-color:#FFFFFF;font-size:14px;font-family:'Open Sans','Helvetica Neue','Helvetica',Arial,Verdana,sans-serif;color:#666666;max-width:480px;min-width:150px\" method=\"post\"><div class=\"title\"><h2>Add New Product</h2></div>\n");
      out.write("\t<div class=\"element-input\"><label class=\"title\">Product Name</label><input class=\"large\" type=\"text\" name=\"pname\" /></div>\n");
      out.write("\t<div class=\"element-select\"><label class=\"title\">Category</label><div class=\"large\"><span><select name=\"selectcat\" >\n");

while(rs.next()){


      out.write("\n");
      out.write("<option value=\"");
      out.print(rs.getString("idcategory"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("name"));
      out.write("</option>}\n");
 } 
      out.write("\n");
      out.write("\t\t</select><i></i></span></div></div>\n");
      out.write("\t<div class=\"element-input\"><label class=\"title\">Pakage weight</label><input class=\"large\" type=\"text\" name=\"pakweight\"  /></div>\n");
      out.write("\t<div class=\"element-textarea\"><label class=\"title\">Discription</label><textarea class=\"medium\" name=\"discription\" cols=\"20\" rows=\"5\" ></textarea></div>\n");
      out.write("       \t<div class=\"element-file\"><label class=\"title\">Choose Image</label><label class=\"large\" ><div class=\"button\">Choose File</div><input type=\"file\" class=\"file_input\" name=\"img\" /><div class=\"file_text\">No file selected</div></label></div>\n");
      out.write("\t<div class=\"element-number\"><label class=\"title\">Warrenty(Days)</label><input class=\"large\" type=\"text\" min=\"0\" max=\"30\" name=\"warday\"  value=\"\"/></div>\n");
      out.write("\t<div class=\"element-input\"><label class=\"title\">Buying Price</label><input class=\"large\" type=\"text\" name=\"b_price\" /></div>\n");
      out.write("\t<div class=\"element-input\"><label class=\"title\">Selling Price</label><input class=\"large\" type=\"text\" name=\"s_price\" /></div>\n");
      out.write("<div class=\"submit\"><input type=\"submit\" value=\"Submit\"/></div></form>\n");
      out.write("<script type=\"text/javascript\" src=\"form_styles/formoid1/formoid-metro-cyan.js\"></script>\n");
      out.write("<!-- Stop Formoid form-->\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"form_styles//formoid1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        \n");
      out.write("  \n");
      out.write("    <link href=\"fonts/font-awesome.min.css\" rel=\"stylesheet\" >\n");
      out.write("       <link href=\"fonts/font-awesome.css\" rel=\"stylesheet\" >\n");
      out.write("       <link rel=\"stylesheet\" href=\"form_styles/formoid1/formoid-metro-cyan.css\" type=\"text/css\">\n");
      out.write("\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("</body>\n");
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
