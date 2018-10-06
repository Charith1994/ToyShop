/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cls;

import DB.CartReg;
import DB.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ZEE
 */
public class Db_cart {

    int pro_id;

    public void save_to_db(List<cart> n, HttpServletRequest request,HttpServletResponse response ) throws IOException, ServletException {
        for (cart ni : n) {
            pro_id = ni.getId();
            Session ss = Connection.conn.getSessionFactory().openSession();
            Criteria cc = ss.createCriteria(DB.Product.class);
            cc.add(Restrictions.eq("idproduct", ni.getId()));
            DB.Product lg = (DB.Product) cc.uniqueResult();
            Transaction tr = ss.beginTransaction();

            DB.User us = (DB.User) request.getSession().getAttribute("loging");

            DB.CartReg c_reg = new CartReg();
            DB.CartReg c_reg2;

            //ekama ekkena ekama baduwa 2parak gattot
            DB.Product pr = (DB.Product) ss.createCriteria(DB.Product.class).add(Restrictions.eq("idproduct", ni.getId())).uniqueResult();
if(pr.getQty()>= ni.getQty()){
            Criteria cc2 = ss.createCriteria(DB.CartReg.class);
            cc2.add(Restrictions.eq("user", us));
            cc2.add(Restrictions.eq("product", pr));

            c_reg2 = (CartReg) cc2.uniqueResult();

            if (c_reg2 == null) {
                c_reg.setProduct(lg);
                c_reg.setQty(ni.getQty() + "");
                c_reg.setUser(us);
                ss.save(c_reg);

            } else {
                c_reg2.setProduct(lg);
                c_reg2.setQty((ni.getQty()) + "");
                c_reg2.setUser(us);
                ss.update(c_reg2);
            }

            tr.commit();
            ss.clear();
            ss.close();

            HttpSession htses = request.getSession();
            htses.removeAttribute("mycart");
            
             RequestDispatcher rd=request.getRequestDispatcher("Products_SERCH_1.jsp");  
        rd.forward(request, response);
            
            
        }else{
    HttpSession htses = request.getSession();
            htses.removeAttribute("mycart");
PrintWriter out = response.getWriter();
out.write("<h1>There are not available this quantity. Only "+pr.getQty()+"items are available in this stock </h1>");
}

    }}

}
