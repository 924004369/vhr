package com.crt.vhr.controller.system.basic;

import com.crt.vhr.bean.Department;
import com.crt.vhr.bean.RespBean;
import com.crt.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/20 11:29
 */
@RestController
@RequestMapping("/system/basic/depart")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department department){
        if (departmentService.addDepartment(department)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteDepartById(@PathVariable Integer id){
        return departmentService.deleteDepartById(id);
    }
}
