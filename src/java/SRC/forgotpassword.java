/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRC;

import DB.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "forgotpassword", urlPatterns = {"/forgotpassword"})
public class forgotpassword extends HttpServlet {

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
            String user = request.getParameter("uemail");

            Session ss = Connection.conn.getSessionFactory().openSession();

            User u = (User) request.getAttribute("loging");

            if (u == null) {
                Criteria cc = ss.createCriteria(DB.User.class);
                cc.add(Restrictions.eq("email", user));
                DB.User lg = (DB.User) cc.uniqueResult();
                Transaction tr = ss.beginTransaction();

                DB.User urc = (DB.User) cc.uniqueResult();
                if (urc != null) {
                    Random rad = new Random();
                    String rd = String.valueOf(rad.nextInt()).substring(2);
                    urc.setUpassword(rd);
                    ss.update(urc);
                    tr.commit();

                    String text = "Use this as your tempory password : " + rd;
                    cls.email_reset_pw.getbody(text,user);

                    ss.clear();
                    ss.close();
                   
                   out.write("Successfully sent your email. Plese check your email. Use the given password for Loging. And reset the Password after loging");

                }else{
                
                out.write("Given email doesn't exsist ");
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
