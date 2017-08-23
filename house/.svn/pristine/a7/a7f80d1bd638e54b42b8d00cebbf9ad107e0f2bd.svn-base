package com.qfedu.house.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.qfedu.house.cipher.ThyCiphers;
import com.qfedu.house.cipher.impl.AESCipher;

public class MyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private AESCipher cipher;
	
	public MyPlaceholderConfigurer() {
		cipher = (AESCipher) ThyCiphers.getThyCipher("aes");
		cipher.setKey(AESCipher.generateKey("1qaz2wsx"));
	}
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (propertyName.equals("username") || propertyName.equals("password")) {
			return cipher.decode(propertyValue);
		} else {
			return propertyValue;
		}
	}

}
