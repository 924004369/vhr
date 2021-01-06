package com.crt.vhr.utils;

import com.crt.vhr.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/21 13:41
 */
public class HrUtils {
    public static Hr getCurrentHr(){
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
