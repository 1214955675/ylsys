package com.bs.sys.service;

import com.bs.sys.entity.Advice;

import java.util.List;

/**
 * @author wwj
 * 2019/4/15 18:21
 */
public interface AdviceService {
        boolean createAdvice(Advice advice);
        List<Advice> getadvices(int page,int limit);
        boolean dealadvice(int id);
        Advice getbyid(int id);
        List<Advice> gethasansweradvice(int page,int limit);
}
