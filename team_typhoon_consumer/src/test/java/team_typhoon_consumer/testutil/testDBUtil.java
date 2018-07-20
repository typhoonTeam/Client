package team_typhoon_consumer.testutil;

import org.junit.Test;
import typhoon.consuemer.util.DBUtil;

import java.sql.Connection;
/**
 * 
 * @author Dunn
 *
 */
public class testDBUtil {
    private static DBUtil dbUtil;
    private static void init(){
        dbUtil = new DBUtil();
    }
    @Test
    public void testConnection(){
        Connection conn = DBUtil.getConnection();
        assert (conn!=null);
    }
    @Test
    public void testConnectionClose(){
        Connection conn = DBUtil.getConnection();
        DBUtil.close(conn,null,null);
    }
}
