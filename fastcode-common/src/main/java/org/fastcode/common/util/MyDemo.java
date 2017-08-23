package org.fastcode.common.util;
import org.springframework.beans.BeanUtils;

public class MyDemo {

	public static void main(String[] args) {
		java.util.Date d = new java.util.Date();
		d.setYear(2008);
		
	
		System.out.println("d::" + d.toLocaleString());
		
		User old = new User("jimmy",20,d);
		Student stu = new Student();
		stu.setUuid("asdfasdfa");
		old.setStu(stu);
		
		
		
		User news = new User();
		System.out.println("oldId:" + old.hashCode() + ";stuId:" + old.getStu().hashCode());
		
		BeanUtils.copyProperties(old, news);
		news.getStu().setUuid("123345");
		System.out.println("oldstuId:" + old.getStu().getUuid());
		System.out.println("" + news.getUserName() + "|| " + news.getDate().getYear() + "|| " + news.getStu().getUuid());
		System.out.println("newsId:" + news.hashCode() + ";stuId:" + news.getStu().hashCode());
	}

}
