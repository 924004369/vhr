package com.crt.vhr.controller.system;

import com.crt.vhr.bean.Hr;
import com.crt.vhr.bean.RespBean;
import com.crt.vhr.bean.Role;
import com.crt.vhr.service.HrService;
import com.crt.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/21 13:33
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    private HrService hrService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateRoles(Integer hrId, Integer[] rids) {
        if (hrService.updateRoles(hrId, rids)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id){
        if (hrService.deleteHrById(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
