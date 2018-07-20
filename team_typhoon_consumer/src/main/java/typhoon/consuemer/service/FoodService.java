package typhoon.consuemer.service;

import java.util.List;

import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.pojo.Page;
/**
 * 
 * @author Dunn
 *
 */
public interface FoodService {
	public List<Food> getFoodsByRestaurantId(String restaurantId);
	public Food getFoodInfoByFoodId(String foodId);
	public Page<Food> getFoodsByRestaurantId(String restaurantId,int currentPage,int pageSize);
}
