/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.message.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ws.shared.Message;

/**
 *
 * @author juan
 */
public class MessageDao {

    private final Connection conn;

    public MessageDao() throws SQLException {
        conn = ConnFactory.getConnection();
    }
    
    public boolean add(String userOwner, String message) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO message(userOwner, content) values(?,?)");
        pstmt.setString(1, userOwner);
        pstmt.setString(2, message);
        int vrf = pstmt.executeUpdate();
        pstmt.close();
        return vrf > 0;
    }
    
    public List<Message> list() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM message");
        ResultSet rs = pstmt.executeQuery();
        Message message;
        List<Message> messages = new ArrayList<>();
        while(rs.next()) {
            message = new Message();
            message.setUserOwner(rs.getString(2));
            message.setContent(rs.getString(3));
            messages.add(message);
        }
        pstmt.close();
        return messages;
    }
}
