package typhoon.consuemer.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.manager.HttpManager;
import typhoon.consuemer.manager.impl.HttpManagerImpl;
import typhoon.consuemer.pojo.Advertisement;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.pojo.HttpReq;
import typhoon.consuemer.pojo.Restaurant;
import typhoon.consuemer.service.AdverstimentService;
import typhoon.consuemer.service.RestaurantService;
import typhoon.consuemer.service.impl.AdverstimentServiceImpl;
import typhoon.consuemer.service.impl.RestaurantServiceImpl;
import typhoon.consuemer.util.JsonOutUtil;

/**
 * 
 * @author Carrie
 *
 */
public class ShowRestaurantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestaurantService rServiceImpl = RestaurantServiceImpl.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(this.getServletConfig().getServletContext().getRealPath("/"));	
		List<Restaurant> restaurants = rServiceImpl.getResaurant();
		if(restaurants!=null && restaurants.size()>0) {
			JsonOutUtil.outJson(request,response,restaurants);
		}		
	}

	

}
