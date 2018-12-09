package sqlhelper.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	
	public static Connection dbConn;
	
	public static Connection getConnection(String user, String pwd, String url) {
		
		Connection conn = null;
		
		try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pwd);
            
            System.out.println("Database에 연결되었습니다.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }

		return conn;
	}
}
