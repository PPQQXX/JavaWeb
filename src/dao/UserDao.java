package dao;
//该类封装   对user表的添加，删除，查找，更新

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.taglibs.standard.lang.jstl.ValueSuffix;

import domain.User;
import utils.JDBCUtils;

public class UserDao {
	// 查找所有users的信息
	public void AllUsers() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//连接
			conn=JDBCUtils.getConnection();
			//获得statement对象
			stmt=conn.createStatement();
			//sql语句
			String sql="select *from users";
			//保存在结果集中
			rs=stmt.executeQuery(sql);
			//处理结果集中数据
			System.out.println("id+|+name+|+password+|+email");
			while (rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String email=rs.getString("email");
				System.out.println(id+"|"+name+"|"+password+"|"+email);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	
	//添加用户
	public boolean insert(User user){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			 String sql = "INSERT INTO users(id,name,password,email) "+
						"VALUES("
						+ user.getId()
						+ ",'"
						+ user.getUsername()
						+ "','"
						+ user.getPassword()
						+ "','"
						+ user.getEmail()
						+  "')";
				int num = stmt.executeUpdate(sql);
			if(num>0)
			{
	
				return true;
			}
			else {
			
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		finally
		{
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	//查找id 
	public User findById(int id) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql="select *from users where id="+id;
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				User user=new User();//向user表中添加rs中的数据
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	//更新指定id
	public boolean update(User user) {
		 Connection conn=null;
		 Statement stmt=null;
		 ResultSet rs=null;
		 try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql = "UPDATE users set name='" + user.getUsername()
			+ "',password='" + user.getPassword() + "',email='"
			+ user.getEmail() + "' WHERE id=" + user.getId();
	int num = stmt.executeUpdate(sql);
			if(num>0)
			{
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;		
	}
}
