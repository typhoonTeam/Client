package typhoon.consuemer.manager.managerImpl;

import typhoon.consuemer.manager.HttpManager;
import typhoon.consuemer.pojo.HttpReq;
import typhoon.consuemer.util.HttpUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpManagerImpl implements HttpManager {
    HttpURLConnection conn = null;
    public String sendHttpRequest(HttpReq res) throws IOException {
        Map<String,String> headerMap = res.getRequestHeaderMap();
        Map<String,String> paramMap = res.getParam();
        URL url = null;
		try {
			url = new URL(res.getUrl());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
        conn = new HttpUtil().getConnection(url,headerMap);
        DataOutputStream out = null;
		try {
			out = new DataOutputStream(conn.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        int count = 0;
        for(Map.Entry<String, String> entry: paramMap.entrySet())
        {
            String content=  entry.getKey()+ "="+entry.getValue();
            count++;
            if(count!=paramMap.size()) {
                content+="&";
            }
            out.writeBytes(content);
        }

        out.flush();
        out.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        StringBuilder sb=new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        reader.close();
        conn.disconnect();
        return sb.toString();
    }
}
