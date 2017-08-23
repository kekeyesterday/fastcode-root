package com;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.rpc.RpcContext;
import com.fastcode.inf.IMyDemo;
import com.util.SpringContextUtil;

import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.io.support.PropertySourceFactory;

@SpringBootApplication
@ImportResource(locations = { "classpath:application-my-dubbo.xml" })
public class AppWebClientBootstrap {
	private static Logger logger = LoggerFactory.getLogger(AppWebClientBootstrap.class);

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(AppWebClientBootstrap.class);
		application.setBannerMode(Banner.Mode.OFF);
		ApplicationContext applicationContext = application.run(args);
		SpringContextUtil.setApplicationContext(applicationContext);
		boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
		logger.info("isConsumerSide:====" + isConsumerSide);
		
		
		logger.info("启动成功");
		final CountDownLatch latch = new CountDownLatch(1);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				latch.countDown();
			}
		});
		latch.await();
	}
}
