package typhoon.consuemer.service;

import java.util.List;

import typhoon.consuemer.pojo.RegisterInfo;
import typhoon.consuemer.pojo.Restaurant;
/**
 * 
 * @author Dunn
 *
 */
public interface RestaurantService {
	/**
	 * search all resturant
	 * @return restaurant List
	 */
	public List<Restaurant> getResaurant();
	/**
	 * 
	 * @param restuarantName 
	 * @return restaurant object
	 */
	public List<Restaurant> getResturantByfuzzyName(String restuarantName);
	
	/**
	 * @param resturantId 
	 * @return restaurant object
	 */
	public Restaurant getRestaurant(String resturantId);
	

}
