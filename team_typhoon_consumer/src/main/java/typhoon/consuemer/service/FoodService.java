package typhoon.consuemer.service;

import java.util.List;

import typhoon.consuemer.pojo.Food;
/**
 * 
 * @author Dunn
 *
 */
public interface FoodService {
	public List<Food> getFoodsByRestaurantId(String restaurantId);
	public Food getFoodInfoByFoodId(String foodId);
}
