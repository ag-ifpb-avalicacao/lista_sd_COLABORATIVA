/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.chat;

import javax.xml.ws.Endpoint;
import ws.chat.service.WSChatImpl;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9092/WSChat", new WSChatImpl());
    }
}
