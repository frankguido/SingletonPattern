
package Singleton;

/**
 *
 * @author User
 */
import java.sql.*;
public class Test {
    public static void main(String [] args){
        Connection conn = DBConnection.getDBConnection();
        
        try{
            String query = "Select * from propietario ";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
            }
        }catch (Exception e){
            System.out.println("Error durante la conexion");
        }  
    }
    
}
