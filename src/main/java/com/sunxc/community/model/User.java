package com.sunxc.community.model;

import lombok.Data;

/**
 * @projectname:community
 * @classname:User
 * @description:TODO
 * @auhtor: sunxc
 * @date: 2019/12/26-19:01
 * @version: 1.0
 */
@Data
public class User {
    private  Integer id;
    private  String name;
    private  String accountId;
    private  String token;
    private  Long gmtCreate;
    private  Long gmtModified;
    private  String avatarUrl;

}
