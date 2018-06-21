package com.voidforce.spring.boot.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.MessageDigest;

public class EncodeUtil {

	private static String SHA256 = "SHA-256";

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String encodeByBCrypt(String str) {
		return BCrypt.hashpw(str, BCrypt.gensalt());
	}

	public static String encodeBySHA256(String str) {
		if(StringUtils.isEmpty(str)) {
			return null;
		}

		return encode(str, SHA256);
	}

	private static String encode(String str, String instance) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(instance);
			messageDigest.reset();
			messageDigest.update(str.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (Exception e) {
			return null;
		}
	}

	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;

		StringBuilder buf = new StringBuilder(len * 2);
		// 把密文转换成十六进制的字符串形式
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}

		return buf.toString();
	}
}
