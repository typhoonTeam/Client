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
import typhoon.consuemer.util.JsonOutUtil;
import typhoon.consuemer.manager.impl.HttpManagerImpl;
import typhoon.consuemer.pojo.Advertisement;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.pojo.HttpReq;
import typhoon.consuemer.pojo.Page;
import typhoon.consuemer.pojo.Restaurant;
import typhoon.consuemer.service.AdverstimentService;
import typhoon.consuemer.service.RestaurantService;
import typhoon.consuemer.service.impl.AdverstimentServiceImpl;
import typhoon.consuemer.service.impl.RestaurantServiceImpl;

/**
 * 
 *update dunn 2018-7-20
 */
public class ShowRestaurantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JsonOutUtil jsonManager = new JsonOutUtil();
	RestaurantService restaurantService = RestaurantServiceImpl.getInstance();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currentPage = Integer.parseInt(req.getParameter("currentPage"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		Page<Restaurant> restaurants = restaurantService.getResaurant(currentPage,pageSize);
		jsonManager.outJson(resp,restaurants);
	}

}
