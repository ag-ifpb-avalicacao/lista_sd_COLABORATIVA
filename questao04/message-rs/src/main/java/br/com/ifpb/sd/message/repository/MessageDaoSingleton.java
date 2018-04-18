package br.com.ifpb.sd.message.repository;

import br.com.ifpb.sd.shared.Message;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public class MessageDaoSingleton {

    private static MessageDaoSingleton instance;
    private MessageDao dao;
    
    private MessageDaoSingleton(){
        dao = new MessageDaoImpl();
    }
    
    public static MessageDaoSingleton getInstance(){
        if(instance == null){
            return instance = new MessageDaoSingleton();
        }
        return instance;
    }
    
    public void insert(Message msg){
        dao.insert(msg);
    }
    
    public List<Message> listAll(){
        return dao.listAll();
    }
    
}
