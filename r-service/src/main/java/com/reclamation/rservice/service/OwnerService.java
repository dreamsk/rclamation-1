package com.reclamation.rservice.service;

import com.reclamation.rservice.domain.HousingEstate;
import com.reclamation.rservice.domain.Owner;
import com.reclamation.rservice.domain.ReclamationOrder;

import java.util.List;
import java.util.Map;

public interface OwnerService {
    List<Map<String,Object>> getAreas(String code);

    List<HousingEstate> getHousingEstateByCityCode(String cityCode);

    String insert(Owner owner);

    List<Owner> getOwnersByOpenid(String openid);

    List<Map<String,Object>> getScraps();

    String addReclamationOrder(ReclamationOrder reclamationOrder);

    List<ReclamationOrder> reclamationOrderList(String openid);

    String cancelOrder(ReclamationOrder reclamationOrder);
}
