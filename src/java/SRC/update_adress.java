/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRC;

import DB.Adress;
import DB.Distric;
import DB.Province;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "update_adress", urlPatterns = {"/update_adress"})
public class update_adress extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession ses = request.getSession();
            DB.User us = (DB.User) ses.getAttribute("loging");

            String line1 = request.getParameter("address[addr1]");
            String line2 = request.getParameter("address[addr2]");
            String line3 = request.getParameter("address[addr3]");
            String twn = request.getParameter("town");
         

            if (us == null) {
                response.sendRedirect("login2.jsp");
            } else {
                Session hbss = Connection.conn.getSessionFactory().openSession();

                if (!line1.equals(null) && !line2.equals(null) && !line3.equals(null) && !twn.equals(null) && !twn.equals("N/A")) {
              Adress ads = (Adress) hbss.createCriteria(Adress.class).add(Restrictions.eq("user", us)).uniqueResult();
                   Distric d = (Distric) hbss.createCriteria(Distric.class).add(Restrictions.eq("distric", twn)).uniqueResult();
                    Transaction tr = hbss.beginTransaction();
                   

//                    if (ads == null && !(twn == null || d.getDistric().equals("N/A"))) {
                        out.write("zee");

                        out.write("save");
                        ads.setDistric(d);
                        ads.setLine1(line1);
                        ads.setLine2(line2);
                        ads.setLine3(line3);
                        ads.setUser(us);
                        hbss.update(ads);
                        tr.commit();

                        hbss.clear();
                        hbss.close();
                      RequestDispatcher rd=request.getRequestDispatcher("uprofile.jsp");  
        rd.forward(request, response);

//                    } else {
//
//                        out.write("<h1>Sorry! Our dilivery service not cover your area. We will promise to expand our dilivery. Stay with us!</h1>");
//                    }

                } else {

                   out.write(""
                            + "<a href='index.jsp'>Go Back Home</a>"
                            + ""
                            + "<h1>Sorry! Our dilivery service not cover your area.So it will cost more than normal dilivery cost rate. We will promise to expand our dilivery. Stay with us!</h1>");

                }

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}