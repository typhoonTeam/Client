package team_typhoon_consumer.InitData;

import typhoon.consuemer.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class InitAdvertisement implements  DataInitIterface{
	@Override
	public void init() {
		Connection conn = DBUtil.getConnection();
		String sql = "DROP TABLE Advertisement";
		String sql1 = "INSERT INTO Advertisement VALUES(ad_seq.nextval,'testShopId1','picture1','slogan1',0,to_date('2018-07-14','yyyy-mm-dd'))";
		String sql2 = "INSERT INTO Advertisement VALUES(ad_seq.nextval,'testShopId2','picture2','slogan1',0,to_date('2018-07-14','yyyy-mm-dd'))";
		String sql3 = "INSERT INTO Advertisement VALUES(ad_seq.nextval,'testShopId3','picture3','slogan1',0,to_date('2018-07-14','yyyy-mm-dd'))";
		System.out.println(sql1);
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.execute(sql1);
			stmt.execute(sql2);
			stmt.execute(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn,stmt,null);
		}

	}
	 public static void main(String[] args) {
			DataInitIterface dataInitIterface = new InitAdvertisement();
			dataInitIterface.init();
		}
}
