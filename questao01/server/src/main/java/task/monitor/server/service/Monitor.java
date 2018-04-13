/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.monitor.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import task.monitor.shared.TaskEvent;

/**
 *
 * @author juan
 */
@WebService(
        name = "Monitor"
)
public interface Monitor extends Remote {

    @WebMethod
    void registry(TaskEvent event) throws RemoteException;

    @WebMethod
    List<TaskEvent> list(String filter) throws RemoteException;
}
