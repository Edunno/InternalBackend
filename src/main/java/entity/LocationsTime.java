/* Esben; DECK-CS */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    , @NamedQuery(name = "LocationsTime.findByTimeAndStatus", query ="SELECT l FROM LocationsTime l WHERE l.carStatus = :status AND l.startsAt < :startsAt AND l.endsAt > :endsAt")
    , @NamedQuery(name = "LocationsTime.findById", query = "SELECT l FROM LocationsTime l WHERE l.id = :id")
    , @NamedQuery(name = "LocationsTime.findByName", query = "SELECT l FROM LocationsTime l WHERE l.name = :name")
    , @NamedQuery(name = "LocationsTime.findByStatus", query = "SELECT l FROM LocationsTime l WHERE l.carStatus = :status")
    , @NamedQuery(name = "LocationsTime.findByStartsAt", query = "SELECT l FROM LocationsTime l WHERE l.startsAt = :startsAt")
    , @NamedQuery(name = "LocationsTime.findByEndsAt", query = "SELECT l FROM LocationsTime l WHERE l.endsAt = :endsAt")
    , @NamedQuery(name = "LocationsTime.findByLocLongitude", query = "SELECT l FROM LocationsTime l WHERE l.locLongitude = :locLongitude")
    , @NamedQuery(name = "LocationsTime.findByLocLatitude", query = "SELECT l FROM LocationsTime l WHERE l.locLatitude = :locLatitude")})
public class LocationsTime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "car_status")
    private String carStatus;
    @Column(name = "starts_at")
    private Integer startsAt;
    @Column(name = "ends_at")
    private Integer endsAt;
    @Column(name = "loc_longitude")
    private double locLongitude;
    @Column(name = "loc_latitude")
    private double locLatitude;
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
        return carStatus;
    }

    public void setStatus(String status) {
        this.carStatus = status;
    }

    public Integer getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Integer startsAt) {
        this.startsAt = startsAt;
    }

    public Integer getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Integer endsAt) {
        this.endsAt = endsAt;
    }

    public double getLocLongitude() {
        return locLongitude;
    }

    public void setLocLongitude(double locLongitude) {
        this.locLongitude = locLongitude;
    }

    public double getLocLatitude() {
        return locLatitude;
    }

    public void setLocLatitude(double locLatitude) {
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
