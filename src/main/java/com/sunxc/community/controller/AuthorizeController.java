package com.sunxc.community.controller;

import com.sunxc.community.dto.AccessTokenDTO;
import com.sunxc.community.dto.GithubUser;
import com.sunxc.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state){
      AccessTokenDTO accessTokenDTO=  new AccessTokenDTO();
      accessTokenDTO.setClient_id(clientId);
      accessTokenDTO.setClient_secret(clientSecret);
      accessTokenDTO.setCode(code);
      accessTokenDTO.setRedirect_uri(redirectUri);
      accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}