package typhoon.consuemer.service;

import typhoon.consuemer.pojo.User;
/**
 * 
 * @author Dunn
 *
 */
public interface UserService {
	public int Login(User user);
	public int regist(User user);
	public int updateUserInfo(User user);
}
