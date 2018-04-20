/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.consume;

import java.io.IOException;
import java.net.URL;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import votes.shared.Manager;

/**
 *
 * @author juan
 */
public class SubscribeServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            URL wsdlDocumentLocation = new URL("http://localhost:9090/Manager");
            QName serviceName = new QName("http://service.manager.votes/", "ManagerService");
            Service service = Service.create(wsdlDocumentLocation, serviceName);
            QName portName = new QName("http://service.manager.votes/", "ManagerServicePort");
            Manager manager = service.getPort(portName, Manager.class);
            manager.subscribe("http://localhost:8080/voteListener");
            res.sendRedirect("main.html");
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }    
}
