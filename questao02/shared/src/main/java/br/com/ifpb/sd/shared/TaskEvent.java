package br.com.ifpb.sd.shared;

import java.io.Serializable;

/**
 *
 * @author rodrigobento
 */
public class TaskEvent implements Serializable {
    
    private String groupName;
    private String eventName;
    private long createdIn;

    public TaskEvent() {
    }

    public TaskEvent(String groupName, String eventName, long createdIn) {
        this.groupName = groupName;
        this.eventName = eventName;
        this.createdIn = createdIn;
    }

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

    @Override
    public String toString() {
        return "TaskEvent{" + "groupName=" + groupName + ", eventName=" + eventName + ", createdIn=" + createdIn + '}';
    }
    
}
