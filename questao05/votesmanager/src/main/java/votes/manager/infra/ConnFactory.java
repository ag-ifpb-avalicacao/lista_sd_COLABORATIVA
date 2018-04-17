/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.manager.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juan
 */
public class ConnFactory {
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:mem:;" + "INIT=RUNSCRIPT FROM './src/main/resources/schema.sql'\\;", "sa", "");
    }
}
