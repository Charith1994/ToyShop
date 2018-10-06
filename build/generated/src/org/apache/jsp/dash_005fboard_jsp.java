package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DB.User;
import SRC.user_reg;
import org.hibernate.Session;
import DB.ActiveState;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Projection;
import DB.Invoice;

public final class dash_005fboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("       \n");
      out.write("\n");

    User us=(User)request.getSession().getAttribute("loging");
    Session hbs=Connection.conn.getSessionFactory().openSession();
    if(us==null){
    response.sendRedirect("home.jsp");
    }else{


      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                <!-- Page Heading -->\n");
      out.write("\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <div class=\"alert alert-info alert-dismissable\">\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                            <i class=\"fa fa-info-circle\"></i>  <strong>New Promotions are available</strong></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                        <div class=\"panel panel-primary\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-xs-3\">\n");
      out.write("                                        <i class=\"fa fa-comments fa-5x\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-xs-9 text-right\">\n");
      out.write("                                        <div class=\"huge\">26</div>\n");
      out.write("                                        <div>Talks!</div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <a href=\"Messages.html\">\n");
      out.write("                                <div class=\"panel-footer\">\n");
      out.write("                                    <span class=\"pull-left\">View Details</span>\n");
      out.write("                                    <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                    <div class=\"clearfix\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        
                        ActiveState purchased=(ActiveState)hbs.load(ActiveState.class, 4);
                        ActiveState confirmed=(ActiveState)hbs.load(ActiveState.class, 5);
                        ActiveState dispatch=(ActiveState)hbs.load(ActiveState.class, 6);
                      
                        
                        Criteria cr = Connection.conn.getSessionFactory().openSession().createCriteria(Invoice.class);
                        int taskcount;
                        if(us.getUserType().getUserType().equals("admin")){
                         taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        }
                        else if(us.getUserType().getUserType().equals("user")){
                         cr.add(Restrictions.eq("user", us));
                          taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        
                        
                        }else if(us.getUserType().getUserType().equals("caller")){
                         cr.add(Restrictions.eq("activeState", purchased));
                           
                          taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        }else if(us.getUserType().getUserType().equals("deliveryManager")){
                          cr.add(Restrictions.eq("activeState", confirmed));
                          taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        }else if(us.getUserType().getUserType().equals("diliveryGuy")){
                          cr.add(Restrictions.eq("activeState", dispatch));
                          taskcount = cr.setProjection(Projections.rowCount()).uniqueResult().hashCode();
                        
                        
                        }else{
                        taskcount=0;
                        }
                        
                        
                       
                    
      out.write("\n");
      out.write("                    <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                        <div class=\"panel panel-green\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-xs-3\">\n");
      out.write("                                        <i class=\"fa fa-tasks fa-5x\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-xs-9 text-right\">\n");
      out.write("                                        <div class=\"huge\">");
      out.print(taskcount);
      out.write("</div>\n");
      out.write("                                        <div>New Tasks!</div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <a href=\"Tasks.jsp\">\n");
      out.write("                                <div class=\"panel-footer\">\n");
      out.write("                                    <span class=\"pull-left\">View Details</span>\n");
      out.write("                                    <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                    <div class=\"clearfix\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                        <div class=\"panel panel-yellow\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-xs-3\">\n");
      out.write("                                        <i class=\"fa fa-shopping-cart fa-5x\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-xs-9 text-right\">\n");
      out.write("                                        <div class=\"huge\">124</div>\n");
      out.write("                                        <div>New Orders!</div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <a href=\"Oder.html\">\n");
      out.write("                                <div class=\"panel-footer\">\n");
      out.write("                                    <span class=\"pull-left\">View Details</span>\n");
      out.write("                                    <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                    <div class=\"clearfix\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                        <div class=\"panel panel-red\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-xs-3\">\n");
      out.write("                                        <i class=\"fa fa-support fa-5x\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-xs-9 text-right\">\n");
      out.write("                                        <div class=\"huge\">13</div>\n");
      out.write("                                        <div>Support Tickets!</div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div class=\"panel-footer\">\n");
      out.write("                                    <span class=\"pull-left\">View Details</span>\n");
      out.write("                                    <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n");
      out.write("                                    <div class=\"clearfix\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <div class=\"row\"></div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <h3 class=\"panel-title\"><i class=\"fa fa-clock-o fa-fw\"></i> Tasks Panel</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"list-group\">\n");
      out.write("                                    <a href=\"#\" class=\"list-group-item\">\n");
      out.write("                                        <span class=\"badge\">just now</span>\n");
      out.write("                                        <i class=\"fa fa-fw fa-calendar\"></i> Calendar updated\n");
      out.write("                                    </a>\n");
      out.write("                                    <a href=\"#\" class=\"list-group-item\">\n");
      out.write("                                        <span class=\"badge\">4 minutes ago</span>\n");
      out.write("                                        <i class=\"fa fa-fw fa-comment\"></i> Commented on a post\n");
      out.write("                                    </a>\n");
      out.write("                                    <a href=\"#\" class=\"list-group-item\">\n");
      out.write("                                        <span class=\"badge\">23 minutes ago</span>\n");
      out.write("                                        <i class=\"fa fa-fw fa-truck\"></i> Order 392 shipped\n");
      out.write("                                    </a>\n");
      out.write("                                    <a href=\"#\" class=\"list-group-item\">\n");
      out.write("                                        <span class=\"badge\">46 minutes ago</span>\n");
      out.write("                                        <i class=\"fa fa-fw fa-money\"></i> Invoice 653 has been paid\n");
      out.write("                                    </a>\n");
      out.write("                                    <a href=\"#\" class=\"list-group-item\">\n");
      out.write("                                        <span class=\"badge\">1 hour ago</span>\n");
      out.write("                                        <i class=\"fa fa-fw fa-user\"></i> A new user has been added\n");
      out.write("                                    </a>\n");
      out.write("                                    <a href=\"#\" class=\"list-group-item\">\n");
      out.write("                                        <span class=\"badge\">2 hours ago</span>\n");
      out.write("                                        <i class=\"fa fa-fw fa-check\"></i> Completed task: \"pick up dry cleaning\"\n");
      out.write("                                    </a>\n");
      out.write("                                    <a href=\"#\" class=\"list-group-item\">\n");
      out.write("                                        <span class=\"badge\">yesterday</span>\n");
      out.write("                                        <i class=\"fa fa-fw fa-globe\"></i> Saved the world\n");
      out.write("                                    </a>\n");
      out.write("                                    <a href=\"#\" class=\"list-group-item\">\n");
      out.write("                                        <span class=\"badge\">two days ago</span>\n");
      out.write("                                        <i class=\"fa fa-fw fa-check\"></i> Completed task: \"fix error on sales page\"\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"text-right\">\n");
      out.write("                                    <a href=\"#\">View All Activity <i class=\"fa fa-arrow-circle-right\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4\">\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <h3 class=\"panel-title\"><i class=\"fa fa-money fa-fw\"></i> Transactions Panel</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <div class=\"table-responsive\">\n");
      out.write("                                    <table class=\"table table-bordered table-hover table-striped\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>Order #</th>\n");
      out.write("                                                <th>Order Date</th>\n");
      out.write("                                                <th>Order Time</th>\n");
      out.write("                                                <th>Amount (USD)</th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>3326</td>\n");
      out.write("                                                <td>10/21/2013</td>\n");
      out.write("                                                <td>3:29 PM</td>\n");
      out.write("                                                <td>$321.33</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>3325</td>\n");
      out.write("                                                <td>10/21/2013</td>\n");
      out.write("                                                <td>3:20 PM</td>\n");
      out.write("                                                <td>$234.34</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>3324</td>\n");
      out.write("                                                <td>10/21/2013</td>\n");
      out.write("                                                <td>3:03 PM</td>\n");
      out.write("                                                <td>$724.17</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>3323</td>\n");
      out.write("                                                <td>10/21/2013</td>\n");
      out.write("                                                <td>3:00 PM</td>\n");
      out.write("                                                <td>$23.71</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>3322</td>\n");
      out.write("                                                <td>10/21/2013</td>\n");
      out.write("                                                <td>2:49 PM</td>\n");
      out.write("                                                <td>$8345.23</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>3321</td>\n");
      out.write("                                                <td>10/21/2013</td>\n");
      out.write("                                                <td>2:23 PM</td>\n");
      out.write("                                                <td>$245.12</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>3320</td>\n");
      out.write("                                                <td>10/21/2013</td>\n");
      out.write("                                                <td>2:15 PM</td>\n");
      out.write("                                                <td>$5663.54</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>3319</td>\n");
      out.write("                                                <td>10/21/2013</td>\n");
      out.write("                                                <td>2:13 PM</td>\n");
      out.write("                                                <td>$943.45</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"text-right\">\n");
      out.write("                                    <a href=\"Oder.html\">View All Transactions <i class=\"fa fa-arrow-circle-right\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
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
      out.write("<!--        <script src=\"js/bootstrap.min.js\"></script>-->\n");
      out.write("\n");
      out.write("        <!-- Morris Charts JavaScript -->\n");
      out.write("        <script src=\"js/plugins/morris/raphael.min.js\"></script>\n");
      out.write("        <script src=\"js/plugins/morris/morris.min.js\"></script>\n");
      out.write("        <script src=\"js/plugins/morris/morris-data.js\"></script>\n");
      out.write("        <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Morris Charts CSS -->\n");
      out.write("        <link href=\"css/plugins/morris.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"fonts/font-awesome.min.css\" rel=\"stylesheet\" >\n");
      out.write("        <link href=\"fonts/font-awesome.css\" rel=\"stylesheet\" >\n");
      out.write("\n");
      out.write("        <!-- Custom Fonts -->\n");
      out.write("        <link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        \n");
      out.write("        ");

        }
        
      out.write("\n");
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
