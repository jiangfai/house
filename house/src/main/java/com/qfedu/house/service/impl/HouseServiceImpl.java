package com.qfedu.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.house.domain.HouseType;
import com.qfedu.house.persistence.HouseTypeDao;
import com.qfedu.house.service.HouseService;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseTypeDao houseTypeDao;
	@Autowired
	private RedisTemplate<String, List<HouseType>> redisTemplate;
	
	@Override
	public List<HouseType> listAllHouseTypes() {
		List<HouseType> houseTypeList = redisTemplate.opsForValue().get("houseTypeList");
		if (houseTypeList == null) {
			houseTypeList = houseTypeDao.findAll();
			redisTemplate.opsForValue().set("houseTypeList", houseTypeList);
		}
		return houseTypeList;
	}

}
