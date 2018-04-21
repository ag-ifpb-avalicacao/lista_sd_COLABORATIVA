package br.com.ifpb.sd.server;

import br.com.ifpb.sd.repository.RepositorySingleton;
import br.com.ifpb.sd.shared.TaskEvent;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author rodrigobento
 */
@Path("task")
public class TaskEventResource {

    private RepositorySingleton dao = RepositorySingleton.getInstance();

    public TaskEventResource() {
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        GenericEntity<List<TaskEvent>> list = new GenericEntity<List<TaskEvent>>(
                dao.listAll()) {
        };
        return Response.ok(200).entity(list).build();
    }
    
    @GET
    @Path("/event/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEvent(@PathParam(value = "value") String value) {
        String aux = value.replaceAll("-", " ");
        System.out.println(aux);
        GenericEntity<List<TaskEvent>> list = new GenericEntity<List<TaskEvent>>(
                dao.listEvent(aux)) {
        };
        return Response.ok(200).entity(list).build();
    }
    
    @GET
    @Path("/group/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getValue(@PathParam(value = "value") String value) {
        String aux = value.replaceAll("-", " ");
        System.out.println(aux);
        GenericEntity<List<TaskEvent>> list = new GenericEntity<List<TaskEvent>>(
                dao.listGroup(aux)) {
        };
        return Response.ok(200).entity(list).build();
    }

    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(TaskEvent event) {
        dao.insert(event);
    }
}
