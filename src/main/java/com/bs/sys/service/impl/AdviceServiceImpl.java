package com.bs.sys.service.impl;

import com.bs.sys.dao.AdviceDao;
import com.bs.sys.entity.Advice;
import com.bs.sys.service.AdviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        advice.setIsDeal(0);
        int result= adviceDao.addAdvice(advice);
        if(result>0){
            return true;
        }else
        return false;
    }

    @Override
    public List<Advice> getadvices(int page, int limit) {
        return adviceDao.getadvices((page-1)*limit, limit);
    }

    @Override
    public boolean dealadvice(int id) {
        int result=adviceDao.dealadvice(id);
        if(result>0){
            return true;
        }else
        return false;
    }

    @Override
    public Advice getbyid(int id) {
        return adviceDao.getbyid(id);
    }

    @Override
    public List<Advice> gethasansweradvice(int page, int limit) {
        return adviceDao.gethasansweradvices((page-1)*limit, limit);
    }
}
