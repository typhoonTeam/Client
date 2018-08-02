package typhoon.consuemer.dao;

import typhoon.consuemer.pojo.User;
/**
 * 
 * @author Dunn
 *
 */
public interface UserDao {
	public int Login(User user);
	public int regist(User user);
	public int updateUserInfo(User user);
	public int searchUser(String username);
}
