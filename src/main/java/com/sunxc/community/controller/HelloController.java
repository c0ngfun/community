package com.sunxc.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @projectname:community
 * @classname:HelloController
 * @description:controller的意思是允许去接受前端的请求
 * @auhtor: sunxc
 * @date: 2019/12/25-19:10
 * @version: 1.0
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name")String name, Model model) {
        model.addAttribute("name",name);
    return  "hello";
    }
}
