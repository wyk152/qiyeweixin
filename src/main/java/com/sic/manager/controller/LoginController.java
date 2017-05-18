package com.sic.manager.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sic.support.KaptchaProducerAgency;
import com.sic.support.Response;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
/**
 * 登录控制器
 * @author wangyankai
 *
 */
@Controller
@RequestMapping("login")
public class LoginController {
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	//@Autowired private AccountService accountService;
//	@Autowired private CurrentUserInfoService currentUserInfoService;
//	@Autowired private StringRedisTemplate redisTemplate;//只有STRING 序列化成JSON用着先,等出稳定版 



	/**
	 * 
	 * @Title: loginDo 
	 * @Description: 平台登录
	 * @param @param username
	 * @param @param password
	 * @return Response 返回类型,如果成功返回跳转的URL
	 * @throws
	 */
	

	/**
	 * 获取登录的图片验证码
	 */
	@RequestMapping(value = "imgcode", method = RequestMethod.GET)
	public void captcha(HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		//Subject currentUser = SecurityUtils.getSubject();
		HttpSession  session = request.getSession();  
		Producer captchaProducer = KaptchaProducerAgency.getKaptchaProducerExample();
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		// return a jpeg
		response.setContentType("image/jpeg");
		// create the text for the image
		String capText = captchaProducer.createText();
		log.debug("******************验证码是: " + capText + "******************");
		// store the text in the session
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText	);
		// create the image with the text
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		// write the data out
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}


}
