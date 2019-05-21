package com.bs.sys.service;

import com.bs.sys.entity.Deal;

import java.util.List;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
public interface DealService {
    void adddeal(Deal deal);
    List<Deal> getalldeal(int page,int limit);
    Deal getdealbyadviceId(int adviceId);
}
