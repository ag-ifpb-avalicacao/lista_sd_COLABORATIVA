/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.user;

import javax.xml.ws.Endpoint;
import ws.user.service.WSUserImpl;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9091/WSUser", new WSUserImpl());
    }
}
