/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRC;

import DB.ActiveState;
import DB.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "User_managment", urlPatterns = {"/User_managment"})
public class User_managment extends HttpServlet {

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
            String uid = request.getParameter("uid");
            String state = request.getParameter("state");
            String url = request.getParameter("url");
            
            if(state.equals("1")){
            state="2";
            }else if(state.equals("2"))state="1";
            
            
            

            Session hbss=Connection.conn.getSessionFactory().openSession();

            //current loging user
            User us = (User) request.getSession().getAttribute("loging");
            //user who giong to be chanhged
            User u=(User)hbss.load(User.class, Integer.parseInt(uid));
            
            ActiveState stat=(ActiveState)hbss.load(ActiveState.class, Integer.parseInt(state));
            
            
            
            
            

            if (("admin".equals(u.getUserType().getUserType()) & "superAdmin".equals(us.getUserType().getUserType())) | (!"admin".equals(u.getUserType().getUserType()) & "admin".equals(us.getUserType().getUserType())) |(!"admin".equals(u.getUserType().getUserType()) & "superAdmin".equals(us.getUserType().getUserType())) |("superAdmin".equals(u.getUserType().getUserType()) & "superAdmin".equals(us.getUserType().getUserType()))) {
                 
                Transaction tr=hbss.beginTransaction();
                u.setActiveState(stat);
                hbss.update(u);
                 tr.commit();
                 System.out.println(url);
//                RequestDispatcher rd = request.getRequestDispatcher(url);
//                rd.forward(request, response);
response.sendRedirect(url);
               
                
                
            } else {
                 out.write("To be changed:    "+u.getUserType().getUserType());
                out.write("<br/>");
                out.write("fal");
                
                 out.write("<br/>");
                  out.write("This :  "+us.getUserType().getUserType());
                 out.write("<br/>");
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            }
     hbss.clear();
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
