/* Esben; DECK-CS */

package dto;

import entity.Cars;
import entity.Rentals;
import java.util.Collection;
import java.util.Date;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
public class RentalsDTO {

    int id;
    String status;
    Date startsAt;
    Date endsAt;
    Collection<Cars> carsCollection;
    int userId;
    
    public RentalsDTO(Rentals a){
        this.id = a.getId();
        this.status = a.getStatus();
        this.startsAt= a.getStartsAt();
        this.endsAt = a.getEndsAt();
        this.carsCollection = a.getCarsCollection();
        this.userId = a.getUserId().getId();
    }
}
