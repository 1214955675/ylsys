package com.bs.sys.controller;

import com.bs.sys.webSocket.WebSocketMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author wwj
 * 2019/3/26 18:26
 */
@Controller
@RequestMapping("/IM")
@ResponseBody
public class IMController {
    @RequestMapping("/getOnline")
    public HashMap<Integer,String> getonline(){
        return WebSocketMsg.idandnameMap;
    }

}
