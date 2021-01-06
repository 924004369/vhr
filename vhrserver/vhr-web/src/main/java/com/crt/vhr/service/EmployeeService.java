package com.crt.vhr.service;

import com.crt.vhr.bean.Employee;
import com.crt.vhr.bean.RespPageBean;
import com.crt.vhr.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/22 12:32
 */
@Service
public class EmployeeService {
    @Autowired(required = false)
    EmployeeMapper employeeMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

    Logger logger = LoggerFactory.getLogger(getClass());

    public RespPageBean getAllEmployees(Integer page, Integer size, String keywords) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getAllEmployees(page, size, keywords);
        Long total = employeeMapper.getTotal(keywords);

        RespPageBean bean = new RespPageBean();
        bean.setTotal(total);
        bean.setData(data);
        return bean;
    }

    public int deleteEmpById(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public int addEmp(Employee employee) {
        if (System.currentTimeMillis() > employee.getEndcontract().getTime()) {
            employee.setWorkstate("离职");
        } else {
            employee.setWorkstate("在职");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Integer year = Integer.valueOf(simpleDateFormat.format(employee.getEndcontract()).toString()) - Integer.valueOf(simpleDateFormat.format(employee.getBegincontract()).toString());
        employee.setContractterm(Double.valueOf(year));
        int result = employeeMapper.insertSelective(employee);

        if (result == 1) {
            Employee emp = employeeMapper.getEmployeeById(employee.getId());
            logger.debug("emp的值为"+String.valueOf(emp));
            rabbitTemplate.convertAndSend("crt.mail.welcome",emp);
        }

        return result;
    }

    public String getMaxWorkId() {
        String maxWorkId = employeeMapper.getMaxWorkId();
        return String.format("%0" + maxWorkId.length() + "d", Integer.parseInt(maxWorkId) + 1);
    }


    public int doDeleteMany(Integer[] ids) {
        return employeeMapper.doDeleteMany(ids);
    }

    public int UpdateEmp(Employee employee) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Integer year = Integer.valueOf(simpleDateFormat.format(employee.getEndcontract()).toString()) - Integer.valueOf(simpleDateFormat.format(employee.getBegincontract()).toString());
        employee.setContractterm(Double.valueOf(year));
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public int importData(List<Employee> list) {
        return employeeMapper.importData(list);
    }
}
