package com.crt.vhr.controller.salary;

import com.crt.vhr.bean.RespBean;
import com.crt.vhr.bean.Salary;
import com.crt.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary){
        if (salaryService.addSalary(salary)==1){
            return RespBean.ok("添加成功");
        }else{
            return RespBean.error("添加失败");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean del(@PathVariable int id){
        if (salaryService.del(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary){
        if (salaryService.updateSalary(salary)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
}
