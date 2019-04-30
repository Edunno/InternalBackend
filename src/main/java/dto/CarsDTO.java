/* Esben; DECK-CS */

package dto;

import entity.Cars;
import entity.LocationsTime;
import entity.Rentals;
import java.util.Collection;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
public class CarsDTO {

    int id;
    String name;
    int distDriven;
    String brand;
    String model;
    int price;
    String comments;
    String createdAt;
    Collection<Rentals> rentalList;
    Collection<LocationsTime> locationTimeList;

    public CarsDTO(Cars a) {
        this.id = a.getId();
        this.name = a.getName();
        this.distDriven = a.getDistDriven();
        this.brand = a.getBrand();
        this.model = a.getModel();
        this.price = a.getPrice();
        this.comments = a.getComments();
        this.createdAt = a.getCreatedAt();
        this.rentalList = a.getRentalsCollection();
        this.locationTimeList = a.getLocationsTimeCollection();
    }
    
   
    
}
