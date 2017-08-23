package com.qfedu.house.cipher;

import com.qfedu.house.cipher.impl.AESCipher;

public class ThyCiphers {

	private ThyCiphers() {
		throw new AssertionError();
	}
	
	public static ThyCipher getThyCipher(String algName) {
		algName = algName.toLowerCase();
		ThyCipher thyCipher = null;
		switch (algName) {
		case "aes":
			thyCipher = new AESCipher();
			break;
		default:
			throw new CipherAlgorithmNotSupportedException();
		}
		return thyCipher;
	}
}
