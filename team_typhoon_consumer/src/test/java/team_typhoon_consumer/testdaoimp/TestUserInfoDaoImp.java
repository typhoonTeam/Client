package team_typhoon_consumer.testdaoimp;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.consuemer.dao.UserDao;
import typhoon.consuemer.dao.impl.UserDaoImpl;
import typhoon.consuemer.pojo.User;
/**
 * 
 * @author Dunn
 *
 */
public class TestUserInfoDaoImp {
	private static UserDao userdao;
	@BeforeClass
	public static void init() {
		userdao = new UserDaoImpl();
	}
	@Test
	public void testLogin() throws Exception {
		//condition1:exit user
		User user  = new User();
		user.setUsername("dunn");
		user.setPassword("123123");
		int x = userdao.Login(user);
		assertTrue(x>0);
		//condition2:doesn't exit user
		user.setPassword("000000");
		assertTrue(x<=0);
	}
}
