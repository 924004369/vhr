package com.crt.vhr.service;

import com.crt.vhr.bean.Role;
import com.crt.vhr.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/17 11:11
 */
@Service
public class RoleService {
    @Autowired(required = false)
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public int addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());;
        }
        return roleMapper.insert(role);
    }

    public int deleteRoleByRid(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
