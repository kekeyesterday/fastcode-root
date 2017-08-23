package com.fastcode.httpApi;

import com.fastcode.inf.vo.SystemResponse;

public interface IFastApi {
	SystemResponse getMsg(Long userId);
	String getTestMsg(String name);
	
	String getCache(String id);
}
