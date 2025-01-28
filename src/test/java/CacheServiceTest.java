
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.cache.model.CacheModel;
import com.project.cache.service.CacheService;


@SpringBootTest
public class CacheServiceTest {

	@Autowired
	private CacheService cacheService;

	private final String CLEMOCK = "MY KEY";
	private final String DATASMOCK = "MY KEY";
	
	@Test
	public void ajouterCache() {
		
		CacheModel cacheModel = new CacheModel();
		cacheModel.setDatas(DATASMOCK);
		cacheModel.setExpirationTime(1L);
		
		assertTrue( cacheService.addCacheDataWithCle(CLEMOCK, cacheModel) );
	}
	@Test
	public void recupererCache() {
		
		assertEquals(DATASMOCK, cacheService.getCacheDataWithCle(CLEMOCK));
	}
	@Test
	public void supprimerCache() {

		assertTrue( cacheService.deleteCacheDataWithCle(CLEMOCK) );
	}
}
