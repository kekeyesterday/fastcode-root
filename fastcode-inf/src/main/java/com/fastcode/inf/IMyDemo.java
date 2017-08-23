package com.fastcode.inf;

import com.fastcode.inf.vo.UserVo;

public interface IMyDemo {
	String getUserInfo(Long userId);
	//void update(TTest test);
	String getMsg(String name);
	UserVo getUserEntity(Long userId);
}
