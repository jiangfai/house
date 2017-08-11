package com.qfedu.house.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qfedu.house.domain.User;
import com.qfedu.house.persistence.BaseDaoHibernateAdapter;
import com.qfedu.house.persistence.UserDAO;

@Repository
public class UserDAOImpl 
		extends BaseDaoHibernateAdapter<User, Integer> 
		implements UserDAO {
	
	@Override
	public User findByUsername(String username) {
		List<User> usersList = sessionFactory.getCurrentSession()
				.createQuery("from User as u where u.username=:uid", User.class)
				.setParameter("uid", username)
				.getResultList();
		return usersList.size() == 1 ? usersList.get(0) : null;
	}
}
