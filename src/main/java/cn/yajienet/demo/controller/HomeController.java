package cn.yajienet.demo.controller;

import cn.yajienet.demo.annotation.DemoAnnotation;
import cn.yajienet.demo.event.DemoEvent;
import cn.yajienet.demo.listener.SpringContextHolder;
import cn.yajienet.demo.service.UserService;
import cn.yajienet.demo.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 16:37
 */

@Controller
@Api(tags = "首页")
public class HomeController {

    @Autowired
    private UserService UserService;
    @Autowired
    private ApplicationContext applicationContext;


    @DemoAnnotation(name = "HomeController.index",value = "注解测试")
    @GetMapping(value = "/")
    public String index(@RequestParam(defaultValue = "wcg") String name, Model model){
        model.addAttribute("user", JSONObject.toJSONString(UserService.demo(name)));
        return "index";
    }

    @GetMapping(value = "/1")
    public String index11(@RequestParam(defaultValue = "wcg") String name, Model model){
        throw new RuntimeException("index11错误");
    }

    @ResponseBody
    @GetMapping(value = "/a")
    public Object index1(@RequestParam(defaultValue = "wcg") String name){
        return applicationContext.getBean(UserServiceImpl.class).demo(name);
    }

    @ResponseBody
    @GetMapping(value = "/b")
    public Object index2(@RequestParam(defaultValue = "wcg") String name){

        return SpringContextHolder.getBean(UserServiceImpl.class).demo(name);
    }


    @ResponseBody
    @GetMapping(value = "/d")
    public Object index3(@RequestParam(defaultValue = "wcg") String name){
        SpringContextHolder.getApplicationContext().publishEvent(new DemoEvent(this,"我成功发送事件！"));
        return "成功发送事件";
    }
}
