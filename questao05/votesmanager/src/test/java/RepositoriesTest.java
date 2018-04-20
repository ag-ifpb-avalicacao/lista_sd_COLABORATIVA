
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.UUID;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.junit.BeforeClass;
import org.junit.Test;
import votes.shared.Manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juan
 */
public class RepositoriesTest {
    
    private static votes.compute.repository.RepositorySingleton computeRepo;
    private static votes.manager.repository.RepositorySingleton managerRepo;
    
    @BeforeClass
    public static void createRepos() {
        computeRepo = votes.compute.repository.RepositorySingleton.getInstance();
        managerRepo = votes.manager.repository.RepositorySingleton.getInstance();
    }
    
    @Test
    public void countingVotes() {
        computeRepo.storeSubscribe("localhost:8080/Votelistener1/");
        String id = managerRepo.store(UUID.randomUUID().hashCode() / 100, "Killua");
        System.out.println("voted: " + id);
        String id2 = managerRepo.store(UUID.randomUUID().hashCode() / 100, "Gon");
        System.out.println("voted: " + id2);
        Map<String, Integer> votations = computeRepo.getVotations();
        votations.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
