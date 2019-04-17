package com.bs.sys.common.response;

import com.bs.sys.entity.Advice;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author wwj
 * 2019/4/15 18:17
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdviceResponse extends BaseResponse{
    private Advice advice;
    private List<Advice> adviceList;

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public List<Advice> getAdviceList() {
        return adviceList;
    }

    public void setAdviceList(List<Advice> adviceList) {
        this.adviceList = adviceList;
    }
}
