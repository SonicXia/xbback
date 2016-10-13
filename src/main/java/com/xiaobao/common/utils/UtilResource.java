package com.xiaobao.common.utils;

import java.util.ResourceBundle;

/**
 * 工具类
 * @java
 * @version 1.0.0
 */
public class UtilResource {
    
    public static String getValue(String propfile,String key){
		try{
			String fileSepartor = System.getProperties().getProperty("file.separator");
//			String os ="windows";
			if(fileSepartor.equals("/")){
				propfile = propfile + "_linux";
	    	}else{
	    		propfile = propfile + "_windows";
	    	}
        	ResourceBundle rb = ResourceBundle.getBundle(propfile);
			return rb.getString(key);
        }catch(Exception e){
        	e.printStackTrace();
            return null;
        }
    } 
    public static void main(String arg[]){
    	System.out.println(UtilResource.getValue("yumconfig", "cache_validity_time_day"));
    }
}

