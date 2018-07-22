package typhoon.consuemer.dao.impl;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import typhoon.consuemer.dao.RestaurantDao;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.pojo.Restaurant;
import typhoon.consuemer.util.DBUtil;
/**
 * 
 * @author Dunn
 *
 */
public class ResurantDaoImpl implements RestaurantDao{
	Connection conn = null;
	public List<Restaurant> getResaurant() {
		conn = DBUtil.getConnection();
		String sql = "select rs.SHOP_NAME,r.SHOP_ID,r.CLOSE_TIME,r.OPEN_TIME,r.DELIVERY, r.DELI_FEE,"
				+ "r.PICTURE,r.SLOGAN,r.STATUS,r.COMMENTS from RESTAURANT r left JOIN REGISTERINFO rs"
				+ " on r.SHOP_ID = rs.SHOP_ID where status = 0";
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List<Restaurant> restaurantsList = new ArrayList<Restaurant>();
		try {
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				setRestaurant(resultSet, restaurantsList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, preparedStatement, resultSet);
		}

		return restaurantsList;
	}




	public List<Restaurant> getResturantByfuzzyName(String restuarantName) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		String sql = "select rs.SHOP_NAME,r.SHOP_ID,r.CLOSE_TIME,r.OPEN_TIME,r.DELIVERY, r.DELI_FEE,r.PICTURE,r.SLOGAN,r.STATUS,r.COMMENTS from RESTAURANT r left JOIN REGISTERINFO rs on r.SHOP_ID = rs.SHOP_ID WHERE rs.SHOP_NAME like ? and  status = 0";
		PreparedStatement preparedStatement  = null;
		System.out.println(sql);
		ResultSet resultSet = null;
		List<Restaurant> restaurantsList = new ArrayList<Restaurant>();
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%"+restuarantName+"%");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				setRestaurant(resultSet, restaurantsList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, preparedStatement, resultSet);
		}

		return restaurantsList;
	}



	public Restaurant getRestaurantById(String resturantId) {
		conn = DBUtil.getConnection();
		String sql = "select rs.SHOP_NAME,r.SHOP_ID,r.CLOSE_TIME,r.OPEN_TIME,r.DELIVERY, r.DELI_FEE,r.PICTURE,r.SLOGAN,r.STATUS,r.COMMENTS from RESTAURANT r left JOIN REGISTERINFO rs on r.SHOP_ID = rs.SHOP_ID WHERE r.SHOP_ID = ? ";
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		Restaurant restaurant = new Restaurant();
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, resturantId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				restaurant.setShopId(resultSet.getString("SHOP_ID"));
				restaurant.setOpenTime(resultSet.getString("OPEN_TIME"));
				restaurant.setCloseTime(resultSet.getString("CLOSE_TIME"));
				restaurant.setDelivery(resultSet.getInt("DELIVERY"));
				restaurant.setDeli_fee(resultSet.getInt("DELI_FEE"));
				restaurant.setPicture(resultSet.getString("PICTURE"));
				restaurant.setSlogan(resultSet.getString("SLOGAN"));
				restaurant.setShopName(resultSet.getString("SHOP_NAME"));
				restaurant.setStatus(resultSet.getInt(("STATUS")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, preparedStatement, resultSet);
		}

		return restaurant;
	}

	private void setRestaurant(ResultSet resultSet, List<Restaurant> restaurantsList) throws SQLException {
		Restaurant restaurant = new Restaurant();
		restaurant.setShopId(resultSet.getString("SHOP_ID"));
		restaurant.setOpenTime(resultSet.getString("OPEN_TIME"));
		restaurant.setCloseTime(resultSet.getString("CLOSE_TIME"));
		restaurant.setDelivery(resultSet.getInt("DELIVERY"));
		restaurant.setDeli_fee(resultSet.getInt("DELI_FEE"));
		restaurant.setPicture(resultSet.getString("PICTURE"));
		restaurant.setSlogan(resultSet.getString("SLOGAN"));
		restaurant.setShopName(resultSet.getString("SHOP_NAME"));
		restaurant.setStatus(1);
		restaurantsList.add(restaurant);
	}




	@Override
	public List<Restaurant> getResaurant(int start, int end) {
		// TODO Auto-generated method stub
				conn = DBUtil.getConnection();
		String sql = "select rs.SHOP_NAME,r.SHOP_ID,r.CLOSE_TIME,r.OPEN_TIME,r.DELIVERY, r.DELI_FEE,r.PICTURE,r.SLOGAN,r.STATUS,r.COMMENTS from (  SELECT A.*, ROWNUM RN  FROM (SELECT * FROM RESTAURANT) A  WHERE ROWNUM <= ?  )  r left JOIN REGISTERINFO rs on r.SHOP_ID = rs.SHOP_ID where status = 0 and RN > ? ";
		PreparedStatement preparedStatement  = null;
		ResultSet resultSet = null;
		List<Restaurant> restaurantsList = new ArrayList<Restaurant>();
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, end);
			preparedStatement.setInt(2, start);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				setRestaurant(resultSet, restaurantsList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, preparedStatement, resultSet);
		}

		return restaurantsList;
	}




	@Override
	public int getRestaurantCount() {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		String sql = "Select count(1) FROM RESTAURANT";
		PreparedStatement pre = null;
		ResultSet rs = null;
		int result = 0;
		List<Food> foods = new ArrayList<Food>();
		try {
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			rs.next();
			result =rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pre, rs);
		}
		return result;
	}
	
}
