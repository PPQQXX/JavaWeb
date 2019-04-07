package example;

import dao.UserDao;
import domain.User;

public class InsertTest {
		public static void main(String []args) {
			UserDao userDao=new UserDao();
			User user=new User();
			user.setId(5);
			user.setUsername("GGBOY");
			user.setPassword("13123");
			user.setEmail("GGBOY@qq.com");
			boolean b=userDao.insert(user);
			System.out.print(b);
		}
}
