package com.reclamation.rservice.mapper;

import com.reclamation.rservice.domain.Dict;
import com.reclamation.rservice.domain.Owner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 小区业主持久层
 */
@Mapper
public interface OwnerMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Owner owner);

	Dict selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Owner owner);

	List<Owner> getOwnersByOpenid(String openid);

	String selectOwnerNameById(Integer id);

	String getCategoryName(String dict_option);

}