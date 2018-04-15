/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.user.repository;

import ws.user.repository.dao.UserDao;
import java.sql.SQLException;
import java.util.List;
import ws.shared.User;

/**
 *
 * @author juan
 */
public class RepositorySingleton {
    private static RepositorySingleton instance;
    private final UserDao dao;
    
    private RepositorySingleton() {
        try {
            dao = new UserDao();
        } catch (SQLException ex) {
            throw new RuntimeException("error creating the dao object: " + ex.getMessage());
        }
    }
    
    public static RepositorySingleton getInstance() {
        if(instance == null)
            return instance = new RepositorySingleton();
        return instance;
    }
    
    public boolean store(User user) {
        try {
            return dao.add(user.getNickname(), user.getPass());
        } catch (SQLException ex) {
            throw new RuntimeException("error trying to store a user in database: " + ex.getMessage());
        }
    }
    
    public List<User> list() {
        try {
            return dao.list();
        } catch (SQLException ex) {
            throw new RuntimeException("error trying to list the users of database: " + ex.getMessage());
        }
    }
    
    public boolean remove(String nickname) {
        try {
            return dao.remove(nickname);
        } catch (SQLException ex) {
            throw new RuntimeException("error trying to remove a user in database: " + ex.getMessage());
        }
    }  
}
