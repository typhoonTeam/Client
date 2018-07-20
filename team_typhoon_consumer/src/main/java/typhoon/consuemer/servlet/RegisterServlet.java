package typhoon.consuemer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.pojo.User;
import typhoon.consuemer.service.UserService;
import typhoon.consuemer.service.impl.UserServiceImpl;
import typhoon.consuemer.util.JsonOutUtil;
import typhoon.consuemer.util.JsonParse;
import typhoon.consuemer.util.JsonParseByJackson;
import typhoon.consuemer.util.MD5Util;
/**
 * 
 * @author Carrie
 *
 */
public class RegisterServlet extends HttpServlet {
	private static JsonParse<User> json = new JsonParseByJackson<>();
	private static final long serialVersionUID = 1L;
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
		String username = request.getParameter("username");
		String password = MD5Util.md5Password(request.getParameter("password"));
		String userId = UUID.randomUUID().toString();
		User user = new User();
		user.setPassword(password);
		user.setUserId(userId);
		user.setUsername(username);
		Integer type = userService.regist(user);
		//返回>0则代表注册成功
		JsonOutUtil.outJson(request,response,type);
	}
}
