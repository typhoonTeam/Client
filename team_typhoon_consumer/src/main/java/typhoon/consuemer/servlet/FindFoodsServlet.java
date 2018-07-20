package typhoon.consuemer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.service.impl.FoodServiceImpl;
import typhoon.consuemer.util.JsonOutUtil;

/**
 * 
 * @author Carrie
 * update dunn  2018/7/20
 */
public class FindFoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	FoodServiceImpl fServiceImpl =  FoodServiceImpl.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shop_id = request.getParameter("shop_id");
		if(shop_id!=null) {
			List<Food> foods = fServiceImpl.getFoodsByRestaurantId(shop_id);
			JsonOutUtil.outJson(request,response,foods);
		}else {
			JsonOutUtil.outJson(request,response,"{}");
		}
	}

}
