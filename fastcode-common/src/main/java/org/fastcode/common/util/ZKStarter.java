package org.fastcode.common.util;

public class ZKStarter {

	public static void main(String[] args) {
		ZkClient zkClient = ZkClient.getZKClientInstance();
		zkClient.startZK();

	}

}
