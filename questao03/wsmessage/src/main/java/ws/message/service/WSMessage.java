/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.message.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import ws.shared.Message;

/**
 *
 * @author juan
 */
@WebService(
        name = "WSMessage"
)
public interface WSMessage extends Remote{
    @WebMethod
    public boolean store(Message message) throws RemoteException;
    @WebMethod
    public List<Message> list() throws RemoteException;
}
