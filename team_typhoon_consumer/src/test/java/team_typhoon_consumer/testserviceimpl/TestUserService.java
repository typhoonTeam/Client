package team_typhoon_consumer.testserviceimpl;

import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.consuemer.pojo.User;
import typhoon.consuemer.service.UserService;
import typhoon.consuemer.service.impl.UserServiceImpl;

/**
 * 
 * @author DUNN
 *
 */
public class TestUserService {
    private static UserService userService;
    @BeforeClass
    public static void init() {
    	userService = UserServiceImpl.getInstance();
    }
    @Test
    public void testLogin() {
    	User user = new User();
		user.setUserId("1");
		user.setPassword("1");
		user.setUsername("1");
		int i = userService.Login(user);
		assert(i>0);
    }
    @Test
    public void testRegist() {
    	User user = new User();
		user.setUserId("4");
		user.setPassword("4");
		user.setUsername("4");
		int i = userService.regist(user);
		assert(i>0);
    }
}
