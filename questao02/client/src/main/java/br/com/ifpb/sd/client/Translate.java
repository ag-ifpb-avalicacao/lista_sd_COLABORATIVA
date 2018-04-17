package br.com.ifpb.sd.client;

import br.com.ifpb.sd.shared.TaskEvent;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author rodrigobento
 */
public interface Translate {
    
    List<TaskEvent> toTask(JSONArray values);
    
}
