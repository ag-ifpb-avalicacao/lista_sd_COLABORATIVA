/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.user.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ws.shared.User;

/**
 *
 * @author juan
 */
public class UserDao {

    private final Connection conn;

    public UserDao() throws SQLException {
        conn = ConnFactory.getConnection();
    }
    
    public boolean add(String nickname, String pass) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO person(nickname, pass) values(?,?)");
        pstmt.setString(1, nickname);
        pstmt.setString(2, pass);
        int vrf = pstmt.executeUpdate();
        pstmt.close();
        return vrf > 0;
    }
    
    public List<User> list() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM person");
        ResultSet rs = pstmt.executeQuery();
        User user;
        List<User> users = new ArrayList<>();
        while(rs.next()) {
            user = new User();
            user.setPass(null);
            user.setNickname(rs.getString(2));
            users.add(user);
        }
        pstmt.close();
        return users;
    }
    
    public boolean remove(String nickname) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM person WHERE nickname=?");
        pstmt.setString(1, nickname);
        int vrf = pstmt.executeUpdate();
        pstmt.close();
        return vrf > 0;    
    }
}
