package com.reclamation.rservice.service;

import com.reclamation.rservice.domain.ReclamationOrder;
import com.reclamation.rservice.domain.ScrapCollector;

import java.util.List;

public interface ScrapCollectorService {

    String bindingWeixin(ScrapCollector scrapCollector);

    List<ReclamationOrder> scrapOrderList(String openid);

    String editOrder(ReclamationOrder reclamationOrder);
}
