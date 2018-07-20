package typhoon.consuemer.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import typhoon.consuemer.dao.RestaurantDao;
import typhoon.consuemer.dao.impl.ResurantDaoImpl;
import typhoon.consuemer.pojo.Page;
import typhoon.consuemer.pojo.Restaurant;
import typhoon.consuemer.service.RestaurantService;
/**
 * 
 * @author Dunn
 *
 */
public class RestaurantServiceImpl implements RestaurantService{
	public RestaurantDao restaurantDao = new ResurantDaoImpl();
	private RestaurantServiceImpl() {}
    private static final RestaurantServiceImpl single = new RestaurantServiceImpl();
    public static RestaurantServiceImpl getInstance() {
    	return single;
    }
	public List<Restaurant> getResaurant() {
		List<Restaurant> restaurants = restaurantDao.getResaurant();
		return CheckIfOpen(restaurants);
	}
	public Restaurant getRestaurant(String resturantId) {
		return restaurantDao.getRestaurantById(resturantId);
	}

	public List<Restaurant> getResturantByfuzzyName(String restuarantName) {
		List<Restaurant> restaurants = restaurantDao.getResturantByfuzzyName(restuarantName);	
		return CheckIfOpen(restaurants);
	}
	

	private List<Restaurant> CheckIfOpen(List<Restaurant> restaurants) {
		Calendar c = Calendar.getInstance();
		List<Restaurant> resList = new ArrayList<>();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		for(Restaurant res : restaurants){
			int closeHour = Integer.parseInt(res.getCloseTime());
			int startHour = Integer.parseInt(res.getOpenTime());
			if(hour<closeHour&&startHour< hour){
				resList.add(res);
			}else {
				continue;
			}
		}
		return resList;
	}
	@Override
	public Page<Restaurant> getResaurant(int currentpage, int pageSize) {
		// TODO Auto-generated method stub
		List<Restaurant> restaurants = restaurantDao.getResaurant(currentpage*pageSize,(currentpage+1)*pageSize);
		int result = restaurantDao.getRestaurantCount();
		Page<Restaurant> page = new Page<>();
		page.setCurrentPage(currentpage);
		page.setPageSize(pageSize);
		page.setTotalCount(result);
		page.setDataList(restaurants);
		page.setTotalPage(result/pageSize);
		return page;		
	}

}
