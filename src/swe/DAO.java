package swe;
import java.text.*;
import java.util.*;
import java.sql.*;
public class DAO {

   static Connection currentCon = null;
   static ResultSet rs = null;  
   static Statement statement = null;
	
   public static void save(ValidBean declira) throws SQLException {  
       currentCon= ConnectionManager.getConnection();  
       String insert = "INSERT INTO INFO (EMAIL,PASSWORD) VALUES (?, ?)";  
       PreparedStatement ps = currentCon.prepareStatement(insert);  
       ps.setString(1, declira.getEmail());  
       ps.setString(2, declira.getPassword());  
      
       ps.executeUpdate();  
       ps.close();  
       currentCon.commit();  
       System.out.println("Storing Student Object is Done!");  
   }

	
 /*  public static ArrayList info()
   {
	   ArrayList names = new ArrayList();
	   currentCon=ConnectionManager.getConnection();
	   try
		{
			
			statement = currentCon.createStatement();
			
			rs = statement.executeQuery("select * from users");
			while(rs.next())
			{
				names.add(rs.getString("sid"));
					
			}
		
		}
		catch(SQLException error)
		{
			System.out.println("Error: "+error.getMessage());
		}
		finally
		{
			if(currentCon != null) try{currentCon.close();} catch(SQLException ignore){}
			if(statement != null) try{statement.close();} catch(SQLException ignore){}
			if(rs != null) try{rs.close();} catch(SQLException ignore){}
		}
	   return names;
   }*/
   
 public ValidBean getInfo(String email,String password) {
	
	   ValidBean bean = new ValidBean();
    
	//   String searchQuery =  "select * from users where email ='" + email +"' AND password='" + password + "'"  ;

       String searchQuery =
             "select * from info where email='"
                      + email
                      + "' AND password='"
                      + password
                      + "'";
   //String searchQuery =  "select * from users where sid =" + "'sid'";
	
	    
   try 
   {
      //connect to DB 
      currentCon = ConnectionManager.getConnection();
      statement=currentCon.createStatement();
      rs = statement.executeQuery(searchQuery);	        
      rs.next();
	       
      
      
       String email1 = rs.getString("email");
       String password1 = rs.getString("password");
    	 
	   bean.setEmail(email1);  
	   bean.setPassword(password1);
	   bean.setValid(true);
	     
  
	   
      
   } 

   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
   } 
	    
   //some exception handling
   finally 
   {
      if (rs != null)	{
         try {
            rs.close();
         } catch (Exception e) {}
            rs = null;
         }
	
      if (statement != null) {
         try {
            statement.close();
         } catch (Exception e) {}
            statement = null;
         }
	
      if (currentCon != null) {
         try {
            currentCon.close();
         } catch (Exception e) {
         }

         currentCon = null;
      }
   }

return bean;
	
   }	
}