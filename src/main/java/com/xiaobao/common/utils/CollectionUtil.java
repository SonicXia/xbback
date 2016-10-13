/*
 * (C)2012 JiangSu HopeRun Corporation. 
 *       All rights reserved.
 */
package com.xiaobao.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * List、Map 共通方法
 * 
 * @version 1.0
 */
public final class CollectionUtil {
    protected static Logger log = LoggerFactory.getLogger(CollectionUtil.class);
/**
     * 判断Map是否为空
 * 
     * @param map 数组
     * @return 为空返回true，不为空返回false
 */
    @SuppressWarnings("rawtypes")
	public static boolean isEmpty(Map map) {
        if (map == null || map.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断Map是否为空
     * 
     * @param map 数组
     * @return 为空返回true，不为空返回false
     */
    @SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    /**
     * 判断集合是否为空
     * 
     * @param collection 数组
     * @return 为空返回true，不为空返回false
     */
    @SuppressWarnings("rawtypes")
	public static boolean isEmpty(Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断数组是否为空
     * 
     * @param objs 数组
     * @return 为空返回true，不为空返回false
     */
    public static boolean isEmpty(Object[] objs) {
        if (objs == null || objs.length == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * 判断集合是否为空
     * 
     * @param collection 集合
     * @return 不为空返回true，为空返回false
     */
    @SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    /**
     * 判断数组是否为空
     * 
     * @param objs 数组
     * @return 不为空返回true，为空返回false
     */
    public static boolean isNotEmpty(Object[] objs) {
        return !isEmpty(objs);
    }

    /**
     * 将数组转成集合
     * 
     * @param objs 数组
     * @return lstArray 集合
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List arrayToCollection(Object[] objs) {

        return new ArrayList(Arrays.asList(objs));

    }

    /**
     * 将集合转成数组
     * 
     * @param collection 集合
     * @return 数组
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object[] collectionToArray(Collection collection) {
        Object[] objs = null;
        if (isNotEmpty(collection)) {
            objs = new Object[collection.size()];
            collection.toArray(objs);
        }
        return objs;

    }

    /**
     * 求两个集合合集，只对集合中的元素是基本类型才有效
     * 
     * @param c1 集合1
     * @param c2 集合2
     * @return 合集
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List union(Collection c1, Collection c2) {
        List collection = new ArrayList();
        collection.addAll(c1);
        collection.addAll(c2);
        return collection;
    }

    /**
     * 求两个集合交集，只对集合中的元素是基本类型才有效
     * 
     * @param c1 集合1
     * @param c2 集合2
     * @return 交集
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List intersect(Collection c1, Collection c2) {
        List c1_ = new ArrayList();
        List c1__ = new ArrayList();
        if (isNotEmpty(c1)) {
            c1_.addAll(c1);
            c1__.addAll(c1);
            c1__.removeAll(c2);
            c1_.removeAll(c1__);
        }

        return c1_;
    }

    /**
     * 求两个集合差集，只对集合中的元素是基本类型才有效
     * 
     * @param c1 集合1
     * @param c2 集合2
     * @return 差集(c1-c2)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List minus(Collection c1, Collection c2) {
        List c1_ = new ArrayList();
        if (isNotEmpty(c1)) {
            c1_.addAll(c1);
            c1_.removeAll(c2);
        }
        return c1_;

    }

    /**
     * 对集合进行排序，只对集合中的元素是基本类型才有效
     * 
     * @param collection 集合
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Collection collection) {
        if (isNotEmpty(collection)) {
            Object[] objs = collectionToArray(collection);
            Arrays.sort(objs);

            collection.clear();
            collection.addAll(arrayToCollection(objs));

        }
    }

    /**
     * 对集合进行排序，只对数组中的元素是基本类型才有效
     * 
     * @param objs 数组
     */
    public static void sort(Object[] objs) {
        if (isNotEmpty(objs)) {
            Arrays.sort(objs);
        }

    }

 /**
     * 获取list长度
     * 
     * @param list
     * @return 为null时，返回0
     */
    public final static int getSize(List<?> list) {
        if (isEmpty(list)) {
            return 0;
        }
        return list.size();
    }
    
    /**
     * 获取map长度
     * 
     * @param list
     * @return 为null时，返回0
     */
    public final static int getSize(Map<?, ?> map) {
        if (isEmpty(map)) {
            return 0;
        }
        return map.size();
    }
}
