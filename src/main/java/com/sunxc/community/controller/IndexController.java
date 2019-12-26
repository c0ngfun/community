package com.sunxc.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @projectname:community
 * @classname:HelloController
 * @description:controller的意思是允许去接受前端的请求    路由api的承载者
 * @auhtor: sunxc
 * @date: 2019/12/25-19:10
 * @version: 1.0
 */
@Controller
public class IndexController {
    @GetMapping("/")   //一个/代表根目录
 public String index(){
        return "index";   //返回index.html
    }
}
