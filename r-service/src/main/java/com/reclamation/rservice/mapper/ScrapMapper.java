package com.reclamation.rservice.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ScrapMapper {

    List<Map<String, Object>> getScraps();
}