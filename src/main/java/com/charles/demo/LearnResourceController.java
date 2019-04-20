package com.charles.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Charles
 * @version 1.0
 */
//@Controller、@ResponseBody相当于@RestController
@Controller
@RequestMapping("/learn")
public class LearnResourceController {

    //value可以是/或者空字符串，访问/learn，则调用该方法
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView index() {
        List<LearnResource> learnList = new ArrayList<>();
        learnList.add(new LearnResource("Baidu", "Baidu Inc", "https://www.baidu.com"));
        learnList.add(new LearnResource("Alibaba", "Alibaba Inc", "https://www.taobao.com"));
        learnList.add(new LearnResource("Tencent", "Tencent Inc", "https://www.qq.com"));
        ModelAndView modelAndView = new ModelAndView("/learn/index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo() {
        return "Echo what";
    }
}
