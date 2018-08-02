package typhoon.consuemer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import typhoon.consuemer.dao.UserDao;
import typhoon.consuemer.pojo.User;
import typhoon.consuemer.util.DBUtil;
/**
 * 
 * @author Dunn
 *
 */
public class UserDaoImpl implements UserDao {
	Connection conn = null;
	public int Login(User user) {
		// TODO Auto-generated method stub
		String sql = "SELECT UID,USERNAME,PASSWORD FROM CONSUMER WHERE USERNAME=? AND PASSWORD=?";
		conn = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs= null;
		int result = 0;
		 try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			rs = pst.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, rs);
		}
		 System.out.println(result);
		return result;
	}

	public int regist(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CONSUMER VALUES(?,?,?)";
		conn = DBUtil.getConnection();
		PreparedStatement pst = null;
		int result = 0;
		 try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUserId());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int searchUser(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT Count(1) FROM CONSUMER WHERE USERNAME=? ";
		conn = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs= null;
		int result = 0;
		 try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}



}
