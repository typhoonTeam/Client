package typhoon.consuemer.dao;

import java.util.List;

import typhoon.consuemer.pojo.Restaurant;
/**
 * 
 * @author Dunn
 *
 */
public interface RestaurantDao {
	/**
	 * search all resturant
	 * @return restaurant List
	 */
	public List<Restaurant> getResaurant();
	/**
	 * 
	 * @param restuarantName 
	 * @return restaurant List 
	 */
	public List<Restaurant> getResturantByfuzzyName(String restuarantName);
	
	/**
	 * @param resturantId 
	 * @return restaurant object
	 */
	public Restaurant getRestaurantById(String resturantId);
	/**
	 * 分页查询
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Restaurant> getResaurant(int start,int end);
	public int getRestaurantCount();
}
