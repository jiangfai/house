package com.qfedu.house.controller;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qfedu.house.domain.User;
import com.qfedu.house.dto.UserDTO;
import com.qfedu.house.service.UserService;
import com.qfedu.house.util.CommonUtil;

@Controller
public class UserController {
	private static final int VC_LEN = 4;

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/delUser")
	public String delUser(@RequestParam("id") int userId) {
		return "";
	}
	
	@GetMapping(value = "/hello/{helloId}")
	public String showPages(
			@PathVariable("helloId") int id,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestPart("file") MultipartFile photo) {
		return "";
	}
	
	@GetMapping(value = "/code", produces = "image/png")
	@ResponseBody
	public BufferedImage getCode(HttpSession session) {
		String code = CommonUtil.generateVC(VC_LEN);
		session.setAttribute("code", code);
		BufferedImage bufferedImage = CommonUtil.getImageFromString(code, 120, 30);
		return bufferedImage;
	}
	
	@GetMapping("/to_login")
	public String toLogin(Model model) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUser(new User());
		model.addAttribute("userDTO", userDTO);
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(HttpServletRequest req, @Valid UserDTO userDTO, Errors errors, Model model) {
		HttpSession session = req.getSession();
		String codeFromServer = (String) session.getAttribute("code");
		String code = userDTO.getCode();
		String hint = null;
		String viewName = "login";
		if (codeFromServer != null && codeFromServer.equalsIgnoreCase(code)) {
			if (errors.hasErrors()) {
				hint = "请输入有效的登录信息";
			} else {
				userDTO.setIpAddress(req.getRemoteAddr());
				if (userService.login(userDTO)) {
					session.setAttribute("user", userDTO.getUser());
					viewName = "redirect: index";
				} else {
					hint = "用户名或密码错误";
				}
			}
		} else {
			hint = "请输入正确的验证码";
		}
		if (hint != null) {
			model.addAttribute("hint", hint);
		}
		return viewName;
	}
	
	@GetMapping("/to_reg")
	public String toRegister() {
		
		return "register";
	}
	
	@PostMapping("reg")
	public String doRegister(@Valid User user, Errors errors) {
		if (errors.hasErrors()) {
			
			return "register";
		} else {
			if (userService.register(user)) {
				
				return "redirect: to_login";
			} else {
				return "register";
			}
		}
	}
	
}
