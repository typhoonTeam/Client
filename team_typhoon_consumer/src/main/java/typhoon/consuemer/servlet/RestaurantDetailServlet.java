package typhoon.consuemer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.pojo.Restaurant;
import typhoon.consuemer.service.impl.RestaurantServiceImpl;
import typhoon.consuemer.util.JsonOutUtil;

/**
 * 
 * @author Carrie
 *update dunn 2018_7_20
 */
public class RestaurantDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RestaurantServiceImpl restaurantServiceImpl =  RestaurantServiceImpl.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopId = (String) request.getParameter("shop_id");
		if(shopId!=null) {
			Restaurant restaurant = restaurantServiceImpl.getRestaurant(shopId);
			JsonOutUtil.outJson(request,response,restaurant);
		}else {
			JsonOutUtil.outJson(request, response, "{}");
		}
	}

}
