/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRC;

import DB.ActiveState;
import DB.User;
import cls.Db_cart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import products_management.cartOp;

/**
 *
 * @author Charith
 */
@WebServlet(name = "logingtest", urlPatterns = {"/logingtest"})
public class logingtest extends HttpServlet {

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
            User u = (User) request.getAttribute("loging");

            if (u == null) {
                String user = request.getParameter("uemail");
                String pass = request.getParameter("upass");

                Session ss = Connection.conn.getSessionFactory().openSession();
                ActiveState act=(ActiveState) ss.load(ActiveState.class, 2);
                Criteria cc = ss.createCriteria(DB.User.class);

                cc.add(Restrictions.eq("email", user));
                cc.add(Restrictions.eq("upassword", pass));
                cc.add(Restrictions.ne("activeState", act));
                
                DB.User lg = (DB.User) cc.uniqueResult();

                HttpSession ses = request.getSession();
                cartOp cop = null;

                if (ses.getAttribute("mycart") == null) {

                    cop = new cartOp();

                } else {

                    cop = (cartOp) ses.getAttribute("mycart");

                }

                if (lg != null) {
                    System.out.println("a");
                    request.getSession().setAttribute("loging", lg);

                    //save to db cart
                    Db_cart d = new Db_cart();
                    d.save_to_db(cop.getArrayData(), request, response);
                    request.getSession().removeAttribute("mycart");
                    response.sendRedirect("home.jsp");
                    out.write("lg != null");
                } else {
                    System.out.println("a3");
                    response.sendRedirect("error.jsp");
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
