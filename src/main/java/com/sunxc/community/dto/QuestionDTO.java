package com.sunxc.community.dto;

import com.sunxc.community.model.User;
import lombok.Data;

/**
 * @projectname:community
 * @classname:QuestionDTO
 * @description:TODO
 * @auhtor: sunxc
 * @date: 2019/12/30-15:39
 * @version: 1.0
 */
@Data
public class QuestionDTO {
    private  Integer id;
    private  String description;
    private  String tag;
    private String title;
    private  Long gmtCreate;
    private  Long gmtModified;
    private  Integer creator;
    private  Integer viewCount;
    private  Integer commentCount;
    private  Integer likeCount;
    private User user;
}
