package com.sunxc.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @projectname:community
 * @classname:ProfileController
 * @description:
 * @auhtor: sunxc
 * @date: 2020/1/1-10:57
 * @version: 1.0
 */
@Controller
public class ProfileController {
    @GetMapping("/profile/{action}")
    public  String profile(){
        return  "profile";
    }
}
