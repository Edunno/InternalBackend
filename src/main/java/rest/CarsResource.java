/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import data.CarsFacade;
import data.LocationsTimeFacade;
import dto.CarsDTO;
import entity.Cars;
import entity.LocationsTime;
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
 * REST Web Service
 *
 * @author Esben
 */
@Path("cars")
public class CarsResource {

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;
    Gson gson = new Gson();
    CarsFacade cF = new CarsFacade();

    /**
     * Creates a new instance of CarsResource
     */
    public CarsResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CarsResource
     *
     * @param brand
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCars() {
        ArrayList<CarsDTO> resP = new ArrayList();
        for (Cars c : (Collection<Cars>) cF.getAllCars()) {
            CarsDTO nCar = new CarsDTO(c);
//            nCar.cleanLists();
            resP.add(nCar);
        }
        return Response.ok().entity(gson.toJson(resP)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        Cars c = cF.getCarById(id);
        CarsDTO cdto = new CarsDTO(c);

        return Response.ok().entity(gson.toJson(cdto)).build();
    }

    @GET
    @Path("/class/{priceClass}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByClass(@PathParam("priceClass") String priceClass) {
        ArrayList<CarsDTO> cList = new ArrayList();
        for (Cars c : (Collection<Cars>) cF.getByPriceClass(priceClass)) {
            cList.add(new CarsDTO(c));
        }
        return Response.ok().entity(gson.toJson(cList)).build();
    }

    @GET
    @Path("/brand/{brand}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByBrand(@PathParam("brand") String brand) {
        ArrayList<CarsDTO> resP = new ArrayList();
        for (Cars c : (Collection<Cars>) cF.getByBrand(brand)) {
            resP.add(new CarsDTO(c));
        }
        return Response.ok().entity(gson.toJson(resP)).build();
    }

    @GET
    @Path("/period/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPeriod(@PathParam("startDate") int startDate, @PathParam("endDate") int endDate) {
        LocationsTimeFacade lF = new LocationsTimeFacade();
        Collection<LocationsTime> cLT = lF.getByDateAndStatus(startDate, endDate, "Available");
        ArrayList<CarsDTO> resp = new ArrayList();
        for (LocationsTime l : cLT) {
            resp.add(new CarsDTO(l.getCarId()));
        }
        return Response.ok().entity(gson.toJson(resp)).build();
    }

//    @GET
//    @Path("/pricemax/{maxPrice}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getByPrice(@PathParam("maxPrice") int maxPrice) {
//        ArrayList<CarsDTO> resp = new ArrayList();
//        for (Cars l : (Collection<Cars>) cF.getByPriceMax(maxPrice)) {
//            resp.add(new CarsDTO(l));
//        }
//        return Response.ok().entity(gson.toJson(resp)).build();
//    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public void postCar(String content) {
        Cars c = gson.fromJson(content, Cars.class);
        cF.addCar(c);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response deleteCarByID(@PathParam("id") int id) {
        Cars c = cF.deleteCarByID(id);
        return Response.ok().entity(gson.toJson(c)).build();
    }
    
        @POST
    @Path("/period")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void postLocTime(String content) {
        LocationsTime locT = gson.fromJson(content, LocationsTime.class);
        LocationsTimeFacade lF = new LocationsTimeFacade();
        lF.addLocationsTime(locT);
    }

    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeQuery(
            @QueryParam("brand") String brand,
            @QueryParam("model") String model,
            @QueryParam("priceclass") String pClass,
            @QueryParam("startdate") Integer dstart,
            @QueryParam("enddate") Integer dend,
            @QueryParam("distmax") int distmax,
            @QueryParam("distmin") int distmin,
            @QueryParam("latitude") double latitude,
            @QueryParam("longitude") double longitude) {
        
        testParameters(brand,model,pClass,dstart,dend,distmax,distmin,latitude,longitude);
        Collection<Cars> cCol = cF.getMultiSearch(brand, model, pClass, dstart, dend, distmax, distmin, latitude,longitude);
        ArrayList<CarsDTO> resp = new ArrayList();
        for(Cars c : cCol){
            resp.add(new CarsDTO(c));
        }
        return Response.ok().entity(gson.toJson(resp)).build();
    }

    /**
     * PUT method for updating or creating an instance of CarsResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    private void testParameters(String brand, String model, String pClass, Integer dstart, Integer dend, int distmax, int distmin, double latitude, double longitude) {
        
    }
}
