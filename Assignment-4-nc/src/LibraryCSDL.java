import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryCSDL {
	public static void main(String args[]) throws SQLException {
	Connection conn = null;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String cnURL = "jdbc:sqlserver://DESKTOP-APAPJBU:1433;"+"databaseName=test1;"+"integratedSecurity=true";
		conn = DriverManager.getConnection(cnURL,"sa","1234");
		// crate statement
		Statement stmt = conn.createStatement();

		ResultSet rs2 = stmt.executeQuery("select tiv_2011,tiv_2012,sum(tiv_2011+tiv_2012) from fl GROUP BY tiv_2011,tiv_2012");
		
		while(rs2.next()) {
			System.out.println(rs2.getFloat(1)+ " + " + rs2.getFloat(2) + " = " + rs2.getFloat(3) );
		}
		conn.close();
		System.out.print("ket noi thanh cong ");
	}catch(ClassNotFoundException e) {
		System.out.print("Ket noi that bai");
		}
	}
	
}
