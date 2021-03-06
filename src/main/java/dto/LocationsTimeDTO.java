/* Esben; DECK-CS */
package dto;

import entity.LocationsTime;
import java.util.Date;

/**
 * @author Esben All rights belong to respective contributors.
 */
public class LocationsTimeDTO {

    int id;
    String name;
    String carStatus;
    int startsAt;
    int endsAt;
    double longitude;
    double latitude;
    int carId;

    public LocationsTimeDTO(LocationsTime a) {
        this.id = a.getId();
        this.name = a.getName();
        this.carStatus = a.getStatus();
        this.startsAt = a.getStartsAt();
        this.endsAt = a.getEndsAt();
        this.longitude = a.getLocLongitude();
        this.latitude = a.getLocLatitude();
        this.carId = a.getCarId().getId();
    }

    public LocationsTimeDTO() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(int startsAt) {
        this.startsAt = startsAt;
    }

    public int getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(int endsAt) {
        this.endsAt = endsAt;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

}
