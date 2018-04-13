/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.monitor.server;

import task.monitor.server.service.MonitorImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author juan
 */
public class Server {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9090/Monitor", new MonitorImpl());
    }
}
