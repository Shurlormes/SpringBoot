import com.voidforce.spring.boot.bean.UserInfo;
import com.voidforce.spring.boot.util.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

	@Test
	public void testJsonUtil() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "abc");
		map.put("email", "abc@abc.com");
		map.put("telephone", "01234567890");
		map.put("address", "abc.cba.ccc.bbb.aaa");

		String json4Map = JsonUtil.convertObject2Json(map);
		System.out.println(json4Map);

		UserInfo user = JsonUtil.convertJson2Object(json4Map, UserInfo.class);
		System.out.println(user);

		System.out.println("===================================================");

		List<UserInfo> list = new ArrayList<>();
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);

		String json4List = JsonUtil.convertObject2Json(list);
		System.out.println(json4List);

		List<UserInfo> userInfoList = JsonUtil.convertJson2Object(json4List, ArrayList.class, UserInfo.class);
		System.out.println(userInfoList);
	}
}
