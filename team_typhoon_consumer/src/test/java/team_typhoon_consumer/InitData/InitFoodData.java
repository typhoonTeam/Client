package team_typhoon_consumer.InitData;

import typhoon.consuemer.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitFoodData implements DataInitIterface {
    @Override
    public  void init() {
        Connection conn = DBUtil.getConnection();
        String sql1 = "INSERT INTO FOOD VALUES('1','beijingkaoya',12.2,'picture1','info1',1,'testId1')";
        String sql2 = "INSERT INTO FOOD VALUES('1','beijingkaoya2',12.2,'picture2','info2',0,'testId1')";
        String sql3 = "INSERT INTO FOOD VALUES('1','beijingkaoya3',12.2,'picture3','info3',1,'testId1')";
        Statement stmt = null;
		try {
			stmt = conn.createStatement();
			 stmt.execute(sql1);
		        stmt.execute(sql2);
		        stmt.execute(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        DBUtil.close(conn,stmt,null);
    }
    public static void main(String[] args) {
		DataInitIterface dataInitIterface = new InitFoodData();
		dataInitIterface.init();
	}
}
