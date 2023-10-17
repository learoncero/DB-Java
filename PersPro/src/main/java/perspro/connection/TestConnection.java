package perspro.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	
	public static void main(String[] args) {
	
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://elmo.hostingcenter.uclv.net:5432/itb_inf_2022_lro3572", "itb_inf_2022_lro3572", "PW_ROLe");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT lname FROM pers_proj.person");
			
			while(rs.next()) {
				System.out.println(rs.getString("lname"));
			}
			
			con.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
}
