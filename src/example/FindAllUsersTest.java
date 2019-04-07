package example;

import java.sql.SQLException;

import dao.UserDao;

public class FindAllUsersTest {
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		UserDao userdao=new UserDao();
			userdao.AllUsers();
	}
}
