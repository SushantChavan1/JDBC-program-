package preparedStatement;
import java.sql.*;
import java.util.Scanner;
public class RetriveRoll {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc= new Scanner(System.in);
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
        	PreparedStatement pst=con.prepareStatement("insert into stud values(?,?,?)");
			for(int i=1;i<=5;i++) {
				System.out.print("Enter Name");
				String  name=sc.next();
				pst.setInt(1, i);
			    System.out.println("Enter percent");
				int per=sc.nextInt();
				pst.setString(2, name);
				pst.setFloat(3, per);
				int n=pst.executeUpdate();
				System.out.println(n+" Rows Affected");
			}
			Statement stmt=con.createStatement();
			ResultSet re=stmt.executeQuery("select * from stud");
			while(re.next()) {
				System.out.println(re.getInt(1)+" "+re.getString(2)+" "+re.getFloat(3));
			}
			Statement stmt=con.createStatement();
			CallableStatement cst=con.prepareCall("{call update_record(?)}");
			cst.setInt(1,4);
			cst.execute();
			ResultSet re=stmt.executeQuery("select * from stud");
			while(re.next()) {
				System.out.println(re.getInt(1)+" "+re.getString(2)+" "+re.getFloat(3));
			}
		}
		
		
		catch(Exception e) {
	          System.out.println(e);		
		}
	}
}

//Actual procedure in 

//create or replace procedure update_record(roll1 in number) as
//  begin
//    update stud set mark=40 where roll=roll1;
// end;
//  /
