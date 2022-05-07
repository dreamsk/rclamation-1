package com.reclamation.rservice.mapper;

import com.reclamation.rservice.domain.ScrapCollector;
import org.apache.ibatis.annotations.Mapper;


/**
 * 回收员持久层
 */
@Mapper
public interface ScrapCollectorMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ScrapCollector scrapCollector);

	ScrapCollector selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(ScrapCollector scrapCollector);

	String selectNameByPrimaryKey(Integer id);

	int bindingWeixin(ScrapCollector scrapCollector);
}