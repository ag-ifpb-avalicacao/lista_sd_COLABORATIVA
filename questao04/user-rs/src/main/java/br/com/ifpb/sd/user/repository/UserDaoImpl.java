package br.com.ifpb.sd.user.repository;

import br.com.ifpb.sd.shared.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodrigobento
 */
public class UserDaoImpl implements UserDao {
    
    private Connection con;
    
    public UserDaoImpl(){
        this.con = ConFactory.getConnection();
    }

    @Override
    public void login(User user) {
        String sql = "INSERT INTO user (nickname, pass) VALUES (?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getNickname());
            stmt.setString(2, user.getPass());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void logout(User user) {
        String sql = "DELETE FROM user WHERE nickname = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getNickname());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }  
    
    @Override
    public List<User> listAll(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setNickname(rs.getString("nickname"));
                user.setPass(rs.getString("pass"));
                users.add(user);
            }
            stmt.close();
            rs.close();
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
    
}
