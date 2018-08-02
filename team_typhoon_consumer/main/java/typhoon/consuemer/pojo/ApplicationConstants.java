package typhoon.consuemer.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
/**
 * @author dunn 2018/7/14
 *
 */
public abstract class ApplicationConstants {
    
  
    public static final String LOGIN_SESSION_NAME = "userInfo";

    public static Map<String,HttpSession> SESSION_MAP = new HashMap<>();
    
 
    public static int CURRENT_LOGIN_COUNT = 0;
    

    public static int TOTAL_HISTORY_COUNT = 0;
    

    public static int MAX_ONLINE_COUNT = 0;
    
 
    public static Date SERVER_START_DATE = new Date();

    
    public static Date MAX_ONLINE_COUNT_DATE = new Date();
}