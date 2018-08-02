package typhoon.consuemer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.util.JsonOutUtil;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.pojo.Page;
import typhoon.consuemer.service.impl.FoodServiceImpl;

/**
 * 
 * @author Carrie
 * update dunn  2018/7/20
 */
public class FindFoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	FoodServiceImpl foodServiceImpl =  FoodServiceImpl.getInstance();
	JsonOutUtil jsonManager = new JsonOutUtil();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String shop_id = request.getParameter("shop_id");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		if(shop_id!=null) {
			Page<Food> page = foodServiceImpl.getFoodsByRestaurantId(shop_id, currentPage,pageSize);
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalPage(page.getTotalCount()/pageSize);
			jsonManager.outJson(response,page);
		}else {
			jsonManager.outJson(response,"{}");
		}
	}
	
	

}
