/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import DB.ActiveState;
import DB.Invoice;
import DB.Product;
import DB.Report;
import DB.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "report", urlPatterns = {"/report"})
public class report extends HttpServlet {

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
            
            String invid = request.getParameter("invid");
            String reason = request.getParameter("reason");
            String Description = request.getParameter("Description");
            String product = request.getParameter("product");
            
            if (!(invid.equals(null) && reason.equals(null) && Description.equals(null))) {
                Session hbss = Connection.conn.getSessionFactory().openSession();
                Transaction tr = hbss.beginTransaction();
                ActiveState act = (ActiveState) hbss.load(ActiveState.class, 1);
                Invoice in = (Invoice) hbss.load(Invoice.class, Integer.parseInt(invid));
                Product p = (Product) hbss.createCriteria(Product.class).add(Restrictions.eq("product", product)).uniqueResult();
                User us = (DB.User) request.getSession().getAttribute("loging");
                
                Report rep = new Report();
                rep.setProduct(p);
                rep.setUser(us);
                rep.setActiveState(act);
                rep.setDescription(Description);
                rep.setInvoice(in);
                rep.setReason(reason);
                rep.setReply("No reply");
                hbss.save(rep);
                tr.commit();
                hbss.clear();
                hbss.close();
                RequestDispatcher rd = request.getRequestDispatcher("Tasks.jsp");                
                rd.forward(request, response);
                
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
