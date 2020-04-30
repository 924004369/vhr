package com.crt.vhr.service;

import com.crt.vhr.bean.politicsStatus;
import com.crt.vhr.mapper.PoliticsStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/22 22:37
 */
@Service
public class PoliticsStatusService {
    @Autowired(required = false)
    PoliticsStatusMapper politicsStatusMapper;

    public List<politicsStatus> getPoliticsStatus(){
        return politicsStatusMapper.getPoliticsStatus();
    }
}
