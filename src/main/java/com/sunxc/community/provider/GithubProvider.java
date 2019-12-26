package com.sunxc.community.provider;

import com.alibaba.fastjson.JSON;
import com.sunxc.community.dto.AccessTokenDTO;
import com.sunxc.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @projectname:community
 * @classname:GithubProvider
 * @description:TODO
 * @auhtor: sunxc
 * @date: 2019/12/26-13:55
 * @version: 1.0
 */
@Component
public class GithubProvider {
    public  String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

            RequestBody body = okhttp3.RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string= response.body().string();
                String token = string.split("&")[0].split("=")[1];
                return token;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  null;
    }
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+accessToken)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String string = response.body().string();
                GithubUser githubUser = JSON.parseObject(string, GithubUser.class);  //把string类型的json转化成githubuser类的类型
                return githubUser;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
    }
    }

