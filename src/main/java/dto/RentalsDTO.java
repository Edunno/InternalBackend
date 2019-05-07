/* Esben; DECK-CS */

package dto;

import entity.Cars;
import entity.Rentals;
import java.util.ArrayList;
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
    ArrayList<CarsDTO> carsCollection;
    int userId;
    
    public RentalsDTO(Rentals a){
        this.id = a.getId();
        this.status = a.getStatus();
        this.startsAt= a.getStartsAt();
        this.endsAt = a.getEndsAt();
        if(!a.getCarsCollection().isEmpty()){
            for(Cars aC : a.getCarsCollection()){
                this.carsCollection.add(new CarsDTO(aC));
            }
        }
        this.userId = a.getUserId().getId();
    }
}
