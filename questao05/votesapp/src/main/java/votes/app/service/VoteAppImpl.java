/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.app.service;

import votes.shared.VoteApp;
import java.net.MalformedURLException;
import java.net.URL;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import votes.shared.Manager;

/**
 *
 * @author juan
 */
@WebService(
        endpointInterface = "votes.shared.VoteApp",
        serviceName = "VoteService",
        portName = "VoteServicePort"
)
public class VoteAppImpl implements VoteApp {

    private Manager manager;

    @Override
    public String vote(String candidate) {
        try {
            URL wsdlDocumentLocation = new URL("http://localhost:9090/Manager");
            QName serviceName = new QName("http://service.manager.votes/", "ManagerService");
            Service service = Service.create(wsdlDocumentLocation, serviceName);
            QName portName = new QName("http://service.manager.votes/", "ManagerServicePort");
            manager = service.getPort(portName, Manager.class);
            return manager.vote(candidate);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}
