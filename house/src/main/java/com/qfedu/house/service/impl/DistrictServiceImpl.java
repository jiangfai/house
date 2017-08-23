package com.qfedu.house.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.house.domain.District;
import com.qfedu.house.service.DistrictService;

@Service
@Transactional(readOnly = true)
public class DistrictServiceImpl implements DistrictService {
	// @Autowired
	// private DistrictMapper distMapper;
	
	@Override
	public List<District> listAllDistricts() {
		// return distMapper.findAll();
		return null;
	}

}
