/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.compute.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import votes.infra.ConnFactory;

/**
 *
 * @author juan
 */
public class SubscribeDao {

    private Connection conn;

    public SubscribeDao() {
        try {
            conn  = ConnFactory.getConnection();
        } catch (SQLException ex) {
            System.out.println("ocurred an error trying to get a database connection in compute system: " + ex.getMessage());
        }
    }

    public boolean storeSubscribed(String URL) {
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into subscribed values(?);");
            stmt.setString(1, URL);
            int isUpdated = stmt.executeUpdate();
            stmt.close();
            return isUpdated > 0;
        } catch (SQLException ex) {
            throw new RuntimeException("an error ocurred trying to insert a row in subscribed table: " + ex.getMessage());
        }
    }

    public List<String> getSubscribeds() {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select URL from subscribed;");
            ResultSet rs = pstmt.executeQuery();
            List<String> subscribeds = new ArrayList<>();
            while (rs.next()) {
                subscribeds.add(rs.getString(1));
            }
            rs.close();
            pstmt.close();
            return subscribeds;
        } catch (SQLException ex) {
            throw new RuntimeException("an error ocurred trying to get the subscribed list: " + ex.getMessage());
        }
    }
}
