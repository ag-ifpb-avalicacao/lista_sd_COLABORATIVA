package br.com.ifpb.sd.message.repository;

import br.com.ifpb.sd.shared.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigobento
 */
public class MessageDaoImpl implements MessageDao {

    private Connection con;
    
    public MessageDaoImpl(){
        this.con = ConFactory.getConnection();
    }
    
    @Override
    public void insert(Message message) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO message (userOwner, content) "
                    + "VALUES (?, ?)");
            stmt.setString(1, message.getUserOwner());
            stmt.setString(2, message.getContent());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Message> listAll() {
        List<Message> msgs = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM message");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Message m = new Message();
                m.setUserOwner(rs.getString("userOwner"));
                m.setContent(rs.getString("content"));
                msgs.add(m);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return msgs;
    }
    
}
