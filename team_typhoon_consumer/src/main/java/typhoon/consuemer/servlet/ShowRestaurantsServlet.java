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
import typhoon.consuemer.util.JsonOut;

/**
 * 
 * @author Carrie
 *
 */
public class ShowRestaurantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpManager httpManager = new HttpManagerImpl();
	RestaurantService rServiceImpl = RestaurantServiceImpl.getInstance();
	AdverstimentService aServiceImpl = AdverstimentServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(this.getServletConfig().getServletContext().getRealPath("/"));
		HttpReq httpReq = getHttpReq();
		String results  = httpManager.sendHttpRequest(httpReq);
		if(results!=null) {
			List<String> resArr = Arrays.asList(results.split("-"));
			if(resArr.size()>0) {
				List<Advertisement> advertisements = aServiceImpl.getAdvertisement(resArr);
				//输出json
				JsonOut.outJson(request,response,advertisements);
			}
		}
		
		List<Restaurant> restaurants = rServiceImpl.getResaurant();
		if(restaurants!=null && restaurants.size()>0) {
//			request.setAttribute("restaurants", restaurants);
			JsonOut.outJson(request,response,restaurants);
		}
//		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}

	private HttpReq getHttpReq() {
		HttpReq httpReq = new HttpReq();
		//properties以后将放在listener中
		Properties conf = new Properties();
		try {
			conf.load(ShowRestaurantsServlet.class.getClassLoader().getResourceAsStream("adminconfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put(conf.getProperty("parammap_key"), conf.getProperty("parammap_value"));
		httpReq.setParam(paramMap);
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put(conf.getProperty("headermap_key"), conf.getProperty("headermap_value"));
		httpReq.setRequestHeaderMap(headerMap);
		httpReq.setUrl(conf.getProperty("httpurl"));
		return httpReq;
	}


}
