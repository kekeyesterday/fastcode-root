package com.fastcode.client;

import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.fastcode.inf.IMyDemo;
import com.fastcode.inf.vo.UserVo;

public class ConsumeTest {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"application-my-dubbo.xml"});
        context.start();
 
        IMyDemo myDemoService = context.getBean("myDemoService",IMyDemo.class); // 获取远程服务代理
        String hello = myDemoService.getUserInfo(1l); // 执行远程方法
 
        System.out.println( hello ); // 显示调用结果
        
        UserVo vo =  myDemoService.getUserEntity(1l);
        
        System.out.println("ttt::" + vo.getUserName());
        
        GenericService barService = (GenericService) context.getBean(GenericService.class);
        HashMap<String, Object> result = ( HashMap<String, Object>)barService.$invoke("getUserEntity", new String[] { "java.lang.Long" }, new Object[] { 1l });
        System.out.println("====GenericService=====" + result);

	}

}
