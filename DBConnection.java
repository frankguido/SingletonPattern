package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    
    //Atributo privado y estatico del mismo tipo
    private static Connection conn = null;
    
    //constructor privado por defecto que no reciba parametros
    private DBConnection(){
    }
    
    //metodo publico estatico que retorna el tipo de la clase Connection que no recibe parametros
    public static Connection getDBConnection(){
        try{
            if(conn == null){
                
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/db_proyecto", "root", "12345678");  
            }
            
        } catch (Exception e){
            e.printStackTrace();
        
        }
        return conn;
    }
  
}
