/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.manager.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import votes.infra.ConnFactory;

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
            System.out.println("ocurred an error trying to get a database connection in manager system: " + ex.getMessage());
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
            throw new RuntimeException("an error ocurred trying insert a row in vote table: " + ex.getMessage());
        }
    }
}
