package com.crt.vhr.controller.emp;

import com.crt.vhr.service.*;
import com.crt.vhr.bean.*;
import com.crt.vhr.utils.POIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/22 12:30
 */
@RestController
@RequestMapping("/emp/basic")
public class EmpBasicController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PoliticsStatusService politicsStatusService;
    @Autowired
    PositionService positionService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getAllEmployees(@RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        @RequestParam(required = false) String keywords) {
        return employeeService.getAllEmployees(page, size, keywords);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable Integer id) {
        if (employeeService.deleteEmpById(id) > 0) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) > 0) {
            return RespBean.ok("添加成功");

        }
        return RespBean.error("添加失败");
    }

    @GetMapping("/nation")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/jobLevel")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/politics")
    public List<politicsStatus> getAllPoliticsStatuse() {
        return politicsStatusService.getPoliticsStatus();
    }

    @GetMapping("/position")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }


    @GetMapping("/dep")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/workid")
    public String getMaxWorkId() {
        return employeeService.getMaxWorkId();
    }

    @DeleteMapping("/delMany")
    public RespBean doDeleteMany(Integer[] ids) {
        if (employeeService.doDeleteMany(ids) == ids.length) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }


    @PutMapping("/updateEmp")
    public RespBean UpdateEmp(@RequestBody Employee employee) {
        if (employeeService.UpdateEmp(employee) > 0) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> list = (List<Employee>) employeeService.getAllEmployees(null, null, null).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file,
                nationService.getAllNations(),
                jobLevelService.getAllJobLevels(),
                politicsStatusService.getPoliticsStatus(),
                positionService.getAllPositions(),
                departmentService.getAllDepartment());
        int nums = employeeService.importData(list);
        if (nums == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
}
