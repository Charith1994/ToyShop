package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.Session;

public final class register_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\"/>\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        \r\n");
      out.write("<!--         <script>\r\n");
      out.write("             function subm(){\r\n");
      out.write("            var fname=document.getElementById(\"fname\");\r\n");
      out.write("            var lname=document.getElementById(\"lname\");\r\n");
      out.write("            var email=document.getElementById(\"email\");\r\n");
      out.write("            var myApp=angular.module(\"myModule\",[]);\r\n");
      out.write("var myController=function ($scope){\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    var arr={name:fname,\r\n");
      out.write("          lname:lname,\r\n");
      out.write("          email:emai\r\n");
      out.write("          };\r\n");
      out.write("    $scope.message=arr;\r\n");
      out.write("};\r\n");
      out.write(" myApp.controller(\"myController\",myController);\r\n");
      out.write("             }\r\n");
      out.write("         </script>-->\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("        ");

         
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("         \r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body style=\"background: #bce8f1;\">\r\n");
      out.write("        <p><br/></p>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-3\"></div>\r\n");
      out.write("            <div class=\"col-md-6\">\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-body\">\r\n");
      out.write("                        <div class=\"page-header\" style=\"margin-top: 5px;\">\r\n");
      out.write("                            <h3>Register Here</h3>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <form class=\"form-horizontal\" action=\"register_2.jsp\" method=\"POST\" >\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"inputfn3\" class=\"col-sm-2 control-label\">First Name</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <div class=\"input-group\">\r\n");
      out.write("                                        <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-user\" id=\"basic-addon1\"></span></span>\r\n");
      out.write("                                    \r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" value=\"\" id=\"fname\" placeholder=\"First Name\" name=\"fname\" required=\"required\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"inputfn3\" class=\"col-sm-2 control-label\">Last Name</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <div class=\"input-group\">\r\n");
      out.write("                                        <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-user\" id=\"basic-addon1\"></span></span>\r\n");
      out.write("                                    \r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" value=\"\" id=\"lname\" placeholder=\"Last Name\" name=\"lname\" required=\"required\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">Email</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <div class=\"input-group\">\r\n");
      out.write("                                        <span class=\"input-group-addon\" id=\"basic-addon1\">@</span>\r\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" value=\"\" id=\"email\" placeholder=\"Email\" name=\"email\" required=\"required\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            \r\n");
      out.write("                            \r\n");
      out.write("                            \r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"telnum\" class=\"col-sm-2 control-label\"> Contact no</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <div class=\"input-group\">\r\n");
      out.write("                                        <span class=\"input-group-addon\" id=\"basic-addon1\"><span class=\"glyphicon glyphicon-phone\"> </span></span>\r\n");
      out.write("                                        <input type=\"tel\" class=\"form-control\" value=\"\" id=\"connum\" placeholder=\"contactno\" name=\"contactno\" required=\"required\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                           \r\n");
      out.write("                          \r\n");
      out.write("                           \r\n");
      out.write("                            \r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <div class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-primary\"  onsubmit=\"subm()\" >Confirm</button>\r\n");
      out.write("                                    \r\n");
      out.write("                               \r\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-link\"><a href=\"login.jsp\">Log in</a></button>\r\n");
      out.write("                                    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                                </form>  \r\n");
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            \r\n");
      out.write("                                \r\n");
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("                  \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-3\"></div>\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("         <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\r\n");
      out.write("         <script src=\"js/jquery.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
