package com.crt.vhr.service;

import com.crt.vhr.bean.Salary;
import com.crt.vhr.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/28 15:11
 */
@Service
public class SalaryService {
    @Autowired(required = false)
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalarys() {
        return salaryMapper.getAllSalarys();
    }

    public int addSalary(Salary salary) {
        salary.setCreatedate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public int del(int id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public int updateSalary(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }
}
