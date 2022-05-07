package com.reclamation.rweb.scrapCollector.controller;

import com.alibaba.fastjson.JSONObject;
import com.reclamation.rweb.domain.ReclamationOrder;
import com.reclamation.rweb.domain.ScrapCollector;
import com.reclamation.rweb.temp.TestData;
import com.reclamation.rweb.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/scrapCollector")
public class ScrapCollectorController extends BaseController {

    @Autowired
    HttpServletRequest request;
    @Value("${service-url.user-service-name}")
    String serviceName;

    /**
     * 跳转到绑定微信界面
     * @return
     */
    @RequestMapping("/toBindingWeixin")
    public String toBindingWeixin(){

        return "bindingWeixin";
    }

    /**
     * 跳转到废品回收订单 回收员
     * @return
     */
    @RequestMapping("/toScrapOrderList")
    public String toScrapOrderList(){
        String openid = (String) request.getSession().getAttribute("openid");
        //获取废品列表,把数据转化为json对象，放到域对象
        request.setAttribute("scrapOrders", JSONObject.parse(get("http://"+serviceName+"/scrapCollector/scrapOrderList/"+openid)));
        return "scrapOrderList";
    }

    /**
     * 回收员绑定微信（根据回收员手机号更新回收员openid）
     * @return
     */
    @RequestMapping("/bindingWeixin")
    @ResponseBody
    public String bindingWeixin(String tel){
        String openid = (String) request.getSession().getAttribute("openid");
//        System.out.println(tel);
        ScrapCollector scrapCollector = new ScrapCollector();
        scrapCollector.setOpenid(openid);
        scrapCollector.setTel(tel);
        return post("http://"+serviceName+"/scrapCollector/bindingWeixin", scrapCollector);
    }

    /**
     * 回收员完成订单
     * @param reclamationOrder
     * @return
     */
    @RequestMapping("/editOrder")
    @ResponseBody
    public String editOrder(ReclamationOrder reclamationOrder){
        String openid = (String) request.getSession().getAttribute("openid");
        reclamationOrder.setOpenid(openid);
        //向后端服务端接口保存数据
//        System.out.println(reclamationOrder.getOrder_no() + "--" + reclamationOrder.getMoney());
        return post("http://"+serviceName+"/scrapCollector/editOrder",reclamationOrder);
    }

}
