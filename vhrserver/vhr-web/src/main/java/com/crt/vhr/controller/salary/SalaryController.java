package com.crt.vhr.controller.salary;

import com.crt.vhr.bean.Salary;
import com.crt.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/28 15:08
 */
@RestController
@RequestMapping("/sal")
public class SalaryController {
    @Autowired
    SalaryService salaryService;
    @GetMapping("/")
    public List<Salary> getAllSalarys(){
        return salaryService.getAllSalarys();
    }
}
