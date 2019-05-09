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

    public RentalsDTO() {
    }
    
    
    
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

    public Integer getId() {
        return id;
    }

    public ArrayList<CarsDTO> getCarsCollection() {
        return carsCollection;
    }

    public void setCarsCollection(ArrayList<CarsDTO> carsCollection) {
        this.carsCollection = carsCollection;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
