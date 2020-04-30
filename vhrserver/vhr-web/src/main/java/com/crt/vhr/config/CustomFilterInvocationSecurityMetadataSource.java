package com.crt.vhr.config;

import com.crt.vhr.bean.Menu;
import com.crt.vhr.bean.Role;
import com.crt.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/14 6:56
 * 根据用户传来的请求地址，分析出请求需要的角色
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher=new AntPathMatcher();//通过这个类进行路径的比对
    //根据访问的接口，查询出需要访问这个接口的所有角色，并且返回
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();//获取当前请求的地址
        List<Menu> menus = menuService.getAllMenusWithRole();//查询数据库中所有的角色，
        //进行权限比对
        for (Menu menu : menus){
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles = menu.getRoles();
                String [] str =new String[roles.size()];
                for (int i=0;i<roles.size();i++){
                    str[i]=roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
