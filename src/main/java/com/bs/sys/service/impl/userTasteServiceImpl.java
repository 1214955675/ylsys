package com.bs.sys.service.impl;

import com.bs.sys.dao.UserTasteDao;
import com.bs.sys.entity.Listbysql;
import com.bs.sys.entity.userTaste;
import com.bs.sys.service.userTasteServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userTasteServiceImpl implements userTasteServiceInf {
    @Autowired
    UserTasteDao userTasteDao;
    @Override
    public boolean addtaste(userTaste usertaste) {
        int countid=userTasteDao.addusertaste(usertaste);
        if(countid>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Listbysql> getbyuserid(int userId) {

        return userTasteDao.getbyuserid(userId);
    }

}
