package typhoon.consuemer.pojo;

import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Dunn
 *
 */
public class Restaurant {
	private String shopId;
	private String openTime;
	private String closeTime;
	private Integer delivery;
	private Integer deli_fee;
	private String picture;
	private String slogan;
	private Integer status;
	private String comment;
	private String shopName;
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public Integer getDelivery() {
		return delivery;
	}
	public void setDelivery(Integer delivery) {
		this.delivery = delivery;
	}
	public Integer getDeli_fee() {
		return deli_fee;
	}
	public void setDeli_fee(Integer deli_fee) {
		this.deli_fee = deli_fee;
	}
	public String getPicture() {		
		return picture;
	}
	public void setPicture(String picture) {
		Properties conf = new Properties();
		try {
			conf.load(Restaurant.class.getClassLoader().getResourceAsStream("merchantconfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.picture = conf.getProperty("imgurl")+picture;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}