package br.com.ifpb.sd.shared;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public class TaskEventList {
    
    private List<TaskEvent> eventList;

    public TaskEventList() {
        this.eventList = new ArrayList<>();
    }

    public List<TaskEvent> getEventList() {
        return eventList;
    }

    public void setEventList(List<TaskEvent> eventList) {
        this.eventList = eventList;
    }
    
    public boolean addEvent(TaskEvent event){
        return eventList.add(event);
    }
    
}
