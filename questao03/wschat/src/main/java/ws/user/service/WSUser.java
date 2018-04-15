
package ws.user.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSUser", targetNamespace = "http://service.user.ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSUser {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "remove", targetNamespace = "http://service.user.ws/", className = "ws.user.service.Remove")
    @ResponseWrapper(localName = "removeResponse", targetNamespace = "http://service.user.ws/", className = "ws.user.service.RemoveResponse")
    @Action(input = "http://service.user.ws/WSUser/removeRequest", output = "http://service.user.ws/WSUser/removeResponse")
    public boolean remove(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<ws.user.service.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "list", targetNamespace = "http://service.user.ws/", className = "ws.user.service.List")
    @ResponseWrapper(localName = "listResponse", targetNamespace = "http://service.user.ws/", className = "ws.user.service.ListResponse")
    @Action(input = "http://service.user.ws/WSUser/listRequest", output = "http://service.user.ws/WSUser/listResponse")
    public List<User> list();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "store", targetNamespace = "http://service.user.ws/", className = "ws.user.service.Store")
    @ResponseWrapper(localName = "storeResponse", targetNamespace = "http://service.user.ws/", className = "ws.user.service.StoreResponse")
    @Action(input = "http://service.user.ws/WSUser/storeRequest", output = "http://service.user.ws/WSUser/storeResponse")
    public boolean store(
        @WebParam(name = "arg0", targetNamespace = "")
        User arg0);

}