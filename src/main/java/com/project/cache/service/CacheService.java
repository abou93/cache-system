package com.project.cache.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.cache.model.CacheModel;


@Service
public class CacheService {

	
	private Map<String, CacheModel> mapCache = new HashMap<String, CacheModel>();
	private Logger LOG = LoggerFactory.getLogger(CacheService.class);
	
	
	public String getCacheDataWithCle(String cle) {
		
		CacheModel cache = mapCache.get(cle);
		
		if (cache != null && !cache.isExpired()) {
			return cache.getDatas();
		}
		else {
			return null;
		}
	}
	
	public boolean deleteCacheDataWithCle(String cle) {
		
		CacheModel cache = mapCache.get(cle);
		
		if (cache != null) {
			mapCache.remove(cle);
			LOG.info("Le cache identifié avec la clé "+cle+" a été supprimé");
			return true;
		}
		else {
			LOG.error("Le cache spécifié avec la clé "+cle+" n'existe pas");
			return false;
		}
	}

	public boolean addCacheDataWithCle(String cle, CacheModel cacheModel) {
		
		if (mapCache.containsKey(cle)) {
			LOG.error("Le cache spécifié avec la clé "+cle+" n'existe pas");
			return false;
		}
		else {
			mapCache.put(cle, cacheModel);
			LOG.info("Le cache identifié avec la clé "+cle+" a été ajouté");
			return true;
		}
	}
}
