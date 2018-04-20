/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.monitor.client;

import task.monitor.server.service.Monitor;
import task.monitor.server.service.MonitorService;
import task.monitor.server.service.TaskEvent;

/**
 *
 * @author juan
 */
public class Client {

    public static void main(String[] args) {
        MonitorService proxy = new MonitorService();
        Monitor monitor = proxy.getMonitorServicePort();
        
        TaskEvent event = new TaskEvent();
        event.setCreatedIn(System.currentTimeMillis());
        event.setEventName("Aula sobre comunicação indireta");
        event.setGroupName("POS");
        //
        TaskEvent event1 = new TaskEvent();
        event1.setCreatedIn(System.currentTimeMillis());
        event1.setEventName("Aula sobre concorrencia");
        event1.setGroupName("POD");
        //
        monitor.registry(event);
        monitor.registry(event1);
        //
        System.out.println("filtering by groupName#POD");
        monitor.list("groupName#POD").stream().forEach((e) -> System.out.println(e.getCreatedIn() + "/" + e.getGroupName() + "/" + e.getEventName()));
        System.out.println("filtering by groupName#POO -- will return nothing");
        monitor.list("groupName#POO").stream().forEach((e) -> System.out.println(e.getCreatedIn() + "/" + e.getGroupName() + "/" + e.getEventName()));
        System.out.println("filtering by eventName#Aula sobre concorrencia");
        monitor.list("groupName#POD").stream().forEach((e) -> System.out.println(e.getCreatedIn() + "/" + e.getGroupName() + "/" + e.getEventName()));
    }
}
