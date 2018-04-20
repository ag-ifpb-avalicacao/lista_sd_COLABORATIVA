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
        name = "Manager"
)
public interface Manager {
    @WebMethod
    @Oneway
    public void subscribe(String URL);
    @WebMethod
    public String vote(String candidate);
}
