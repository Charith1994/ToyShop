package DB;
// Generated Dec 5, 2016 9:43:02 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer iduser;
     private ActiveState activeState;
     private UserType userType;
     private String fname;
     private String lname;
     private String email;
     private String upassword;
     private String telnumber;
     private String mobnumber;
     private Set cartRegs = new HashSet(0);
     private Set orders = new HashSet(0);
     private Set reports = new HashSet(0);
     private Set adresses = new HashSet(0);
     private Set grns = new HashSet(0);
     private Set invoices = new HashSet(0);

    public User() {
    }

	
    public User(ActiveState activeState, UserType userType) {
        this.activeState = activeState;
        this.userType = userType;
    }
    public User(ActiveState activeState, UserType userType, String fname, String lname, String email, String upassword, String telnumber, String mobnumber, Set cartRegs, Set orders, Set reports, Set adresses, Set grns, Set invoices) {
       this.activeState = activeState;
       this.userType = userType;
       this.fname = fname;
       this.lname = lname;
       this.email = email;
       this.upassword = upassword;
       this.telnumber = telnumber;
       this.mobnumber = mobnumber;
       this.cartRegs = cartRegs;
       this.orders = orders;
       this.reports = reports;
       this.adresses = adresses;
       this.grns = grns;
       this.invoices = invoices;
    }
   
    public Integer getIduser() {
        return this.iduser;
    }
    
    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }
    public ActiveState getActiveState() {
        return this.activeState;
    }
    
    public void setActiveState(ActiveState activeState) {
        this.activeState = activeState;
    }
    public UserType getUserType() {
        return this.userType;
    }
    
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUpassword() {
        return this.upassword;
    }
    
    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
    public String getTelnumber() {
        return this.telnumber;
    }
    
    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }
    public String getMobnumber() {
        return this.mobnumber;
    }
    
    public void setMobnumber(String mobnumber) {
        this.mobnumber = mobnumber;
    }
    public Set getCartRegs() {
        return this.cartRegs;
    }
    
    public void setCartRegs(Set cartRegs) {
        this.cartRegs = cartRegs;
    }
    public Set getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set orders) {
        this.orders = orders;
    }
    public Set getReports() {
        return this.reports;
    }
    
    public void setReports(Set reports) {
        this.reports = reports;
    }
    public Set getAdresses() {
        return this.adresses;
    }
    
    public void setAdresses(Set adresses) {
        this.adresses = adresses;
    }
    public Set getGrns() {
        return this.grns;
    }
    
    public void setGrns(Set grns) {
        this.grns = grns;
    }
    public Set getInvoices() {
        return this.invoices;
    }
    
    public void setInvoices(Set invoices) {
        this.invoices = invoices;
    }




}


