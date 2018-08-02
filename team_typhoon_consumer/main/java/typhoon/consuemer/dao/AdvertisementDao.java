package typhoon.consuemer.dao;

import java.util.List;

import typhoon.consuemer.pojo.Advertisement;
/**
 * 
 * @author Dunn
 *
 */
public interface AdvertisementDao {
	public List<Advertisement> getAdvertisement(List<String> advertisementId);

	int addAdvertisement(Advertisement ad);
}
