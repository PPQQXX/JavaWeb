package example;

import dao.UserDao;
import domain.User;

public class UpdateUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao ud=new UserDao();
		User user=new User();
		user.setId(4);
		user.setUsername("ppp");
		user.setPassword("12345");
		user.setEmail("ppp@qq.com");
		boolean b=ud.update(user);
		System.out.print(b);
	}

}
