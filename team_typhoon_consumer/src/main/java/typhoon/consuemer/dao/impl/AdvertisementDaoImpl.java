package typhoon.consuemer.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import typhoon.consuemer.dao.AdvertisementDao;
import typhoon.consuemer.pojo.Advertisement;
import typhoon.consuemer.util.DBUtil;
/**
 * 
 * @author Dunn
 *
 */
public class AdvertisementDaoImpl implements AdvertisementDao{
	private Connection conn;

	@Override
	public List<Advertisement> getAdvertisement(List<String> advertisementId) {
		conn = new DBUtil().getConnection();
		List<Advertisement> ads=new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select * from advertisement where shop_id in(");
			for(int i=0;i<advertisementId.size();i++) {
				sb.append("?");
				if((i+1)<advertisementId.size()) sb.append(",");
			}
			sb.append(")");
			String sql=sb.toString();
			pst = conn.prepareStatement(sql);
			System.out.println(sql);
			for(int i=0;i<advertisementId.size();i++) {
				pst.setString(i+1, advertisementId.get(i));
			}
			rs=pst.executeQuery();
			while(rs.next()){
				Advertisement ad=new Advertisement();
				ad.setId(rs.getInt("id"));
				ad.setPicture(rs.getString("picture"));
				ad.setShopId(rs.getString("shop_id"));
				ad.setSlogan(rs.getString("slogan"));
				ad.setState(rs.getInt("state"));
				ad.setDate(rs.getDate("time"));
				ads.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pst, rs);
		}
		return ads; 

	}

	@Override
	public int addAdvertisement(Advertisement ad) {
		int num = 0;
		String sql = "INSERT INTO advertisement(id,shop_id,picture,slogan,state,time) VALUES (ad_seq.nextval,?,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
		pStatement = con.prepareStatement(sql);
		pStatement.setString(1, ad.getShopId());
		pStatement.setString(2, ad.getPicture());
		;
		pStatement.setString(3, ad.getSlogan());
		pStatement.setInt(4, ad.getState());
		pStatement.setDate(5,new Date(ad.getDate().getTime()));

		num = pStatement.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
		DBUtil.close(con, pStatement, null);
		}
		return num;
	}
  
	
	

}
