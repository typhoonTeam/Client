package typhoon.consuemer.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
/**
 * 
 * @author Dunn
 *
 */
public class DBUtil {
	//read config from properties
	private static Properties conf = new Properties();
	//data connection pool
	private static BasicDataSource basicDataSource = new BasicDataSource();
	static {
		//load connection pool
		try {
//			conf.load(new FileInputStream("DBConfig.properties"));
			conf.load(DBUtil.class.getClassLoader().getResourceAsStream("DBConfig.properties"));
			String url = conf.getProperty("url");
			String username = conf.getProperty("username");
			String password = conf.getProperty("password");
			basicDataSource.setUrl(url);
			basicDataSource.setPassword(password);
			basicDataSource.setDriverClassName(conf.getProperty("driverclass"));
			basicDataSource.setUsername(username);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//get connection
	public static Connection getConnection() {
		Connection conn = null;
		try {
		    conn = basicDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//close connection
	public static void close(Connection con,Statement st,ResultSet rs) {
			try {
				if(rs!=null) con.close();
				if(st!=null) st.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
//	private static String getRealPath(String filePath) {
//		System.out.println(DBUtil.class.getResource("/" + filePath).toString().substring(6));
//	     return DBUtil.class.getResource("/" + filePath).toString().substring(6);
//	    }
	
	public static void main(String[] args) {
		Connection conn  = getConnection();
		System.out.println(conn);
	}
}
