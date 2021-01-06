package com.crt.vhr.service;

import com.crt.vhr.bean.Department;
import com.crt.vhr.bean.RespBean;
import com.crt.vhr.mapper.DepartmentMapper;
import com.crt.vhr.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/20 12:09
 */
@Service
public class DepartmentService {

    @Autowired(required = false)
    DepartmentMapper departmentMapper;

    @Autowired(required = false)
    EmployeeMapper employeeMapper;

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }
    @Transactional
    public int addDepartment(Department department) {
        Department departmentParent = departmentMapper.selectByPrimaryKey(department.getParentId());
        department.setEnabled(true);
        department.setParent(false);
        int insert = departmentMapper.insert(department);
        if (insert>0){
            department.setDepPath(departmentParent.getDepPath()+"."+department.getId());
        }
        departmentMapper.updateByPrimaryKeySelective(department);
        departmentParent.setParent(true);



        return departmentMapper.updateByPrimaryKeySelective(departmentParent);
    }

    @Transactional
    public RespBean deleteDepartById(Integer id) {
        Department department = departmentMapper.selectByPrimaryKey(id);
        if (department.getParent()){
            return RespBean.error("该部门下有子部门，不能删除！！！");
        }if (employeeMapper.getEmployeesByDepartmentId(id).size()>0){
            return RespBean.error("该部门下有员工，不能删除！！！");
        }
        int i = departmentMapper.deleteByPrimaryKey(id);
        if (i>0){
           return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }
}
