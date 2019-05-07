/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import data.CarsFacade;
import dto.CarsDTO;
import entity.Cars;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Esben
 */
@Path("Cars")
public class CarsResource {

    @Context
    private UriInfo context;
    Gson gson = new Gson();
    CarsFacade cF = new CarsFacade();

    /**
     * Creates a new instance of CarsResource
     */
    public CarsResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CarsResource
     * @param brand
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/brand/{brand}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByBrand(@PathParam ("brand") String brand){
        ArrayList<CarsDTO> resP = new ArrayList();
        for(Cars c : (Collection<Cars>) cF.getByBrand(brand)){
            resP.add(new CarsDTO(c));
        }
        return Response.ok().entity(gson.toJson(resP)).build();
    }
    
    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCars(){
        ArrayList<CarsDTO> resP = new ArrayList();
        for(Cars c : (Collection<Cars>) cF.getAllCars()){
            resP.add(new CarsDTO(c));
        }
        System.out.println(resP.get(0).getBrand());
        return Response.ok().entity(gson.toJson(resP)).build();
    }

    /**
     * PUT method for updating or creating an instance of CarsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}