package com.bs.sys.controller;

import com.bs.sys.common.ResultCode;
import com.bs.sys.common.response.AdviceResponse;
import com.bs.sys.entity.Advice;
import com.bs.sys.service.impl.AdviceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wwj
 * 2019/4/15 18:18
 */
@Controller
@RequestMapping("/advice")
@ResponseBody
public class AdviceController {
    @Resource
    AdviceServiceImpl adviceService;
    @RequestMapping("/issueAdvice")
    public AdviceResponse issueAdvice(Advice advice){
        AdviceResponse res=new AdviceResponse();
        if(!adviceService.createAdvice(advice)){
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
}
