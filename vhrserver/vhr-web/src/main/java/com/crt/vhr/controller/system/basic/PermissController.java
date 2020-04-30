package com.crt.vhr.controller.system.basic;

import com.crt.vhr.bean.Menu;
import com.crt.vhr.bean.RespBean;
import com.crt.vhr.bean.Role;
import com.crt.vhr.service.MenuService;
import com.crt.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/17 11:09
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        if(menuService.updateMenuRole(rid,mids)){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if(roleService.addRole(role)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleByRid(@PathVariable Integer rid){
        if (roleService.deleteRoleByRid(rid)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
