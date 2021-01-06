package com.crt.vhr.mapper;

import com.crt.vhr.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer parentId);

    void addDepartment(Department department);

    Department selectDepartmentByParentId(Integer parentId);

    List<Department> getAllDepartment();
}