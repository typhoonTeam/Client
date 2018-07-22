package typhoon.consuemer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.service.impl.FoodServiceImpl;
import typhoon.consuemer.util.JsonOutUtil;

/**
 * 
 * @author Carrie
 *
 */
public class FoodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FoodServiceImpl foodServiceImpl = FoodServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String foodId = (String)request.getParameter("food_id");
		 if(foodId!=null) {
			 Food food = foodServiceImpl.getFoodInfoByFoodId(foodId);
			 JsonOutUtil.outJson(request,response,food);
		 }else {
			 JsonOutUtil.outJson(request,response,"");
		 }
	}

}
