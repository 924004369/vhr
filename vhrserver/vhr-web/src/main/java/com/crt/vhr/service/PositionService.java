package com.crt.vhr.service;

import com.crt.vhr.bean.Position;
import com.crt.vhr.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/15 11:28
 */
@Service
public class PositionService {

    @Autowired(required = false)
    PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    public Integer addPosition(Position position) {
        position.setCreateDate(new Date());
        position.setEnabled(true);
        return positionMapper.insertSelective(position);
    }

    public int updatePositions(Position position) {

        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id) {

        return positionMapper.deleteByPrimaryKey(id);
    }

    public int deletepositionsByIds(Integer[] ids) {
        return positionMapper.deletepositionsByIds(ids);
    }
}
