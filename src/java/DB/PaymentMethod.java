package DB;
// Generated Dec 5, 2016 9:43:02 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * PaymentMethod generated by hbm2java
 */
public class PaymentMethod  implements java.io.Serializable {


     private int idpaymentMethod;
     private String paymentMethod;
     private Set invoices = new HashSet(0);

    public PaymentMethod() {
    }

	
    public PaymentMethod(int idpaymentMethod) {
        this.idpaymentMethod = idpaymentMethod;
    }
    public PaymentMethod(int idpaymentMethod, String paymentMethod, Set invoices) {
       this.idpaymentMethod = idpaymentMethod;
       this.paymentMethod = paymentMethod;
       this.invoices = invoices;
    }
   
    public int getIdpaymentMethod() {
        return this.idpaymentMethod;
    }
    
    public void setIdpaymentMethod(int idpaymentMethod) {
        this.idpaymentMethod = idpaymentMethod;
    }
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public Set getInvoices() {
        return this.invoices;
    }
    
    public void setInvoices(Set invoices) {
        this.invoices = invoices;
    }




}

