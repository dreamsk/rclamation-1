package com.reclamation.rservice.mapper;

import com.reclamation.rservice.domain.HousingEstate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 小区持久层
 */
@Mapper
public interface HousingEstateMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(HousingEstate housingEstate);

	HousingEstate selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(HousingEstate housingEstate);

	List<Map<String,Object>> getAreas(String code);

	List<HousingEstate> getHousingEstateByCityCode(String cityCode);

	String getAreaNameByAreaCode(String code);
}