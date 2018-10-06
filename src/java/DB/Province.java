package DB;
// Generated Dec 5, 2016 9:43:02 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Province generated by hbm2java
 */
public class Province  implements java.io.Serializable {


     private Integer idprovince;
     private String province;
     private Set districs = new HashSet(0);

    public Province() {
    }

    public Province(String province, Set districs) {
       this.province = province;
       this.districs = districs;
    }
   
    public Integer getIdprovince() {
        return this.idprovince;
    }
    
    public void setIdprovince(Integer idprovince) {
        this.idprovince = idprovince;
    }
    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    public Set getDistrics() {
        return this.districs;
    }
    
    public void setDistrics(Set districs) {
        this.districs = districs;
    }




}

