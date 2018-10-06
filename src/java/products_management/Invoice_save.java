/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products_management;

import DB.ActiveState;
import DB.Adress;
import DB.CartReg;
import DB.Invoice;
import DB.InvoiceReg;
import DB.PaymentMethod;
import DB.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ZEE
 */
@WebServlet(name = "Invoice_save", urlPatterns = {"/Invoice_save"})
public class Invoice_save extends HttpServlet {

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
           int payid=Integer.parseInt(request.getParameter("payment"));
            double tot = 0.00;
            Session ss=Connection.conn.getSessionFactory().openSession();
            User us=(User) request.getSession().getAttribute("loging");
            
            
            if (us != null) {
                
                Adress ad = (Adress) ss.createCriteria(Adress.class).add(Restrictions.eq("user", us)).uniqueResult();
                if (ad != null) {
                    int cregid = Integer.parseInt(request.getParameter("cart_reg_id"));

                    List<CartReg> creg;

                    if (cregid == 0) {
                        creg = ss.createCriteria(CartReg.class).add(Restrictions.eq("user", us)).list();
out.write("1");
                    } else {
                        out.write(cregid);
                        creg = ss.createCriteria(CartReg.class).add(Restrictions.eq("idcartReg", cregid)).list();
                    }
                    Transaction tr=ss.beginTransaction();
                    //invoice
                    Invoice inv=new Invoice();
                    ActiveState act=(ActiveState) ss.load(ActiveState.class, 4);
                    Date d=new Date();
                    PaymentMethod pm=(PaymentMethod) ss.load(PaymentMethod.class, payid);
                    
                    inv.setActiveState(act);
                    inv.setDate(d);
                    inv.setDistric(ad.getDistric());
                    inv.setPaymentMethod(pm);
                    inv.setUser(us);
                    
                  ss.save(inv);
                   
                //  out.write(inv.getIdinvoice()+"");
                  out.write("boo");
                  
                   

                    
                      for (CartReg cr : creg) {
                          
                         //invoice registry 
                         
                          InvoiceReg inreg=new InvoiceReg();
                          inreg.setInvoice(inv);
                          inreg.setPrice(cr.getProduct().getSellingPrice());
                          inreg.setProduct(cr.getProduct());
                          inreg.setQty(Integer.parseInt(cr.getQty()));
                          ss.save(inreg);
                         
                         CartReg creg2=(CartReg) ss.load(CartReg.class, cr.getIdcartReg());
                         
                         ss.delete(creg2);
                         
                         
                     
                      
                      
                      }
                     RequestDispatcher rd=request.getRequestDispatcher("thanx.jsp");  
        rd.forward(request, response);
                  tr.commit();
                  ss.clear();
                  ss.close();
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    } else {
                    response.sendRedirect("register_3.jsp?url=" + "My_cart.jsp");
                }
            } else {
                response.sendRedirect("login2.jsp?comeBackurl=" + "My_cart.jsp");
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
