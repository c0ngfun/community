package com.sunxc.community.controller;

import com.sunxc.community.dto.AccessTokenDTO;
import com.sunxc.community.dto.GithubUser;
import com.sunxc.community.mapper.UserMapper;
import com.sunxc.community.model.User;
import com.sunxc.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @projectname:community
 * @classname:AuthorizeController
 * @description:TODO
 * @auhtor: sunxc
 * @date: 2019/12/26-13:45
 * @version: 1.0
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
   @Value("${github.client.id}")
    private  String clientId;
   @Value("${github.client.secret}")
   private  String clientSecret;
   @Value("${github.redirect.uri}")
   private String redirectUri;
   @Autowired
   private UserMapper userMapper;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse respone){
      AccessTokenDTO accessTokenDTO=  new AccessTokenDTO();
      accessTokenDTO.setClient_id(clientId);
      accessTokenDTO.setClient_secret(clientSecret);
      accessTokenDTO.setCode(code);
      accessTokenDTO.setRedirect_uri(redirectUri);
      accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser !=null && githubUser.getId()!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubUser.getAvatar_url());
            userMapper.insert(user);  //相当于写入session
            respone.addCookie(new Cookie("token",token));
            //登录成功 写cookie 和session
          //  request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }
        else {
            return "redirect:/";
        }
    }
}
