package br.com.ifpb.sd.repository;

import br.com.ifpb.sd.shared.TaskEvent;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public interface TaskDao {
    
    void insert(TaskEvent event);
    List<TaskEvent> listAll();
    List<TaskEvent> listEvent(String eventName);
    List<TaskEvent> listGroup(String groupName);
    
}
