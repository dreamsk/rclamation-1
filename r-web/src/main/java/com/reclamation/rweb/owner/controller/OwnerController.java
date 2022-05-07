package com.reclamation.rweb.owner.controller;

import com.alibaba.fastjson.JSONObject;
import com.reclamation.rweb.domain.Owner;
import com.reclamation.rweb.domain.ReclamationOrder;
import com.reclamation.rweb.temp.TestData;
import com.reclamation.rweb.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/owner")
public class OwnerController extends BaseController {
    @Autowired
    HttpServletRequest request;
    @Value("${service-url.user-service-name}")
    String serviceName;

    /**
     * 跳转业主注册界面
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){

        return "register";
    }

    /**
     * 跳转到业主填写废品回收订单页
     * @return
     */
    @RequestMapping("/toReclamationOrder")
    public String toReclamationOrder(){
        //根据openid获取业主信息  把数据转化为json对象
        String openid = (String) request.getSession().getAttribute("openid");

        request.setAttribute("owners", JSONObject.parse(get("http://"+serviceName+"/owner/getOwnersByOpenid/" + openid)));
        //获取废品列表
        request.setAttribute("scraps", JSONObject.parse(get("http://"+serviceName+"/owner/getScraps")));
        return "reclamationOrder";
    }

    /**
     * 跳转到业主的废品回收订单列表页
     * @return
     */
    @RequestMapping("/toReclamationOrderList")
    public String toReclamationOrderList(){
        String openid = (String) request.getSession().getAttribute("openid");
        //业主获取订单列表  根据openid
        request.setAttribute("reclamationOrders", JSONObject.parse(get("http://"+serviceName+"/owner/reclamationOrderList/"+openid)));
        return "reclamationOrderList";
    }

    /**
     * 从后端服务端获取数据
     * @param code
     * @return
     */
    @RequestMapping("/getAreasByCode")
    @ResponseBody
    public String getAreasByCode(String code){

        return get("http://"+serviceName+"/owner/getAreasByCode/"+code);
    }
    @RequestMapping("/getHousingEstateByCityCode")
    @ResponseBody
    public String getHousingEstateByCityCode(String code){

        return get("http://"+serviceName+"/owner/getHousingEstateByCityCode/"+code);
    }

    /**
     * 业主注册  保存数据
     * @param owner
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(Owner owner){
        String openid = (String) request.getSession().getAttribute("openid");
        owner.setOpenid(openid);
        return post("http://"+serviceName+"/owner/register",owner);
    }

    /**
     * 业主填写订单提交
     * @param reclamationOrder
     * @return
     */
    @RequestMapping("/addReclamationOrder")
    @ResponseBody
    public String addReclamationOrder(ReclamationOrder reclamationOrder){
//        System.out.println(reclamationOrder.getOwner_id());
        return post("http://"+serviceName+"/owner/addReclamationOrder", reclamationOrder);
    }

    /**
     * 业主取消订单
     * @param reclamationOrder
     * @return
     */
    @RequestMapping("/cancelOrder")
    @ResponseBody
    public String cancelOrder(ReclamationOrder reclamationOrder){

        return post("http://"+serviceName+"/owner/cancelOrder",reclamationOrder);
    }

}
