package jee.pj.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author willi
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByIdemp", query = "SELECT e FROM Employees e WHERE e.idemp = :idemp"),
    @NamedQuery(name = "Employees.findByLastname", query = "SELECT e FROM Employees e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Employees.findByFirstname", query = "SELECT e FROM Employees e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Employees.findByHomephone", query = "SELECT e FROM Employees e WHERE e.homephone = :homephone"),
    @NamedQuery(name = "Employees.findByMobilephone", query = "SELECT e FROM Employees e WHERE e.mobilephone = :mobilephone"),
    @NamedQuery(name = "Employees.findByWorkphone", query = "SELECT e FROM Employees e WHERE e.workphone = :workphone"),
    @NamedQuery(name = "Employees.findByAddress", query = "SELECT e FROM Employees e WHERE e.address = :address"),
    @NamedQuery(name = "Employees.findByPostalcode", query = "SELECT e FROM Employees e WHERE e.postalcode = :postalcode"),
    @NamedQuery(name = "Employees.findByCity", query = "SELECT e FROM Employees e WHERE e.city = :city"),
    @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEMP")
    private Integer idemp;
    @Size(max = 32)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 15)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 15)
    @Column(name = "HOMEPHONE")
    private String homephone;
    @Size(max = 15)
    @Column(name = "MOBILEPHONE")
    private String mobilephone;
    @Size(max = 32)
    @Column(name = "WORKPHONE")
    private String workphone;
    @Size(max = 32)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 32)
    @Column(name = "POSTALCODE")
    private String postalcode;
    @Size(max = 32)
    @Column(name = "CITY")
    private String city;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 32)
    @Column(name = "EMAIL")
    private String email;

    public Employees() {
    }

    /**
     * Constructor
     * @param idemp Integer we want to set the employee's id with
     */
    public Employees(Integer idemp, String firstname, String lastname) {
        this.idemp = idemp;
        this.lastname = lastname;
        this.firstname = firstname;
    }
    
    /**
     *
     * @return employee's password
     */
    public Integer getIdemp() {
        return idemp;
    }
    
    /**
     *
     * @param idemp Integer we want to set the employee's id with
     */
    public void setIdemp(Integer idemp) {
        this.idemp = idemp;
    }
    
    /**
     *
     * @return employee's last name
     */
    public String getLastname() {
        return lastname;
    }
    /**
     *
     * @param lastname String we want to set the employee's last name with
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    /**
     *
     * @return employee's first name
     */
    public String getFirstname() {
        return firstname;
    }
    /**
     *
     * @param firstname String we want to set the employee's first name with
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    /**
     *
     * @return employee's home phone
     */
    public String getHomephone() {
        return homephone;
    }
    /**
     *
     * @param homephone Phone number we want to set the employee's home phone with
     */
    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }
    /**
     *
     * @return employee's mobile phone
     */
    public String getMobilephone() {
        return mobilephone;
    }

   /**
     *
     * @param mobilephone Phone number we want to set the employee's mobile phone with
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
    /**
     *
     * @return employee's work phone
     */
    public String getWorkphone() {
        return workphone;
    }
    /**
     *
     * @param workphone Phone number we want to set the employee's work phone with
     */
    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }
    /**
     *
     * @return employee's address
     */
    public String getAddress() {
        return address;
    }
    /**
     *
     * @param address Address we want to set the employee's address with
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     *
     * @return employee's postal code
     */
    public String getPostalcode() {
        return postalcode;
    }
    /**
     *
     * @param postalcode postal code we want to set the employee's postal code with
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    /**
     *
     * @return employee's city
     */
    public String getCity() {
        return city;
    }
    /**
     *
     * @param city City's name we want to set employee's city field with
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     *
     * @return employee's email
     */
    public String getEmail() {
        return email;
    }
    /**
     *
     * @param email String we want to set the employee's email with
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemp != null ? idemp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.idemp == null && other.idemp != null) || (this.idemp != null && !this.idemp.equals(other.idemp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jee.pj.beans.Employees[ idemp=" + idemp + " ]";
    }
    
}
