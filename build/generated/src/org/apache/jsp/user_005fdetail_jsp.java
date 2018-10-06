package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.criterion.Restrictions;
import DB.Adress;
import org.hibernate.Session;
import DB.Province;
import java.util.List;

public final class user_005fdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function updatePW() {\n");
      out.write("\n");
      out.write("                var pw1 = document.getElementById(\"pw1\").value;\n");
      out.write("                var pw2 = document.getElementById(\"pw2\").value;\n");
      out.write("\n");
      out.write("                if (pw2 !== \"\") {\n");
      out.write("                    if (pw1 === pw2) {\n");
      out.write("                        document.getElementById('pw2zz').setAttribute('class', 'label label-default');\n");
      out.write("                        document.getElementById('pw1zz').setAttribute('class', 'label label-default');\n");
      out.write("\n");
      out.write("\n");
      out.write("                    } else if (pw1 !== pw2) {\n");
      out.write("                        alert(\"passwords are does not match\");\n");
      out.write("                        document.getElementById('pw2zz').setAttribute('class', 'label label-danger');\n");
      out.write("//             \n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Fill the password fields before submit\");\n");
      out.write("                    document.getElementById('pw2zz').setAttribute('class', 'label label-danger');\n");
      out.write("                    document.getElementById('pw1zz').setAttribute('class', 'label label-danger');\n");
      out.write("\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("              \n");
      out.write("             function loadtown(){\n");
      out.write("               var pro=  document.getElementById(\"provinsel\").value;\n");
      out.write("                 $.post(\"loadTown\",{prov:pro},function (data){\n");
      out.write("                    \n");
      out.write("                     $(\"#twns\").html(data+\"\");\n");
      out.write("                 });\n");
      out.write("                 \n");
      out.write("             }\n");
      out.write("             \n");
      out.write("            \n");
      out.write("       \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
        DB.User u = (DB.User) session.getAttribute("loging");

            if (u != null) {

        
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                    <div class=\"col-lg-10  \">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <h2>\n");
      out.write("\n");
      out.write("                            Name: \n");
      out.write("                            ");
      out.print(u.getFname() + " " + u.getLname());
      out.write("\n");
      out.write("\n");
      out.write("                        </h2>\n");
      out.write("\n");
      out.write("                        <form action=\"user_reg\"   >      \n");
      out.write("                            <div class=\"col-lg-12  panel panel-info\">\n");
      out.write("\n");
      out.write("                                <div class=\"panel-heading\">Edit details </div> \n");
      out.write("                                <div class=\"panel-body\">\n");
      out.write("                                    <div class=\"col-lg-6\">\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group\" >\n");
      out.write("                                            <span class=\"label  label-default \" style=\"font-size: medium\">   First Name </span>\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <input class=\"form-control\" name=\"fname\" type=\"text\" value=\"");
      out.print(u.getFname());
      out.write("\" >\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\" >\n");
      out.write("                                            <span class=\"label label-default\" style=\"font-size: medium\">   Last Name </span>\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <input class=\"form-control\" name=\"lname\" type=\"text\" value=\"");
      out.print(u.getLname());
      out.write("\" >\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\" >\n");
      out.write("                                            <span class=\"label label-default\" style=\"font-size: medium\">   Email: </span>\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <input class=\"form-control\" name=\"email\" type=\"text\" value=\"");
      out.print(u.getEmail());
      out.write("\" >\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group\" >\n");
      out.write("                                            <span class=\"label label-default\" style=\"font-size: medium\">Land number: </span>\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <input class=\"form-control\" name=\"contactno\" type=\"text\" value=\"");
      out.print( u.getTelnumber());
      out.write("\"> \n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div>\n");
      out.write("                                            <input type=\"hidden\" name=\"userpassword\" value=\"");
      out.print( u.getUpassword());
      out.write("\">\n");
      out.write("                                            <input class=\"button\" type=\"submit\" value=\"Update\" />\n");
      out.write("                                        </div>  \n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                  \n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </form>\n");
      out.write("                                            \n");
      out.write("                            <div class=\"col-lg-12  panel panel-info\">\n");
      out.write("\n");
      out.write("                                <div class=\"panel-heading\">Edit details </div> \n");
      out.write("                                <div class=\"panel-body\">\n");
      out.write("                                    <form action=\"update_adress\">\n");
      out.write("                                    \n");
      out.write("                                    <div class=\"col-lg-6\">\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group\" >\n");
      out.write("                                            <span class=\"label  label-default \" style=\"font-size: medium\">   Select Province </span>\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <select name=\"province\" id=\"provinsel\" style=\"padding-left: 45px\" onchange=\"loadtown()\">\n");
      out.write("                                                    ");


                                                        Session ss = Connection.conn.getSessionFactory().openSession();
                                                        List<Province> province = ss.createQuery("from Province").list();
                                                        Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", u)).uniqueResult();
                                                    
      out.write("\n");
      out.write("                                                   \n");
      out.write("                                                           \n");
      out.write("                                                           \n");
      out.write("                                                           <option selected=\"selected\"    >");
      out.print(ad.getDistric().getProvince().getProvince());
      out.write("</option>\n");
      out.write("                                                    ");
                   for (Province p : province) {
                                                    
      out.write("\n");
      out.write("\n");
      out.write("                                                    <option>\n");
      out.write("\n");
      out.write("                                                        ");
      out.print(p.getProvince());
      out.write("\n");
      out.write("                                                    </option>\n");
      out.write("                                                    ");

                                                        }
                                                    
      out.write("\n");
      out.write("                                                </select><i></i>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <span class=\"label  label-default \" style=\"font-size: medium\">   Select Town </span>\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <select name=\"town\" id=\"twns\" style=\"padding-right:  45px\">\n");
      out.write("                                                    <option selected=\"selected\" >");
      out.print(ad.getDistric().getDistric());
      out.write("</option>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                </select><i></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\" >\n");
      out.write("                                            <span class=\"label label-default\" style=\"font-size: medium\">   First line </span>\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <input class=\"form-control\" name=\"address[addr1]\" type=\"text\" value=\"");
      out.print(ad.getLine1());
      out.write("\" >\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\" >\n");
      out.write("                                            <span class=\"label label-default\" style=\"font-size: medium\">   Second line </span>\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <input class=\"form-control\" name=\"address[addr2]\" type=\"text\" value=\"");
      out.print(ad.getLine2());
      out.write("\" >\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group\"  >\n");
      out.write("                                            <span class=\"label label-default\" style=\"font-size: medium\">Land number: </span>\n");
      out.write("                                            <div class=\"input-group\">\n");
      out.write("                                                <input class=\"form-control\" name=\"address[addr3]\" type=\"text\" value=\"");
      out.print(ad.getLine3());
      out.write("\"> \n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div>\n");
      out.write("<div>\n");
      out.write("                                           \n");
      out.write("                                            <input class=\"button\" type=\"submit\" value=\"Update\" />\n");
      out.write("                                        </div>  \n");
      out.write("\n");
      out.write("                                        </div>  \n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>  \n");
      out.write("                                    \n");
      out.write("                                    </form>\n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                                </div></div></div>                  \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                                            \n");
      out.write("                        <form action=\"passwordUp\">\n");
      out.write("                            <div class=\"col-lg-12  panel panel-info\">\n");
      out.write("\n");
      out.write("                                <div class=\"panel-heading\">Change password</div> \n");
      out.write("                                <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\" >\n");
      out.write("                                        <span id=\"pw1zz\" class=\"label label-default\" style=\"font-size: medium\">New password: </span>\n");
      out.write("                                        <div class=\"input-group\">\n");
      out.write("                                            <input class=\"form-control\" name=\"pw1\" id=\"pw1\" type=\"password\"> \n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\" >\n");
      out.write("                                        <span id=\"pw2zz\" class=\"label label-default\" style=\"font-size: medium\">Confirm new password: </span>\n");
      out.write("                                        <div class=\"input-group\">\n");
      out.write("                                            <span>\n");
      out.write("                                                <input class=\"form-control\" name=\"pw2\" id=\"pw2\" type=\"password\" > \n");
      out.write("                                                <img id=\"ok\" src=\"#\" style=\"width: 30px; height: 30px;\" hidden=\"true\"/>\n");
      out.write("\n");
      out.write("                                            </span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div>\n");
      out.write("\n");
      out.write("                                        <input class=\"button\" type=\"submit\" value=\"Update\" onmousemove=\"updatePW()\"/>\n");
      out.write("                                    </div>   \n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div></div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);

            }
        
      out.write("\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/jquery-1.9.1.min.js\"></script>\n");
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
