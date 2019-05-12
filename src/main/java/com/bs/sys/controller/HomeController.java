package com.bs.sys.controller;

import com.bs.sys.entity.Post;
import com.bs.sys.entity.Topic;
import com.bs.sys.service.impl.PostServiceImpl;
import com.bs.sys.service.impl.TopicServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.*;

/**
 * @author wwj
 * 2019/4/2 17:37
 */

@Controller
@ResponseBody
public class HomeController {
    @Autowired
    PostServiceImpl postService;
    @Autowired
    TopicServiceImpl topicService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping("/searchAll")
    public HashMap<String,Object> searchall(@RequestParam String key){
        HashMap<String,Object> res=new HashMap<>();
        List<Post> posts=new ArrayList<>();
        posts=postService.searchall(key);
        List<Topic> topics=topicService.searchall(key);
        res.put("Post",posts);
        res.put("Topic",topics);
        return res;
    }
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "index";
    }

}
