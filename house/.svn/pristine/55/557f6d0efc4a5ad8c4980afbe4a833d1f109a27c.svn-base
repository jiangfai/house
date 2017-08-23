package com.qfedu.house.service.impl;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.house.domain.LoginLog;
import com.qfedu.house.domain.User;
import com.qfedu.house.dto.UserDTO;
import com.qfedu.house.persistence.LoginLogDAO;
import com.qfedu.house.persistence.UserDAO;
import com.qfedu.house.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private LoginLogDAO loginLogDAO;
	
	@Override
	public boolean login(UserDTO userDTO) {
		User user = userDTO.getUser();
		User temp = userDAO.findByUsername(user.getUsername());
		if (temp != null) {
			String md5 = DigestUtils.md5Hex(user.getPassword());
			boolean flag = temp.getPassword().equals(md5);
			if (flag) {
				user.setId(temp.getId());
				user.setIsAdmin(temp.getIsAdmin());
				user.setRealname(temp.getRealname());
				LoginLog log = new LoginLog();
				log.setUser(user);
				log.setIpAddress(userDTO.getIpAddress());
				log.setLogDate(new Date());
				loginLogDAO.save(log);
			}
			return flag;
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		if (userDAO.findByUsername(user.getUsername()) == null) {
			user.setPassword(DigestUtils.md5Hex(user.getPassword()));
			return userDAO.save(user) != null;
		}
		return false;
	}

}
