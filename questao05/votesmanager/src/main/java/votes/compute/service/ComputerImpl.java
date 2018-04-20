/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.compute.service;

import votes.shared.Computer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import votes.compute.repository.RepositorySingleton;

/**
 *
 * @author juan
 */
@WebService(
        endpointInterface = "votes.shared.Computer",
        serviceName = "ComputerService",
        portName = "ComputerServicePort"
)
public class ComputerImpl implements Computer{

    private final RepositorySingleton repo;
    
    public ComputerImpl() {
        repo = RepositorySingleton.getInstance();
    }
    
    @Override
    public void registry(String URL) {
        repo.storeSubscribe(URL);
    }

    @Override
    public void notifySub() {
        Map<String, Integer> votations = repo.getVotations();
        Integer candidate1 = votations.get("Killua");
        Integer candidate2 = votations.get("Gon");
        List<String> subscribeds = repo.getSubscribeds();
        if(subscribeds.isEmpty())
            return;
        HttpClient client = HttpClients.createDefault();
        HttpPost post;
        for (String URL : subscribeds) {
            post = new HttpPost(URL);
            List<NameValuePair> params = new ArrayList<>(2);
            params.add(new BasicNameValuePair("candidate1", Integer.toString(candidate1)));
            params.add(new BasicNameValuePair("candidate2", Integer.toString(candidate2)));
            try {
                post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
                client.execute(post);
            } catch (IOException ex) {
                System.out.println("an error occurred trying to send a post request to a subscribed host: " + ex.getMessage());
            }
        }
    }
    
}
