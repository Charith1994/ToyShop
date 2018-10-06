/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products_management;

import DB.Product;
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
@WebServlet(name = "update_details", urlPatterns = {"/update_details"})
public class update_details extends HttpServlet {

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

            String pid = request.getParameter("pid");
            String price = request.getParameter("newPrice");
            String discription = request.getParameter("newDis");
            String Weight = request.getParameter("newWeight");
            String Warr = request.getParameter("newarr");
            String bprice = request.getParameter("newbprice");

            Session hbss = Connection.conn.getSessionFactory().openSession();
            Product pro = (Product) hbss.load(Product.class, Integer.parseInt(pid));

            Transaction tr = hbss.beginTransaction();
            try {
                if (!price.equals(null) && price != "") {
                    System.out.println("1");
                    pro.setSellingPrice(Double.parseDouble(price));
                } else {

                    price = pro.getSellingPrice().toString();
                    System.out.println("2");

                }

                if (!price.equals(null) && bprice != "") {
                    System.out.println("1");
                    pro.setBuyingPrice(Double.parseDouble(bprice));
                } else {

                    bprice = pro.getBuyingPrice().toString();
                    System.out.println("2");

                }

            } catch (Exception e) {

                e.printStackTrace();
            }

            if (!discription.equals(null)&& discription == "") {
                discription = pro.getDiscription();
                System.out.println("3");
            } else {
                pro.setDiscription(discription);
                System.out.println("4");
            }

            if (!Weight.equals(null)&&Weight == "") {
                System.out.println("5");
                Weight = pro.getPaketWeight();
            } else {
                System.out.println("6");
                pro.setPaketWeight(Weight);
            }

            if (!Warr.equals(null)&&Warr == "") {
                System.out.println("7");
                Warr = pro.getWarenty();
            } else {
                System.out.println("8");
                pro.setWarenty(Warr);
            }

            hbss.update(pro);
            tr.commit();

            RequestDispatcher rd = request.getRequestDispatcher("Product_view.jsp");
            rd.forward(request, response);
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
