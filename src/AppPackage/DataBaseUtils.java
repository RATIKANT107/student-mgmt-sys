package AppPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseUtils 
{
    public static Connection con = null;
    
    private static final String USER_ID = "root";
    private static final String PASSWORD = "";
    
       
    public void connectToDataBase()
    {
        try 
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmgmtsys", USER_ID, PASSWORD);
            
            if(con != null)
            {
                System.out.println("Connected to Database");
            }            
        } 
        catch (SQLException e) 
        {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
}
