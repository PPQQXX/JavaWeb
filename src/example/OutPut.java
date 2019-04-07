package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutPut {
	public static void main(String[] args) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			// 1. 注册数据库的驱动 和registerDriver有什么关系??
			//实际上此方式是加载驱动，而另一方法导致驱动注册两次。driver源码自动注册一次
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 System.out.println("连接数据库...");
			 
			// 2.通过DriverManager获取数据库连接
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, username, password);
			// 3.通过Connection对象获取Statement对象
			 System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			// 4.使用Statement执行SQL语句。
			String sql = "select * from users";
			rs = stmt.executeQuery(sql);
			// 5. 操作ResultSet结果集
			System.out.println("id| name | password | email");
			while (rs.next()) { // 通过字段检索
				int id = rs.getInt("id"); // 通过列名获取指定字段的值
				String name = rs.getString("name");
				String psw = rs.getString("password");
				String email = rs.getString("email");
				System.out.println(id + " | " + name + " | " + psw + " | " + email);
			}
			//preparedstatement插入    带变量的插入，注册？？
			/*String str="insert into users(id,name,password,email) values(?,?,?,?)";
			PreparedStatement prestmt=conn.prepareStatement(str);
			prestmt.setInt(1, 4);
			prestmt.setString(2, "lzy");
			prestmt.setString(3, "1186");
			prestmt.setObject(4, "lzy@qq.com");
			prestmt.executeUpdate();*/
			
			//菜鸟教程在此处就
			/*  // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();*/
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6.回收数据库资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}
