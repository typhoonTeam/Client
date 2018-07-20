package typhoon.consuemer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import typhoon.consuemer.pojo.Food;
import typhoon.consuemer.pojo.Restaurant;


public class  JsonParseByJackson<T> implements JsonParse<T>{

	@Override
	public String parseObjectToJson(Object object) {
		String result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			result= mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String parseListToJson(List<T> list) {
		String result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			result= mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public T parseJsonToObject(Class<T> clazz, String json) {
		T result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			result=mapper.readValue(json,clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public List<T> parseJsonToList(Class<T> clazz, String json) {
		List<T> result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class,clazz);
			result=mapper.readValue(json,javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map<String, T> parseJsonToMap(Class<T> clazz, String json) {
		Map<String,T> result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType javaType = mapper.getTypeFactory().constructParametricType(Map.class,String.class,clazz);
			result=mapper.readValue(json,javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String parseMapToJson(Map<String, T> map) {
		String result=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			result= mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args){
//		List<Food> foods = new ArrayList<Food>();
//		for(int i = 0;i<10;i++){
//			Food food = new Food();
//			food.setFoodName("foodname");
//			food.setId(1);
//			food.setInfo("foodinfo");
//			food.setPicture("ccc");
//			food.setPrice("11");
//			food.setShopId("aa");
//			food.setStatus(0);
//			foods.add(food);
//		}
		Restaurant res = new Restaurant();
		res.setCloseTime("21");
		res.setDeli_fee(2);
		res.setOpenTime("22");
		res.setPicture("cvcc");
		res.setShopId("ccc");
		res.setSlogan("sss");
		res.setStatus(0);
		res.setComment("aaa");
		res.setShopName("sss");
		res.setDelivery(2);
		JsonParse jsonParse = new JsonParseByJackson();
		System.out.println(jsonParse.parseObjectToJson(res));
	}
}
