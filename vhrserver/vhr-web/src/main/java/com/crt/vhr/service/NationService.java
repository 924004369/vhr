package com.crt.vhr.service;

import com.crt.vhr.bean.Nation;
import com.crt.vhr.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/22 19:29
 */
@Service
public class NationService {
    @Autowired(required = false)
    NationMapper nationMapper;

    public List<Nation> getAllNations(){
        return nationMapper.getAllNations();
    }
}
