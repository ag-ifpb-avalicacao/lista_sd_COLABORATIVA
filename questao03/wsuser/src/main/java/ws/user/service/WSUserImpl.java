/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.user.service;

import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;
import ws.shared.User;
import ws.user.repository.RepositorySingleton;

/**
 *
 * @author juan
 */
@WebService(
        serviceName = "WSUserService",
        endpointInterface = "ws.user.service.WSUser"
)
public class WSUserImpl implements WSUser {

    private RepositorySingleton repo;

    public WSUserImpl() {
        repo = RepositorySingleton.getInstance();
    }

    @Override
    public boolean store(User user) throws RemoteException {
        return repo.store(user);
    }

    @Override
    public List<User> list() throws RemoteException {
        return repo.list();
    }

    @Override
    public boolean remove(String nickname) throws RemoteException {
        return repo.remove(nickname);
    }

}
