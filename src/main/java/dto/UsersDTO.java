/* Esben; DECK-CS */

package dto;

import entity.Rentals;
import entity.Users;
import java.util.Collection;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
public class UsersDTO {
    
    int id;
    String fullName;
    String email;
    String gender;
    String dateOfBirth;
    String createdAt;
    int longitude;
    int latitude;
    Collection<Rentals> rentalsCollcetion;
    
    public UsersDTO(Users a){
        this.id = a.getId();
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
