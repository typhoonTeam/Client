package team_typhoon_consumer.testdaoimp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import typhoon.consuemer.dao.AdvertisementDao;
import typhoon.consuemer.dao.impl.AdvertisementDaoImpl;
import typhoon.consuemer.pojo.Advertisement;
import typhoon.consuemer.util.DBUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Dunn
 *
 */
public class TestAdDaoImpl {
    private static AdvertisementDao advertisementDao;
    @BeforeClass
    public static void init(){
        advertisementDao = new AdvertisementDaoImpl();
    }
    @Test
    public void testAddAdvertisement() {
    	Advertisement ad = new Advertisement();
    	ad.setDate(new Date());
    	ad.setId(1);
    	ad.setPicture("/ad");
    	ad.setPrice(11);
    	ad.setSlogan("asdasd");
    	ad.setShopId("asd");
    	ad.setState(0);
    	assert(advertisementDao.addAdvertisement(ad)>0);
    }
    @Test
    public void testGetAdvertisementDao(){
       
    	List<String> ad = new ArrayList<>();
    	ad.add("asd");
        List<Advertisement> ads = advertisementDao.getAdvertisement(ad);
        assert(ads.size()>0);

    }

}
