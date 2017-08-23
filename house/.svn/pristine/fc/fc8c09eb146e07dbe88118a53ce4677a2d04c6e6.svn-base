package com.qfedu.house.cipher.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;

import com.qfedu.house.cipher.ThyCipher;

public class AESCipher implements ThyCipher {
	private static final SecretKey DEFAULT_KEY = generateKey();
	private SecretKey key = DEFAULT_KEY;
	
	public static SecretKey generateKey(String key) {
		byte[] buffer = DigestUtils.md5(key);
		return new SecretKeySpec(buffer, "AES");
	}
	
	public static SecretKey generateKey() {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128);
			return keyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setKey(SecretKey key) {
		this.key = key;
	}
	
	@Override
	public String encode(String originalStr) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] buffer = cipher.doFinal(originalStr.getBytes());
			return Base64.getEncoder().encodeToString(buffer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String decode(String cipheredStr) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] buffer = Base64.getDecoder().decode(cipheredStr);
			buffer = cipher.doFinal(buffer);
			return new String(buffer, "utf-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
