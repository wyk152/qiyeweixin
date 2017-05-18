package com.sic.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sic.manager.pojo.Token;
import com.sic.utils.HttpClientUtil;
import com.sic.utils.JsonUtils;


@Controller 
@RequestMapping("token")
public class GetAccessToken {

	 /**
     * 将json结果集转化为对象
     * 
     * @param jsonData json数据
     * @param clazz 对象中的object类型
     * @return
     */
	@RequestMapping("/get")
	@ResponseBody
	public Token getToken(){
		
		//企业号CorpID:ww416cc8a6998d10d7 
		/*Map<String, String> param = new HashMap<>();
		param.put("corpid", "wx5fa6b9aa2465df3f");
		param.put("corpsecret", "piphKpeHPG_tOhqWhNkmTeIg6M7A31_YUntbJ_qlfWctXZQ0F32LZB5tMsO0aeUD");
		String doGet = HttpClientUtil.doGet("https://qyapi.weixin.qq.com/cgi-bin/gettoken", param);
		System.out.println(doGet);
		Token token = JsonUtils.jsonToPojo(doGet, Token.class);*/
		
		//公众号(测试号)
		
		Map<String, String> param = new HashMap<>();
		param.put("appid", "wx713e22041688a79b");
		param.put("secret", "b578624715323cf0709c16817619d427");
		String doGet = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential", param);
		System.out.println(doGet);
		Token token = JsonUtils.jsonToPojo(doGet, Token.class);
		/*Map<String, String> param2 = new HashMap<>();
		param2.put("appid", "wx5fa6b9aa2465df3f");
		param2.put("redirect_uri ", "http://localhost:8080/sic/user/select");
		param2.put(" response_type ", "code");
		param2.put(" scope ", "snsapi_base");
		param2.put(" agentid ", "snsapi_base#wechat_redirect");
		String doGet2 = HttpClientUtil.doGet("https://open.weixin.qq.com/connect/oauth2/authorize", param2);
		System.out.println(doGet2);*/
		return token;
	}
}
