package typhoon.consuemer.service.impl;

import java.util.List;

import typhoon.consuemer.dao.FoodDao;
import typhoon.consuemer.dao.impl.FoodDaoImpl;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.pojo.Page;
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

	@Override
	public Page<Food> getFoodsByRestaurantId(String restaurantId, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Page<Food> page = new Page<>();
		int result = foodDao.foodCountByRestaurantId(restaurantId);
		page.setTotalCount(result);
		page.setPageSize(pageSize);
		page.setCurrentPage(currentPage);
		page.setTotalPage(result/pageSize);
		List<Food> foods = foodDao.getFoodsByRestaurantId(restaurantId,currentPage*pageSize,(currentPage+1)*pageSize);
		page.setDataList(foods);
		return page;
	}

	
}
