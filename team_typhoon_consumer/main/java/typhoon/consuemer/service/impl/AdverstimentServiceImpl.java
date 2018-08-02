package typhoon.consuemer.service.impl;

import java.util.List;

import typhoon.consuemer.dao.AdvertisementDao;
import typhoon.consuemer.dao.impl.AdvertisementDaoImpl;
import typhoon.consuemer.pojo.Advertisement;
import typhoon.consuemer.service.AdverstimentService;
/**
 * 
 * @author Dunn
 *
 */
public class AdverstimentServiceImpl implements AdverstimentService{
	//饿汉单例模式
	private AdverstimentServiceImpl() {}
    private static final AdverstimentServiceImpl single = new AdverstimentServiceImpl();
    public static AdverstimentServiceImpl getInstance() {
    	return single;
    }
	private AdvertisementDao advertisementDaoImpl = new AdvertisementDaoImpl();
	@Override
	public List<Advertisement> getAdvertisement(List<String> advertisementId) {
		// TODO Auto-generated method stub
		return advertisementDaoImpl.getAdvertisement(advertisementId);
	}

}
