package br.com.ifpb.sd.chat.infra;

import br.com.ifpb.sd.shared.Message;
import br.com.ifpb.sd.shared.User;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author rodrigobento
 */
public class Marshaller {

    public static List<Message> unMarshallerMessage(String json){
        List<Message> msgs = new ArrayList<>();
        JSONArray array = new JSONArray(json);
        for(int i = 0; i < array.length(); i++){
            JSONObject object = array.getJSONObject(i);
            Message m = new Message();
            m.setUserOwner(object.getString("userOwner"));
            m.setContent(object.getString("content"));
            msgs.add(m);
        }
        return msgs;
    }
    
    public static List<User> unMarshallerUser(String json){
        List<User> users = new ArrayList<>();
        JSONArray array = new JSONArray(json);
        for(int i = 0; i < array.length(); i++){
            JSONObject object = array.getJSONObject(i);
            User user = new User();
            user.setNickname(object.getString("nickname"));
            user.setPass("pass");
            users.add(user);
        }
        return users;
    }
    
}
