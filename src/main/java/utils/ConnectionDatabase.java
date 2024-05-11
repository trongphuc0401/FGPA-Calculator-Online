package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
	public static String DB_URL = "jdbc:mysql://localhost:3306/cgpa_calculator";

	public static String DB_USER = "root";

	 public static String DB_PASSWORD = "trongphuc098";
	
    
	 public static Connection getConnection() throws SQLException, ClassNotFoundException {
		 Class.forName("com.mysql.jdbc.Driver");
         return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
     }
	 
    public static void main(String[] args) throws ClassNotFoundException {
    	 
         
         try {
        	 
        	 DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgpa_calculator", "root", "trongphuc098");

             System.out.println("Connect Mysql succeed！");

             

             conn.close();

         } catch (SQLException e) {

             System.out.println("Error: Fail to connect Mysql！");

             e.printStackTrace();

         }

     }
    
    
    
}
