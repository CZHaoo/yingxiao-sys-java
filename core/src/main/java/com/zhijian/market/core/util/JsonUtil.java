package com.zhijian.market.core.util;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

	/**
	 * 将 javaBean转成 json串（带有日期格式）
	 * 
	 * @param bean
	 *            javaBean
	 * @param dateFormat
	 *            日期格式
	 * @return
	 */
	public static <T> String beanToJson(T bean, String dateFormat) {
		if (bean == null) {
			return null;
		} else {
			if (StringUtil.isNull(dateFormat)) {
				return beanToJson(bean);
			} else {
				return JSONObject.toJSONStringWithDateFormat(bean, dateFormat);
			}
		}

	}

	/**
	 * 将javabean 转成json字符串
	 * 
	 * @param bean
	 * @return
	 */
	public static <T> String beanToJson(T bean) {
		if (bean == null) {
			return null;
		}
		return JSONObject.toJSONString(bean);
	}

	/**
	 * 将 json字符串 转换为javaBean
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static <T> T jsonToBean(String jsonStr, Class<T> clazz) {
		if (jsonStr == null || clazz == null) {
			return null;
		}
		return JSONObject.parseObject(jsonStr, clazz);
	}
	
	public static <T> T jsonToBean(String jsonStr,String dataFormat,Class<T> clazz) {
		return null;
	}

	/**
	 * 根据json字符串的key 取获取值
	 * 
	 * @param jsonStr
	 * @param key
	 * @return
	 */
	public static <T> T getJsonValueByKey(String jsonStr, String key) {
		if (jsonStr == null || key == null) {
			return null;
		}
		Map<String, Object> map = JSONObject.parseObject(jsonStr, Map.class);
		return (T) map.get(key);
	}
	


}
