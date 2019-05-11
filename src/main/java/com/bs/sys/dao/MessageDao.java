package com.bs.sys.dao;

import com.bs.sys.entity.Message;
import org.apache.ibatis.annotations.Insert;

/**
 * @author wwj
 * 2019/4/16 15:39
 */
public interface MessageDao {
    @Insert("insert into message (fromId,fromName,toId,messageText,messageDate,alert,type) " +
            "values (#{fromId},#{fromName},#{toId},#{messageText},#{messageDate},#{alert},#{type})")
    void addmess(Message message);
}
