package com.reclamation.rweb.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BaseController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * restTemplate的get请求 参数在url上
     * @param url
     * @return
     */
    public String get(String url){
        return restTemplate.getForObject(url, String.class);
    }
    /**
     * restTemplate的post请求
     *
     */

    public String post(String url , Object parm){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<String>(JSONObject.toJSONString(parm),headers);
        return  restTemplate.postForEntity(url, httpEntity, String.class).getBody();


    }
}
