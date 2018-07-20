package team_typhoon_consumer.testserviceimpl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.pojo.Page;
import typhoon.consuemer.service.FoodService;
import typhoon.consuemer.service.impl.FoodServiceImpl;
/**
 * 
 * @author Dunn
 *
 */
public class TestFoodServiceImpl {
	public static FoodService foodService;
	@BeforeClass
	public static void init() {
		foodService=  FoodServiceImpl.getInstance();
	}
	@Test
	public void testGetFood() {
		Food food = foodService.getFoodInfoByFoodId("1");
		assert(food.getFoodName()!=null);
		
	}
	@Test
	public void testGetFoodByRestaurantID() throws Exception {
		List<Food> foods = foodService.getFoodsByRestaurantId("1");
		assert(foods.size()>=1);
	}
	
	@Test
	public void testGetFoodPage() throws Exception {
		Page<Food> foods = foodService.getFoodsByRestaurantId("5243d4b6ac14461bb00c781f82e6ce91", 0, 1);
		assert(foods.getTotalCount()>=1);
	}
}
