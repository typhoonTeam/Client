package team_typhoon_consumer.testdaoimp;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.consuemer.dao.FoodDao;
import typhoon.consuemer.dao.impl.FoodDaoImpl;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.util.DBUtil;

/**
 * 
 * @author Dunn
 *
 */
public class TestFoodDaoImpl {
	private static FoodDao foodDao ;
	@BeforeClass
	public static void init() {
		foodDao = new FoodDaoImpl();
	}
	@Test
	public void AddFood() {
		Food food = new Food();
		food.setFoodName("黄萌吉米饭");
		food.setId(1);
		food.setInfo("asdasdasdasd");
		food.setPrice("12");
		food.setPicture("asdsd");
		food.setShopId("683a2c14a4914bbaa2ab67473be29902");
		food.setStatus(0);
		int result = foodDao.addFood(food);
		assert(result>0);
		
	}
	@Test
	public void getFoodsByResturantId() throws Exception {
		
		//input a exit restaurantId
		List<Food> foods = foodDao.getFoodsByRestaurantId("683a2c14a4914bbaa2ab67473be29902");	
		System.out.println(foods.size());
		assertTrue(foods.size()!=0);
	}
}
