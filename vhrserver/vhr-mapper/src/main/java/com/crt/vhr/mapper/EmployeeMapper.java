package com.crt.vhr.mapper;

import com.crt.vhr.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeesByDepartmentId(@Param("departmentId") Integer departmentId);

    List<Employee> getAllEmployees(@Param("page") Integer page, @Param("size") Integer size, @Param("keywords") String keywords);

    Long getTotal(String keywords);

    String getMaxWorkId();

    int doDeleteMany(@Param("ids") Integer[] ids);

    int importData(@Param("list") List<Employee> list);

    Employee getEmployeeById(Integer id);
}