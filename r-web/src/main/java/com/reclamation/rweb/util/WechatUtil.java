package com.reclamation.rweb.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 微信接口调用工具类
 * @author Administrator
 * @version 1.0
 * 2017-05-12
 */
public class WechatUtil {
	/**
	 * 获取HttpURLConnection
	 * @param action 微信接口调用地址（参数access_token要拼接好）
	 * @return
	 * @throws Exception
	 */
	public static HttpURLConnection getHttpURLConnection(String action) throws Exception{
		 URL url = new URL(action);
         HttpURLConnection http =   (HttpURLConnection) url.openConnection();    

         http.setRequestMethod("POST");        
         http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
         http.setDoOutput(true);        
         http.setDoInput(true);
         return http;
	}
	
	/**
	 * 获取解析调用微信接口时接口返回的信息
	 * @param is 通过http.getOutputStream()获取
	 * @return
	 * @throws Exception
	 */
	public static String getMessage(InputStream is) throws Exception{
		 int size = is.available();
         byte[] jsonBytes = new byte[size];
         is.read(jsonBytes);
         return new String(jsonBytes,"UTF-8");
	}

	/**
	 * 创建微信公众号菜单
	 * @param action 微信接口调用地址（参数access_token要拼接好）
	 * @param menu 菜单json
	 * @return
	 */
	public static String createMenu(String action,String menu){
		String message = "";
		try {
	           HttpURLConnection http = getHttpURLConnection(action);
	 
	           http.connect();
	           OutputStream os= http.getOutputStream();    
	           os.write(menu.getBytes("UTF-8"));//传入参数    
	           os.flush();
	           os.close();

	           message = getMessage(http.getInputStream());
	           System.out.println("返回信息"+message);
           } catch (Exception e) {
               e.printStackTrace();
           }
		return message;
	}
	
	
}
