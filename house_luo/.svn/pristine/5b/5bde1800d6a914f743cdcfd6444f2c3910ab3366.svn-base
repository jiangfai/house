package com.qfedu.house.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qfedu.house.domain.User;
import com.qfedu.house.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/to_login")
	public String toLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(HttpServletRequest req, @Valid User user, Errors errors, Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("hint", "请输入有效的登录信息");
			return "login";
		} else {
			String ipAddress = req.getRemoteAddr();
			if (userService.login(user, ipAddress)) {
				req.getSession().setAttribute("user", user);
				return "redirect: index";
			} else {
				model.addAttribute("hint", "用户名或密码错误");
				return "login";
			}
		}
	}
	
}
