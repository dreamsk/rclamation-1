package com.reclamation.rservice.mapper;

import com.reclamation.rservice.domain.Dict;
import org.apache.ibatis.annotations.Mapper;




/**
 * 数据字典持久层
 */
@Mapper
public interface DictMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Dict dict);

	Dict selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Dict dict);

	
}