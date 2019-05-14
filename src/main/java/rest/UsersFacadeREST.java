/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import data.LocationsTimeFacade;
import data.UserFacade;
import dto.CarsDTO;
import dto.UsersDTO;
import entity.Cars;
import entity.LocationsTime;
import entity.Users;
import exceptions.AuthenticationException;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author caspe
 */
@Stateless
@Path("users")
public class UsersFacadeREST {

    @Context
    private UriInfo context;
    Gson gson = new Gson();
    UserFacade uf = new UserFacade();

    public UsersFacadeREST() {
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response getAllUsers() {
        
//           String hi = "{\"msg\":\"response from server\"}";
        ArrayList<UsersDTO> uList = new ArrayList();
        for (Users u : (Collection<Users>) uf.getAllUsers()) {
            UsersDTO nUser = new UsersDTO(u);
            uList.add(nUser);
        }   
        return Response.ok().entity(gson.toJson(uList)).build();
//        return Response.ok().entity(hi).build();
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response getById(@PathParam("username") String username) {

        Users u = uf.getUserByUsername(username);
        UsersDTO udto = new UsersDTO(u);
        
        return Response.ok().entity(gson.toJson(udto)).build();
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

}
