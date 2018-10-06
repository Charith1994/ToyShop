/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products_management;

import DB.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "update_img", urlPatterns = {"/update_img"})
public class update_img extends HttpServlet {

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
            String img="";
            String pid="";
            
             Session ses = Connection.conn.getSessionFactory().openSession();
            
            try {
                FileItemFactory fact = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fact);
                List<Object> items = upload.parseRequest(request);
                 
                for (Object item : items) {
                    FileItem fileItem = (FileItem) item;
                    if (!fileItem.isFormField()) {
                        if (fileItem.getName().isEmpty()) {
                            img = "def_product.png";
                            System.out.println("1");
                        } else {
                            try {
                                File savefile = new File(request.getServletContext().getRealPath("") + "/productImg/" + fileItem.getName());
                                img = "productImg/" + fileItem.getName();
                                System.out.println("2");
                                 fileItem.write(savefile);
                               
                            } catch (FileNotFoundException e) {
                                img = "def_product.png";
                                System.out.println("1");
                            }

                        }
                    } else if (fileItem.isFormField()) {
if (fileItem.getFieldName().equals("pid")) {
                            pid = fileItem.getString();

                        }
                       

                    }
                }
//  out.write("img:"+img+"pname:" +pname+"dis: "+discription+"pakt weght:"+paket+"categ: "+category+"warrenty:"+warrenty+"b_price :"+b_price+"s_price: " + s_price);
          
            } catch (Exception e) {
//out.write("5");
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
           

            Transaction tr = ses.beginTransaction();
            DB.Product p = (DB.Product) ses.load(Product.class, Integer.parseInt(pid));
            
            p.setImage(img);
            
            
            ses.update(p);

            tr.commit();
            ses.clear();
            ses.close();

            response.sendRedirect("Add_new_toy.jsp");

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
