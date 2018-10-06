/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products_management;

import DB.ActiveState;
import DB.Category;
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
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "product_save", urlPatterns = {"/product_save"})
public class product_save extends HttpServlet {

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

            String img = null;
            String pname = "";
            String discription = "";
            String paket = "";
            String category = "";
            String warrenty = "";
            Double b_price = 0.0;
            Double s_price = 0.0;
            
            
          

           
            
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

                        if (fileItem.getFieldName().equals("pname")) {
                            pname = fileItem.getString();

                        }
                        if (fileItem.getFieldName().equals("selectcat")) {
                            
                            category=fileItem.getString();

                         }

                        if (fileItem.getFieldName().equals("discription")) {
                            discription = fileItem.getString();
                        }

                        if (fileItem.getFieldName().equals("pakweight")) {
                            paket = fileItem.getString();

                        }
                      
                        if (fileItem.getFieldName().equals("b_price")) {
                            b_price =Double.parseDouble(fileItem.getString()) ;

                        }
                        if (fileItem.getFieldName().equals("s_price")) {
                            s_price = Double.parseDouble(fileItem.getString()) ;

                        }
                        if (fileItem.getFieldName().equals("warday")) {
                            warrenty = fileItem.getString();

                        }

                    }
                }
//  out.write("img:"+img+"pname:" +pname+"dis: "+discription+"pakt weght:"+paket+"categ: "+category+"warrenty:"+warrenty+"b_price :"+b_price+"s_price: " + s_price);
          
            } catch (Exception e) {
//out.write("5");
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
            DB.Category cc=(DB.Category) ses.load(DB.Category.class, Integer.parseInt(category));
            System.out.println(b_price);
            System.out.println(pname);
            System.out.println(s_price);
            System.out.println(cc.getName());
            System.out.println(paket);
            System.out.println(warrenty);
            System.out.println(discription);
            System.out.println(img);
                       
            DB.ActiveState act = (DB.ActiveState) ses.load(DB.ActiveState.class, 1);

            Transaction tr = ses.beginTransaction();
            DB.Product p = new Product();
            p.setDiscription(discription);

            p.setCategory(cc);
                p.setWarenty(warrenty);
            p.setImage(img);
            p.setProduct(pname);
            p.setPaketWeight(paket);
            p.setActiveState(act);
            p.setQty(0);
            p.setSellingPrice(s_price);
            p.setBuyingPrice(b_price);
            
            ses.save(p);

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
