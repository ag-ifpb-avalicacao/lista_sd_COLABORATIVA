/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import votes.shared.VoteApp;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        try {
            URL wsdlDocumentLocation = new URL("http://localhost:9092/Vote");
            QName serviceName = new QName("http://service.app.votes/", "VoteService");
            Service service = Service.create(wsdlDocumentLocation, serviceName);
            QName portName = new QName("http://service.app.votes/", "VoteServicePort");
            VoteApp voteApp = service.getPort(portName, VoteApp.class);
            String id = voteApp.vote("Killua");
            System.out.println(id);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
