package com.bs.sys.service;

import com.bs.sys.entity.Listbysql;
import com.bs.sys.entity.userTaste;

import java.util.List;

public interface userTasteServiceInf {
    boolean addtaste(userTaste usertaste);
    List<Listbysql> getbyuserid(int userId);
}
