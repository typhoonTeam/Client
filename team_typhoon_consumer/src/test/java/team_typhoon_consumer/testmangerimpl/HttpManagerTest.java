package team_typhoon_consumer.testmangerimpl;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import oracle.net.aso.l;
import typhoon.consuemer.manager.HttpManager;
import typhoon.consuemer.manager.impl.HttpManagerImpl;
import typhoon.consuemer.pojo.HttpReq;
/**
 * 
 * @author Dunn
 *
 */
public class HttpManagerTest {
 @Test
public void tsetHttpSend() throws Exception {
	 HttpManager httpManager = new HttpManagerImpl();
	 HttpReq request = new HttpReq();
	 request.setUrl("http://www.baidu.com");
	 Map<String,String> map = new HashMap<>();
	 map.put("Content-Type", "application/x-www-form-urlencoded");
	 Map<String,String> pmap = new HashMap<>();
	 pmap.put("a", "1");
	 request.setParam(pmap);
	 request.setRequestHeaderMap(map);
	 String aString = httpManager.sendHttpRequest(request);
	 System.out.println(aString);
	 assert(aString!=null);
	 
}
}
