package br.com.ifpb.sd.chat.rs;

import br.com.ifpb.sd.chat.infra.Marshaller;
import br.com.ifpb.sd.shared.Message;
import br.com.ifpb.sd.shared.User;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClientBuilder;

/**
 * REST Web Service
 *
 * @author rodrigobento
 */
@Path("chat")
public class ChatResource {
    
    private ClientConfig config;
    private Client client;
    
    public ChatResource() {
        this.config = new ClientConfig(JacksonJsonProvider.class);
        this.client = JerseyClientBuilder.createClient(config);
    }
    
    @GET
    @Path("/allUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        WebTarget target = client.target("http://user:8081/user-rs/user/all");
//        WebTarget target = client.target("http://localhost:8081/user-rs/user/all");
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        String resp = invocation.get().readEntity(String.class);
        List<User> users = Marshaller.unMarshallerUser(resp);
        System.out.println(users.toString());
        GenericEntity<List<User>> user = new GenericEntity<List<User>>(users){};
        return Response.ok().entity(user).build();
    }
    
    @GET
    @Path("/allMessages")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages() {
        WebTarget target = client.target("http://message:8083/message-rs/message/all");
//        WebTarget target = client.target("http://localhost:8083/message-rs/message/all");
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        String resp = invocation.get().readEntity(String.class);
        List<Message> msgs = Marshaller.unMarshallerMessage(resp);
        System.out.println(msgs.toString());
        GenericEntity<List<Message>> user = new GenericEntity<List<Message>>(msgs){};
        return Response.ok().entity(user).build();
    }
    
    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login() {
        User u = new User();
        u.setNickname("TIGI - TESTE");
        u.setPass("123");
        WebTarget target = client.target("http://user:8081/user-rs/user/login");
//        WebTarget target = client.target("http://localhost:8081/user-rs/user/login");
        Invocation.Builder invocation = target.request();
        Response response = invocation.post(Entity.entity(u, MediaType.APPLICATION_JSON));
        System.out.println("Adicionado, codigo: " + response);
        return Response.ok().entity(u).build();
    }
    
    @GET
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        User u = new User();
        u.setNickname("TIGI - TESTE");
        u.setPass("321");
        WebTarget target = client.target("http://user:8081/user-rs/user/logout");
//        WebTarget target = client.target("http://localhost:8081/user-rs/user/logout");
        Invocation.Builder invocation = target.request();
        Response response = invocation.post(Entity.entity(u, MediaType.APPLICATION_JSON));
        System.out.println("Adicionado, codigo: " + response.getStatus());
        return Response.ok().entity(u).build();
    }   
    
    @GET
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertMessage() {
        Message msg = new Message();
        msg.setContent("CHAT TESTE");
        msg.setUserOwner("CHAT");
        WebTarget target = client.target("http://message:8083/message-rs/message/insert");
//        WebTarget target = client.target("http://localhost:8083/message-rs/message/insert");
        Invocation.Builder invocation = target.request();
        Response resp = invocation.post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        System.out.println("Adicionado, codigo: " + resp.getStatus());
        return Response.ok().entity(msg).build();
    }
    
//    @POST
//    @Path("/login")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void login(User user) {
//        WebTarget target = client.target("http://localhost:8081/user-rs/user/login");
//        Invocation.Builder invocation = target.request();
//        Response response = invocation.post(Entity.entity(user, MediaType.APPLICATION_JSON));
//        System.out.println("Adicionado, codigo: " + response);
//    }
//    
//    @POST
//    @Path("/logout")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void logout(User user) {
//        WebTarget target = client.target("http://localhost:8081/user-rs/user/logout");
//        Invocation.Builder invocation = target.request();
//        Response response = invocation.post(Entity.entity(user, MediaType.APPLICATION_JSON));
//        System.out.println("Adicionado, codigo: " + response.getStatus());
//    }   
//    
//    @POST
//    @Path("/insert")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void insertMessage(Message msg) {
//        WebTarget target = client.target("http://localhost:8082/message-rs/message/insert");
//        Invocation.Builder invocation = target.request();
//        Response resp = invocation.post(Entity.entity(msg, MediaType.APPLICATION_JSON));
//        System.out.println("Adicionado, codigo: " + resp.getStatus());
//    }
    
}
