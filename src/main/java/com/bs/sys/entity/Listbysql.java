package com.bs.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Listbysql {
    private Object objectid;
    private int count;

    public Object getObjectid() {
        return objectid;
    }

    public void setObjectid(Object objectid) {
        this.objectid = objectid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
