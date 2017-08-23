package org.fastcode.common.util;

public class ZKStoper {

	public static void main(String[] args) {
		ZkClient zkClient = ZkClient.getZKClientInstance();
		zkClient.stopZK();

	}

}
