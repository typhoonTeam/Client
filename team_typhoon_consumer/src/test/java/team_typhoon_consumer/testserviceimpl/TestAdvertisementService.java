package team_typhoon_consumer.testserviceimpl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import typhoon.consuemer.pojo.Advertisement;
import typhoon.consuemer.service.AdverstimentService;
import typhoon.consuemer.service.impl.AdverstimentServiceImpl;
/**
 * 
 * @author Dunn
 *
 */
public class TestAdvertisementService {
	private static AdverstimentService adverstimentService;
	@BeforeClass
	public static void init() {
		adverstimentService =  AdverstimentServiceImpl.getInstance();
	}
	@Test
	public void getAdverstiment() throws Exception {
		List<String> s = new ArrayList<>();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("5");
		List<Advertisement> ads = adverstimentService.getAdvertisement(s);
		System.out.println(ads.size());
		assert(ads.size()>0);
	}
}
