package com.juebingliu.boot4learn.controller;

import com.juebingliu.boot4learn.config.Log;
import com.juebingliu.boot4learn.config.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author juebing
 * @date 2018/12/3 11:53
 * @description
 */
@Controller
//@RestController
public class HelloController {

    @RequestMapping("/hello")
    @Log(ignore = true)
    public String index(ModelMap map) {
        map.addAttribute("host", "127.0.0.1");
        return "hello";
    }

    @RequestMapping("/index")
    @Log(ignore = true)
    public String index2(ModelMap map) {
        map.addAttribute("host", "127.0.0.1");
        return "index";
    }

    @RequestMapping("/hello1")
    @Log(ignore = true)
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    @Log(ignore = true)
    public String json() throws MyException {
        throw new MyException("发生错误");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    @Log(value = "日志注解打印测试")
    public String hello(@RequestParam String name) {

        return "Hello " + name;
    }

    @RequestMapping("/login")
    @Log(ignore = true)
    public String login() {
        return "login";
    }
}