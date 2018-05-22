package com.zhijian.market.core.util;
/**
 * 字符串工具类
 * @author CZHao
 *
 */
public class StringUtil {
	private StringUtil(){}
	
	/**
	 * 判断字符串是否为空
	 * @param target
	 * @return
	 */
	public static boolean isNull(String target) {
		return target == null || target.length()== 0;
	}
	
	/**
	 * 判断字符串是否不为空 
	 * @param target 
	 * @return
	 */
	public static boolean isNotNull(String target) {
		return target != null && target.length() > 0;
	}
	
	/**
	 * 字符串取左右空格
	 * @param target
	 * @return
	 */
	public static String trim(String target) {
		if(target == null) {
			return null;
		}else{
			return target.trim();
		}
	}
	
	/**
	 * 移除所有空格
	 * @param target 
	 * @return
	 */
	public static String removeAllSpace(String target) {
		if(target == null) {
			return null;
		}else {
			return target.replaceAll("\\s", "");
		}
	}
	
	
}
