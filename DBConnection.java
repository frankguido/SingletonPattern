package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    
    static Connection conn = null;
    
    private DBConnection(){
    }
    
    public static Connection getDBConnection(){
        try{
            if(conn == null){
                
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/db_proyectointegradorgroup5", "root", "12345678");  
            }
            
        } catch (Exception e){
            e.printStackTrace();
        
        }
        return conn;
    }
  
}
