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
		food.setShopId("5243d4b6ac14461bb00c781f82e6ce91");
		food.setStatus(0);
		int result = foodDao.addFood(food);
		assert(result>0);
		
	}
	@Test
	public void getFoodsByResturantId() throws Exception {
		
		//input a exit restaurantId
		List<Food> foods = foodDao.getFoodsByRestaurantId("5243d4b6ac14461bb00c781f82e6ce91");	
		System.out.println(foods.size());
		assertTrue(foods.size()!=0);
	}
	
	@Test
	public void getFoodsByResturantIdPage() throws Exception {
		
		//input a exit restaurantId
		List<Food> foods = foodDao.getFoodsByRestaurantId("5243d4b6ac14461bb00c781f82e6ce91",1,1);	
		System.out.println(foods.size());
		assertTrue(foods.size()!=0);
	}
	
	@Test
	public void getFoodCount() throws Exception {
		
		//input a exit restaurantId
		int result = foodDao.foodCountByRestaurantId("5243d4b6ac14461bb00c781f82e6ce91");	
		assertTrue(result>0);
	}
}
