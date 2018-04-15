/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.chat.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import ws.message.service.Message;
import ws.user.service.User;

/**
 *
 * @author juan
 */
@WebService(
        name = "WSChat"
)
public interface WSChat extends Remote {
    @WebMethod
    public boolean login(User user) throws RemoteException;
    @WebMethod
    public boolean logout(String nickname) throws RemoteException;
    @WebMethod
    public boolean sendMessage(Message message) throws RemoteException;
    @WebMethod
    public List<User> listUsers() throws RemoteException;
    @WebMethod
    public List<Message> listMessages() throws RemoteException;
}
