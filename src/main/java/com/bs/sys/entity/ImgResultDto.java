package com.bs.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwj
 * 2019/4/11 10:21
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImgResultDto<T> {

    private int  errno;//错误代码

    private String[] data;//存放数据

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
