package typhoon.consuemer.service.impl;

import java.util.List;

import typhoon.consuemer.dao.FoodDao;
import typhoon.consuemer.dao.impl.FoodDaoImpl;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.service.FoodService;
/**
 * 
 * @author Dunn
 *
 */
public class FoodServiceImpl implements FoodService{
	//饿汉单例模式
	private FoodServiceImpl() {}
    private static final FoodServiceImpl single = new FoodServiceImpl();
    public static FoodServiceImpl getInstance() {
    	return single;
    }
	private FoodDao foodDao = new FoodDaoImpl();
	public List<Food> getFoodsByRestaurantId(String restaurantId) {
		return foodDao.getFoodsByRestaurantId(restaurantId);
	}

	public Food getFoodInfoByFoodId(String foodId) {
		return foodDao.getFoodInfoByFoodId(foodId);
	}

	
}
