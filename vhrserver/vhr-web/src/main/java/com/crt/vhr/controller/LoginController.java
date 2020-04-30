package com.crt.vhr.controller;

import com.crt.vhr.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/1/20 10:14
 */
@RestController
public class LoginController {

    @GetMapping(value = "/login")
    public RespBean login(){

        return RespBean.error("尚未登录，请登录");
    }

}
