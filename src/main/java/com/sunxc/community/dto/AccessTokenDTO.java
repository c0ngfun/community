package com.sunxc.community.dto;

import lombok.Data;

/**
 * @projectname:community
 * @classname:AccessTokenDTO
 * @description:TODO
 * @auhtor: sunxc
 * @date: 2019/12/26-14:00
 * @version: 1.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
