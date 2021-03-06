package DB;
// Generated Dec 5, 2016 9:43:02 PM by Hibernate Tools 4.3.1



/**
 * Adress generated by hbm2java
 */
public class Adress  implements java.io.Serializable {


     private Integer idAdress;
     private Distric distric;
     private User user;
     private String line1;
     private String line2;
     private String line3;

    public Adress() {
    }

	
    public Adress(Distric distric, User user) {
        this.distric = distric;
        this.user = user;
    }
    public Adress(Distric distric, User user, String line1, String line2, String line3) {
       this.distric = distric;
       this.user = user;
       this.line1 = line1;
       this.line2 = line2;
       this.line3 = line3;
    }
   
    public Integer getIdAdress() {
        return this.idAdress;
    }
    
    public void setIdAdress(Integer idAdress) {
        this.idAdress = idAdress;
    }
    public Distric getDistric() {
        return this.distric;
    }
    
    public void setDistric(Distric distric) {
        this.distric = distric;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getLine1() {
        return this.line1;
    }
    
    public void setLine1(String line1) {
        this.line1 = line1;
    }
    public String getLine2() {
        return this.line2;
    }
    
    public void setLine2(String line2) {
        this.line2 = line2;
    }
    public String getLine3() {
        return this.line3;
    }
    
    public void setLine3(String line3) {
        this.line3 = line3;
    }




}


