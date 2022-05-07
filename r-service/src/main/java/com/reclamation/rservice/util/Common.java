package com.reclamation.rservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    /**
     * 订单编号的生成规则
     * R-yyy-MM-dd-当前时间的毫秒数
     */
    public static String getOrderNum(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Date date = new Date();
        String currentTime= dateFormat.format(date);
        long time = date.getTime();
        String orderNum = "R-"+currentTime+"-"+time;
        return orderNum;
    }
}
