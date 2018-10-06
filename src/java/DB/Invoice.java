package DB;
// Generated Dec 5, 2016 9:43:02 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Invoice generated by hbm2java
 */
public class Invoice  implements java.io.Serializable {


     private Integer idinvoice;
     private ActiveState activeState;
     private Distric distric;
     private PaymentMethod paymentMethod;
     private User user;
     private Date date;
     private Set invoiceRegs = new HashSet(0);
     private Set reports = new HashSet(0);

    public Invoice() {
    }

	
    public Invoice(ActiveState activeState, Distric distric, PaymentMethod paymentMethod, User user) {
        this.activeState = activeState;
        this.distric = distric;
        this.paymentMethod = paymentMethod;
        this.user = user;
    }
    public Invoice(ActiveState activeState, Distric distric, PaymentMethod paymentMethod, User user, Date date, Set invoiceRegs, Set reports) {
       this.activeState = activeState;
       this.distric = distric;
       this.paymentMethod = paymentMethod;
       this.user = user;
       this.date = date;
       this.invoiceRegs = invoiceRegs;
       this.reports = reports;
    }
   
    public Integer getIdinvoice() {
        return this.idinvoice;
    }
    
    public void setIdinvoice(Integer idinvoice) {
        this.idinvoice = idinvoice;
    }
    public ActiveState getActiveState() {
        return this.activeState;
    }
    
    public void setActiveState(ActiveState activeState) {
        this.activeState = activeState;
    }
    public Distric getDistric() {
        return this.distric;
    }
    
    public void setDistric(Distric distric) {
        this.distric = distric;
    }
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
    
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
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
    public Set getInvoiceRegs() {
        return this.invoiceRegs;
    }
    
    public void setInvoiceRegs(Set invoiceRegs) {
        this.invoiceRegs = invoiceRegs;
    }
    public Set getReports() {
        return this.reports;
    }
    
    public void setReports(Set reports) {
        this.reports = reports;
    }




}


