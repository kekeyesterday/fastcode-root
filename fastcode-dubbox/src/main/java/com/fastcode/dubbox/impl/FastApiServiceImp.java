package com.fastcode.dubbox.impl;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.fastcode.httpApi.IFastApi;
import com.fastcode.inf.ICacheService;
import com.fastcode.inf.IMyDemo;
import com.fastcode.inf.ISyncService;
import com.fastcode.inf.vo.SystemResponse;
import com.fastcode.inf.vo.UserVo;



@Service("fastApiService")
@Path("fastApi")
public class FastApiServiceImp implements IFastApi {
	@Autowired
	private IMyDemo myDemo;
	@Autowired
	private ISyncService syncService;
	@Autowired
	private ICacheService cacheService;

	@Override
	@GET
    @Path("getMsg/{userId}")
	@Produces({"application/json; charset=UTF-8" ,"text/xml; charset=UTF-8"})
	//@Consumes({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
	//@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML,MediaType.CHARSET_PARAMETER})
	public SystemResponse getMsg(@PathParam("userId")Long userId) {
		String address = RpcContext.getContext().getRemoteHost().toString();
		System.out.println("=====address:" + address);
		SystemResponse res = new SystemResponse();
		UserVo vo = myDemo.getUserEntity(userId);
		res.setData(vo);
		return res;
	}

	@GET
    @Path("getTMsg")
	@Override
	public String getTestMsg(@QueryParam("name")String name) {
		String msg = syncService.getMsg(name);
		Date date = new Date();
		System.out.println(date + "::=======msg1:" + msg);
		Future<String> future = RpcContext.getContext().getFuture();  
		try {
			msg = future.get();
			System.out.println(date + "::=======msg2:" + msg);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@GET
    @Path("getCache")
	@Override
	/**
	 * lru 缓存示例，缓存在消费端，一样的参数，返回的结果相同,不会再进入服务接口端
	 */
	public String getCache(@QueryParam("id")String id) {
		
		String cmsg = cacheService.findCache(id);
		
		for(int i=1;i<=30006;i++){
			cmsg = cacheService.findCache(id);
			System.out.println(i+ "===cmsg====" + cmsg);
		}
		
		return cmsg;
	}
	
	

}	
