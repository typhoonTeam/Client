package team_typhoon_consumer.testutil;

import org.junit.Test;
import typhoon.consuemer.util.HttpUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Dunn
 *
 */
public class httpUtil {
   @Test
   public void testConnection() throws IOException{
       URL url = new URL("http://www.baidu.com");
       Map<String,String> map = new HashMap<>();
       map.put("Content-Type","application/x-www-form-urlencoded");
       HttpURLConnection conn = new HttpUtil().getConnection(url,map);
       assert(conn!=null);
   }
  
}
