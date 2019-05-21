package com.bs.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Deal {
    private Integer id;
    private String content;
    private int adviceId;
    private long dealTime;

    public int getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(int adviceId) {
        this.adviceId = adviceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDealTime() {
        return dealTime;
    }

    public void setDealTime(long dealTime) {
        this.dealTime = dealTime;
    }
}
