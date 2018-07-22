package typhoon.consuemer.service.impl;

import typhoon.consuemer.dao.UserDao;
import typhoon.consuemer.dao.impl.UserDaoImpl;
import typhoon.consuemer.pojo.User;
import typhoon.consuemer.service.UserService;
/**
 * 
 * @author Dunn
 *
 */        
public class UserServiceImpl implements UserService{
	private UserServiceImpl() {}
    private static final UserServiceImpl single = new UserServiceImpl();
    public static UserServiceImpl getInstance() {
    	return single;
    }
    private UserDao userDao = new UserDaoImpl();
	public int Login(User user) {
		// TODO Auto-generated method stub
		return userDao.Login(user);
	}

	public int regist(User user) {
		// TODO Auto-generated method stub
		int result = userDao.searchUser(user.getUsername());
		if(result>0) return 0;
		return userDao.regist(user);
	}

	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
