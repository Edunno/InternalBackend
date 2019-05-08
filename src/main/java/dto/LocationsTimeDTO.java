/* Esben; DECK-CS */

package dto;

import entity.LocationsTime;
import java.util.Date;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
public class LocationsTimeDTO {

    int id;
    String name;
    String status;
    int startsAt;
    int endsAt;
    int longitude;
    int latitude;
    int carId;
    
    public LocationsTimeDTO(LocationsTime a){
        this.id = a.getId();
        this.name = a.getName();
        this.status = a.getStatus();
        this.startsAt = a.getStartsAt();
        this.endsAt = a.getEndsAt();
        this.longitude = a.getLocLongitude();
        this.latitude = a.getLocLatitude();
        this.carId = a.getCarId().getId();
    }
    
    
    
}
