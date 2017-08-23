package com.fastcode.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.fastcode.inf.ISyncService;

@Service("syncService")
public class SyncServiceImpl implements ISyncService {

	@Override
	public String getMsg(String name) {
		String msg = null;
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date date = new Date();
		msg = "Hello " + name;
		System.out.println(date + "::=========msg=======" + msg);
		return msg;
	}

}
