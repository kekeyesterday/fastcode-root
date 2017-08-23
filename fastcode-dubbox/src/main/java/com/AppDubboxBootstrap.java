package com;



import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.fastcode.inf.IMyDemo;
import org.springframework.beans.factory.config.EmbeddedValueResolver;

@SpringBootApplication
@ImportResource(locations={"application-dubbo.xml"})
public class AppDubboxBootstrap {
	private static Logger logger = LoggerFactory.getLogger(AppDubboxBootstrap.class);
	
/*	   @Bean
	    public Object testBean(PlatformTransactionManager platformTransactionManager){
	        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
	        return new Object();
	    }*/
	   
//	   @Resource(name="txManager2")
//	    private PlatformTransactionManager txManager2;

	    // 创建事务管理器1
//	    @Bean(name = "txManager1")
//	    public PlatformTransactionManager txManager(DataSource dataSource) {
//	        return new DataSourceTransactionManager(dataSource);
//	    }

//	    // 创建事务管理器2
//	    @Bean(name = "txManager2")
//	    public PlatformTransactionManager txManager2(EntityManagerFactory factory) {
//	        return new JpaTransactionManager(factory);
//	    }
//
//	    // 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
//	    @Override
//	    public PlatformTransactionManager annotationDrivenTransactionManager() {
//	        return txManager2;
//	    }
	   
	public static void main(String[] args) throws Exception{
		SpringApplication application = new SpringApplication(AppDubboxBootstrap.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
		//ApplicationContext applicationContext = application.run(args);
		
//		IMyDemo myDemo = (IMyDemo)applicationContext.getBean(IMyDemo.class);
//		
//		EchoService echoService = (EchoService) myDemo; // 强制转型为EchoService
//		String status = echoService.$echo("OK").toString(); // 回声测试可用性
//		 
//		assert(status.equals("OK"));
		
		
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
