/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.shared;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author juan
 */
@WebService(
        name = "Computer"
)
public interface Computer {
    @WebMethod
    @Oneway
    public void registry(String URL);
    @WebMethod
    public void notifySub();
}
