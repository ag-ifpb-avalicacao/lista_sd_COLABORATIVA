package br.com.ifpb.sd.repository;

import br.com.ifpb.sd.shared.TaskEvent;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public class RepositorySingleton {

    private static RepositorySingleton instance;
    private final TaskDao dao;

    private RepositorySingleton() {
        dao = new TaskDaoImpl();
    }
    
    public static RepositorySingleton getInstance() {
        if(instance == null) {
            return instance = new RepositorySingleton();
        }
        return instance;
    }
    
    public void insert(TaskEvent event){
        dao.insert(event);
    }
    
    public List<TaskEvent> listAll(){
        return dao.listAll();
    }
    
    public List<TaskEvent> listEvent(String eventName){
        return dao.listEvent(eventName);
    }
    
    public List<TaskEvent> listGroup(String groupName){
        return dao.listGroup(groupName);
    }

}
