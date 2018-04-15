/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.message.repository;

import java.sql.SQLException;
import java.util.List;
import ws.message.repository.dao.MessageDao;
import ws.shared.Message;

/**
 *
 * @author juan
 */
public class RepositorySingleton {
    private static RepositorySingleton instance;
    private final MessageDao dao;
    
    private RepositorySingleton() {
        try {
            dao = new MessageDao();
        } catch (SQLException ex) {
            throw new RuntimeException("error creating the dao object: " + ex.getMessage());
        }
    }
    
    public static RepositorySingleton getInstance() {
        if(instance == null)
            return instance = new RepositorySingleton();
        return instance;
    }
    
    public boolean store(Message message) {
        try {
            return dao.add(message.getUserOwner(), message.getContent());
        } catch (SQLException ex) {
            throw new RuntimeException("error trying to store a message in database: " + ex.getMessage());
        }
    }
    
    public List<Message> list() {
        try {
            return dao.list();
        } catch (SQLException ex) {
            throw new RuntimeException("error trying to list the messages of database: " + ex.getMessage());
        }
    }
}
