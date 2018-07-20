package typhoon.consuemer.manager;

import typhoon.consuemer.pojo.HttpReq;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
/**
 * 
 * @author Dunn
 *
 */
public interface HttpManager {
    public String sendHttpRequest(HttpReq res) throws IOException;
}
