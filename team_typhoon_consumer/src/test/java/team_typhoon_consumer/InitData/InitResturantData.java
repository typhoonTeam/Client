package team_typhoon_consumer.InitData;

import typhoon.consuemer.util.DBUtil;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @Dunn
 */
public class InitResturantData implements DataInitIterface{
    @Override
    public void init(){
        Connection conn = DBUtil.getConnection();
//        String sql = "DROP TABLE user";
//        String sql1 = "INSERT INTO userinfo VALUES('shopid1','username1','password1')";
//        String sql2 = "INSERT INTO RESTAURANT VALUES('shopid1','0','24',)";
//        String sql3 = "INSERT INTO REGISTERINFO VALUES()";
//        Statement stmt = conn.createStatement();
//        stmt.execute(sql);
//        stmt.execute(sql1);
//        stmt.execute(sql2);
//        stmt.execute(sql3);
//        DBUtil.close(conn,stmt,null);
    }
}
