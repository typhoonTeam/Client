package typhoon.consuemer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpUtils;

import typhoon.consuemer.dao.FoodDao;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.util.DBUtil;
/**
 * 
 * @author Dunn
 *
 */
public class FoodDaoImpl implements FoodDao {
	Connection conn = null;
	public List<Food> getFoodsByRestaurantId(String restaurantId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		String sql = "Select * FROM Food where SHOP_ID=?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		List<Food> foods = new ArrayList<Food>();
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, restaurantId);
			rs = pre.executeQuery();
			while(rs.next()) {
				Food food = new Food();
				food.setId(rs.getInt("ID"));
				food.setFoodName(rs.getString("FOOD_NAME"));
				food.setPrice(rs.getString("PRICE"));
				food.setPicture(rs.getString("PICTURE"));
				food.setShopId(rs.getString("SHOP_ID"));
				food.setInfo(rs.getString("INFO"));
				food.setStatus(rs.getInt("STATUS"));
				foods.add(food);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pre, rs);
		}
		return foods;
	}

	public Food getFoodInfoByFoodId(String foodId) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		String sql = "Select * FROM Food where ID=?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		Food food = null;	
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, foodId);
			rs = pre.executeQuery();
			while(rs.next()) {
				food = new Food();
				food.setId(rs.getInt("ID"));
				food.setFoodName(rs.getString("FOOD_NAME"));
				food.setPrice(rs.getString("PRICE"));
				food.setPicture(rs.getString("PICTURE"));
				food.setShopId(rs.getString("SHOP_ID"));
				food.setInfo(rs.getString("INFO"));
				food.setStatus(rs.getInt("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pre, rs);
		}
		return food;
	}

	@Override
	public int addFood(Food food) {
		// TODO Auto-generated method stub
		int num = 0;
		String sql = "INSERT INTO food(id,food_name,price,picture,info,status,shop_id) VALUES (food_seq.nextval,?,?,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
		pStatement = con.prepareStatement(sql);
		pStatement.setString(1, food.getFoodName());
		pStatement.setString(2, food.getPrice());
		;
		pStatement.setString(3, food.getPicture());
		pStatement.setString(4, food.getInfo());
		pStatement.setInt(5, food.getStatus());
		pStatement.setString(6, food.getShopId());
		num = pStatement.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		DBUtil.close(con, pStatement, null);
		return num;
	}

}
