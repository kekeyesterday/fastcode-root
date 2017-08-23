package com.fastcode.service;

import org.springframework.stereotype.Service;

import com.fastcode.inf.IUserService;

@Service("userService")
public class UserServiceImp implements IUserService {

	@Override
	public String getMsg(String name) {
		String msg = "Hello " + name;
		return msg;
	}

}
