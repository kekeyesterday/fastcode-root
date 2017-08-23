package org.fastcode.common.util;

public class ZookeeperTest {

	public static void main(String[] args) throws Exception{
		
		ZkClient zkClient = ZkClient.getZKClientInstance();
		
		for(int i=0;i<10;i++){
			Thread.sleep(3000l);
			zkClient.writePath("test-" + i);
			//break;
		}
		
//		Thread.sleep(5000l);
		

	}

}
