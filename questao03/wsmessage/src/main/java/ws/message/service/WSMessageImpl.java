/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.message.service;

import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;
import ws.message.repository.RepositorySingleton;
import ws.shared.Message;

/**
 *
 * @author juan
 */
@WebService(
        serviceName = "WSMessageService",
        endpointInterface = "ws.message.service.WSMessage"
)
public class WSMessageImpl implements WSMessage {

    private RepositorySingleton repo;

    public WSMessageImpl() {
        repo = RepositorySingleton.getInstance();
    }

    @Override
    public boolean store(Message message) throws RemoteException {
        return repo.store(message);
    }

    @Override
    public List<Message> list() throws RemoteException {
        return repo.list();
    }

}
