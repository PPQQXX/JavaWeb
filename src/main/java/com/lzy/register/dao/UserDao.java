package com.lzy.register.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import com.lzy.register.domain.UserBean;
import com.lzy.register.util.JDBCUtils;
public class UserDao {
	public static boolean insert(UserBean user) {
		//指定用户名唯一则需要判断一下
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			 String sql = "INSERT INTO users(id,name,password,email) "+
						"VALUES("
						+ 0
						+ ",'" 
						+ user.getName()
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
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
}
