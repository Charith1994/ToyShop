/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author ZEE
 */
public class db {
    
    static private Connection c=null;
  private static Connection  db()throws Exception{
    if(c==null){
        Class.forName("com.mysql.jdbc.Driver");
       c= DriverManager.getConnection("jdbc:mysql://localhost:3306/thunapaha", "root", "123");
     return c ;
    }else{
     return c ;
    }
     
 
  }  
  
  public boolean sqlupdate(String query){
          try {
              db().createStatement().executeUpdate(query);
               return true;
          } catch (Exception ex) {
              ex.printStackTrace();
               return false;
          }
         
      
  
  }
  
  public  ResultSet getdata(String query){
          ResultSet rs = null;
     
             try {
            rs = db().createStatement().executeQuery(query);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     return rs;
  
  }
    
}
