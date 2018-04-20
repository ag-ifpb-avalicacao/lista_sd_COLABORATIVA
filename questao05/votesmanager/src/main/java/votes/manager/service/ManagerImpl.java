/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.manager.service;

import votes.shared.Manager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import votes.shared.Computer;
import votes.manager.repository.RepositorySingleton;

/**
 *
 * @author juan
 */
@WebService(
        endpointInterface = "votes.shared.Manager",
        serviceName = "ManagerService",
        portName = "ManagerServicePort"
)
public class ManagerImpl implements Manager {
    
    private Computer computer;
    private static List<Integer> idList;
    RepositorySingleton repo;

    public ManagerImpl() {
        idList = new ArrayList<>();
        repo = RepositorySingleton.getInstance();
    }

    @Override
    public void subscribe(String URL) {
        try {
            URL wsdlDocumentLocation = new URL("http://localhost:9091/Computer");
            QName serviceName = new QName("http://service.compute.votes/", "ComputerService");
            Service service = Service.create(wsdlDocumentLocation, serviceName);
            QName portName = new QName("http://service.compute.votes/", "ComputerServicePort");
            computer = service.getPort(portName, Computer.class);
            computer.registry(URL);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public String vote(String candidate) {
        int voteId = createId();
        String response = repo.store(voteId, candidate);
        if(response.equals("OK"))
            return Integer.toString(voteId);
        return "ERROR";
    }

    public int createId() {
        int voteId = UUID.randomUUID().hashCode() / 100;
        if (idList.contains(voteId)) {
            return createId();
        } else {
            idList.add(voteId);
            return voteId;
        }
    }
}
