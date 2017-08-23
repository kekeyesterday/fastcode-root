package org.fastcode.common.util.jdk8;

import java.io.File;
import java.io.FileFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.util.FileUtil;

public class Lambda {
	private static Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
	
	private static String tempPath = "D:/test";
	
	/**
	 * 根据tagId查找文件
	 * @param tagId
	 * @return
	 */
	private static File[] findFilesByTagId(final String tagId){
		File[] files = null;
		try {
			StringBuilder filePath = new StringBuilder(tempPath).append("/msgtemp");
			File fileDir = new File(filePath.toString());
			if(fileDir.isDirectory()){
				FileFilter fFilter = (File f) -> (f.getName().contains(tagId));
//				FilenameFilter fileter = new FilenameFilter(){
//					@Override
//					public boolean accept(File dir, String name) {
//						if(name.contains(tagId))
//							return true;
//						return false;
//					}
//					
//				};
				files = fileDir.listFiles(fFilter);
			}
		} catch (Exception e) {
			LOGGER.error("文件过滤异常",e);
			throw e;
		}
		
		return files;
	}
	
	private void test(int x){
	}
	
	public static void main(String[] args) {
		Integer []a = {1,2,3,4,5};
		java.util.List<Integer> aa = java.util.Arrays.asList(a);
		aa.forEach((p)->System.out.println(p*2));
		
	}
	
	private static void myTest(String str){
		System.out.print(str+"_");
	}
	
	

}


