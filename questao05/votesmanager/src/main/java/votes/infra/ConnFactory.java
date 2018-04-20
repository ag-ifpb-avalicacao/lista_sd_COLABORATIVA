/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.infra;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juan
 */
public class ConnFactory {

    public static Connection getConnection() throws SQLException {
        if (!new File("testdb.mv.db").exists()) {
            return DriverManager.getConnection("jdbc:h2:file:./testdb;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE;" + "INIT=RUNSCRIPT FROM './src/main/resources/schema.sql'\\;", "sa", "");
        } else {
            return DriverManager.getConnection("jdbc:h2:file:./testdb;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE;", "sa", "");
        }
    }
}
