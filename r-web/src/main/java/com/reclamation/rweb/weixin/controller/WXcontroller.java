package com.reclamation.rweb.weixin.controller;


import com.alibaba.fastjson.JSONObject;
import com.reclamation.rweb.util.ReadConfigUtil;
import com.reclamation.rweb.util.WechatUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@Controller
@RequestMapping("/weixin")
public class WXcontroller {
	private Logger log = Logger.getLogger(WXcontroller.class);
	private static final String token = "janken";
	private static String access_token = "56_Gd9w0cVZMcyVSytQTXd1WjFBsFzb0YlBrwPlrEdcq5xmIZLC3NRopkbGRfaTZD3Qlvxx4SSef4O2yas7Jto8cRKpigVM-nfgwzuykc8c2bHk-iWtPb9OWF3HIhEi9u4Y0ul8eKj-wQgd98IgLOZjAGASVG";

	private static String appid = "wx916b4d97e14dcd98";
	private static String secret = "df55139182b34148b3783e0231bce94d";
	
	
	/**
	 * 微信认证(URL)
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("portal")
	public void portal(HttpServletRequest request, HttpServletResponse response) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		log.info("signature:" + signature);
		log.info("timestamp:" + timestamp);
		log.info("nonce:" + nonce);
		log.info("echostr:" + echostr);

		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.append(echostr);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取access_token
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("getAccessToken")
	public void getAccessToken(HttpServletRequest request,
			HttpServletResponse response) {
		

		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
						+ appid + "&secret=" + secret);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		UrlEncodedFormEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(params, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		httpPost.setEntity(entity);
		try {
			HttpResponse httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = httpResponse.getEntity();
				String res = EntityUtils.toString(httpEntity, "UTF-8");
				access_token = String.valueOf(JSONObject.parseObject(res).get("access_token"));
				log.info(res);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 授权
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("oauth2")
	public void oauth2(HttpServletRequest request,
			HttpServletResponse response){
		try {
			//scope=snsapi_base是静默授权
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?"  
			        + "appid="+appid+"&redirect_uri="  
			        + "https://" + ReadConfigUtil.config.get("config").get("local") + "/weixin/getOpenid?"
			        + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
			log.info("url==="+url);
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getOpenid
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("getOpenid")
	public void getOpenid(HttpServletRequest request,
			HttpServletResponse response){

		try {
			
			
			String code = request.getParameter("code");
	        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
	        
	        HttpClient client = new DefaultHttpClient();  
            HttpGet httpget = new HttpGet(requestUrl);  
            ResponseHandler<String> responseHandler = new BasicResponseHandler();  
            String res = client.execute(httpget, responseHandler);  
            JSONObject OpenidJSONO = JSONObject.parseObject(res);
            String openid = String.valueOf(OpenidJSONO.get("openid"));
			log.info("openid==="+openid);

			//第一次请求 获取access_token 和 openid
			request.getSession().setAttribute("openid", openid);
			//取出之前放在filter中的url
			String curURL = (String) request.getSession().getAttribute("currentUrl");

			response.sendRedirect(curURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建菜单 
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("createMenu")
	public void createMenu(HttpServletRequest request,
			HttpServletResponse response) {
		String hostname = ReadConfigUtil.config.get("config").get("local");
//		String access_token = "38_rmTcGQezERgmx4sT3xlQEAXv-rkgXh1XwpVd7Tfv-ct4cEnug6dXDPT53l4nzKZKZlKd5Idr72IEZSK7kO5iRKuBBG0tJMqBLtjsWJU_qefkfg08iCVo814rv8wzoJtK9XXR3_67h74yzoLLOFPbAJACTD";
		String menu = "{\"button\":[                                                                       "
				+ " {\"name\":\"小区业主\",\"sub_button\":[                                        "
				+ "      {\"type\":\"view\",                                                           "
				+ "          \"name\":\"业主注册\",                                                    "
				+ "          \"url\":\"https://"+hostname+"/owner/toRegister\"},               "
				+ "       {\"type\":\"view\",                                                          "
				+ "          \"name\":\"填写订单\",                                                    "
				+ "          \"url\":\"https://"+hostname+"/owner/toReclamationOrder\"},       "
				+ "       {\"type\":\"view\",                                                          "
				+ "          \"name\":\"订单列表\",                                                    "
				+ "          \"url\":\"https://"+hostname+"/owner/toReclamationOrderList\"}]},   "
				+ " {\"name\":\"回收员\",\"sub_button\":[                                          "
				+ "      {\"type\":\"view\",                                                          "
				+ "          \"name\":\"绑定微信\",                                                    "
				+ "          \"url\":\"https://"+hostname+"/scrapCollector/toBindingWeixin\"}, "
				+ "       {\"type\":\"view\",                                                          "
				+ "          \"name\":\"订单查看\",                                                    "
				+ "          \"url\":\"https://"+hostname+"/scrapCollector/toScrapOrderList\"}  "
				+ "       ]}   ]}                                                                        ";

		System.out.println(menu);
		
		String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ access_token;
		String message = WechatUtil.createMenu(action, menu);
		log.info(message);
	}

}
