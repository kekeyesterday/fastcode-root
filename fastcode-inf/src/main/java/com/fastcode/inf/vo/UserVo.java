package com.fastcode.inf.vo;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class UserVo implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4929594747577487438L;
	
	private String userName;
	private String age;
	private String desc;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

}
