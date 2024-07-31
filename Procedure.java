package preparedStatement;
import java.sql.*;
import java.util.Scanner;
public class Procedure {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc= new Scanner(System.in);
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
			CallableStatement cst=con.prepareCall("{call show}");
			cst.execute();
			System.out.println("Stored procedure executed successfully.");
		}
		catch(Exception e) {
	          System.out.println(e);		
		}
	}

}
