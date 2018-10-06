/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRC;

import DB.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Charith
 */
@WebServlet(name = "user_reg", urlPatterns = {"/user_reg"})
public class user_reg extends HttpServlet {

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

            String Fname = request.getParameter("fname");
            String Lname = request.getParameter("lname");
            String Email = request.getParameter("email");
            String Tel = request.getParameter("contactno");
            //String uname=request.getParameter("username");
            String pass = request.getParameter("userpassword");

            DB.User u = new DB.User();

            User us = (User) request.getSession().getAttribute("loging");

            if (us == null) {
                Session ses = Connection.conn.getSessionFactory().openSession();
                DB.ActiveState act = (DB.ActiveState) ses.load(DB.ActiveState.class, 3);
                DB.UserType typ = (DB.UserType) ses.load(DB.UserType.class, 2);
                System.out.println("2");
                Transaction tr = ses.beginTransaction();

                
                
                Criteria crr=ses.createCriteria(User.class).add(Restrictions.eq("email", Email));
                DB.User urc = (DB.User) crr.uniqueResult();
                
                if(urc==null){
                
                
                
                
                
                u.setActiveState(act);
                u.setEmail(Email);
                u.setFname(Fname);
                u.setLname(Lname);
                u.setTelnumber(Tel);

                u.setUpassword(pass);
                u.setUserType(typ);
                System.out.println("3");
                ses.save(u);

                tr.commit();
                ses.clear();
                ses.close();
                response.sendRedirect("EmailVeryficatio?id=" + u.getIduser() + "&mail=" + u.getEmail() + "&uname=" + u.getFname());
          
                }else{
                 RequestDispatcher rd = request.getRequestDispatcher("error_1.jsp");
                rd.forward(request, response);
                }

                  } else if (us != null) {
                Session ses = Connection.conn.getSessionFactory().openSession();

                Transaction tr = ses.beginTransaction();

                us.setEmail(Email);
                us.setFname(Fname);
                us.setLname(Lname);
                us.setTelnumber(Tel);
                //u.setusername(uname);
                us.setUpassword(pass);
//            us.setUserType(typ);
                System.out.println("3");
                ses.update(us);

                tr.commit();
                System.out.println("awa");
                ses.clear();
                ses.close();
                RequestDispatcher rd = request.getRequestDispatcher("uprofile.jsp");
                rd.forward(request, response);

            }

//            
//            ses.clear();
//            ses.close();
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
