package br.com.ifpb.sd.user.repository;

import br.com.ifpb.sd.shared.User;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public class UserDaoSingleton {

    private static UserDaoSingleton instance;
    private UserDao dao;
    
    private UserDaoSingleton(){
        dao = new UserDaoImpl();
    }
    
    public static UserDaoSingleton getInstance(){
        if(instance == null){
            return instance = new UserDaoSingleton();
        }
        return instance;
    }
    
    public void login(User user){
        dao.login(user);
    }
    
    public void logout(User user){
        dao.logout(user);
    }
    
    public List<User> listAll(){
        return dao.listAll();
    }
    
}
