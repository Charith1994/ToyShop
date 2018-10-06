package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_005f2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\"/>\r\n");
      out.write("        \r\n");
      out.write("         <link href=\"register_1.jsp\" type=\"text/javascript\"/>\r\n");
      out.write("         <script>\r\n");
      out.write("           \r\n");
      out.write("            \r\n");
      out.write("         </script>\r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body ng-app=\"myModule\" style=\"background: #bce8f1;\">\r\n");
      out.write("         ");

          
            String Fname=request.getParameter("fname");
            String Lname=request.getParameter("lname");
            String Email=request.getParameter("email");
            String Tel=request.getParameter("contactno");




          
         
      out.write("\r\n");
      out.write("        <p><br/></p>\r\n");
      out.write("       \r\n");
      out.write("       \r\n");
      out.write("        <div class=\"row\" ng_app=\"mymodule\">\r\n");
      out.write("            <div class=\"col-md-3\" ng-controller=\"myController\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    \r\n");
      out.write("                </div>    \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-6\">\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-body\">\r\n");
      out.write("                        <div class=\"page-header\" style=\"margin-top: 5px;\">\r\n");
      out.write("                            <h3>Register Here</h3>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <form class=\"form-horizontal\"  method=\"POST\" action=\"user_reg\">\r\n");
      out.write("                            <div class=\"form-group\"><label >a2</label></div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"fname\" value=\"");
      out.print(Fname);
      out.write("\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"lname\" value=\"");
      out.print(Lname);
      out.write("\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"email\" value=\"");
      out.print(Email);
      out.write("\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"contactno\" value=\"");
      out.print(Tel);
      out.write("\">\r\n");
      out.write("                              \r\n");
      out.write("                              <label for=\"inputConEmail3\" class=\"col-sm-5 control-label\">Set your account Security</label>\r\n");
      out.write("                          </div>\r\n");
      out.write("                           \r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                              <label for=\"inputun3\" class=\"col-sm-3 control-label\">User Name</label>\r\n");
      out.write("                                <div class=\"col-sm-9\">\r\n");
      out.write("                                    <div class=\"input-group\">\r\n");
      out.write("                                        <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-user\" id=\"basic-addon1\"></span></span>\r\n");
      out.write("                                    \r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"inputun3\" placeholder=\"User Name\" name=\"username\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"inputPassword3\" class=\"col-sm-3 control-label\">Password</label>\r\n");
      out.write("                                <div class=\"col-sm-9\">\r\n");
      out.write("                                    <div class=\"input-group\">\r\n");
      out.write("                                        <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-star\" id=\"basic-addon1\"></span></span>\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" id=\"inputPassword3\" placeholder=\"Password\" name=\"userpassword\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"inputConPassword3\" class=\"col-sm-3 control-label\">Conform Password</label>\r\n");
      out.write("                                <div class=\"col-sm-9\">\r\n");
      out.write("                                    <div class=\"input-group\">\r\n");
      out.write("                                        <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-star\" id=\"basic-addon1\"></span></span>\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" id=\"inputConPassword3\" placeholder=\"Conform Password\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                              <div class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("                                \r\n");
      out.write("                                 <button type=\"submit\" class=\"btn btn-primary\" \">Previous</button> \r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary\" \">Next</button>\r\n");
      out.write("                              </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <form >\r\n");
      out.write("                      \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("         <script src=\"js/jquery.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("     <script src=\"js/angular.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
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
