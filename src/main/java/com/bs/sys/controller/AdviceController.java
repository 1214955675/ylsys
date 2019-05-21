package com.bs.sys.controller;

import com.bs.sys.common.ResultCode;
import com.bs.sys.common.SendEmailUtil;
import com.bs.sys.common.response.AdviceResponse;
import com.bs.sys.entity.Advice;
import com.bs.sys.entity.Deal;
import com.bs.sys.service.impl.AdviceServiceImpl;
import com.bs.sys.service.impl.DealServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    DealServiceImpl dealService;
    @RequestMapping("/issueAdvice")
    public AdviceResponse issueAdvice(Advice advice){
        AdviceResponse res=new AdviceResponse();
        advice.setIsDeal(0);
        if(!adviceService.createAdvice(advice)){
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
    @RequestMapping("/getAllAdvice")
    public AdviceResponse getAllAdvice( @RequestParam(value = "page",defaultValue = "1")String page,
                                        @RequestParam(value = "limit",defaultValue = "10")String limit){
        AdviceResponse res=new AdviceResponse();
        try {
            int page_int=Integer.parseInt(page);
            int limit_int=Integer.parseInt(limit);
            res.setAdviceList(adviceService.getadvices(page_int,limit_int));
        }catch (Exception e){
            e.printStackTrace();
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
    @RequestMapping("/deal")
    public AdviceResponse dealadvice(Advice advice,@RequestParam String subject,@RequestParam String content){
        AdviceResponse res=new AdviceResponse();
        Advice needdeal=adviceService.getbyid(advice.getId());
        Deal deal=new Deal();
        deal.setContent(content);
        deal.setAdviceId(needdeal.getId());
        deal.setDealTime(System.currentTimeMillis());
        dealService.adddeal(deal);
        SendEmailUtil.send(needdeal.getContactWay(),subject,content);
        if(!adviceService.dealadvice(advice.getId())){
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
        }
        return res;
    }
    @RequestMapping("/getAdvicesWithAnswer")
    public AdviceResponse getAdvicesWithAnswer(@RequestParam(value = "page",defaultValue = "1")String page,
                                       @RequestParam(value = "limit",defaultValue = "10")String limit){
        AdviceResponse res=new AdviceResponse();
        try {
            int page_int=Integer.parseInt(page);
            int limit_int=Integer.parseInt(limit);
            List<Advice> list=adviceService.gethasansweradvice(page_int,limit_int);
            res.setAdviceList(list);
            return res;
        }catch (Exception e){
            res.setResultCode(ResultCode.db_opterror.getCode());
            res.setResultMessage(ResultCode.db_opterror.getMessage());
            return res;
        }
    }
}
