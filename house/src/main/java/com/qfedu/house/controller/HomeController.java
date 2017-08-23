package com.qfedu.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.qfedu.house.service.HouseService;

@Controller
public class HomeController {

	@Autowired
	private HouseService houseService;
	
	@GetMapping(value = "/index")
	public String toIndex(Model model) {
		model.addAttribute("houseTypes", houseService.listAllHouseTypes());
		return "index";
	}
}
