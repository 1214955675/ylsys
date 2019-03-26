package com.bs.sys.common.response;

/**
 * @author Hu Min
 * 2019/3/26 18:07
 */
public class BaseResponse {
        private Integer resultCode;
        private String  resultMessage;

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
