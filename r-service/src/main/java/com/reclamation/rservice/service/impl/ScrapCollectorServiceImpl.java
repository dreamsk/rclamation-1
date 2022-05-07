package com.reclamation.rservice.service.impl;

import com.reclamation.rservice.domain.ReclamationOrder;
import com.reclamation.rservice.domain.ScrapCollector;
import com.reclamation.rservice.mapper.ReclamationOrderMapper;
import com.reclamation.rservice.mapper.ScrapCollectorMapper;
import com.reclamation.rservice.service.ScrapCollectorService;
import com.reclamation.rservice.util.Reqstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrapCollectorServiceImpl implements ScrapCollectorService {

    @Autowired
    ScrapCollectorMapper scrapCollectorMapper;

    @Autowired
    ReclamationOrderMapper reclamationOrderMapper;
    @Override
    public String bindingWeixin(ScrapCollector scrapCollector) {
        String status = Reqstatus.FAIL;
        int res = scrapCollectorMapper.bindingWeixin(scrapCollector);
        if(res > 0){
            status = Reqstatus.SUCCESS;
        }
        return status;
    }

    @Override
    public List<ReclamationOrder> scrapOrderList(String openid) {
        return reclamationOrderMapper.scrapOrderList(openid);
    }

    @Override
    public String editOrder(ReclamationOrder reclamationOrder) {
        String status = Reqstatus.FAIL;
        int res = reclamationOrderMapper.editOrder(reclamationOrder);
        if(res > 0){
            status = Reqstatus.SUCCESS;
        }
        return status;
    }
    }

