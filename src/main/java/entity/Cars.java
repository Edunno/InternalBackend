/* Esben; DECK-CS */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
@Entity
@Table(name = "cars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c")
    , @NamedQuery(name = "Cars.findById", query = "SELECT c FROM Cars c WHERE c.id = :id")
    , @NamedQuery(name = "Cars.findByPriceClass", query = "SELECT c FROM Cars c WHERE c.priceClass = :priceClass")
    , @NamedQuery(name = "Cars.findByDistDrivenMAX", query = "SELECT c FROM Cars c WHERE c.distDriven < :distDriven")
    , @NamedQuery(name = "Cars.findByDistDrivenMIN", query = "SELECT c FROM Cars c WHERE c.distDriven > :distDriven")
    , @NamedQuery(name = "Cars.findByBrand", query = "SELECT c FROM Cars c WHERE c.brand = :brand")
    , @NamedQuery(name = "Cars.findByModel", query = "SELECT c FROM Cars c WHERE c.model = :model")
    , @NamedQuery(name = "Cars.findByYear", query = "SELECT c FROM Cars c WHERE c.pyear = :pyear")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "priceClass")
    private String priceClass;
    @Column(name = "distDriven")
    private Integer distDriven;
    @Size(max = 255)
    @Column(name = "brand")
    private String brand;
    @Size(max = 255)
    @Column(name = "model")
    private String model;
    @Lob
    @Size(max = 65535)
    @Column(name = "comments")
    private String comments;
    @Size(max = 255)
    @Column(name = "pyear")
    private String pyear;
    @ManyToMany(mappedBy = "carsCollection")
    private Collection<Rentals> rentalsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carId")
    private Collection<LocationsTime> locationsTimeCollection;

    public Cars() {
    }

    public Cars(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriceClass() {
        return priceClass;
    }

    public void setPriceClass(String priceClass) {
        this.priceClass = priceClass;
    }

    public Integer getDistDriven() {
        return distDriven;
    }

    public void setDistDriven(Integer distDriven) {
        this.distDriven = distDriven;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getYear() {
        return pyear;
    }

    public void setYear(String year) {
        this.pyear = year;
    }

    @XmlTransient
    public Collection<Rentals> getRentalsCollection() {
        return rentalsCollection;
    }

    public void setRentalsCollection(Collection<Rentals> rentalsCollection) {
        this.rentalsCollection = rentalsCollection;
    }

    @XmlTransient
    public Collection<LocationsTime> getLocationsTimeCollection() {
        return locationsTimeCollection;
    }

    public void setLocationsTimeCollection(Collection<LocationsTime> locationsTimeCollection) {
        this.locationsTimeCollection = locationsTimeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cars[ id=" + id + " ]";
    }

}
