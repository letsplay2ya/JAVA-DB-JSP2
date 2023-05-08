package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤(Singleton) 적용
public class JdbcConnectionUtil {
	private static JdbcConnectionUtil instance;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "scott";
	private String password = "tiger";
	
	private JdbcConnectionUtil() {
		
	}

	public static JdbcConnectionUtil getInstance() {
		synchronized (JdbcConnectionUtil.class) {
			
			try {
				Class.forName("orcle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			if(instance == null) {
				instance = new JdbcConnectionUtil();
			}
		}
		return instance;
	}
	
	public Connection getConncetion() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
