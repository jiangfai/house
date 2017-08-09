package com.qfedu.house.service;

import com.qfedu.house.domain.User;

// Transaction Script Pattern
// User request ---> method ---> transaction script

public interface UserService {
	
	boolean login(User user, String ipAddress);
	
	boolean register(User user);
}
