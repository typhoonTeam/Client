package typhoon.consuemer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.manager.JsonOutManager;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.service.impl.FoodServiceImpl;

/**
 * 
 * @author Carrie
 *
 */
public class FoodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JsonOutManager jsonManager = new JsonOutManager();
	FoodServiceImpl foodServiceImpl = FoodServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String foodId = (String)request.getParameter("food_id");
		 if(foodId!=null) {
			 Food food = foodServiceImpl.getFoodInfoByFoodId(foodId);
			 jsonManager.outJson(response,food);
		 }else {
			 jsonManager.outJson(response,"");
		 }
	}

}
