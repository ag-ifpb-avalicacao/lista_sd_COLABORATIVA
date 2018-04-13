/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.monitor.shared;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan
 */
@XmlRootElement
public class TaskEvent {

    private String groupName;
    private String eventName;
    private long createdIn;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public long getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(long createdIn) {
        this.createdIn = createdIn;
    }
}
