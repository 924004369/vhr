package com.crt.vhr.mapper;

import com.crt.vhr.bean.HrRole;
import org.apache.ibatis.annotations.Param;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    int deleteByHrid(Integer hrId);

    int addRole(@Param("hrId") Integer hrId, @Param("rids") Integer[] rids);
}