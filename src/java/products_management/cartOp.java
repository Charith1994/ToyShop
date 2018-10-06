/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products_management;

import cls.cart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZEE
 */
public class cartOp {
    private List<cart> arrayData;
    
    public cartOp(){
    arrayData=new ArrayList<cart>();
    
    }

    public List<cart> getArrayData() {
        return arrayData;
    }
    
    public  void addProducToCart(cart ni){
    cart old;
    int qty=0;
   
        for (int i = 0; i < arrayData.size(); i++) {
         old   =arrayData.get(i);
         
         if(old.getId()==ni.getId()){
         
         qty=ni.getQty();
         
         arrayData.remove(old);
         ni.setQty(qty);
         }
            
        }
    
    arrayData.add(ni);
        
    }
    
    public  void removeProducts(cart p){
        for (int i = 0; i < arrayData.size(); i++) {
            
            
            cart elem=arrayData.get(i);
            if(elem.getId()==p.getId()){
            arrayData.remove(i);
            }
        }
    
    }
}
