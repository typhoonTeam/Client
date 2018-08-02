package typhoon.consuemer.pojo;

import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Dunn
 *
 */
public class Food {
	private Integer id;
	private String foodName;
	private String price;
	private String picture;
	private String info;
	private Integer status;
	private String shopId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		Properties conf = new Properties();
		try {
			conf.load(Food.class.getClassLoader().getResourceAsStream("merchantconfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.picture = conf.getProperty("imgurl") + picture;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
}
