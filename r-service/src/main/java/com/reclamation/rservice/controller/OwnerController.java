package com.reclamation.rservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.reclamation.rservice.domain.Owner;
import com.reclamation.rservice.domain.ReclamationOrder;
import com.reclamation.rservice.service.OwnerService;
import com.reclamation.rservice.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    /**
     * 根据parent_code获取省市列表
     * @return
     */
    @RequestMapping(value = "/getAreasByCode/{code}",produces = "application/json; charset=utf-8")
    public String getAreasByCode(@PathVariable("code") String code){

        return  JSONObject.toJSONString(ownerService.getAreas(code));
    }

    /**
     * 根据cityCode获取小区列表
     */
    @RequestMapping(value = "/getHousingEstateByCityCode/{cityCode}",produces = "application/json; charset=utf-8")
    public String getHousingEstateByCityCode(@PathVariable("cityCode") String cityCode){

        return  JSONObject.toJSONString(ownerService.getHousingEstateByCityCode(cityCode));
    }
    /**
     * 业主注册
     */

    @RequestMapping(value = "/register",produces = "application/json; charset=utf-8")
    public String register(@RequestBody Owner owner){
        owner.setCreate_time(new Date());

        return JSONObject.toJSONString(ownerService.insert(owner));

    }
    /**
     * 根据openid获取业主列表
     */

    @RequestMapping(value = "/getOwnersByOpenid/{openid}",produces = "application/json; charset=utf-8")
    public String getOwnersByOpenid(@PathVariable String openid){

        return JSONObject.toJSONString(ownerService.getOwnersByOpenid(openid));

    }

    /**
     * 获取废品列表
     */
    @RequestMapping(value = "/getScraps",produces = "application/json; charset=utf-8")
    public String getScraps(){

        return JSONObject.toJSONString(ownerService.getScraps());

    }

    /**
     * 保存业主提交的废品回收订单
     * @return
     */
    @RequestMapping(value = "/addReclamationOrder",produces = "application/json; charset=utf-8")
    public String addReclamationOrder(@RequestBody ReclamationOrder reclamationOrder){
        //创建时间
        reclamationOrder.setCreate_time(new Date());
        //订单编号
        reclamationOrder.setOrder_no(Common.getOrderNum());
        //分拣状态
        reclamationOrder.setRd_status("rd_0");
        //回收状态
        reclamationOrder.setSc_status("sc_0");
        return JSONObject.toJSONString(ownerService.addReclamationOrder(reclamationOrder));

    }
    /**
     * 根据openid获取业主的订单列表
     */
    @RequestMapping(value = "/reclamationOrderList/{openid}",produces = "application/json; charset=utf-8")
    public String reclamationOrderList(@PathVariable("openid") String openid){

        return JSONObject.toJSONString(ownerService.reclamationOrderList(openid));

    }
    /**
     * 业主取消订单
     */
    @RequestMapping(value = "/cancelOrder",produces = "application/json; charset=utf-8")
    public String cancelOrder(@RequestBody ReclamationOrder reclamationOrder){

        return JSONObject.toJSONString(ownerService.cancelOrder(reclamationOrder));

    }

}
