/* Esben; DECK-CS */

package rest;

import com.google.gson.Gson;
import data.CarsFacade;
import data.LocationsTimeFacade;
import data.RentalsFacade;
import dto.CarsDTO;
import entity.Cars;
import entity.LocationsTime;
import entity.Rentals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */

@Path("rental")
public class RentalsResource {
    @Context
    private UriInfo context;
    
    @Context
    SecurityContext securityContext;
    Gson gson = new Gson();
    RentalsFacade rF = new RentalsFacade();
    
    public RentalsResource(){
        
    }
    
    @POST
    @Path("/addrental")
    @Consumes(MediaType.APPLICATION_JSON)
    public void postNewRental(String content){
        Rentals r = gson.fromJson(content, Rentals.class);
        CarsFacade cF = new CarsFacade();
        LocationsTimeFacade lTF = new LocationsTimeFacade();
        for(Cars c : r.getCarsCollection()){
            Cars lCar =  cF.getCarById(c.getId());
            LocationsTime lT = new LocationsTime();
            lT.setStartsAt(r.getStartsAt());
            lT.setEndsAt(r.getEndsAt());
            lT.setCarId(lCar);
            lT.setStatus("Occupied");
            lTF.addLocationsTime(lT);
            ;
        }
        rF.addRental(r);
    }

}
