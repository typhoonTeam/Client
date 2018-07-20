package typhoon.consuemer.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
/**
 * 
 * @author Dunn
 *
 */
public class HttpUtil {
    private  HttpURLConnection connection;
    /*
     * map中为存入的http请求参数头等，如key为Conten-Type，value为""application/x-www-form-urlencoded";
     */
    public HttpURLConnection getConnection(URL url, Map<String, String> map) throws IOException{
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        //设置请求头
        for(String key:map.keySet()) {
            connection.setRequestProperty(key, map.get(key));
        }
        connection.connect();
        return connection;
    }
}
