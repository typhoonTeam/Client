package team_typhoon_consumer.testdaoimp;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.consuemer.dao.RestaurantDao;
import typhoon.consuemer.dao.impl.ResurantDaoImpl;
import typhoon.consuemer.pojo.Restaurant;
import typhoon.consuemer.util.DBUtil;

/**
 * 
 * @author Dunn
 *
 */
public class TestRestaurantDaoImp {
    private static RestaurantDao dao;
    @BeforeClass
    public static void init() {
    	dao = new ResurantDaoImpl();
    }
    @Test
	public void testGetOpenShop() throws Exception {
		List<Restaurant> resList =  dao.getResaurant();
		System.out.println(resList.size());
		assert(resList!=null);
    }
    @Test
	public void testFuzzyGetResturantByName() throws Exception {
    	//查找拥有的店铺
    	List<Restaurant> resList =  dao.getResturantByfuzzyName("na");
		assert(resList.size()>=1);
		//查找没有的店铺
		 resList =  dao.getResturantByfuzzyName("没有的");
		assert(resList.size()==0);
	}
    
    @Test
  	public void testGetRestaurant() throws Exception {
    	//测试
  		Restaurant resList =  dao.getRestaurantById("1");
  		System.out.println(resList.getShopName());
  		assert(resList!=null);
  		//
  		 resList =  dao.getRestaurantById("没有的商铺id");
  		 System.out.println(resList.getShopName());
  		assert(resList.getShopId()==null);
    }
    @Test
    public void testGetRestaurantPage() throws Exception{
    	List<Restaurant> resList = dao.getResaurant(0, 1);
    	assert(resList.size()>0);
    }
    @Test
    public void testGetRestaurantCount() throws Exception{
    	int resList = dao.getRestaurantCount();
    	assert(resList>0);
    }
}
