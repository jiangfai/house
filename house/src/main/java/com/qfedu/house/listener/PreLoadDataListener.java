package com.qfedu.house.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qfedu.house.domain.HouseType;
import com.qfedu.house.service.HouseService;

@WebListener
public class PreLoadDataListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		WebApplicationContext ctx = 
				WebApplicationContextUtils.getWebApplicationContext(sc);
		RedisTemplate<String, List<HouseType>> redisTemplate = 
				ctx.getBean(RedisTemplate.class);
		redisTemplate.opsForValue().set("houseTypeList", null);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		WebApplicationContext ctx = 
				WebApplicationContextUtils.getWebApplicationContext(sc);
		HouseService houseService = ctx.getBean(HouseService.class);
		houseService.listAllHouseTypes();
	}

}
