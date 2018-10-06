/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products_management;

import DB.Product;
import cls.Db_cart;
import cls.cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import static org.hibernate.annotations.SourceType.DB;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "sescart", urlPatterns = {"/sescart"})
public class sescart extends HttpServlet {

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

            int id = Integer.parseInt(request.getParameter("id"));
            int qty = Integer.parseInt(request.getParameter("qty"));
            Session ss = Connection.conn.getSessionFactory().openSession();
            DB.Product pr = (DB.Product) ss.load(Product.class, id);
            if (pr.getQty() <= qty) {
                qty = pr.getQty();
            }

            out.write(id + ":id");
            out.write(qty + ":qty");
            ArrayList<cart> cart;

            cart c = new cart();
            c.setId(id);
            c.setQty(qty);

            cartOp cop = null;
            if (ses.getAttribute("mycart") == null) {
                cop = new cartOp();

            } else {
                //check already exsist
                cop = (cartOp) ses.getAttribute("mycart");
                out.write("paka");
            }

            c.setId(id);
            c.setQty(qty);
            cop.addProducToCart(c);

            if (ses.getAttribute("loging") == null) {
                //log wela nattam ses cart ekata add wenne

                ses.setAttribute("mycart", cop);

                int items = cop.getArrayData().size();

                String write = null;
                write = "<br/><span class='badge pull-right'>";
                write += items + "</span>";

                out.write(write);
                

            } else {
                //db ekata save karanna

                Db_cart d = new Db_cart();
                d.save_to_db(cop.getArrayData(), request, response);

            }
          ss.clear();
            ss.close();
            System.out.println("harida?...............");
            RequestDispatcher rd = request.getRequestDispatcher("Products_SERCH_1.jsp");
            rd.forward(request, response);

     
          

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
