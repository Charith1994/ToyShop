package DB;
// Generated Dec 5, 2016 9:43:02 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Grn generated by hbm2java
 */
public class Grn  implements java.io.Serializable {


     private Integer idiGrn;
     private User user;
     private Date date;
     private Set grnRegs = new HashSet(0);

    public Grn() {
    }

	
    public Grn(User user) {
        this.user = user;
    }
    public Grn(User user, Date date, Set grnRegs) {
       this.user = user;
       this.date = date;
       this.grnRegs = grnRegs;
    }
   
    public Integer getIdiGrn() {
        return this.idiGrn;
    }
    
    public void setIdiGrn(Integer idiGrn) {
        this.idiGrn = idiGrn;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Set getGrnRegs() {
        return this.grnRegs;
    }
    
    public void setGrnRegs(Set grnRegs) {
        this.grnRegs = grnRegs;
    }




}


