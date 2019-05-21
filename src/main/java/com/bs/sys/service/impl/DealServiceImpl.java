package com.bs.sys.service.impl;

import com.bs.sys.dao.DealDao;
import com.bs.sys.entity.Deal;
import com.bs.sys.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
@Service
public class DealServiceImpl implements DealService {
    @Autowired
    DealDao dealDao;
    @Override
    public void adddeal(Deal deal) {
        dealDao.adddeal(deal);
    }

    @Override
    public List<Deal> getalldeal(int page, int limit) {
        return dealDao.getalldeal(page,limit);
    }

    @Override
    public Deal getdealbyadviceId(int adviceId) {
        return dealDao.getdealbyadviceid(adviceId);
    }
}
