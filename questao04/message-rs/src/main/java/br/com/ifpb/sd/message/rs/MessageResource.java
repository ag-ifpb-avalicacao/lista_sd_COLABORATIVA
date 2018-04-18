package br.com.ifpb.sd.message.rs;

import br.com.ifpb.sd.message.repository.MessageDaoSingleton;
import br.com.ifpb.sd.shared.Message;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("message")
public class MessageResource {

    private MessageDaoSingleton dao;

    public MessageResource() {
        this.dao = MessageDaoSingleton.getInstance();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allMessages() {
        System.out.println("Requisição recebida");
        GenericEntity<List<Message>> msgs = new GenericEntity<List<Message>>(dao.listAll()) {
        };
        return Response.ok(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(msgs).build();
    }

    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertMessage(Message message) {
        System.out.println("Invocação recebida, msg: " + message.toString());
        dao.insert(message);
    }

}
