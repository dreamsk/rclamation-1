package com.reclamation.rservice.mapper;

import com.reclamation.rservice.domain.ReclamationOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单持久层
 */
@Mapper
public interface ReclamationOrderMapper {


    int insert(ReclamationOrder reclamationOrder);

    List<ReclamationOrder> reclamationOrderList(String openid);

    Integer selectScrapPriceByScrapCode(String scrap_code);

    String selectScrapNameByScrapCode(String scrap_code);

    List<ReclamationOrder> scrapOrderList(String openid);

    int editOrder(ReclamationOrder reclamationOrder);

    int cancelOrder(ReclamationOrder reclamationOrder);
}