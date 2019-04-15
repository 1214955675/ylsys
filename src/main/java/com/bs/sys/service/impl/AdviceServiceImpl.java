package com.bs.sys.service.impl;

import com.bs.sys.dao.AdviceDao;
import com.bs.sys.entity.Advice;
import com.bs.sys.service.AdviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wwj
 * 2019/4/15 18:24
 */
@Service
public class AdviceServiceImpl implements AdviceService {
    @Resource
    AdviceDao adviceDao;
    @Override
    public boolean createAdvice(Advice advice) {
        advice.setCreateTime(System.currentTimeMillis());
        int result= adviceDao.addAdvice(advice);
        if(result>0){
            return true;
        }
        return false;
    }
}
