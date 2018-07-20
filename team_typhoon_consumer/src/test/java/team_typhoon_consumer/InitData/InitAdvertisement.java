package team_typhoon_consumer.InitData;

import typhoon.consuemer.util.DBUtil;

import java.sql.Connection;
import java.sql.Statement;

public class InitAdvertisement implements  DataInitIterface{
    @Override
    public void init() {
        Connection conn = DBUtil.getConnection();
        String sql1 = "INSERT INTO Advertisement VALUES("1","1","1")";
        String sql2 = "INSERT INTO Advertisement VALUES()";
        String sql3 = "INSERT INTO Advertisement VALUES()";
        Statement stmt = conn.createStatement();
        stmt.execute(sql1);
        stmt.execute(sql2);
        stmt.execute(sql3);
        DBUtil.close(conn,stmt,null);
    }
}
