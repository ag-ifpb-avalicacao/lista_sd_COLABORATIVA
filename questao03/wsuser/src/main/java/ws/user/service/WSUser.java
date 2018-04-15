/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.user.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import ws.shared.User;

/**
 *
 * @author juan
 */
@WebService(
        name = "WSUser"
)
public interface WSUser extends Remote{
    @WebMethod
    public boolean store(User user) throws RemoteException;
    @WebMethod
    public List<User> list() throws RemoteException;
    @WebMethod
    public boolean remove(String nickname) throws RemoteException;
}
