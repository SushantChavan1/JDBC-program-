/*This code contain only code of inserting the record in exesting table and retrive by using the PreparedStatement interface(parameterized query)*/
package preparedStatement;
import java.sql.*;
import java.util.*;
public class Prepare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc= new Scanner(System.in);
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
			PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?)");
			
			
			for(int i=1;i<=5;i++) {
				System.out.print("Enter Name");
				String  name=sc.next();
				pst.setInt(1, i);
			    System.out.println("Enter percent");
				float per=sc.nextFloat();
				pst.setString(2, name);
				pst.setFloat(3, per);
				int n=pst.executeUpdate();
				System.out.println(n+" Rows Affected");
			}
			Statement stmt=con.createStatement();
			ResultSet re=stmt.executeQuery("select * from student");
			while(re.next()) {
				System.out.println(re.getInt(1)+" "+re.getString(2)+" "+re.getFloat(3));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
