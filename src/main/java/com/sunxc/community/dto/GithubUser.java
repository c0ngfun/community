package com.sunxc.community.dto;

import lombok.Data;

/**
 * @projectname:community
 * @classname:GithubUser
 * @description:
 * @auhtor: sunxc
 * @date: 2019/12/26-14:52
 * @version: 1.0
 */
@Data
public class GithubUser {
    private String name;
    private  Long id;
    private String bio;
    private  String avatar_url;
}
