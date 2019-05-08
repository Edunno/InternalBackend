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
    String name;
    int distDriven;
    String brand;
    String model;
    int price;
    String comments;
    String createdAt;
    ArrayList<Integer> rentalList;
    ArrayList<Integer> locationTimeList;

    public CarsDTO(Cars a) {
        this.id = a.getId();
        this.name = a.getName();
        this.distDriven = a.getDistDriven();
        this.brand = a.getBrand();
        this.model = a.getModel();
        this.price = a.getPrice();
        this.comments = a.getComments();
        this.createdAt = a.getCreatedAt();
        if (!a.getRentalsCollection().isEmpty()) {
            for (Rentals aR : a.getRentalsCollection()) {
                this.rentalList.add(new RentalsDTO(aR).getId());
            }
        }
        if (!a.getLocationsTimeCollection().isEmpty()) {
            for (LocationsTime aT : a.getLocationsTimeCollection()) {
                this.locationTimeList.add(new LocationsTimeDTO(aT).getId());
            }
        }
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<Integer> getRentalList() {
        return rentalList;
    }

    public void setRentalList(ArrayList<Integer> rentalList) {
        this.rentalList = rentalList;
    }

    public ArrayList<Integer> getLocationTimeList() {
        return locationTimeList;
    }

    public void setLocationTimeList(ArrayList<Integer> locationTimeList) {
        this.locationTimeList = locationTimeList;
    }

    public void cleanLists() {
        rentalList = null;
        locationTimeList = null;
        System.gc();
    }

}
