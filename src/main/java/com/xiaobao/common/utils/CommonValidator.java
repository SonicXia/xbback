package com.xiaobao.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonValidator {

	static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	/**
	 * 验证输入的邮箱格式是否符合
	 * 
	 * @param email
	 * @return 是否合法
	 */
	public static boolean isEmail(String email) {
		// String regular = "\\w+@(\\w+\\.){1,3}\\w+";
		if (null != email) {
			Matcher matcher = EMAIL_PATTERN.matcher(email);
			return matcher.matches();
		}
		return false;
	}

	// 当前运营商号段分配
	// 中国移动号段 1340-1348 135 136 137 138 139 150 151 152 157 158 159 187 188
	// 147
	// 中国联通号段 130 131 132 155 156 185 186 145
	// 中国电信号段 133 1349 153 180 189
	static final String MOBILE_REGEX = "1\\d{10}";
	static final Pattern MOBILE_PATTERN = Pattern.compile(MOBILE_REGEX);

	static final String BLURED_MOBILE_REGEX = "1[3,4,5,7,8]{1}[\\d*]{9}";
	static final Pattern BLURED_MOBILE_PATTERN = Pattern.compile(BLURED_MOBILE_REGEX);

	/**
	 * 验证是否是手机号格式 该方法还不是很严谨,只是可以简单验证 当前运营商号段分配 中国移动号段 1340-1348 135 136 137 138
	 * 139 150 151 152 157 158 159 187 188 147 中国联通号段 130 131 132 155 156 185
	 * 186 145 中国电信号段 133 1349 153 180 189
	 * 
	 * @param mobile
	 * @return true表示是正确的手机号格式,false表示不是正确的手机号格式
	 */
	public static boolean isMobile(String mobile) {
		if (mobile != null) {
			Matcher matcher = MOBILE_PATTERN.matcher(mobile);
			return matcher.matches();
		}
		return false;
	}

	/**
	 * 是否为加星号的手机
	 * @param mobile
	 * @return
	 */
	public static boolean isBluredMobile(String mobile) {
		if (mobile != null) {
			Matcher matcher = BLURED_MOBILE_PATTERN.matcher(mobile);
			return matcher.matches();
		}
		return false;
	}

	/**
	 * 验证是否为安全的字符类型参数，防止SQL注入攻击
	 * 
	 * @return
	 */
	public static boolean isSafeString(String string) {
		return true;
	}

	
	static final String MOBILE_CC_REGEX = "^861\\d{10}";
    static final Pattern MOBILE_CC_PATTERN = Pattern.compile(MOBILE_CC_REGEX);
    public static boolean isMobileWithCountryCode(String mobile) {
        
        if (mobile != null) {
            Matcher matcher = MOBILE_CC_PATTERN.matcher(mobile);
            return matcher.matches();
        }
        return false;
    }

	public static void main(String[] args) {
		
	}
}
