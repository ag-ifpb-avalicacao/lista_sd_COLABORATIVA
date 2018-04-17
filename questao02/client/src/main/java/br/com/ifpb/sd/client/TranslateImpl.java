package br.com.ifpb.sd.client;

import br.com.ifpb.sd.shared.TaskEvent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author rodrigobento
 */
public class TranslateImpl implements Translate {

    @Override
    public List<TaskEvent> toTask(JSONArray values) {
        List<TaskEvent> tasks = new ArrayList<>();
        for (int i = 0; i < values.length(); i++){
            JSONObject object = values.getJSONObject(i);
            TaskEvent task = new TaskEvent();
            task.setGroupName(object.getString("groupName"));
            task.setEventName(object.getString("eventName"));
            task.setCreatedIn(object.getLong("createdIn"));
            tasks.add(task);
        }
        return tasks;
    }
    
}
