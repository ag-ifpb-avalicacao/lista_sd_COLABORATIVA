package br.com.ifpb.sd.client;

import br.com.ifpb.sd.shared.TaskEvent;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.json.JSONArray;

/**
 *
 * @author rodrigobento
 */
public class Main {

    private static ClientConfig config;
    private static Client client;
    
    public static void main(String[] args) {
        config = new ClientConfig(JacksonJsonProvider.class);
        client = JerseyClientBuilder.createClient(config);
        insert();
        listAll();
        listGroup("Group-1");
        listEvent("Event-2");
    }

    private static void insert() {
        TaskEvent event = new TaskEvent("Group 1", "Event 2", 
                System.currentTimeMillis());
        // Para executar localmente
//        WebTarget target = client.target("http://localhost:8080/server/task/insert");
        WebTarget target = client.target("http://server:8080/server/task/insert");
        Invocation.Builder builder = target.request();
        Response response = builder.post(Entity.entity(event, MediaType.APPLICATION_JSON));
        System.out.println("Adicionado. Codigo: " + response.getStatus());
    }

    private static void listAll() {
        // Para executar localmente
//        WebTarget target = client.target("http://localhost:8080/server/task/all");
        WebTarget target = client.target("http://server:8080/server/task/all");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        JSONArray array = new JSONArray(response.readEntity(String.class));
        Translate translate = new TranslateImpl();
        List<TaskEvent> tasks = translate.toTask(array);
        System.out.println(tasks.toString());
    }
    
    private static void listGroup(String group){
        // Para executar localmente
//        WebTarget target = client.target("http://localhost:8080/server/task/group/"+group);
        WebTarget target = client.target("http://server:8080/server/task/group/"+group);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        JSONArray array = new JSONArray(response.readEntity(String.class));
        Translate translate = new TranslateImpl();
        List<TaskEvent> tasks = translate.toTask(array);
        System.out.println(tasks.toString());
    }
    
    private static void listEvent(String event){
        // Para executar localmente
//        WebTarget target = client.target("http://localhost:8080/server/task/event/"+event);
        WebTarget target = client.target("http://server:8080/server/task/event/"+event);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        JSONArray array = new JSONArray(response.readEntity(String.class));
        Translate translate = new TranslateImpl();
        List<TaskEvent> tasks = translate.toTask(array);
        System.out.println(tasks.toString());
    }

}
