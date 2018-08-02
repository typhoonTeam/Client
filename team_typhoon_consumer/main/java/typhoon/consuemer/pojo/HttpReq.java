package typhoon.consuemer.pojo;

import java.util.Map;
/**
 * 
 * @author Dunn
 *
 */
public class HttpReq {
    public String url;
    public Map<String,String> requestHeaderMap; //请求头
    public Map<String,String> param; //请求参数

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getRequestHeaderMap() {
        return requestHeaderMap;
    }

    public void setRequestHeaderMap(Map<String, String> requestHederMap) {
        this.requestHeaderMap = requestHederMap;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }
}
