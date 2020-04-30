package com.crt.vhr.service;

import com.crt.vhr.bean.Hr;
import com.crt.vhr.mapper.HrMapper;
import com.crt.vhr.mapper.HrRoleMapper;
import com.crt.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/1/19 15:44
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired(required = false)
    private HrMapper hrMapper;

    @Autowired(required = false)
    private HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public int updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateRoles(Integer hrId, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrId);
        return hrRoleMapper.addRole(hrId,rids)==rids.length;
    }

    public int deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }
}
