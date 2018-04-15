/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.chat.service;

import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;
import ws.message.service.Message;
import ws.message.service.WSMessage;
import ws.message.service.WSMessageService;
import ws.user.service.User;
import ws.user.service.WSUser;
import ws.user.service.WSUserService;

/**
 *
 * @author juan
 */
@WebService(
        serviceName = "WSChatService",
        endpointInterface = "ws.chat.service.WSChat"
)
public class WSChatImpl implements WSChat {

    private final WSUser wsUser;
    private final WSMessage wsMessage;

    public WSChatImpl() {
        wsUser = new WSUserService().getWSUserImplPort();
        wsMessage = new WSMessageService().getWSMessageImplPort();
    }

    @Override
    public boolean login(User user) throws RemoteException {
        return wsUser.store(user);
    }
    
    @Override
    public boolean logout(String nickname) throws RemoteException {
        return wsUser.remove(nickname);
    }

    @Override
    public List<User> listUsers() throws RemoteException {
        return wsUser.list();
    }
    
    @Override
    public boolean sendMessage(Message message) throws RemoteException {
        return wsMessage.store(message);
    }

    @Override
    public List<Message> listMessages() throws RemoteException {
        return wsMessage.list();
    }
}
