package com.crt.vhr.mapper;

import com.crt.vhr.bean.politicsStatus;

import java.util.List;

public interface PoliticsStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(politicsStatus record);

    int insertSelective(politicsStatus record);

    politicsStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(politicsStatus record);

    int updateByPrimaryKey(politicsStatus record);

    List<politicsStatus> getPoliticsStatus();
}