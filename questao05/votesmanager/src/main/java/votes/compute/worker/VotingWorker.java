/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.compute.worker;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import votes.compute.repository.RepositorySingleton;
import votes.shared.Computer;

/**
 *
 * @author juan
 */
public class VotingWorker extends Thread {

    private RepositorySingleton repo;
    private Computer computer;
    private static int rowsCount = 0;

    public VotingWorker(String name) {
        super(name);
        try {
            repo = RepositorySingleton.getInstance();
            URL wsdlDocumentLocation = new URL("http://localhost:9091/Computer");
            QName serviceName = new QName("http://service.compute.votes/", "ComputerService");
            Service service = Service.create(wsdlDocumentLocation, serviceName);
            QName portName = new QName("http://service.compute.votes/", "ComputerServicePort");
            computer = service.getPort(portName, Computer.class);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                int updateCount = repo.countRows();
                if (updateCount > rowsCount) {
                    Map<String, Integer> votes = repo.getVotations();
                    repo.updateVotation(votes.get("Killua"), votes.get("Gon"));
                    rowsCount = updateCount;
                    computer.notifySub();
                }
            } catch (InterruptedException ex) {
                System.out.println("occurred an error trying to block the Worker thread: " + ex.getMessage());
            }
        }
    }
}
