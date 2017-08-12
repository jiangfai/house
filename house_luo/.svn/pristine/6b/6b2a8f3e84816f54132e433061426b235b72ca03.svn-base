package com.qfedu.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.qfedu.house.service.DistrictService;

@Controller
public class DistrictController {

	@Autowired
	private DistrictService distService;
	
	@GetMapping("/exp")
	public String exportDistricts(ModelMap map) {
		map.put("districts", distService.listAllDistricts());
		return "distExcel";
	}
	
	@GetMapping("/pdf")
	public String exportDistrictsToPdf(ModelMap map) {
		map.put("districts", distService.listAllDistricts());
		return "distPdf";
	}
}
