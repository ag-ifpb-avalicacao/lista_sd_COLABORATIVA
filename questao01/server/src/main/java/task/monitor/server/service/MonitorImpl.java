/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.monitor.server.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.jws.WebService;
import task.monitor.shared.TaskEvent;

/**
 *
 * @author juan
 */
@WebService(
        serviceName = "MonitorService",
        endpointInterface = "task.monitor.server.service.Monitor",
        portName = "MonitorServicePort"
)
public class MonitorImpl implements Monitor {

    private List<TaskEvent> events = new ArrayList<>();

    @Override
    public void registry(TaskEvent event) {
        events.add(event);
    }

    @Override
    public List<TaskEvent> list(String filter) throws RemoteException {
        if (filter.contains("#")) {
            String[] filters = filter.split("#");
            if (filters[0].equals("groupName")) {
                return events.stream().filter((e) -> e.getGroupName().equals(filters[1])).collect(Collectors.toList());
            }

            if (filters[0].equals("eventName")) {
                return events.stream().filter((e) -> e.getEventName().equals(filters[1])).collect(Collectors.toList());
            }
            
            return Arrays.asList();
        }

        List<TaskEvent> eventsToReturn = events.stream().filter((e) -> e.getGroupName().equals(filter)).collect(Collectors.toList());

        if (eventsToReturn.isEmpty()) {
            return events.stream().filter((e) -> e.getEventName().equals(filter)).collect(Collectors.toList());
        }
        
        return eventsToReturn;
    }

}
