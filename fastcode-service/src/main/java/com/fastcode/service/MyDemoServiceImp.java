package com.fastcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcode.domain.entity.TTest;
import com.fastcode.inf.IMyDemo;
import com.fastcode.inf.vo.UserVo;
import com.fastcode.mapper.TTestMapper;

@Service("myDemoService")
public class MyDemoServiceImp implements IMyDemo {
	
	@Autowired
	TTestMapper TTestMapper;

	@Override
	public String getUserInfo(Long userId) {
		TTest test = TTestMapper.selectByPrimaryKey(userId);
		return test.getUdesc();
	}

//	@Override
//	public void update(TTest test) {
//		TTestMapper.updateByPrimaryKey(test);
//
//	}

	@Override
	public String getMsg(String name) {
		String msg = "Hello " + name;
		return msg;
	}

	@Override
	public UserVo getUserEntity(Long userId) {
		UserVo vo = new UserVo();
		TTest test = TTestMapper.selectByPrimaryKey(userId);
		vo.setAge(test.getAge());
		vo.setDesc(test.getUdesc());
		vo.setUserName(test.getUserName());
		return vo;
	}

}
