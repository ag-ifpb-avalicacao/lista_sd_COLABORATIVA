
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
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
public class VoteTest {

    @Test 
    public void serviceTest() {
        try {
            URL wsdlDocumentLocation = new URL("http://localhost:9090/Manager");
            QName serviceName = new QName("http://service.manager.votes/", "ManagerService");
            Service service = Service.create(wsdlDocumentLocation, serviceName);
            QName portName = new QName("http://service.manager.votes/", "ManagerServicePort");
            Manager manager = service.getPort(portName, Manager.class);
            String id = manager.vote("Killua");
            System.out.println(id);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
}
