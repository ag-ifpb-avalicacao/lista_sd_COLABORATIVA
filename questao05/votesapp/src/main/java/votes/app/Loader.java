/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.app;

import javax.xml.ws.Endpoint;
import votes.app.service.VoteAppImpl;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9092/Vote", new VoteAppImpl());
    }
}
