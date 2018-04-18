/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.sd.user.rs;

import br.com.ifpb.sd.shared.User;
import br.com.ifpb.sd.user.repository.UserDao;
import br.com.ifpb.sd.user.repository.UserDaoImpl;
import br.com.ifpb.sd.user.repository.UserDaoSingleton;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author rodrigobento
 */
@Path("user")
public class UserResource {
    
    private UserDaoSingleton dao;
    
    public UserResource() {
        dao = UserDaoSingleton.getInstance();
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        GenericEntity<List<User>> user = new GenericEntity<List<User>>(dao.listAll()){};
        return Response.ok().entity(user).build();
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public void login(User user) {
        System.out.println("Requisição recebida...");
        dao.login(user);
    }
    
    @POST
    @Path("logout")
    @Consumes(MediaType.APPLICATION_JSON)
    public void logout(User user) {
        System.out.println("Requisição recebida...");
        dao.logout(user);
    }
    
}
