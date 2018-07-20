package typhoon.consuemer.dao;

import java.util.List;

import typhoon.consuemer.pojo.Food;
/**
 * 
 * @author Dunn
 *
 */
public interface FoodDao {
	public List<Food> getFoodsByRestaurantId(String restaurantId);
	public Food getFoodInfoByFoodId(String foodId);
	int addFood(Food food);
}
