package com.xiaobao.common.utils;

import java.io.UnsupportedEncodingException;

public class codeConertUtil {
	
	 public static String iso2Utf(String str) throws UnsupportedEncodingException
	    {
	       return new String(str.getBytes("ISO-8859-1"),"UTF-8");
	    }
}
