/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.manager.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import votes.manager.infra.ConnFactory;

/**
 *
 * @author juan
 */
public class VoteDao {

    private Connection conn;

    public VoteDao() {
        try {
            conn = ConnFactory.getConnection();
        } catch (SQLException ex) {
            System.out.println("ocurred an error trying to get a database connection: " + ex.getSQLState());
        }
    }

    public boolean vote(int id, String candidate) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("insert into vote values(?,?);");
            pstmt.setInt(1, id);
            pstmt.setString(2, candidate);
            int vrf = pstmt.executeUpdate();
            pstmt.close();
            return vrf > 0;
        } catch (SQLException ex) {
            throw new RuntimeException("an error ocurred trying insert a row in vote table: " + ex.getSQLState());
        }
    }

    public int countVotes() {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select count(candidate) from vote;");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            pstmt.close();
            return count;
        } catch (SQLException ex) {
            throw new RuntimeException("an error ocurred trying to count the number of rows in vote table: " + ex.getSQLState());
        }
    }

    public List<String> getVotes() {
        try {
            PreparedStatement pstmt = conn.prepareStatement("select candidate from vote;");
            ResultSet rs = pstmt.executeQuery();
            List<String> votes = new ArrayList<>();
            while (rs.next()) {
                votes.add(rs.getString(1));
            }
            rs.close();
            pstmt.close();
            return votes;
        } catch (SQLException ex) {
            throw new RuntimeException("an error ocurred trying to get the vote list: " + ex.getSQLState());
        }
    }
}
