/*
 * *************************************************************************************
 *
 *   Project:        ZXQ
 *
 *   Copyright ©     2014-2017 Banma Technologies Co.,Ltd
 *                   All rights reserved.
 *
 *   This software is supplied only under the terms of a license agreement,
 *   nondisclosure agreement or other written agreement with Banma Technologies
 *   Co.,Ltd. Use, redistribution or other disclosure of any parts of this
 *   software is prohibited except in accordance with the terms of such written
 *   agreement with Banma Technologies Co.,Ltd. This software is confidential
 *   and proprietary information of Banma Technologies Co.,Ltd.
 *
 * *************************************************************************************
 *
 *   Class Name: com.zebra.carcloud.trip.utils.StringUtil
 *
 *   General Description:
 *
 *   Revision History:
 *                            Modification
 *    Author                Date(MM/DD/YYYY)   JiraID           Description of Changes
 * **************************************************************************************
 *    lvchuntian            2017-02-13
 *
 * **************************************************************************************
 */

package org.fastcode.common;

import com.google.gson.Gson;

/**
 *
 */
public class StringUtil {
	private static Gson gson = new Gson();
    
    public static String null2Str(Object origin) {
        return ((origin == null || "null".equals(origin)) ? "" : origin.toString().trim());
    }

    public static String getJsonByObj(Object obj){
        try {
        	return gson.toJson(obj);
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public static <T> T transJsonToObject(String objJson,Class<T> t){
        try {
            return gson.fromJson(objJson, t);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
        
    }
    
    static int num = 0;
    public static void main(String[] args) {
		System.out.println("" + funTest(10));
		System.out.println("num::" + num);
	}
    
    public static int funTest(int n ){
    	num ++;
    	if(n <= 1)
    		return 1;
    	else
    		return funTest(n-1) + funTest(n-2);
    	
    }
    
}
