package typhoon.consuemer.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.manager.JsonOutManager;
import typhoon.consuemer.pojo.User;
import typhoon.consuemer.service.UserService;
import typhoon.consuemer.service.impl.UserServiceImpl;
import typhoon.consuemer.util.JsonParse;
import typhoon.consuemer.util.JsonParseByJackson;
import typhoon.consuemer.util.MD5Util;
/**
 * 
 * @author Dunn
 *
 */
public class RegisterServlet extends HttpServlet {
	private static JsonParse<User> jsonParse = new JsonParseByJackson<>();
	private static final long serialVersionUID = 1L;
	JsonOutManager jsonManager = new JsonOutManager();
	private static UserService userService = UserServiceImpl.getInstance();   
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String temp = br.readLine();
		User user = jsonParse.parseJsonToObject(User.class, temp);
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		Integer type = userService.regist(user);
		//返回>0则代表注册成功
		jsonManager.outJson(response,type);
	}
}
