package com.sunxc.community.controller;

import com.sunxc.community.Service.QuestionService;
import com.sunxc.community.dto.PaginationDTO;
import com.sunxc.community.dto.QuestionDTO;
import com.sunxc.community.mapper.QuestionMapper;
import com.sunxc.community.mapper.UserMapper;
import com.sunxc.community.model.Question;
import com.sunxc.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    private UserMapper userMapper;
   @Autowired
private QuestionService questionService;
    @GetMapping("/")   //一个/代表根目录
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size
                        ) {
        Cookie[] cookies = request.getCookies();
        if(cookies !=null && cookies.length!=0){
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token=cookie.getValue();
                User user= userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        }
        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";   //返回index.html
    }
}
