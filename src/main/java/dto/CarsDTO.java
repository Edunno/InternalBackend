/* Esben; DECK-CS */
package dto;

import entity.Cars;
import entity.LocationsTime;
import entity.Rentals;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Esben All rights belong to respective contributors.
 */
public class CarsDTO {

    int id;
    String priceClass;
    int distDriven;
    String brand;
    String model;
    String comments;
    String pyear;
    String regno;
    ArrayList<RentalsDTO> rentalList = new ArrayList();
    ArrayList<LocationsTimeDTO> locationTimeList = new ArrayList();

    public CarsDTO(Cars a) {
        this.id = a.getId();
        this.distDriven = a.getDistDriven();
        this.brand = a.getBrand();
        this.model = a.getModel();
        this.priceClass = a.getPriceClass();
        this.comments = a.getComments();
        this.pyear = a.getYear();
        if (!a.getRentalsCollection().isEmpty()) {
            for(Rentals aR : a.getRentalsCollection()){
                this.rentalList.add(new RentalsDTO(aR));
            }
        }
        if (!a.getLocationsTimeCollection().isEmpty()) {
            for(LocationsTime aT : a.getLocationsTimeCollection()){
                this.locationTimeList.add(new LocationsTimeDTO(aT));
            }
        }
    }

    public CarsDTO() {
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }
    
    
    
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getPriceClass() {
        return priceClass;
    }

    public void setPriceClass(String priceClass) {
        this.priceClass = priceClass;
    }

    public int getDistDriven() {
        return distDriven;
    }

    public void setDistDriven(int distDriven) {
        this.distDriven = distDriven;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getYear() {
        return pyear;
    }

    public void setYear(String pyear) {
        this.pyear = pyear;
    }

    public ArrayList<RentalsDTO> getRentalList() {
        return rentalList;
    }

    public void setRentalList(ArrayList<RentalsDTO> rentalList) {
        this.rentalList = rentalList;
    }

    public ArrayList<LocationsTimeDTO> getLocationTimeList() {
        return locationTimeList;
    }

    public void setLocationTimeList(ArrayList<LocationsTimeDTO> locationTimeList) {
        this.locationTimeList = locationTimeList;
    }
    
    public void cleanLists(){
        rentalList = null;
        locationTimeList = null;
        System.gc();
    }

}
