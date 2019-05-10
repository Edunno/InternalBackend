/* Esben; DECK-CS */

package dto;

import entity.Rentals;
import entity.Role;
import entity.Users;
import java.util.Collection;
import java.util.List;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
public class UsersDTO {
    
    String userName;
    String fullName;
    String email;
    String gender;
    String dateOfBirth;
    String createdAt;
    int longitude;
    int latitude;
    Collection<Rentals> rentalsCollcetion;
    List<Role> role;

    public UsersDTO() {
    }
    
    
    
    public UsersDTO(Users a){
        this.userName = a.getUserName();
        this.fullName = a.getFullName();
        this.email = a.getEmail();
        this.gender = a.getGender();
        this.dateOfBirth = a.getDateOfBirth();
        this.createdAt = a.getCreatedAt();
        this.longitude = a.getUsrLongitude();
        this.latitude = a.getUsrLatitude();
        this.rentalsCollcetion = a.getRentalsCollection();
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public Collection<Rentals> getRentalsCollcetion() {
        return rentalsCollcetion;
    }

    public void setRentalsCollcetion(Collection<Rentals> rentalsCollcetion) {
        this.rentalsCollcetion = rentalsCollcetion;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
    
    
}
