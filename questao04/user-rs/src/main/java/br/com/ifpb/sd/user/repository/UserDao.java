package br.com.ifpb.sd.user.repository;

import br.com.ifpb.sd.shared.User;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public interface UserDao {
    
    void login(User user);
    void logout(User user);    
    List<User> listAll();
    
}
