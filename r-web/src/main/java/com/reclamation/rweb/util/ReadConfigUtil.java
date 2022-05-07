package com.reclamation.rweb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 读取properties配置文件工具类
 * @author Administrator
 *
 */
public class ReadConfigUtil {
	public static Map<String,Map<String,String>> config = new HashMap<String,Map<String,String>>();
	
	static{
		initReadProp();
	}
	
	public static void initReadProp(){
		Properties p = null;
		Set<Object> keys = null;
		Map<String,String> tempMap = new HashMap<String, String>();
		String tempKey = "";
		String[] proNames = getProperties("common.properties").getProperty("proNames").split(",");
		System.out.println("`````````"+proNames.length);
		for(String proName : proNames){
			p = getProperties(proName+".properties");
			keys = p.keySet();
			for(Object obj : keys){
				tempKey = (String)obj;
				tempMap.put(tempKey, p.getProperty(tempKey));
			}
			config.put(proName, tempMap);
		}
	}
	
	/**
	 * 读取配置key的值
	 * @param filePath 例如./config/config.properties
	 * @param key
	 * @return value
	 */
	public static String get(String filePath,String key) {
		Properties p = null;
		InputStream inputStream = null;
		try {
			p = new Properties();

			inputStream = ReadConfigUtil.class.getClassLoader()
					.getResourceAsStream(filePath);
			p.load(inputStream);
			
		} catch (IOException e) {
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		String value = p.getProperty(key);
		if (value != null){
			return value.trim();
		}
		return value;
	}
	
	/**
	 * 读取配置文件获取对应的Properties
	 * @param filePath
	 * @return
	 */
	public static Properties getProperties(String filePath){
		Properties p = null;
		InputStream inputStream = null;
		try {
			p = new Properties();

			inputStream = ReadConfigUtil.class.getClassLoader()
					.getResourceAsStream(filePath);
			p.load(inputStream);
			
		} catch (IOException e) {
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return p;
	}
}
