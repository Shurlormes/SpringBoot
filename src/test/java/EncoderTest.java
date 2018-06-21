import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Base64;

public class EncoderTest {
	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	@Test
	public void MD5Encoder() {
		String s = "123456";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset();
			messageDigest.update(s.getBytes());
			System.out.println(messageDigest.digest().length);
			System.out.println(getFormattedText(messageDigest.digest()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void BCryptTest() {
		String str = "123456";
		String encodeStr = BCrypt.hashpw(str, BCrypt.gensalt());
		System.out.println(encodeStr);
		System.out.println(BCrypt.checkpw(str, "$2a$10$uQ2cDEJjlptwaLpBEOsw2.fQ0KwgfwT8tgCiReKy/XRMtmVp1qMUq"));
	}

	@Test
	public void Base64Test() throws UnsupportedEncodingException {
		String str = "123456asdasdasdasd";
		String encodeStr = Base64.getEncoder().encodeToString(str.getBytes());
		System.out.println(encodeStr);
		System.out.println(new String(Base64.getDecoder().decode(encodeStr), "UTF-8"));
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
