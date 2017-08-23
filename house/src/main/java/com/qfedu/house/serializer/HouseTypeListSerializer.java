package com.qfedu.house.serializer;

import java.util.List;

import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.qfedu.house.domain.HouseType;

public class HouseTypeListSerializer extends Jackson2JsonRedisSerializer<List<HouseType>> {

	public HouseTypeListSerializer(Class<List<HouseType>> type) {
		super(type);
	}

}
