package com.sic.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sic.manager.dao.UserMapper;
import com.sic.manager.pojo.User;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired UserMapper userMapper;
	
	@RequestMapping("/select")
	@ResponseBody
	public User serlectByid() {
		User user = new User();
		user = userMapper.selectById(1);
		return user;
		
	}
}
