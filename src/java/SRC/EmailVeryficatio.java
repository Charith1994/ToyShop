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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "EmailVeryficatio", urlPatterns = {"/EmailVeryficatio"})
public class EmailVeryficatio extends HttpServlet {

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

            User u = (User) request.getSession().getAttribute("loging");
           
            String username = null;
            String email = null;
            String id = null;
          
            if (u==null) {
   out.write("1");
                username = request.getParameter("uname");
                email = request.getParameter("mail");
                id = request.getParameter("id");
//                Random rad = new Random();
//                String rd = String.valueOf(rad.nextInt()).substring(2);
//                //ul.setVCode(rd);
                System.out.println("aaaaaaa");

                String text = "Click this link for Verify your account  : " + "http://localhost:8080/web2016/ActiveUserByEmail?id=" + id ;
                cls.email.getbody(text, email);
                out.write("done");
             response.sendRedirect("login2.jsp");
            } else if (!u.equals(null)) {
                
                username = u.getFname() + " " + u.getLname();
                email = u.getEmail();
                id = u.getIduser() + "";

                String text = "Click this link for Verify your account  : " + "http://localhost:8080/web2016/ActiveUserByEmail?id=" + id + "&uname=" + username;
                cls.email.getbody(text, email);
                 RequestDispatcher rd = request.getRequestDispatcher("login2.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
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
