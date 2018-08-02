package typhoon.consuemer.pojo;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;
/**
 * 
 * @author Dunn
 *
 */
public class Advertisement
{
	private Integer id; 
	private String shopId;
	private String  picture;
	private String slogan; //简介
	private double price;
	private int state;
	private Date date;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		Properties conf = new Properties();
		try {
			conf.load(Advertisement.class.getClassLoader().getResourceAsStream("merchantconfig.properties"));
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
}
