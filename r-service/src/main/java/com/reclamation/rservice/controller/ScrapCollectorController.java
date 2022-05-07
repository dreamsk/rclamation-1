package com.reclamation.rservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.reclamation.rservice.domain.ReclamationOrder;
import com.reclamation.rservice.domain.ScrapCollector;
import com.reclamation.rservice.service.ScrapCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 回收员相关接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/scrapCollector")
public class ScrapCollectorController {

    @Autowired
    ScrapCollectorService scrapCollectorService;

    /**
     * 回收员绑定微信（根据回收员手机号更新回收员openid）
     */
    @RequestMapping(value="/bindingWeixin", produces="application/json; charset=utf-8")
    public String bindingWeixin(@RequestBody ScrapCollector scrapCollector){
        return JSONObject.toJSONString(scrapCollectorService.bindingWeixin(scrapCollector));
    }

    /**
     * 根据openid获取回收员的订单列表
     * @param openid
     * @return
     */
    @RequestMapping(value="/scrapOrderList/{openid}", produces="application/json; charset=utf-8")
    public String scrapOrderList(@PathVariable("openid") String openid){
        return JSONObject.toJSONString(scrapCollectorService.scrapOrderList(openid));
    }

    /**
     * 回收员完成废品回收订单
     * @return
     */
    @RequestMapping(value="/editOrder", produces="application/json; charset=utf-8")
    public String editOrder(@RequestBody ReclamationOrder reclamationOrder){
        reclamationOrder.setUpdate_time(new Date());
        return JSONObject.toJSONString(scrapCollectorService.editOrder(reclamationOrder));
    }
}
