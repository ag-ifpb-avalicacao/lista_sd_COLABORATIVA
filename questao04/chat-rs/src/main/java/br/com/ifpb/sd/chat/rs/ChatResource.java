//package br.com.ifpb.sd.chat.rs;
//
//import br.com.ifpb.sd.shared.Message;
//import br.com.ifpb.sd.shared.User;
//import java.util.List;
//import javax.json.JsonArray;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.Produces;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.GenericEntity;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
///**
// * REST Web Service
// *
// * @author rodrigobento
// */
//@Path("chat")
//public class ChatResource {
//    
//    private Client client;
//    
//    public ChatResource() {
//        this.client = ClientBuilder.newClient();
//    }
//    
//    @GET
//    @Path("/allUsers")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getUsers() {
//        WebTarget target = client.target("http://user:8080/user-rs/user/all");
//        JsonArray array = target.request(MediaType.APPLICATION_JSON).get().readEntity(JsonArray.class);
//        return Response.ok()
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .header("Access-Control-Max-Age", "1209600").entity(array).build();
////        WebTarget target = client.target("http://user:8085/user-rs/user/all");
////        WebTarget target = client.target("http://localhost:8085/user-rs/user/all");
//        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
//        String resp = invocation.get().readEntity(String.class);
//        List<User> users = Marshaller.unMarshallerUser(resp);
//        System.out.println(users.toString());
//        GenericEntity<List<User>> user = new GenericEntity<List<User>>(users){};
//        return Response.ok().entity(user).build();
//    }
//    
//    @GET
//    @Path("/allMessages")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getMessages() {
//<<<<<<< HEAD
//        WebTarget target = client.target("http://message:8080/message-rs/message/all");
//        JsonArray resp = target.request(MediaType.APPLICATION_JSON).get().readEntity(JsonArray.class);
//        return Response.ok()
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .header("Access-Control-Max-Age", "1209600").entity(resp).build();
//=======
//        WebTarget target = client.target("http://message:9090/message-rs/message/all");
////        WebTarget target = client.target("http://localhost:9090/message-rs/message/all");
//        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
//        String resp = invocation.get().readEntity(String.class);
//        List<Message> msgs = Marshaller.unMarshallerMessage(resp);
//        System.out.println(msgs.toString());
//        GenericEntity<List<Message>> user = new GenericEntity<List<Message>>(msgs){};
//        return Response.ok().entity(user).build();
//>>>>>>> 027542cc638816f7c6d17e3d7a48dd7988299c96
//    }
//    
//    @POST
//    @Path("/login")
//<<<<<<< HEAD
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response login(User user) {
//        WebTarget target = client.target("http://user:8080/user-rs/user/login");
//        target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
//        return Response.created(null)
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .header("Access-Control-Max-Age", "1209600")
//                .entity(user).build();
//=======
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response login() {
//        User u = new User();
//        u.setNickname("TIGI - TESTE");
//        u.setPass("123");
//        WebTarget target = client.target("http://user:8085/user-rs/user/login");
////        WebTarget target = client.target("http://localhost:8085/user-rs/user/login");
//        Invocation.Builder invocation = target.request();
//        Response response = invocation.post(Entity.entity(u, MediaType.APPLICATION_JSON));
//        System.out.println("Adicionado, codigo: " + response);
//        return Response.ok().entity(u).build();
//>>>>>>> 027542cc638816f7c6d17e3d7a48dd7988299c96
//    }
//    
//    @POST
//    @Path("/logout")
//<<<<<<< HEAD
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response logout(User user) {
//        WebTarget target = client.target("http://user:8080/user-rs/user/logout");
//        target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
//        return Response.created(null)
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .header("Access-Control-Max-Age", "1209600")
//                .entity(user).build();
//=======
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response logout() {
//        User u = new User();
//        u.setNickname("TIGI - TESTE");
//        u.setPass("321");
//        WebTarget target = client.target("http://user:8085/user-rs/user/logout");
////        WebTarget target = client.target("http://localhost:8085/user-rs/user/logout");
//        Invocation.Builder invocation = target.request();
//        Response response = invocation.post(Entity.entity(u, MediaType.APPLICATION_JSON));
//        System.out.println("Adicionado, codigo: " + response.getStatus());
//        return Response.ok().entity(u).build();
//>>>>>>> 027542cc638816f7c6d17e3d7a48dd7988299c96
//    }   
//    
//    @POST
//    @Path("/insert")
//<<<<<<< HEAD
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response insertMessage(Message msg) {
//        WebTarget target = client.target("http://message:8080/message-rs/message/insert");
//        target.request().post(Entity.entity(msg, MediaType.APPLICATION_JSON));
//        return Response.created(null)
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .header("Access-Control-Max-Age", "1209600")
//                .entity(msg).build();
//    }
//    
//=======
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response insertMessage() {
//        Message msg = new Message();
//        msg.setContent("CHAT TESTE");
//        msg.setUserOwner("CHAT");
//        WebTarget target = client.target("http://message:9090/message-rs/message/insert");
////        WebTarget target = client.target("http://localhost:9090/message-rs/message/insert");
//        Invocation.Builder invocation = target.request();
//        Response resp = invocation.post(Entity.entity(msg, MediaType.APPLICATION_JSON));
//        System.out.println("Adicionado, codigo: " + resp.getStatus());
//        return Response.ok().entity(msg).build();
//    }
//    
////    @POST
////    @Path("/login")
////    @Consumes(MediaType.APPLICATION_JSON)
////    public void login(User user) {
////        WebTarget target = client.target("http://localhost:8085/user-rs/user/login");
////        Invocation.Builder invocation = target.request();
////        Response response = invocation.post(Entity.entity(user, MediaType.APPLICATION_JSON));
////        System.out.println("Adicionado, codigo: " + response);
////    }
////    
////    @POST
////    @Path("/logout")
////    @Consumes(MediaType.APPLICATION_JSON)
////    public void logout(User user) {
////        WebTarget target = client.target("http://localhost:8085/user-rs/user/logout");
////        Invocation.Builder invocation = target.request();
////        Response response = invocation.post(Entity.entity(user, MediaType.APPLICATION_JSON));
////        System.out.println("Adicionado, codigo: " + response.getStatus());
////    }   
////    
////    @POST
////    @Path("/insert")
////    @Consumes(MediaType.APPLICATION_JSON)
////    public void insertMessage(Message msg) {
////        WebTarget target = client.target("http://localhost:9090/message-rs/message/insert");
////        Invocation.Builder invocation = target.request();
////        Response resp = invocation.post(Entity.entity(msg, MediaType.APPLICATION_JSON));
////        System.out.println("Adicionado, codigo: " + resp.getStatus());
////    }
//    
//>>>>>>> 027542cc638816f7c6d17e3d7a48dd7988299c96
//}
