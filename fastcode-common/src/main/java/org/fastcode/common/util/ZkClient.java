/***************************************************************************************
 *
 *  Project:        ZXQ
 *
 *  Copyright ©     2014-2017 Banma Technologies Co.,Ltd
 *                  All rights reserved.
 *
 *  This software is supplied only under the terms of a license agreement,
 *  nondisclosure agreement or other written agreement with Banma Technologies
 *  Co.,Ltd. Use, redistribution or other disclosure of any parts of this
 *  software is prohibited except in accordance with the terms of such written
 *  agreement with Banma Technologies Co.,Ltd. This software is confidential
 *  and proprietary information of Banma Technologies Co.,Ltd.
 *
 ***************************************************************************************
 *
 *  Header Name: Banma.h
 *
 *  General Description: Copyright and file header.
 *
 *  Revision History:
 *                           Modification
 *   Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 *   ---------------------   ------------    ----------     -----------------------------
 *   lvchuntian            2017年4月5日
 *
 ****************************************************************************************/

package org.fastcode.common.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class ZkClient {
	private static final Logger logger = LoggerFactory.getLogger(ZkClient.class);
	private static ZkClient zkClient = null;
	private String zkConn;
	private String userName;
	private String password;
	private static CuratorFramework client;
	private boolean zkConnected = false;
	static CountDownLatch countDownLatch = new CountDownLatch(1);
	private static String PUBLISH_PATH = "/trigger1";

	private ZkClient(String zkConn, String userName, String password) throws Exception {
		this.zkConn = zkConn;
		this.userName = userName;
		this.password = password;

		ExponentialBackoffRetry retry = new ExponentialBackoffRetry(2000, 8);
		// 创建zk客户端
		CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder().connectString(zkConn)
				.retryPolicy(retry).connectionTimeoutMs(1000 * 16).sessionTimeoutMs(1000 * 30).namespace("opm_pushmsg");

		client = builder.build();
		client.start();
		try {
			zkConnected = client.blockUntilConnected(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
		if(client.checkExists().forPath(PUBLISH_PATH) == null){
			client.create().forPath(PUBLISH_PATH);
		}
		
//		zkClient.client.getData().usingWatcher(pathWatcher).forPath(PUBLISH_PATH);
//		zkClient.client.getData().watched();
		
		
		//client.getData().usingWatcher(pathWatcher).forPath(PUBLISH_PATH);
		
		
//		 final NodeCache nodeCache = new NodeCache(client,PUBLISH_PATH);
//		 nodeCache.start();
//		 nodeCache.getListenable().addListener(new NodeCacheListener(){
//			@Override
//			public void nodeChanged() throws Exception {
//				Stat st = nodeCache.getCurrentData().getStat();
//                System.out.println("重新获得节点内容为：" + new String(nodeCache.getCurrentData().getData()));
//			}
//			 
//		 });
		 
		
	}

	private static ZkClient init(String zkConn, String userName, String password) throws Exception {
		zkClient = new ZkClient(zkConn, userName, password);
		// watcherPath(PUBLISH_PATH,pathWatcher);
		return zkClient;
	}
	
	public static void startZK(){
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void stopZK(){
		try {
			countDownLatch.countDown();
			//client.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ZkClient getZKClientInstance() {
		try {
			if (null == zkClient) {
				synchronized (ZkClient.class) {
					zkClient = ZkClient.init("10.6.230.84:2181", "", "");
				}
			}
		} catch (Exception e) {
			logger.error("初始化异常", e);
		}
		return zkClient;
	}

	static CuratorWatcher pathWatcher = new CuratorWatcher() {

		public void process(WatchedEvent event) throws Exception {
			//System.out.println("======name:=======" + event.getState().getIntValue());
			readPath(event.getPath());
			// 当数据变化后，重新获取数据信息
//			if (event.getType() == EventType.NodeDataChanged) {
//				// 获取更改后的数据，进行相应的业务处理
//				//readPath(event.getPath());
//			}
		}
	};


	public static String readPath(String path) throws Exception {
		byte[] buffer = zkClient.client.getData().forPath(path);
		String jsonParam = new String(buffer);
		// JSONObject jsonObject = JSON.parseObject(jsonParam);
		// @SuppressWarnings("unchecked")
		// Map<String,String> appKeyMap = jsonObject.getObject("appKeyMap",
		// Map.class);
		logger.info("获取推送消息的数据:{}", jsonParam);
		System.out.println("获取推送消息的数据:" + jsonParam);
		// noticeCommService.setPushTimer(jsonObject.getLong("msgId"),appKeyMap);
		return jsonParam;
	}

	public void writePath(String data) throws Exception {
		System.out.println("输入数据:{}" + data);
		zkClient.client.setData().forPath(PUBLISH_PATH, data.getBytes());
		zkClient.client.getData().usingWatcher(pathWatcher).forPath(PUBLISH_PATH);
		zkClient.client.getData().watched();
//		byte[] buffer = zkClient.client.getData().usingWatcher(pathWatcher).forPath(PUBLISH_PATH);
	}

	public static void main(String[] args) throws Exception {
		//ZkClient client = ZkClient.getZKClientInstance();
		//client.writePath("qwerqwerq");
		// client.readPath(PUBLISH_PATH);
		// Thread.sleep(2000000);
	}

	public String getZkConn() {
		return zkConn;
	}

	public void setZkConn(String zkConn) {
		this.zkConn = zkConn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CuratorFramework getClient() {
		return client;
	}

	public void setClient(CuratorFramework client) {
		this.client = client;
	}

	public boolean isZkConnected() {
		return zkConnected;
	}

	public void setZkConnected(boolean zkConnected) {
		this.zkConnected = zkConnected;
	}

}
