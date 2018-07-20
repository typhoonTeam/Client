package team_typhoon_consumer.testdaoimp;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.consuemer.dao.UserDao;
import typhoon.consuemer.dao.impl.UserDaoImpl;
import typhoon.consuemer.pojo.User;

public class TestUserDao {
	private static UserDao dao;
	@BeforeClass
	public static void init() {
		dao = new UserDaoImpl();
	}
	@Test
	public void login() throws Exception {
		User user = new User();
		user.setUserId("1");
		user.setPassword("1");
		user.setUsername("1");
		int i = dao.Login(user);
		assert(i>0);
	}
	@Test
	public void regist() throws Exception {
		User user = new User();
		user.setUserId("3");
		user.setPassword("3");
		user.setUsername("3");
		int i = dao.regist(user);
		assert(i>0);
	}
}
