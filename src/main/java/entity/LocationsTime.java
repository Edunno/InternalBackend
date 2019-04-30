/* Esben; DECK-CS */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
@Entity
@Table(name = "locations_time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocationsTime.findAll", query = "SELECT l FROM LocationsTime l")
    , @NamedQuery(name = "LocationsTime.findById", query = "SELECT l FROM LocationsTime l WHERE l.id = :id")
    , @NamedQuery(name = "LocationsTime.findByName", query = "SELECT l FROM LocationsTime l WHERE l.name = :name")
    , @NamedQuery(name = "LocationsTime.findByStatus", query = "SELECT l FROM LocationsTime l WHERE l.status = :status")
    , @NamedQuery(name = "LocationsTime.findByStartsAt", query = "SELECT l FROM LocationsTime l WHERE l.startsAt = :startsAt")
    , @NamedQuery(name = "LocationsTime.findByEndsAt", query = "SELECT l FROM LocationsTime l WHERE l.endsAt = :endsAt")
    , @NamedQuery(name = "LocationsTime.findByLocLongitude", query = "SELECT l FROM LocationsTime l WHERE l.locLongitude = :locLongitude")
    , @NamedQuery(name = "LocationsTime.findByLocLatitude", query = "SELECT l FROM LocationsTime l WHERE l.locLatitude = :locLatitude")})
public class LocationsTime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Column(name = "starts_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startsAt;
    @Column(name = "ends_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endsAt;
    @Column(name = "loc_longitude")
    private Integer locLongitude;
    @Column(name = "loc_latitude")
    private Integer locLatitude;
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cars carId;

    public LocationsTime() {
    }

    public LocationsTime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getLocLongitude() {
        return locLongitude;
    }

    public void setLocLongitude(Integer locLongitude) {
        this.locLongitude = locLongitude;
    }

    public Integer getLocLatitude() {
        return locLatitude;
    }

    public void setLocLatitude(Integer locLatitude) {
        this.locLatitude = locLatitude;
    }

    public Cars getCarId() {
        return carId;
    }

    public void setCarId(Cars carId) {
        this.carId = carId;
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
        if (!(object instanceof LocationsTime)) {
            return false;
        }
        LocationsTime other = (LocationsTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LocationsTime[ id=" + id + " ]";
    }

}
