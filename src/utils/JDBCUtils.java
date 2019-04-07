package utils;
// 连接与释放资源
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	//数据库连接
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		//加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//建立连接
		String url="jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "123456";
		Connection conn=DriverManager.getConnection(url, user, password);
		return conn;
	}
	//关闭连接，释放资源
	//查询--释放
	public static void release(Statement stmt,Connection conn) {
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			stmt=null;
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			conn=null;
		}
	}
	//其他
	public static void  release(ResultSet rs,Statement stmt,Connection conn) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			rs=null;
		}
		release(stmt, conn);//调用上面那个
		
	}
}
