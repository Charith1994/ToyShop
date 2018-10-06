/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products_management;

import DB.Product;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "my_products", urlPatterns = {"/my_products"})
public class my_products extends HttpServlet {

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
            String write = null;
            DB.Product p = new Product();
            Session s = Connection.conn.getSessionFactory().openSession();
            Criteria cr = s.createCriteria(DB.Product.class);

            int tot = cr.list().size();

            List<DB.Product> li = (List<DB.Product>) cr.list();

            
            
            
            
            if (tot != 0) {

                write = "<div    id='page-wrapper'>";
                write = "<div class='container-fluid'>";
                for (Product pr : li) {
                    write += "<div class='col-sm-4'>";
                    write += "<div class='panel panel-yellow' style='height:339px' >";
                    write += "<div class='panel-heading' >";
                    write += "<h3 class='panel-title'>" + pr.getProduct() + "</h3>";
                    write += "</div>";
                    write += "<div class='panel-body' >";
                    write += "<div class='thumbnail' >";
                    write += "<img style='height: 180px' src='" + pr.getImage() + "' alt='product image' height='100px'>";
                    write += "</div>" + pr.getDiscription() + "</div>";
                   //  String add_product_params= pr.getIdproduct()+","+pr.getProduct()+","+pr.getPaketWeightg();
                     write += "<input type='hidden' id='pn' value='"+pr.getProduct()+"'/>";
                    write += "<input type='hidden' id='pw' value='"+pr.getPaketWeight()+"'/>";
                    write += "<div class='panel-footer'><a onclick='add("+pr.getIdproduct()+")'>+add staock </a></div>";
                    //+","+pr.getProduct()+","+pr.getPaketWeightg()+
                    write += "</div></div>";
                    
                }
                write += "</div></div>";

            } else {
                write += "<div style = 'margin-top: 100px;'> <p style ='font-size: 20px;' > Sorry, No result found</p> <a class ='btn btn-warning' href='home.jsp'><< Back to Home </a></div>\n";

            }
            out.write(write);
            s.clear();
            s.close();
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
