/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.message;

import javax.xml.ws.Endpoint;
import ws.message.service.WSMessageImpl;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9090/WSMessage", new WSMessageImpl());
    }
}
