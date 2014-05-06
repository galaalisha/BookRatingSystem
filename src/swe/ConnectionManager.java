package swe;

import java.sql.*;
import java.util.*;

public class ConnectionManager {

	static Connection con;
    static String url;
          
    public static Connection getConnection()
    {
      
       try
       {
          String url = "jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g"; 
          // assuming "DataSource" is your DataSource name

          Class.forName("oracle.jdbc.driver.OracleDriver");
          
          try
          {            	
             con = DriverManager.getConnection(url,"agala","Paradise28"); 
              								
          // assuming your SQL Server's	username is "username"               
          // and password is "password"
               
          }
          
          catch (SQLException ex)
          {
             ex.printStackTrace();
          }
       }

       catch(ClassNotFoundException e)
       {
          System.out.println(e);
       }

    return con;
}
 }
