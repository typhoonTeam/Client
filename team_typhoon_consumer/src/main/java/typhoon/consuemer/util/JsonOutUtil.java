package typhoon.consuemer.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.consuemer.util.JsonParse;
import typhoon.consuemer.util.JsonParseByJackson;

import java.io.IOException;
import java.io.PrintWriter;

public class JsonOutUtil {
    private  JsonParse json = new JsonParseByJackson();
    public  void outJson(HttpServletResponse response, Object object){
        response.setContentType("text/html;charset=UTF-8");
        //禁用缓存，确保网页信息是最新数据
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", -10);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String jsonStr=json.parseObjectToJson(object);
            out.print(jsonStr);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            out.close();
        }
    }
}
