package typhoon.consuemer.service;

import java.util.List;

import typhoon.consuemer.pojo.Advertisement;
/**
 * 
 * @author Dunn
 *
 */
public interface AdverstimentService {
	public List<Advertisement> getAdvertisement(List<String> advertisementId);
}
