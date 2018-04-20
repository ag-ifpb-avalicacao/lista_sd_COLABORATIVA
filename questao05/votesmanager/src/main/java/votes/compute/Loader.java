/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.compute;

import javax.xml.ws.Endpoint;
import votes.compute.service.ComputerImpl;
import votes.compute.worker.VotingWorker;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9091/Computer", new ComputerImpl());
        Thread worker = new VotingWorker("Worker");
        worker.start();
    }
}
