package com.xiaobao.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * 常用对象方法
 * 
 * 
 */
public class ObjectUtils {
	/**
	 * 比较2对象相等,处理null
	 * 
	 * @param a
	 * @param b
	 * @return 是否相等
	 */
	public static boolean safeEq(Object a, Object b) {
		return Objects.equals(a, b);
	}

	public static byte[] serializeObject(Object o) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream(1024);
		ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
		try {
			objectStream.writeObject(o);
			return byteStream.toByteArray();
		} finally {
			byteStream.close();
			objectStream.close();
		}
	}

	public static Object unserializeObject(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
		ObjectInputStream objectStream = new ObjectInputStream(byteStream);
		try {
			return objectStream.readObject();
		} finally {
			byteStream.close();
			objectStream.close();
		}
	}
}
