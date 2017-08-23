package org.fastcode.common.util;

import java.util.Date;

public class User {
	private String userName;
	private int age;
	private Date date;
	private Student stu;
	
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	User(){}
	
	User(String userName,int age,Date date){
		this.userName = userName;
		this.age = age;
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
