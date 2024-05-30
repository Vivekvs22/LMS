package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class conn {
	private PreparedStatement psti;
	  Connection cnn;
	    Statement s;
	    
	    public conn() { 
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            
	            cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","vivek","7338085820");
	            s =cnn.createStatement();  
	            
	           
	        }catch(Exception e){  
	            System.out.println(e);
	        }  
	    }


//		public PreparedStatement prepareStatement(String loginsql) {
//			// TODO Auto-generated method stub
//			return null;
//		}

		
}
