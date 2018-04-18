/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.sd.user.rs;

import br.com.ifpb.sd.shared.User;
import br.com.ifpb.sd.user.repository.UserDaoSingleton;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
        System.out.println("Requisição recebida");
        GenericEntity<List<User>> user = new GenericEntity<List<User>>(dao.listAll()) {
        };
        return Response.ok(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(user).build();
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
