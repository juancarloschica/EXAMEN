package clases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.sqlite.SQLiteConfig;

public class ConnectionDB {
	
	private static Connection connection;
	
	private ConnectionDB() {}
	
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		if (connection != null)
			return connection;
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		Properties properties = new Properties();
		properties.load(new FileReader("config/config.properties"));
		final String DRIVER = properties.getProperty("DRIVER");
		String URL = properties.getProperty("URL");
		return DriverManager.getConnection(DRIVER + URL, config.toProperties());
	}
	
//	public static void main(String[] args) {
//		
//		try {
//			System.out.println(ConnectionDB.getConnection());
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
