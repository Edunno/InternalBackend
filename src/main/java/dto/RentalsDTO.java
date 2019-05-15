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
    int startsAt;
    int endsAt;
    ArrayList<CarsDTO> carsCollection;
    String userName;

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
        this.userName = a.getUserName().getUserName();
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

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userName) {
        this.userName = userName;
    }
    
    
}
