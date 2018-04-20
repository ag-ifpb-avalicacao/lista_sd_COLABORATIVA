package br.com.ifpb.sd.chat.rs;

import br.com.ifpb.sd.shared.Message;
import br.com.ifpb.sd.shared.User;
import javax.json.JsonArray;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author rodrigobento
 */
@Path("chat")
public class ChatResource {
    
    private Client client;
    
    public ChatResource() {
        this.client = ClientBuilder.newClient();
    }
    
    @GET
    @Path("/allUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        WebTarget target = client.target("http://user:8080/user-rs/user/all");
        JsonArray array = target.request(MediaType.APPLICATION_JSON).get().readEntity(JsonArray.class);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600").entity(array).build();
    }
    
    @GET
    @Path("/allMessages")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages() {
        WebTarget target = client.target("http://message:8080/message-rs/message/all");
        JsonArray resp = target.request(MediaType.APPLICATION_JSON).get().readEntity(JsonArray.class);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600").entity(resp).build();
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        WebTarget target = client.target("http://user:8080/user-rs/user/login");
        target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
        return Response.created(null)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(user).build();
    }
    
    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logout(User user) {
        WebTarget target = client.target("http://user:8080/user-rs/user/logout");
        target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
        return Response.created(null)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(user).build();
    }   
    
    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertMessage(Message msg) {
        WebTarget target = client.target("http://message:8080/message-rs/message/insert");
        target.request().post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        return Response.created(null)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(msg).build();
    }
    
}
