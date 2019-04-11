package com.bs.sys.entity;

/**
 * Created by Windows10 on 2019/4/11/0011.
 */
public class ImgResultDto {
    private int errno;
    private String[] data;

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