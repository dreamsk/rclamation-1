package com.reclamation.rservice.service.impl;

import com.reclamation.rservice.domain.HousingEstate;
import com.reclamation.rservice.domain.Owner;
import com.reclamation.rservice.domain.ReclamationOrder;
import com.reclamation.rservice.mapper.HousingEstateMapper;
import com.reclamation.rservice.mapper.OwnerMapper;
import com.reclamation.rservice.mapper.ReclamationOrderMapper;
import com.reclamation.rservice.mapper.ScrapMapper;
import com.reclamation.rservice.service.OwnerService;
import com.reclamation.rservice.util.Reqstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    HousingEstateMapper housingEstateMapper;
    @Autowired
    OwnerMapper ownerMapper;
    @Autowired
    ScrapMapper scrapMapper;
    @Autowired
    ReclamationOrderMapper reclamationOrderMapper;
    @Override
    public List<Map<String, Object>> getAreas(String code) {
        return housingEstateMapper.getAreas(code);
    }

    @Override
    public List<HousingEstate> getHousingEstateByCityCode(String cityCode) {
        return housingEstateMapper.getHousingEstateByCityCode(cityCode);
    }

    @Override
    public String insert(Owner owner) {
        String status = Reqstatus.FAIL;
        int res = ownerMapper.insert(owner);
        if(res > 0){
            status = Reqstatus.SUCCESS;
        }
        return status;
    }

    @Override
    public List<Owner> getOwnersByOpenid(String openid) {
        return ownerMapper.getOwnersByOpenid(openid);

    }

    @Override
    public List<Map<String, Object>> getScraps() {
        return scrapMapper.getScraps();
    }

    @Override
    public String addReclamationOrder(ReclamationOrder reclamationOrder) {
        String status = Reqstatus.FAIL;
         int res = reclamationOrderMapper.insert(reclamationOrder);
        if(res > 0){
            status = Reqstatus.SUCCESS;
        }
        return status;
    }

    @Override
    public List<ReclamationOrder> reclamationOrderList(String openid) {
        return reclamationOrderMapper.reclamationOrderList(openid);
    }

    @Override
    public String cancelOrder(ReclamationOrder reclamationOrder) {
        String status = Reqstatus.FAIL;
        int res = reclamationOrderMapper.cancelOrder(reclamationOrder);
        if(res > 0){
            status = Reqstatus.SUCCESS;
        }
        return status;
    }
}
