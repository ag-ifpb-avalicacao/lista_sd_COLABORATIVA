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
import java.util.HashMap;
import java.util.Map;
import votes.infra.ConnFactory;

/**
 *
 * @author juan
 */
public class VotationDao {

    private Connection conn;
    private Map<String, Integer> map;

    public VotationDao() {
        map = new HashMap<>();
        //initializing the map of candidate votations
        map.put("Killua", 0);
        map.put("Gon", 0);
        try {
            conn = ConnFactory.getConnection();
            //default operation, initialize unique row of the table
            initializeRow();
        } catch (SQLException ex) {
            System.out.println("ocurred an error trying to get a database connection in compute system: " + ex.getMessage());
        }
    }

    public boolean updateVotation(int value1, int value2) {
        try {
            PreparedStatement stmt = conn.prepareStatement("update votation set candidate1 = ?, candidate2 = ? where id=-1;");
            stmt.setInt(1, value1);
            stmt.setInt(2, value2);
            int isUpdated = stmt.executeUpdate();
            stmt.close();
            return isUpdated > 0;
        } catch (SQLException ex) {
            throw new RuntimeException("an error ocurred trying to update a row in votation table: " + ex.getMessage());
        }
    }

    private boolean initializeRow() {
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into votation(candidate1,candidate2) values(0,0);");
            int isInserted = stmt.executeUpdate();
            stmt.close();
            return isInserted > 0;
        } catch (SQLException ex) {
            throw new RuntimeException("an error ocurred trying to insert a row in votation table: " + ex.getMessage());
        }
    }

    public Map<String, Integer> getVotation() {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select candidate, count(id) from vote group by candidate;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                map.put(rs.getString(1), rs.getInt(2));
            }
            rs.close();
            pstmt.close();
            return map;
        } catch (SQLException ex) {
            throw new RuntimeException("an error ocurred trying to get the vote list: " + ex.getMessage());
        }
    }

    public int countRows() {
        try {
            PreparedStatement stmt = conn.prepareStatement("select count(id) from vote;");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count;
        } catch (SQLException ex) {
            throw new RuntimeException("trying to count the lines of vote table: " + ex.getMessage());
        }
    }
}
