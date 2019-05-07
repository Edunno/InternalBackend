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
    
    int id;
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
    
    public UsersDTO(Users a){
        this.id = a.getId();
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
}
