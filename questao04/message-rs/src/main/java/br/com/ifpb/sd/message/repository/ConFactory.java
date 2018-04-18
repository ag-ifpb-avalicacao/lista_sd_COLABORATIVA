package br.com.ifpb.sd.message.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rodrigobento
 */
public class ConFactory {
    
    public static Connection getConnection(){
        try {
            Class.forName ("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;"
                + "INIT=RUNSCRIPT FROM 'classpath:create_schema.sql'\\;", "sa", "");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
        return null;
    }       
    
}
