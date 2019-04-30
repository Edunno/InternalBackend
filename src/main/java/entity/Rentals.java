/* Esben; DECK-CS */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
@Entity
@Table(name = "rentals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rentals.findAll", query = "SELECT r FROM Rentals r")
    , @NamedQuery(name = "Rentals.findById", query = "SELECT r FROM Rentals r WHERE r.id = :id")
    , @NamedQuery(name = "Rentals.findByStatus", query = "SELECT r FROM Rentals r WHERE r.status = :status")
    , @NamedQuery(name = "Rentals.findByStartsAt", query = "SELECT r FROM Rentals r WHERE r.startsAt = :startsAt")
    , @NamedQuery(name = "Rentals.findByEndsAt", query = "SELECT r FROM Rentals r WHERE r.endsAt = :endsAt")})
public class Rentals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Column(name = "starts_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startsAt;
    @Column(name = "ends_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endsAt;
    @JoinTable(name = "rental_has_car", joinColumns = {
        @JoinColumn(name = "rental_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Cars> carsCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userId;

    public Rentals() {
    }

    public Rentals(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    public Date getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Date endsAt) {
        this.endsAt = endsAt;
    }

    @XmlTransient
    public Collection<Cars> getCarsCollection() {
        return carsCollection;
    }

    public void setCarsCollection(Collection<Cars> carsCollection) {
        this.carsCollection = carsCollection;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof Rentals)) {
            return false;
        }
        Rentals other = (Rentals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rentals[ id=" + id + " ]";
    }

}
