package GenericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class DataBaseUtility {
	static Connection con = null;
	static ResultSet result = null;
	static FileUtility fLib = new FileUtility();
	
	public static void connectToDB() throws SQLException, IOException
	{
		try
		{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(fLib.getDataFromPropertiesFile("DBUrl")
					,fLib.getDataFromPropertiesFile("DB_Username"),
					fLib.getDataFromPropertiesFile("DB_Password"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static ResultSet execyteQuery(String query) throws Throwable {
		try {
			// executing the query
			 result = con.createStatement().executeQuery(query);
			 return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return result;
		
	}
	public static void closeDB() throws SQLException
	{
		con.close();
	}
	

}
