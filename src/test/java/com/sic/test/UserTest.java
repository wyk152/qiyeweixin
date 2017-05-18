package com.sic.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sic.manager.dao.UserMapper;
import com.sic.manager.pojo.User;
import com.sic.utils.HttpClientUtil;

public class UserTest {

	@Test
	public void test1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		UserMapper userMapper = applicationContext.getBean(UserMapper.class);
		User user = new User();
		user = userMapper.selectById(1);
		System.out.println(user);
		
		Map<String, String> param2 = new HashMap<>();
		param2.put("appid", "wx5fa6b9aa2465df3f");
		param2.put("redirect_uri ", "http://localhost:8080/sic/user/select");
		param2.put(" response_type ", "code");
		param2.put(" scope ", "snsapi_base");
		param2.put(" agentid ", "snsapi_base#wechat_redirect");
		String doGet2 = HttpClientUtil.doGet("https://open.weixin.qq.com/connect/oauth2/authorize", param2);
		System.out.println(doGet2);
	}
}
