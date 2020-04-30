package com.crt.vhr.service;

import com.crt.vhr.bean.JobLevel;
import com.crt.vhr.mapper.JobLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/16 11:15
 */
@Service
public class JobLevelService {

    @Autowired(required = false)
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }


    public int deleteJobLevelById(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public int addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insert(jobLevel);
    }

    public int updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public int deleteManyByIds(Integer[] ids) {
        return jobLevelMapper.deleteManyByIds(ids);
    }
}
