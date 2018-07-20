package team_typhoon_consumer.testserviceimpl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.consuemer.pojo.Page;
import typhoon.consuemer.pojo.Restaurant;
import typhoon.consuemer.service.RestaurantService;
import typhoon.consuemer.service.impl.RestaurantServiceImpl;
/**
 * 
 * @author Dunn
 *
 */
public class TestRestaurantsService {
	public static RestaurantService res ;
	@BeforeClass
	public static void init() {
		res = RestaurantServiceImpl.getInstance();
	}
	@Test
	public void testGetOpenShop() throws Exception {
		List<Restaurant>ress =  res.getResaurant();
		assert(ress.size()==1);
	}
	@Test
	public void testGetRestaurantById() throws Exception {
		Restaurant restaurant = res.getRestaurant("1");
		System.out.println(restaurant.getShopName());
		assert(restaurant.getPicture()!=null);
	}
	@Test
	public void testGetRestaurantByNameFuzzy() throws Exception {
		List<Restaurant> restaurant = res.getResturantByfuzzyName("na");
		System.out.println(restaurant.size());
		assert(restaurant.size()>=1);
	}
	@Test
	public void testGetRestaurantPage() {
		Page<Restaurant> restaurant = res.getResaurant(0, 5);
		System.out.println(restaurant.getTotalCount());
		assert(restaurant.getTotalCount()>=1);
	}
}
