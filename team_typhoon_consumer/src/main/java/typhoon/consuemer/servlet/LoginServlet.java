package typhoon.consuemer.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.util.JsonOutUtil;
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
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserService userService = UserServiceImpl.getInstance();
    private JsonParse<User> jsonParse = new JsonParseByJackson<>();
	JsonOutUtil jsonManager = new JsonOutUtil();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String temp = br.readLine();
		User user = jsonParse.parseJsonToObject(User.class, temp);
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(MD5Util.md5Password(user.getPassword()));
		Integer result = userService.Login(user);
		br.close();
		jsonManager.outJson(response,result);

	}

}
