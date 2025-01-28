package com.project.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cache.model.CacheModel;
import com.project.cache.service.CacheService;

@RestController
@RequestMapping("/api/v1/cache")
public class CacheController {

	@Autowired
	private CacheService service;
	

	@GetMapping("/get")
	public String getCache(@RequestParam("cle") String cle) {
		
		return service.getCacheDataWithCle(cle);
	}
	@DeleteMapping("/delete")
	public boolean deleteCache(@RequestParam("cle") String cle) {
		
		return service.deleteCacheDataWithCle(cle);
	}
	@PostMapping("/add")
	public void addCache(@RequestParam("cle") String cle, @RequestBody CacheModel cacheModel) {
		
		 service.addCacheDataWithCle(cle, cacheModel);
	}
}
